package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;

public class TestExpediente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expediente e1=new Expediente();
		
		Asignatura a1 = new Asignatura("Fundamentos de Programación",
	    		   "0000230",12,TipoAsignatura.ANUAL, 1);
		Asignatura a2 = new Asignatura("Fundamentos Físicos de la Informática",
	    		   "0000220",6,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura a3 = new Asignatura("Sistemas Operativos",
	    		   "0000220",6,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		
		Integer curso = 2024;
		Convocatoria convocatoria=Convocatoria.PRIMERA;
		float valor = 6;
		Nota n1 = new Nota(a1, curso, convocatoria, valor, false);		
		valor = 4;
		Nota n2 = new Nota(a2, curso, convocatoria, valor, false);		
		convocatoria=Convocatoria.SEGUNDA;
		valor = 7.5f;
		Nota n3 = new Nota(a3, curso, convocatoria, valor, false);
		
		e1.nuevaNota(n1);
		e1.nuevaNota(n2);
		e1.nuevaNota(n3);
		
		System.out.println("Prueba: ");
		System.out.println(e1.notaMedia());
		
	}

}
