package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Asignatura(String nombre,String codigo, 
		double creditos, TipoAsignatura tipo, int curso) implements 
                                            Comparable<Asignatura> {
	
	public Asignatura{
		Checkers.check("Código debe tener 7 dígitos", testarSiCodigoCon7Digitos(codigo) );
		Checkers.check("El número de créditos debe ser mayor que 0", creditos>0);
		Checkers.check("Curso debe pertecer al intervalo [1..4]", 1<=curso && curso<=4);
	}
	
	
	private boolean testarSiCodigoCon7Digitos(String codigo) {
		boolean r=true;
		if (codigo.length()!=7) r=false;
		else {
		   for(int i=0;i<codigo.length()-1;i++) {
			   if (!Character.isDigit(codigo.charAt(i))) {
				   return false;
			   }
		   }
		}
		return r;
	}
	
	public String acronimo() {
		String r = "";
		for(int i=0;i<nombre.length();i++) {
			if (Character.isUpperCase(nombre.charAt(i)))
					r+=nombre.charAt(i);			
		}
		return r;
	}
    //Representación como cadena:
	//"(0000230) Fundamentos de Programación"
	@Override
	public String toString() {
		return "(" + codigo + ") "+nombre;
	}

	



	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(this.codigo, other.codigo);
	}

	@Override
	public int compareTo(Asignatura o) {
		// TODO Auto-generated method stub
		return this.codigo.compareTo(o.codigo);
	}
	
}
