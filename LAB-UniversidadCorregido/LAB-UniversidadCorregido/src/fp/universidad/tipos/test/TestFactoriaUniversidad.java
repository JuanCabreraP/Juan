package fp.universidad.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.Nota;
import fp.utiles.FactoriaUniversidad;

public class TestFactoriaUniversidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Espacio>espacios=
				FactoriaUniversidad.leeEspacios("espacios.csv");		
		System.out.println(espacios);		
		
		List<Despacho>despachos=
				FactoriaUniversidad.leeDespachos("despachos.csv");
		System.out.println(despachos);		
		
		List<Alumno>alumnos=
				FactoriaUniversidad.leeAlumnos("alumnos.csv");
		System.out.println(alumnos.size());
		
		/*
		
		List<Asignatura>asignaturas=
				FactoriaUniversidad.leeAsignaturas("asignaturas.txt");
		System.out.println(asignaturas);
		
		List<Nota>notas=
				FactoriaUniversidad.leeNotas("notas.csv");
		System.out.println(notas);
		*/
	}

}
