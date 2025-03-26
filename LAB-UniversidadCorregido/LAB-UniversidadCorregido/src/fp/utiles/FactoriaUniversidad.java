package fp.utiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Convocatoria;
import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;

public class FactoriaUniversidad {

	public static Espacio creaEspacio(String s) {
		return new Espacio(s);
	}
	
	public static List<Espacio> leeEspacios(String nombreFichero){
		List<Espacio>r=new LinkedList<>();
		List<String>aux=Ficheros.leeFichero("No se encuentra el fichero: "+
		        nombreFichero, 
				"./data/"+nombreFichero);
		for(String s:aux) {
			r.add(FactoriaUniversidad.creaEspacio(s));
		}
		return r;
	}
	
	public static Despacho creaDespacho(String s) {
		return new Despacho(s);
	}
	
	public static List<Despacho> leeDespachos(String nombreFichero){
		List<Despacho>r=new LinkedList<>();
		List<String>aux=Ficheros.leeFichero("No se encuentra el fichero: "+nombreFichero, 
				"./data/"+nombreFichero);
		for(String s:aux) {
			r.add(FactoriaUniversidad.creaDespacho(s));
		}
		return r;
	}
	
	/*
	 * "12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es"
	 */
	public static Alumno creaAlumno(String s) {
		Alumno r = null;
		String[]partes=s.split(",");
		Checkers.check("Número incorrecto de informaciones", 
				partes.length==5);
		String dni=partes[0].trim();
		String nombre=partes[1].trim();
		String apellidos=partes[2].trim();
		String[] fs=partes[3].trim().split("/");
		LocalDate fechaNacimiento=LocalDate.of(Integer.parseInt(fs[2].trim()), 
				Integer.parseInt(fs[1].trim()), 
				Integer.parseInt(fs[0].trim()));
		String correo=partes[4].trim();
		r=new Alumno(dni, nombre, apellidos, 
				fechaNacimiento, correo, null);
	    return r;
	}
	
	public static List<Alumno> leeAlumnos(String nombreFichero){
		List<Alumno>r=new LinkedList<>();
		List<String>aux=Ficheros.leeFichero("No se encuentra el fichero: "+
		        nombreFichero, 
				"./data/"+nombreFichero);
		for(int i=1;i<aux.size();i++) {
			r.add(FactoriaUniversidad.creaAlumno(aux.get(i)));
		}
		return r;
	}
	
	/*
	 * "Fundamentos de Programación#1234567#12.0#ANUAL#1"
	 * Asignatura(String nombre,String codigo, 
		double creditos, TipoAsignatura tipo, int curso)
	 */
	public static Asignatura creaAsignatura(String s) {
		Asignatura r=null;
		String partes[]=s.split("#");
		Checkers.check("Número de informaciones incorrecta", 
				partes.length==5);
		String nombre=partes[0].trim();
		String codigo=partes[1].trim();
		Double creditos=Double.valueOf(partes[2].trim());
		TipoAsignatura tipo=TipoAsignatura.valueOf(partes[3].trim());
		int curso=Integer.parseInt(partes[4].trim());
		r=new Asignatura(nombre,codigo,creditos,tipo,curso);
		return r;
	}
	
	public static List<Asignatura> leeAsignaturas(String nombreFichero){
		List<Asignatura>r=new LinkedList<>();
		List<String>aux=Ficheros.leeFichero("No se encuentra el fichero: "+nombreFichero, 
				"./data/"+nombreFichero);
		for(String s:aux) {
			r.add(FactoriaUniversidad.creaAsignatura(s));
		}
		return r;
	}
	
	/*
	 * "Fundamentos de Programación#1234567#12.0#ANUAL#1,2014,PRIMERA,10.0,true"
	 * Nota(Asignatura asignatura, Integer curso, 
		Convocatoria convocatoria, 
		float valor, boolean mencionHonor)
	 */
	public static Nota creaNota(String s) {
		Nota r=null;
		String partes[]=s.split(",");
		Asignatura asignatura=FactoriaUniversidad.creaAsignatura(partes[0]);
		Integer curso=Integer.valueOf(partes[1].trim());
		Convocatoria convocatoria=Convocatoria.valueOf(partes[2].trim()); 
		float valor=Float.parseFloat(partes[3].trim());
		boolean mencionHonor=Boolean.parseBoolean(partes[4].trim());
		Checkers.check("El número de informaciones no es correcto", 
				partes.length==5);	
		r=new Nota(asignatura,curso,convocatoria,valor,mencionHonor);
		return r;
	}
	
	public static List<Nota> leeNotas(String nombreFichero){
		List<Nota>r=new LinkedList<>();
		List<String>aux=Ficheros.leeFichero("No se encuentra el fichero: "+nombreFichero, 
				"./data/"+nombreFichero);
		for(String s:aux) {
			r.add(FactoriaUniversidad.creaNota(s));
		}
		return r;
	}
}
