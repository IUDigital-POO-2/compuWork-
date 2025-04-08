package IUDIGITAL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reporteDesempenoTest {

    @Test
    public void testCrearReporte() {
        reporteDesempeno reporte = new reporteDesempeno("2025-04-07", "Buen rendimiento", 9);

        assertEquals("2025-04-07", reporte.getFecha());
        assertEquals("Buen rendimiento", reporte.getDescripcion());
        assertEquals(9, reporte.getPuntuacion());
    }

    @Test
    public void testSetters() {
        reporteDesempeno reporte = new reporteDesempeno("2025-04-01", "Regular", 6);
        reporte.setDescripcion("Mejorado");
        reporte.setPuntuacion(8);
        reporte.setFecha("2025-04-07");

        assertEquals("Mejorado", reporte.getDescripcion());
        assertEquals(8, reporte.getPuntuacion());
        assertEquals("2025-04-07", reporte.getFecha());
    }

    @Test
    public void testToString() {
        reporteDesempeno reporte = new reporteDesempeno("2025-04-07", "Muy bueno", 10);
        String esperado = "Fecha: 2025-04-07, Descripción: Muy bueno, Puntuación: 10";
        assertEquals(esperado, reporte.toString());
    }
}
