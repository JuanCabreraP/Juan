package fp.grados.tipos;

public class Espacio {
    private String nombre;
    private int capacidad;
    private int planta;

    public Espacio(String nombre, int capacidad, int planta) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.planta = planta;
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
		this.capacidad = capacidad;
	}


	public int getPlanta() {
		return planta;
	}


	public void setPlanta(int planta) {
		this.planta = planta;
	}


	@Override
    public String toString() {
        return nombre + " (planta " + planta + ")";
    }
}




