package fp.universidad.tipos.test;

import java.time.LocalDate;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.utiles.Checkers;
import fp.utiles.FactoriaUniversidad;

public class TestAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="Fundamentos de Programación#1234567#12.0#ANUAL#1";
		Asignatura asignatura=FactoriaUniversidad.creaAsignatura(s);
		s="12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es";
		Alumno alumno=FactoriaUniversidad.creaAlumno(s);
		alumno.matriculaAsignatura(asignatura);
		System.out.println(alumno.getCurso());
		
	}

}
