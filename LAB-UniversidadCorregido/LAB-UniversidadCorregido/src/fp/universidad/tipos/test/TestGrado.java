package fp.universidad.tipos.test;

import java.util.HashSet;
import java.util.Set;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Grado;
import fp.universidad.tipos.TipoAsignatura;

public class TestGrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Asignatura a1 = new Asignatura("Fundamentos de Programación",
    		   "0000230",12,TipoAsignatura.ANUAL, 1);
       Asignatura a2 = new Asignatura("Fundamentos Físicos de la Informática",
    		   "0000233",6,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
       Asignatura a3 = new Asignatura("Procesadores de Lenguajes",
    		   "0000201",6,TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
       Asignatura a4 = new Asignatura("Acceso Inteligente a la Información",
    		   "0000202",6,TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
       
       String nombre="Grado en Ingeniería Informática – Tecnologías Informáticas";
       Set<Asignatura>asignaturasObligatorias=new HashSet<>();
       asignaturasObligatorias.add(a1);asignaturasObligatorias.add(a2);
       Set<Asignatura>asignaturasOptativas=new HashSet<>();
       asignaturasOptativas.add(a3);asignaturasOptativas.add(a4);
       double minimoNumeroCreditosOptativos=12;
       Grado g1 = new Grado(nombre, asignaturasObligatorias,
    		   asignaturasOptativas,minimoNumeroCreditosOptativos);
       System.out.println("Prueba:");
       System.out.println(g1.getAsignaturas(3));
       System.out.println(g1.getAsignaturas("0000202"));
       
	}
}
