package fp.universidad.tipos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.universidad.tipos.Categoria;
import fp.universidad.tipos.Centro;
import fp.universidad.tipos.Departamento;
import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoEspacio;

public class TestCentro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
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
		
		nombre="Lenguajes y Sistemas Informáticos";
		Departamento d1 = new Departamento(nombre);
		nombre="Inteligencia Artificial";
		Departamento d2 = new Departamento(nombre);
		d1.nuevoProfesor(p1);d1.nuevoProfesor(p2);
		d2.nuevoProfesor(p3);		
		
		Espacio e1 = new Espacio(TipoEspacio.TEORIA,"A3.10", 230, 3);
		Espacio e4 = new Espacio(TipoEspacio.LABORATORIO,"F1.32", 23, 1);
		
		Set<Profesor>profesores=new HashSet<>();
		profesores.add(p1);profesores.add(p2);
		Despacho e2 = new Despacho("F1.54", 1, 1, p3);
		Despacho e3 = new Despacho("F1.56", 2, 1, profesores);
				
		nombre = "Escuela Técnica Superior de Ingeniería Informática";
		String direccion = "Avenida Reina Mercedes s/n";
		int plantas = 4;
		int sotanos = 1;
		
		Centro c = new Centro(nombre, direccion, plantas,sotanos);
		c.nuevoEspacio(e1);c.nuevoEspacio(e2);c.nuevoEspacio(e3);
		c.nuevoEspacio(e4);
		
		System.out.println("Prueba: ");
		List<Integer>contadores=c.getConteosEspacios();
		for(Integer contador:contadores) {
			System.out.println("Número de Espacios: "+contador);
		}
		
		System.out.println("Prueba: ");
		Set<Despacho>aux = c.getDespachos();
		for(Despacho d:aux)
			System.out.println(d);
		
		System.out.println("Prueba: ");
		Set<Despacho>despachosDept=c.getDespachos(d1);
		for(Despacho despachoDept:despachosDept) {
			System.out.println("Dept. "+d1.getNombre()+" "+
					"Profs. "+d1.getProfesores()+" ---> "+despachoDept);
		}
		
		System.out.println("Prueba: ");
		Set<Profesor>profesoresCentro=c.getProfesores();
		for(Profesor profesor:profesoresCentro) {
			System.out.println(profesor);
		}
		
		System.out.println("Prueba: ");
		Set<Profesor>profesoresDept=c.getProfesores(d2);
		for(Profesor profesor:profesoresDept) {
			System.out.println(profesor);
		}
		
		System.out.println("Prueba: ");
		Espacio espacio=c.getEspacioMayorCapacidad();
		System.out.println(espacio);
	}

}
