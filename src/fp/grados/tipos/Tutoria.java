package fp.grados.tipos;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Duration;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, long duracionMinutos) {

    public Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this(dia, horaInicio, horaFin, Duration.between(horaInicio, horaFin).toMinutes());
    }

    public Tutoria(DayOfWeek dia, LocalTime horaInicio, long duracionMinutos) {
        this(dia, horaInicio, horaInicio.plusMinutes(duracionMinutos), duracionMinutos);
    }

    @Override
    public String toString() {
        return String.format("%s %s-%s", dia, horaInicio, horaFin);
    }
}
