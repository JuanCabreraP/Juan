package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Alumno extends Persona{

	private Expediente expediente;
	private Set<Asignatura>asignaturas;
	
	public Alumno(String dni, String nombre, String apellidos, 
			LocalDate fechaNacimiento, String correo, 
			Expediente expediente) {		
		super(dni, nombre, apellidos, fechaNacimiento, correo);
		Checkers.check("El email debe acabar en @alum.us.es", 
				correo.endsWith("@alum.us.es"));
		this.expediente=expediente;
		this.asignaturas=new HashSet<>();
	}	

	public int getCurso() {
		int r=0;
		for(Asignatura asignatura:this.asignaturas)
			if (asignatura.curso()>r)
				r=asignatura.curso();
		return r;
	}

	
	//Representación como cadena:
	// "(1º) 28864657W – García Vaquero, Pascual – 15/09/1998”
	@Override
	public String toString() {
		return "("+this.getCurso()+"º"+") "+super.toString();
	}
	
	/*
	 * `matriculaAsignatura`, que dada una asignatura, añade 
	 * esa asignatura al conjunto de asignaturas en las que está 
	 * matriculado el alumno. Si el alumno ya está matriculado en 
	 * esa asignatura, se elevará la excepción `IllegalArgumentException`.
	 */
	public void matriculaAsignatura(Asignatura asignatura) {
		if (this.asignaturas.contains(asignatura))
			throw new IllegalArgumentException("Asignatura ya matriculada.");
		else
			this.asignaturas.add(asignatura);
	}
	
	/*
	 * `eliminaAsignatura`, 	que dada una asignatura, la elimina del 
	 * conjunto de asignaturas en las que está matriculado el alumno. 
	 * Si el alumno no está matriculado en esa asignatura, se elevará 
	 * la excepción `IllegalArgumentException`.
	 */
	public void eliminaAsignatura(Asignatura asignatura) {
		if (!this.asignaturas.contains(asignatura))
			throw new IllegalArgumentException("Asignatura no matriculada.");
		else
			this.asignaturas.remove(asignatura);
	}
	
	/*
	 * `estaMatriculadoEn`, que dada una asignatura devuelve `true` si el 
	 * alumno está matriculado en la asignatura dada, y `false` en caso 
	 * contrario.
	 */
	public boolean estaMatriculadoEn(Asignatura asignatura) {
		boolean r=false;
		if (this.asignaturas.contains(asignatura))
			r=true;
		return r;
	}
}
