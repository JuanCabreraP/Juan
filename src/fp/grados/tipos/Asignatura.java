package fp.grados.tipos;

import fp.utiles.Checkers;

public record Asignatura(
        String nombre,
        String codigo,
        Double creditos,
        TipoAsignatura tipoasignatura,
        Integer Curso
        ) implements Comparable<Asignatura> {
    
    private void creditosCorrectos(Double creditos) {
        if (creditos <= 0.0) {
            throw new IllegalArgumentException("Creditos incorrectos");
        }
    }

    // Constructor
    public Asignatura {
        Checkers.check("Creditos incorrectos", creditos > 0 && creditos != null);
        Checkers.check("Codigo incorrecto", codigo.length() == 7 && esCodigoNumerico(codigo));
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Asignatura asignatura) {
            return codigo.equals(asignatura.codigo);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + nombre;
    }

    @Override
    public int compareTo(Asignatura a) {
        return codigo.compareTo(a.codigo);
    }

    public String acronimo() {
        StringBuilder r = new StringBuilder();
        for (char c : nombre.toCharArray()) {
            if (Character.isUpperCase(c)) {
                r.append(c);
            }
        }
        return r.toString();
    }

    public static boolean esCodigoNumerico(String codigo) {
        for (int i = 0; i < codigo.length(); i++) {
            if (!Character.isDigit(codigo.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
