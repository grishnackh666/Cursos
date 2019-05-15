package cursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CursoPresencial extends Curso {
    private final int cupoMaximo;
    private final int asistenMinima;
    private Map<Integer, ArrayList<String>> asistencias;

    public CursoPresencial(int cupoMaximo, int asistenMinima, String titulo, Calendar fechaInicio, Calendar fechaFinal, int numeroDias, double precio) {
        super(titulo, fechaInicio, fechaFinal, numeroDias, precio);
        this.cupoMaximo = cupoMaximo;
        this.asistenMinima = asistenMinima;
        this.asistencias = new HashMap<>();

    }
    
    public boolean registrarAsis(int dia, Alumno alumno){
        ArrayList<String> lista;
        if(numerodeDias <= dia && alumnos.contains(alumno)){
            lista = asistencias.get(dia);
            if(lista == null){
                lista = new ArrayList<>();
                asistencias.put(dia, lista);
            }
            lista.add(alumno.getNombre());
            return true;
        }
        return false;
    }
    
    @Override
    public boolean matricular(Alumno alumno){
        if(alumno.getCreditos() >= precio && cupoMaximo - alumnos.size() > 0){
            alumno.decrementarCredito(precio);
            alumnos.add(alumno);
            return true;
        }else{
            return false;
        }
    }
    
    
    public int numeroAsisIndividual (Alumno alumno){
        Iterator it = asistencias.keySet().iterator();
        int sumatoria = 0;
        while(it.hasNext()){
            Integer key =  (Integer) it.next();
            if(asistencias.get(key).contains(alumno.getNombre())){
                sumatoria++;
            }
        }
        return sumatoria;
    }
    
    
    
    @Override
    public boolean alumnoApto(Alumno alumno) {
        return numeroAsisIndividual(alumno) >= asistenMinima;
    }

    @Override
    public boolean vacio() {
        return this.alumnos.isEmpty() && this.alumnosAptos.isEmpty() && asistencias.isEmpty();
    }
    
}
