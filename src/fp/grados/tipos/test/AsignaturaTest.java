import org.junit.jupiter.api.Test;

import fp.grados.tipos.Asignatura;

import static org.junit.jupiter.api.Assertions.*;

public class AsignaturaTest {

    
    public void testCreditosCorrectos() {
        
        Asignatura asignatura = new Asignatura("Matemáticas", "1234567", 5.0, TipoAsignatura.PRIMER_CUATRIMESTRE);
        
       
        assertDoesNotThrow(() -> asignatura.creditosCorrectos(asignatura.creditos()));
    }
}