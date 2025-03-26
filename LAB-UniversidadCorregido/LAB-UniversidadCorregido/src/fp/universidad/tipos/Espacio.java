package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public class Espacio implements  Comparable<Espacio>{

	protected TipoEspacio tipo;
	protected String nombre;
	protected int capacidad;
	protected final int planta;
	
	public Espacio(TipoEspacio tipo, String nombre, int capacidad, int planta) {
		Checkers.check("La capacidad debe ser > 0", capacidad>0);
		this.tipo=tipo;
		this.nombre=nombre;
		this.capacidad=capacidad;
		this.planta=planta;
	}
	
	/*
	 * El constructor deberá crear un objeto de tipo Espacio a 
	 * partir de una cadena con el siguiente formato: 
	 * "A0.10,0,100,TEORIA", 
	 * donde primero aparece el nombre del espacio (A0.10), 
	 * seguido de la planta (0), la capacidad (100) y 
	 * el tipo de espacio (TEORIA).
	 */
	public Espacio(String s) {
		String[]partes = s.split(",");
		Checkers.check("Se debe suministrar 4 informaciones", 
				partes.length==4);
		Checkers.check("La capacidad debe ser > 0", 
				Integer.valueOf(partes[2].trim())>0);
		this.nombre=partes[0];
		this.planta=Integer.valueOf(partes[1].trim());
		this.capacidad=Integer.valueOf(partes[2].trim());
		this.tipo=TipoEspacio.valueOf(partes[3].trim());
		
	}
	
	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		Checkers.check("La capacidad debe ser > 0", capacidad>0);
		this.capacidad = capacidad;
	}

	public int getPlanta() {
		return planta;
	}

	//Representación como cadena
	//"A3.10 (planta 3)"
	@Override
	public String toString() {
		return nombre + " (" + planta + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, planta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(nombre, other.nombre) && planta == other.planta;
	}

	@Override
	public int compareTo(Espacio o) {
		// TODO Auto-generated method stub
		int r=this.planta-o.planta;
		if (r==0)
			r=this.nombre.compareTo(o.nombre);
		return r;
	}
	
	
	

	
}
