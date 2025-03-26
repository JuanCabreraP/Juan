package fp.universidad.tipos;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Expediente {

	private List<Nota>notas;
	
	public Expediente() {
		notas = new LinkedList<>();
	}

	public List<Nota> getNotas() {
		return notas;
	}
	
	/*
	 * `void nuevaNota(Nota n)`. Añade la nota `n` 
	 * al expediente. Si en el expediente ya existe 
	 * una nota para la misma asignatura, convocatoria y 
	 * curso académico (es decir, otra nota igual según el 
	 * criterio de igualdad del tipo Nota), 
	 * se elimina la nota antigua y se añade la nueva. 
	 * Las notas se añaden siempre al final de la lista.
	 */
	public void nuevaNota(Nota n) {
		Nota nota = null;
		int i=0;
		while (nota==null && i<this.notas.size()) {
			if (this.notas.get(i).equals(n))
				nota = this.notas.get(i);
			i++;
		}
		
		if (nota==null)
		   this.notas.add(n);
		else {
			this.notas.remove(nota);
			this.notas.add(n);
		}
	}

	/////////////////////
	public double notaMedia() {
		double r=0.0;
		int cont=0;
		for(Nota nota:this.notas) {
			if (nota.valor()>=5) {
				cont++;
				r+=nota.valor();
			}
		}
		if (cont>0) r=r/cont;
		return r;
	}
	
	///////////////////
	
	@Override
	public String toString() {
		return notas.toString() ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(notas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}
	
	
}
