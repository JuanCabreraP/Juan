package fp.grados.tipos;

import java.util.HashSet;


import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Centro implements Comparable<Centro> {
	
	private String nombre;
	private Integer direccion;
	private Integer numPlantas;
	private Integer numSotanos; //camelCase
	private Set <Espacio> espacios ;
	
	
	public String getNombre() {
		return nombre;
	}
	public Integer getDireccion() {
		return direccion;
	}
	public Integer getNumPlantas() {
		return numPlantas;
	}
	public Integer getNumSotanos() {
		return numSotanos;
	}
	public Set<Espacio> getEspacios() {
		return espacios;
	}
	public Centro(String nombre, Integer direccion, Integer numPlantas, Integer numSotanos) {
		super();
		Checkers.check("El número de plantas no puede ser negativo", numPlantas >= 1);
        Checkers.check("El número de sótanos no puede ser negativo", numSotanos >= 0);
		this.nombre = nombre;
		this.direccion = direccion;
		this.numPlantas = numPlantas;
		this.numSotanos = numSotanos;
		this.espacios = new HashSet<Espacio>(); 
		
	}
	
	public void nuevoEspacio(Espacio e) {
		if (e.getPlanta()>= -getNumSotanos()&& e.getPlanta() < getNumPlantas()) {
			espacios.add(e);
		} else {
			throw new IllegalArgumentException("Plantea Erronea");
		}
		
	}
	///public void nuevoEspacio(Espacio e) {
	///	Checkers.check("La planta debe estar entre [-s,p-1]",e.getPlanta()>= -getNumSotanos()&& e.getPlanta() < getNumPlantas());
	///	espacios.add(e);
	///}
	public void eliminaEspacio(Espacio e) {
		espacios.remove(e);
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
	
	public int compareTo(Centro o) {
		return getNombre().compareTo(o.getNombre());
	}
	
	
	

}
