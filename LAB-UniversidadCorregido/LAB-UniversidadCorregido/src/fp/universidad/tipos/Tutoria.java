package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public record Tutoria(DayOfWeek dia,
		LocalTime horaComienzo, LocalTime horaFin) implements Comparable<Tutoria>{

	public Tutoria{
		Checkers.check("Día incorrecto.", 
				1<=dia.getValue() && dia.getValue()<=5);
		Checkers.check("Duración incorrecta.", 
				Duration.between(horaComienzo,horaFin).toMinutes()>15);
	}
	
	public long duracion() {
		return Duration.between(horaComienzo,horaFin).toMinutes();
	}
	
	private String conversionDiaSemana() {
		switch(this.dia.getValue()) {
		case 1: return "L";
		case 2: return "M";
		case 3: return "X";
		case 4: return "J";
		case 5: return "V";
		case 6: return "S";
		default: return "D";
		}
	}
	//Representación como cadena:
	// X 10:30-12:30

	@Override
	public String toString() {
		return conversionDiaSemana()+" " +
	           horaComienzo.format(DateTimeFormatter.ofPattern("HH:mm"))+
	           "-"+
	           horaFin.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, horaComienzo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutoria other = (Tutoria) obj;
		return dia == other.dia && Objects.equals(horaComienzo, other.horaComienzo);
	}

	@Override
	public int compareTo(Tutoria o) {
		// TODO Auto-generated method stub
		int r=this.dia.compareTo(o.dia);
		if (r==0)
			r=this.horaComienzo.compareTo(o.horaComienzo);
		return r;
	}
	
	
}
