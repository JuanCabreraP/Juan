package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;

public class TestNota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asignatura a1 = new Asignatura("Fundamentos de Programación",
	    		   "0000230",12,TipoAsignatura.ANUAL, 1);
        Nota n1 = new Nota(a1,2024,Convocatoria.PRIMERA,7,true);
        System.out.println(n1);
        
        try {
           Nota n2 = new Nota(a1,2024,Convocatoria.PRIMERA,12);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
        try {
            Nota n2 = new Nota(a1,2024,Convocatoria.PRIMERA,1,true);
         }catch(Exception e) {
         	System.out.println(e.getMessage());
         }
	}

}
