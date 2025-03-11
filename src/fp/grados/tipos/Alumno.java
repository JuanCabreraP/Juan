package fp.grados.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Alumno extends Persona {
    private Set<Asignatura> asignaturas;
    private String email;
    private String dni;
    private String apellidos;
    private String nombre;
    private String fechaNacimiento;
    
    
    

    // Constructor
    public Alumno(String dni, String apellidos, String nombre, String fechaNacimiento, String email) {
        super(dni, apellidos, nombre, fechaNacimiento);
        if (email == null || !email.endsWith("@alum.us.es") || email.isEmpty()) {
            throw new IllegalArgumentException("Email no válido");
        }
        this.email = email;
        this.asignaturas = new HashSet<>();
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.endsWith("@alum.us.es") || email.isEmpty()) {
            throw new IllegalArgumentException("Email no válido");
        }
        this.email = email;
    }

    // Método para matricular asignatura
    public void matriculaAsignatura(Asignatura asignatura) {
        if (!asignaturas.add(asignatura)) {
            throw new IllegalArgumentException("Ya está matriculado en esta asignatura");
        }
    }

    // Método para eliminar asignatura
    public void eliminaAsignatura(Asignatura asignatura) {
        if (!asignaturas.remove(asignatura)) {
            throw new IllegalArgumentException("No está matriculado en esta asignatura");
        }
    }

    // Método para comprobar si está matriculado en una asignatura
    public boolean estaMatriculadoEn(Asignatura asignatura) {
        return asignaturas.contains(asignatura);
    }

    // Método para calcular el curso del alumno (TODO: Implementar en el futuro)
    public int getCurso() {
        // TODO: Implementar la lógica para calcular el curso
        return 0;
    }

    // Representación en forma de cadena
    @Override
    public String toString() {
        return "(" + getCurso() + "º) " + super.toString();
    }

    // Equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return getDni().equals(alumno.getDni()) &&
                getApellidos().equals(alumno.getApellidos()) &&
                getNombre().equals(alumno.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getApellidos(), getNombre());
    }
}


