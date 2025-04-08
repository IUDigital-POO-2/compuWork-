package IUDIGITAL;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadosTest {

    @Test
    public void testAgregarEmpleado() {
        Empleados sistema = new Empleados(true);
        empleado emp = new empleado("Brandon", "001");
        sistema.addEmpleado(emp);

        assertEquals(1, sistema.getEmpleados().size());
        assertEquals("Brandon", sistema.getEmpleados().get(0).getNombre());
    }

    @Test
    public void testEditarReporteComoAdmin() {
        Empleados sistema = new Empleados(true);
        empleado emp = new empleado("Brandon", "001");
        reporteDesempeno reporte = new reporteDesempeno("2025-04-07", "Buen trabajo", 8);
        emp.addReporte(reporte);
        sistema.addEmpleado(emp);

        // Simular entrada del usuario (elegir primer reporte, nueva descripción, nueva puntuación)
        String input = "1\nActualización de reporte\n9\n";
        Scanner scanner = new Scanner(input);

        sistema.editarReportes("001", scanner);

        assertEquals("Actualización de reporte", emp.getReportesDesempeno().get(0).getDescripcion());
        assertEquals(9, emp.getReportesDesempeno().get(0).getPuntuacion());
    }

    @Test
    public void testEditarReporteSinPermisos() {
        Empleados sistema = new Empleados(false); // no es admin
        empleado emp = new empleado("Brandon", "001");
        reporteDesempeno reporte = new reporteDesempeno("2025-04-07", "Buen trabajo", 8);
        emp.addReporte(reporte);
        sistema.addEmpleado(emp);

        String input = "1\nIntento fallido\n1\n";
        Scanner scanner = new Scanner(input);

        sistema.editarReportes("001", scanner);

        // El reporte no debe cambiar porque el usuario no tiene permisos
        assertEquals("Buen trabajo", emp.getReportesDesempeno().get(0).getDescripcion());
        assertEquals(8, emp.getReportesDesempeno().get(0).getPuntuacion());
    }
}
