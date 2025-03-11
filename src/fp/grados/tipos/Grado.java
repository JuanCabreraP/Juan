package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public class Grado {
    private String nombre;
    private Set<Asignatura> asignaturasObligatorias;
    private Set<Asignatura> asignaturasOptativas;
    private int creditosMinimosOptativas;

    public Grado(String nombre, Set<Asignatura> asignaturasObligatorias, Set<Asignatura> asignaturasOptativas, int creditosMinimosOptativas) {
        this.nombre = nombre;
        this.asignaturasObligatorias = new HashSet<>(asignaturasObligatorias);
        this.asignaturasOptativas = new HashSet<>(asignaturasOptativas);
        this.creditosMinimosOptativas = creditosMinimosOptativas;

        // Restricciones
        if (!asignaturasOptativas.isEmpty()) {
            double creditosOptativos = asignaturasOptativas.iterator().next().creditos();
            Checkers.check("Todas las asignaturas optativas deben tener el mismo número de créditos", asignaturasOptativas.stream().allMatch(a -> a.creditos().equals(creditosOptativos)));
        }
        Checkers.check("El número mínimo de créditos de asignaturas optativas debe estar entre 0 y el número total de créditos de asignaturas optativas", creditosMinimosOptativas >= 0 && creditosMinimosOptativas <= asignaturasOptativas.stream().mapToDouble(Asignatura::creditos).sum());
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Asignatura> getAsignaturasObligatorias() {
        return new HashSet<>(asignaturasObligatorias);
    }

    public Set<Asignatura> getAsignaturasOptativas() {
        return new HashSet<>(asignaturasOptativas);
    }

    public int getCreditosMinimosOptativas() {
        return creditosMinimosOptativas;
    }

    public int getTotalCreditos() {
        return (int) (asignaturasObligatorias.stream().mapToDouble(Asignatura::creditos).sum() + creditosMinimosOptativas);
    }

    // Operaciones que devuelven null y tienen un comentario //TODO
    public Set<Asignatura> getAsignaturas(int curso) {
        // TODO: Implementar esta operación
        return null;
    }

    public Asignatura getAsignatura(String codigo) {
        // TODO: Implementar esta operación
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grado grado = (Grado) o;
        return nombre.equals(grado.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
