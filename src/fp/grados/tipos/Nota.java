package fp.grados.tipos;

public record Nota(String asignatura, String cursoAcademico, String convocatoria, double valorNumerico, boolean mencionDeHonor) {

    public Nota(String asignatura, String cursoAcademico, String convocatoria, double valorNumerico) {
        this(asignatura, cursoAcademico, convocatoria, valorNumerico, false);
    }

    public String calcularCalificacion() {
        if (valorNumerico < 5) {
            return "SUSPENSO";
        } else if (valorNumerico < 7) {
            return "APROBADO";
        } else if (valorNumerico < 9) {
            return "NOTABLE";
        } else {
            return mencionDeHonor ? "MATRÍCULA DE HONOR" : "SOBRESALIENTE";
        }
    }

    @Override
    public String toString() {
        return String.format("(%s), %s, %s, %.1f, %s", asignatura, cursoAcademico, convocatoria, valorNumerico, calcularCalificacion());
    }

   
}
