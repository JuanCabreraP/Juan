package fp.universidad.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Departamento;
import fp.universidad.tipos.Profesor;

public class TestProfesor {

	public static void main(String[] args) {
		
		String dni="39765432V";
		String nombre="Petra";
		String apellidos= "Gascón Suárez";
		LocalDate fechaNacimiento=LocalDate.of(1995, 4, 11);
		String correo="petgassua@us.es";
		Categoria categoria = Categoria.AYUDANTE_DOCTOR;
		Profesor p1 = new Profesor(dni, nombre, apellidos, 
				fechaNacimiento, correo, categoria);
		
		dni="49766432K";
		nombre="Juan";
		apellidos= "Trueba Pina";
		fechaNacimiento=LocalDate.of(1975, 2, 1);
		correo="juatrupin@us.es";
		categoria = Categoria.TITULAR;
		Profesor p2 = new Profesor(dni, nombre, apellidos, 
				fechaNacimiento, correo, categoria);
		
		dni="19766888W";
		nombre="María";
		apellidos= "Portet Eslava";
		fechaNacimiento=LocalDate.of(1979, 12, 10);
		correo="marporesl@us.es";
		categoria = Categoria.INTERINO;
		Profesor p3 = new Profesor(dni, nombre, apellidos, 
				fechaNacimiento, correo, categoria);
		
		dni="19766899D";
		nombre="Mario";
		apellidos= "Portales Rodas";
		fechaNacimiento=LocalDate.of(1987, 5, 10);
		correo="marporodl@us.es";
		categoria = Categoria.AYUDANTE;
		Profesor p4 = new Profesor(dni, nombre, apellidos, 
				fechaNacimiento, correo, categoria);
		
		LocalTime horaComienzo=LocalTime.of(10, 00);
		long duracion=150;
		p4.nuevaTutoria(horaComienzo, duracion, DayOfWeek.MONDAY);
		p4.nuevaTutoria(horaComienzo, duracion, DayOfWeek.WEDNESDAY);

		System.out.println(p4.getTutorias());
	}

}
