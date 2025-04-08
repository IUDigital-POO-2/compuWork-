package IUDIGITAL;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class empleadoTest {

    @Test
    public void testCrearEmpleado() {
        empleado emp = new empleado("Brandon Cano", "BC001");
        assertEquals("Brandon Cano", emp.getNombre());
        assertEquals("BC001", emp.getId());
        assertTrue(emp.getReportesDesempeno().isEmpty());
    }

    @Test
    public void testAgregarReporte() {
        empleado emp = new empleado("Brandon Cano", "BC001");
        reporteDesempeno reporte = new reporteDesempeno("2025-04-07", "Desempeño excelente", 10);

        emp.addReporte(reporte);
        List<reporteDesempeno> reportes = emp.getReportesDesempeno();

        assertEquals(1, reportes.size());
        assertEquals("Desempeño excelente", reportes.get(0).getDescripcion());
    }
}

