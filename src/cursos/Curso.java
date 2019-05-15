package cursos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

abstract class Curso {
    protected String titulo;
    protected Calendar inicio;
    protected Calendar Final;
    protected int numerodeDias;
    protected double precio;
    protected ArrayList<Alumno> alumnos;
    protected ArrayList<Alumno> alumnosAptos;

  
    public Curso(String titulo, Calendar inicio, Calendar Final, int numerodeDias, double precio) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.Final = Final;
        this.numerodeDias = numerodeDias;
        this.precio = precio;
        this.alumnos = new ArrayList<>();
        this.alumnosAptos = new ArrayList<>();
    }
    
    
    
    public boolean terminado(){
        Date fecha = new Date();
        return Final.getTime().compareTo(fecha) == 1 || Final.getTime().compareTo(fecha) == 0;
    }
    
    
    
    abstract public boolean alumnoApto(Alumno alumno);
    
    
    public boolean matricular(Alumno alumno){
        if(alumno.getCreditos() >= precio){
            alumno.decrementarCredito(precio);
            alumnos.add(alumno);
            return true;
        }else{
            return false;
        }
    }
   
    public boolean calificar(){
        if(terminado()){
            for(int i = 0;i<alumnos.size();i++ ){
                if(alumnoApto(alumnos.get(i))){
                    alumnosAptos.add(alumnos.get(i));
                }
            }
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Curso obj=null;
        if(!vacio()){
            try{
                obj=(Curso)super.clone();
            }catch(CloneNotSupportedException ex){
                System.out.println("No se puede duplicar");
            }
        }else{
            System.out.println("No esta vacio");
        }
        return obj;
    }
    
    abstract public boolean vacio();
}
