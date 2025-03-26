package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Centro implements Comparable<Centro>{

	private String nombre;
	private String direccion;
	private int plantas;
	private int sotanos;
	private Set<Espacio>espacios;
	
	public Centro(String nombre, String direccion, int plantas,
			int sotanos) {
		Checkers.check("Número de plantas incorrectas.", plantas>=1);
		Checkers.check("Número de sotanos incorrectos.", sotanos>=0);
		this.nombre=nombre;
		this.direccion=direccion;
		this.plantas=plantas;
		this.sotanos=sotanos;
		this.espacios=new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPlantas() {
		return plantas;
	}

	public int getSotanos() {
		return sotanos;
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}
	
	public void nuevoEspacio(Espacio e) {
		Checkers.check("Espacio incorrecto.", 
				-this.sotanos<=e.getPlanta() && 
				e.getPlanta()<=this.plantas-1);
		this.espacios.add(e);
	}
	
	public void eliminaEspacio(Espacio e) {
		this.espacios.remove(e);
	}

	@Override
	public String toString() {
		return nombre;
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
		Centro other = (Centro) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Centro o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}
	
	//Operaciones
	
	/*
	`getConteosEspacios`, devuelve un array de 5 elementos de 
	tipo Integer que representan el número de espacios de tipo 
	aula de teoría, laboratorio, seminario, aula de examen u otro tipo, 
	respectivamente, que hay en el centro.
	(Problemas: 1.filtro/selección, 2.reducción/conteo)
	*/
	public List<Integer> getConteosEspacios(){
		List<Integer>r=new ArrayList<>();
		
		Set<Espacio>aulasTeoria=new HashSet<>();
		Set<Espacio>aulasLaboratorio=new HashSet<>();
		Set<Espacio>aulasSeminario=new HashSet<>();
		Set<Espacio>aulasExamen=new HashSet<>();
		Set<Espacio>aulasOtroTipo=new HashSet<>();
		//1.
		for(Espacio e:this.espacios) {
			switch(e.getTipo()) {
			case TipoEspacio.TEORIA: aulasTeoria.add(e);break;
			case TipoEspacio.LABORATORIO: aulasLaboratorio.add(e);break;
			case TipoEspacio.EXAMEN: aulasSeminario.add(e);break;
			case TipoEspacio.SEMINARIO: aulasExamen.add(e);break;
			default: aulasOtroTipo.add(e);
			}
		}
		//2.
		r.add(0, aulasTeoria.size());
		r.add(1, aulasLaboratorio.size());
		r.add(2, aulasExamen.size());
		r.add(3, aulasSeminario.size());
		r.add(4, aulasOtroTipo.size());
		return r;
	}
	
	/*
	 * `getDespachos`, devuelve un conjunto con todos los espacios de 
	 * tipo `Despacho` que hay en el centro.
	 * Problemas: 1.filtro/selección
	 */
	public Set<Despacho>getDespachos(){
		Set<Despacho>r=new HashSet<>();
		for(Espacio e:this.espacios) {
			//if (e.getClass().getSimpleName().equals("Despacho"))
			if (e.getTipo()==TipoEspacio.OTRO)
				r.add((Despacho) e);
		}
		return r;
	}
	
	/*
	 * `getDespachos`, dado un departamento `d`, devuelve un 
	 * conjunto con todos los despachos del centro donde hay al 
	 * menos un profesor del departamento d.
	 * Problemas: 1. filtro/selección (despachos) 
	 *            
	 */
	private boolean algunProfesorAsignadoADespacho(Set<Profesor>profesores,
			Despacho d) {
		boolean r = false;
		for (Profesor profesor:profesores) {
			if (d.getProfesores().contains(profesor))
				return true;
		}
		return r;
	}
	public Set<Despacho>getDespachos(Departamento d){
		Set<Despacho>r=new HashSet<>();
		//1.
		Set<Despacho>despachos=this.getDespachos();
		Set<Profesor>profesores=d.getProfesores();
		for(Despacho despacho:despachos) {
			if (this.algunProfesorAsignadoADespacho(profesores, despacho)) {
				r.add(despacho);
			}
		}
		
		return r;
	}
	
	/*
	 * `getProfesores`, devuelve el conjunto de todos los profesores 
	 *  que tienen un despacho en el centro.
	 *  Problemas: 1. filtro/selección (despachos)
	 *             2. proyección (profesores)
	 */
	public Set<Profesor>getProfesores(){
		Set<Profesor>r=new HashSet<>();
		//1.
		Set<Despacho>despachos=this.getDespachos();
		//2.
		for(Despacho d:despachos)
			r.addAll(d.getProfesores());
		return r;
		
	}
	
	/*
	 * `getProfesores`, dado un departamento `d`, devuelve el conjunto
	 *  de todos los profesores que pertenecen al departamento d y tienen 
	 *  un despacho en el centro.
	 *  Problemas: 1.filtro/selección (profesores)
	 */
	private boolean algunDespachoAsignadoAprofesor(Set<Despacho>despachos,
			Profesor profesor) {
		boolean r=false;
		for(Despacho despacho:despachos)
			if (despacho.getProfesores().contains(profesor))
				return true;
		return r;
	}
	public Set<Profesor>getProfesores(Departamento d){
		Set<Profesor>r=new HashSet<>();
		Set<Despacho>despachos=this.getDespachos();
		Set<Profesor>profesores=d.getProfesores();
		for(Profesor profesor:profesores) {
			if (algunDespachoAsignadoAprofesor(despachos,profesor))
				r.add(profesor);
		}
		return r;
	}
	
	/*
	 * `getEspacioMayorCapacidad`,  devuelve el espacio con mayor 
	 * capacidad del centro.
	 * Problemas: 1.busqueda (máximo)
	 */
	public Espacio getEspacioMayorCapacidad() {
		Espacio r = null;
		int capacidad_maxima = 0;
		for(Espacio e:this.espacios)
			if (e.getCapacidad()>capacidad_maxima) {
				r=e;
				capacidad_maxima=e.getCapacidad();
			}
		return r;
	}
}
