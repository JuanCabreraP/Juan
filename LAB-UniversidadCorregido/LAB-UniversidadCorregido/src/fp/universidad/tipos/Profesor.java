package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.utiles.Checkers;

public class Profesor extends Persona{

	private Categoria categoria;
	private Set<Asignatura>asignaturas;
	private SortedSet<Tutoria>tutorias;
	
	public Profesor(String dni, String nombre, String apellidos, 
			LocalDate fechaNacimiento, String correo, 
			Categoria categoria) {
		super(dni, nombre, apellidos, fechaNacimiento, correo);
		Checkers.check("El profesor debe ser mayor de edad.", 
				this.edad()>=18);
		this.asignaturas = new HashSet<>();
		this.tutorias = new TreeSet<>();
		this.categoria = categoria;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}


	public SortedSet<Tutoria> getTutorias() {
		return tutorias;
	}


	/*
	 * `nuevaTutoria`, que dados una hora de comienzo, de tipo `LocalTime`, 
	 * un número entero que representa la duración y un día de la semana 
	 * (de tipo `DayOfWeek`), añade una nueva tutoría al profesor con esos 
	 * datos.
	 */
	public void nuevaTutoria(LocalTime horaComienzo, long duracion, 
			DayOfWeek dia) {
		LocalTime horaFin = horaComienzo.plusMinutes(duracion);
		Tutoria tutoria = new Tutoria(dia,horaComienzo,horaFin);
		this.tutorias.add(tutoria);
	}
	
	/*
	 * `borraTutoria`, que dados una hora de comienzo (de tipo `LocalTime`) 
	 * y un día de la semana (de tipo `DayOfWeek`), 
	 * elimina la tutoría con 
	 * el día y hora de comienzo indicados; 
	 * si el profesor no tenía esa tutoría, la operación no tiene efecto.
	 */
	public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia) {
		Tutoria tutoria = new Tutoria(dia,horaComienzo,null);
		if (this.tutorias.contains(tutoria))
			this.tutorias.remove(tutoria);
	}
	
	/*
	 * `borraTutorias`, que elimina todas las tutorías del profesor.
	 */
	public void borraTutorias() {
		this.tutorias=new TreeSet<>();
	}
}
