package fp.grados.tipos;

import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private List<Nota> notas;

    public Expediente() {
        this.notas = new ArrayList<>();
    }

    public void nuevaNota(Nota n) {
        for (int i = 0; i < notas.size(); i++) {
            Nota notaExistente = notas.get(i);
            if (notaExistente.getAsignatura().equals(n.getAsignatura())
                    && notaExistente.getConvocatoria().equals(n.getConvocatoria())
                    && notaExistente.getCurso().equals(n.getCurso())) {
                notas.set(i, n);
                return;
            }
        }
        notas.add(n);
    }

    public double calcularNotaMedia() {
        double suma = 0;
        int count = 0;
        for (Nota nota : notas) {
            if (nota.getValor() >= 5) {
                suma += nota.getValor();
                count++;
            }
        }
        return count == 0 ? 0.0 : suma / count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Expediente that = (Expediente) obj;
        return notas.equals(that.notas);
    }

    @Override
    public String toString() {
        return notas.toString();
    }

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

    
}
