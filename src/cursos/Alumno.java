package cursos;

import java.util.ArrayList;


public class Alumno {
    private final String nombre;
    private final String indentificacion;
    private double creditos;
    private ArrayList<Curso> cursos;

    public Alumno(String nombre, String indentificacion, double credito) {
        this.nombre = nombre;
        this.indentificacion = indentificacion;
        this.creditos = credito;
        cursos = new ArrayList<>();
    }
    
    
    public Alumno(String nombre, String indentificacion) {
        this.nombre = nombre;
        this.indentificacion = indentificacion;
        this.creditos = 100;
        cursos = new ArrayList<>();
    }
    
    
    
    @Override
    public String toString(){
        String info = nombre + " " + indentificacion + " ";
        if(!cursos.isEmpty()){
            for(int i = 0;i<cursos.size();i++ ){
                info += cursos.get(i).titulo + " ";
            }
        }else{info += "No tiene";}
        return info;
    }
    
    public void incrementarCredito(double credito){
        this.creditos = credito + this.creditos;
    }
    
     public String getNombre() {
        return nombre;
    }

    public String getIndentificacion() {
        return indentificacion;
    }

    public double getCreditos() {
        return creditos;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
    public void decrementarCredito(double credito){
        this.creditos = this.creditos - credito;
    }
    
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }
    
   
    
}
