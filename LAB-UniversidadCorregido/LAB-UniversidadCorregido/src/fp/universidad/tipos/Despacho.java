package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public class Despacho extends Espacio{

	private Set<Profesor>profesores;
	
	public Despacho(String nombre, int capacidad, int planta,
			Set<Profesor>profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		Checkers.check("No se debe superar la capacidad del despacho.", 
				profesores.size()<=this.getCapacidad());
		this.profesores = new HashSet<>();
		this.profesores.addAll(profesores);
	}
	
	public Despacho(String nombre, int capacidad, int planta,
			Profesor profesor) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores=new HashSet<>();
		this.profesores.add(profesor);
	}
	
	public Despacho(String nombre, int capacidad, int planta) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<>();
	}
	
	/*
	 * El constructor deberá crear un objeto de tipo Despacho a partir 
	 * de una cadena con el siguiente formato: "F1.43,1,3", 
	 * donde primero aparece el nombre del despacho (F1.43), 
	 * seguido de la planta (1) y, por último, la capacidad (3).
	 */
	public Despacho(String s) {
		//super(s);
		super(s+",OTRO");
		this.profesores = new HashSet<>();
	}
	
	public Set<Profesor> getProfesores() {
		return profesores;
	}
	
	@Override
	public void setTipo(TipoEspacio tipo) {
		throw new UnsupportedOperationException("Operación no aplicable.");
	}
	
}
