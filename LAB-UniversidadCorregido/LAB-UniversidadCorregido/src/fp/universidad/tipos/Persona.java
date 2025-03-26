package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public class Persona implements Comparable<Persona>{
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected LocalDate fechaNacimiento;
	protected String correo;	
	
	private boolean digitosDniValidos(String dni) {
		if (dni.length()!=9) 
			return false;
		else {
		   for(int i=0;i<=7;i++){
			  if (!Character.isDigit(dni.charAt(i)))
				return false;
		   }
		   return Character.isLetter(dni.charAt(8));
		}
	}
	
	public Persona(String dni,String nombre,String apellidos,
			LocalDate fechaNacimiento,String correo) {
		Checkers.check("Dni debe tener 8 dígitos", digitosDniValidos(dni));
		Checkers.check("Correo debe tener @", correo.contains("@"));
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.correo=correo;
	}
	
	public Persona(String dni,String nombre,String apellidos,
			LocalDate fechaNacimiento) {
		Checkers.check("Dni debe tener 8 dígitos", digitosDniValidos(dni));
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.correo=null;
	}
	
	//Observadores y modificadores
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		Checkers.check("Dni debe tener 8 dígitos", digitosDniValidos(dni));
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		Checkers.check("Correo debe tener @", correo.contains("@"));
		this.correo = correo;
	}


    //Propiedades derivadas
	public int edad() {
		Period p=Period.between(this.fechaNacimiento,LocalDate.now());
		return p.getYears();
	}

	//Representación como cadena
	//"28864657W – García Vaquero, Pascual – 15/09/1998"
	@Override
	public String toString() {
		return dni + " - " + apellidos+
				 ", " + nombre + " - "	+ 
		fechaNacimiento.format(DateTimeFormatter.ofPattern("d/M/y"));
	}



	

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		int r = this.apellidos.compareTo(o.apellidos);
		if (r==0) {	
			r = this.nombre.compareTo(o.nombre);
		    if (r==0)
			   r=this.dni.compareTo(o.dni);
		}
		return r;
	}
	
}
