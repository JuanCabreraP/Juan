package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Departamento implements Comparable<Departamento>{
	
   private String nombre;
   private Set<Profesor>profesores;
   private Set<Asignatura>asignaturas;
   
   public Departamento(String nombre) {
	   this.nombre=nombre;
	   this.profesores=new HashSet<>();
	   this.asignaturas=new HashSet<>();
   }

	public String getNombre() {
		return nombre;
	}
	
	public Set<Profesor> getProfesores() {
		return profesores;
	}
	
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	   
	public void nuevoProfesor(Profesor p) {
		this.profesores.add(p);
	}
	
	public void nuevaAsignatura(Asignatura a) {
		this.asignaturas.add(a);
	}
	
	public void eliminaProfesor(Profesor p) {
		this.profesores.remove(p);
	}
	
	public void eliminaAsignatura(Asignatura a) {
		this.asignaturas.remove(a);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Departamento o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}
	
	/*
	 * elimina las tutorías de todos los profesores del departamento.
	 */
	public void borraTutorias() {
		for(Profesor profesor:this.profesores) {
			profesor.borraTutorias();
		}
	}
	
	/*
	 * dada una categoría, elimina las tutorías de todos los profesores 
	 * del departamento cuya categoría sea la dada como parámetro.
	 */
	public void borraTutorias(Categoria categoria) {
		for(Profesor profesor:this.profesores) {
			if (profesor.getCategoria()==categoria)
				profesor.borraTutorias();
		}
	}
}
