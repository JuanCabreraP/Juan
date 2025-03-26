package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//try{
       Asignatura a1 = new Asignatura("Fundamentos de Programación",
    		   "0000230",12,TipoAsignatura.ANUAL, 1);
       Asignatura a3=a1;
	//}catch(Exception e) {
		//System.out.println(e.getMessage());
		//System.out.println("No se ha creado el objeto asignatura.");}
	
	Asignatura a2 = new Asignatura("Fundamentos Físicos de la Informática",
    		   "0000230",6,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
	//System.out.println(a2);
    System.out.println(a2.acronimo()); 
    /*
    System.out.println(a3==a1);
    System.out.println(a2==a1);
    System.out.println(a3.equals(a1));
    System.out.println(a2.equals(a1));
    */
	}

}
