package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Nota(Asignatura asignatura, Integer curso, 
		Convocatoria convocatoria, 
		float valor, boolean mencionHonor) implements Comparable<Nota>{
	
	private boolean testRestriccion() {
		boolean r = false;
		if (this.mencionHonor==true) {
			if (this.valor>=9)
				r=true;
			else
				r=false;
		}
		else
			r=true;
		return r;
	}
	
	public Nota{
		Checkers.check("La nota debe estar definida entre 0 y 10.", 
				0<=valor && valor<=10);
		Checkers.check("La mención de honor requiere sobresaliente.", 
				!mencionHonor || valor>=9);
	}

	public Nota(Asignatura asignatura, Integer curso, 
			Convocatoria convocatoria, 
			float valor) {
		this(asignatura,curso,convocatoria,valor,false);
		Checkers.check("La nota debe estar definida entre 0 y 10", 
				0<=valor && valor<=10);
		Checkers.check("La mención de honor requiere sobresaliente", 
				!mencionHonor || valor>=9);
	}
	
	public Calificacion calificacion() {
		if(this.valor<5) 
			return Calificacion.SUSPENSO;
		else
			if (this.valor<7)
				return Calificacion.APROBADO;
			else
				if (this.valor<9)
					return Calificacion.NOTABLE;
				else
					if (!this.mencionHonor)
						return Calificacion.SOBRESALIENTE;
					else
						return Calificacion.MATRICULA_DE_HONOR;
	}

	private String calcularCurso() {
		Integer i =  this.curso;
		i++;
		return this.curso+"-"+i;
	}
	
	//Representación como cadena
	//"(0000230) Fundamentos de Programación, 2014-15, PRIMERA, 
	//7.5, NOTABLE"
	@Override
	public String toString() {
		return "(" + asignatura.codigo() + ") " + 
						asignatura.nombre() + ", "+
						calcularCurso() + ", " + 
						this.convocatoria + ", " + 
						this.valor + ", "+this.calificacion();
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, convocatoria, curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura) && convocatoria == other.convocatoria
				&& Objects.equals(curso, other.curso);
	}

	@Override
	public int compareTo(Nota o) {
		// TODO Auto-generated method stub
		int r=this.curso.compareTo(o.curso);
		if (r==0) {
			r=this.asignatura.compareTo(o.asignatura);
			if (r==0)
				r=this.convocatoria.compareTo(o.convocatoria);
		}
		return r;
	}	
	
}
