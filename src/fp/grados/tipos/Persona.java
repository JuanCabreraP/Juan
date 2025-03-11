package fp.grados.tipos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import fp.utiles.Checkers;

public class Persona {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;
	private String email;
	private Integer Edad;
	
	public Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String email) {
		;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		setEmail(email);
		this.email = email;
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Checkers.check("Email incorrecto",email.contains("@")|| email.isEmpty());
		this.email = email;
	}
	

	public Long getEdad() {
		Long res = getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
		return res;
	}
    public int hashCode() {
    	return getDni().hashCode()
    			+31*getNombre().hashCode()
    			+31*31*getApellidos().hashCode();
    }
    public String toString() {
    	return getDni()+ " - " + getApellidos() + " - "+ getNombre() + " - "+ getFechaNacimiento();
    }
    
    public boolean equals(Object o) {
    	if (this == o ) return true;
    	
    	if (o instanceof Persona) {
    		Persona persona = (Persona) o;
    	return getDni().equals(persona.getDni())
    			&& getNombre().equals(persona.getNombre())
    			&& getApellidos().equals(persona.getApellidos());
    	}
    	return false;
    			
    }
    
    
    
    
    
    
    public int compareTo(Persona p) {
    	int res = getApellidos().compareTo(p.getApellidos());
    	
    	if (res ==0) {
    		res = getNombre().compareTo(p.getNombre());
    		
    		if (res == 0) {
    			res = getDni().compareTo(p.getDni());
    		}
    	}
    	return res;
    	
    	
   
    }
    
		
    private boolean digitosDniValidos(String dni) {
        // Verifica que el DNI no sea nulo y tenga la longitud correcta (9 caracteres)
        if (dni == null || dni.length() != 9) {
            return false;
        }

        // Extrae la parte numérica (primeros 8 caracteres)
        String numeroDni = dni.substring(0, 8);

        // Verifica que los primeros 8 caracteres sean dígitos
        if (!numeroDni.matches("[0-9]+")) {
            return false;
        }

        // Extrae la letra (último carácter)
        char letraDni = dni.charAt(8);

        // Calcula la letra válida según los 8 primeros números
        // El cálculo de la letra en España es la posición en el resto de la división de los 8 dígitos entre 23
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Convierte la parte numérica a un número
        int numero = Integer.parseInt(numeroDni);

        // Calcula la letra correcta a partir de los primeros 8 dígitos
        char letraCorrecta = letras.charAt(numero % 23);

        // Compara la letra del DNI con la calculada
        return letraDni == letraCorrecta;
    }


	
	

	
	
	
	


	
	

	
	}
	
	

	


