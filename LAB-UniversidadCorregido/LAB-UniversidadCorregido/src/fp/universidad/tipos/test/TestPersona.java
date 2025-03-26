package fp.universidad.tipos.test;

import java.time.LocalDate;

import fp.universidad.tipos.Persona;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   LocalDate fechaNacimiento=LocalDate.of(1990, 11,23);
       Persona p1 = new Persona("36035009T","Francisco","Molero Gutiérrez",
   			fechaNacimiento,"framolgut@us.es");
       System.out.println(p1);
       
       LocalDate fechaNacimiento2=LocalDate.of(1990, 11,23);
       Persona p2 = new Persona("36035009T","Francisco","Molero Gutiérrez",
   			fechaNacimiento);
       System.out.println(p2);
	}

}
