package fp.universidad.tipos.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import fp.universidad.tipos.Tutoria;

public class TestTutoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LocalTime hi=LocalTime.of(10, 30);
        LocalTime hf=LocalTime.of(12, 20);
        
        Tutoria t1 = new Tutoria(DayOfWeek.WEDNESDAY,hi,hf);
        System.out.println(t1);
        System.out.println(t1.duracion()+" min.");
        
        LocalTime hi2=LocalTime.of(10, 30);
        LocalTime hf2=LocalTime.of(10, 40);
        Tutoria t2 = new Tutoria(DayOfWeek.SUNDAY,hi2,hf2);
        
	}

}
