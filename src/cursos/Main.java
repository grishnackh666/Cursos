/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;
import java.util.Date;
import java.util.Calendar;




public class Main {
    public static void main(String[] args) {
        Alumno alum1 = new Alumno("Pepe", "34678904");
        Alumno alum2 = new Alumno("Andrea", "17679456");
        
        Date now  = new Date();
        Calendar calen = Calendar.getInstance();
        calen.set(2004,1,7);
        
        CursoPresencial curso_pres = new CursoPresencial(20, 1, "Diseños de bases de datos", calen, calen, 1, 50.0);
        CursoOnline curso_on = new CursoOnline("Administracion de bases de datos", calen, calen, 5, 25.0, 4, curso_pres);
        
        curso_pres.matricular(alum1);
        curso_pres.matricular(alum2);
        
        curso_pres.registrarAsis(1, alum1);
        
        curso_pres.numeroAsisIndividual (alum1);
        
        curso_on.matricular(alum1);
        curso_on.matricular(alum2);
        
        curso_on.subirNivel(alum1);
        
        
        
        
    }
}
