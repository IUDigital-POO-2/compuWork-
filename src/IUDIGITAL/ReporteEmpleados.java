
package IUDIGITAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para representar un Reporte de Desempeño
class ReporteDesempeno {
    private String fecha;
    private String descripcion;
    private int puntuacion;

    public ReporteDesempeno(String fecha, String descripcion, int puntuacion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Descripción: " + descripcion + ", Puntuación: " + puntuacion;
    }
}

// Clase para representar un Empleado
class Empleado {
    private String nombre;
    private String id;
    private List<reporteDesempeno> reportesDesempeno;

    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.reportesDesempeno = new ArrayList<>();
    }

    // Método para añadir un reporte de desempeño
    public void addReporte(reporteDesempeno reporte) {
        reportesDesempeno.add(reporte);
    }

    // Método para visualizar los reportes de desempeño
    public void visualizarReportes() {
        if (reportesDesempeno.isEmpty()) {
            System.out.println("No hay reportes de desempeño disponibles para " + nombre);
        } else {
            System.out.println("Reportes de desempeño de " + nombre + ":");
            for (reporteDesempeno reporte : reportesDesempeno) {
                System.out.println(reporte);
            }
        }
    }

    public List<reporteDesempeno> getReportesDesempeno() {
        return reportesDesempeno;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase principal para manejar la interfaz de reportes de empleados
public class ReporteEmpleados {
    private List<empleado> empleados;
    private boolean esAdministrador; // Simula si el usuario es administrador

    public ReporteEmpleados(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
        this.empleados = new ArrayList<>();
    }

    // Método para añadir un empleado
    public void addEmpleado(empleado empleado) {
        empleados.add(empleado);
    }

    // Método para visualizar los reportes de todos los empleados
    public void visualizarReportesEmpleados() {
        for (IUDIGITAL.empleado empleado : empleados) {
            empleado.visualizarReportes();
        }
    }

    // Método para que el administrador edite reportes
    public void editarReportes(String idEmpleado, Scanner scanner) {
        if (!esAdministrador) {
            System.out.println("No tienes permisos para editar reportes.");
            return;
        }

        empleado empleado = buscarEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.println("Selecciona el número del reporte que quieres editar:");
        List<reporteDesempeno> reportes = empleado.getReportesDesempeno();
        for (int i = 0; i < reportes.size(); i++) {
            System.out.println((i + 1) + ". " + reportes.get(i));
        }

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion > 0 && opcion <= reportes.size()) {
            reporteDesempeno reporte = reportes.get(opcion - 1);

            System.out.println("Editar descripción (Actual: " + reporte.getDescripcion() + "): ");
            String nuevaDescripcion = scanner.nextLine();
            reporte.setDescripcion(nuevaDescripcion);

            System.out.println("Editar puntuación (Actual: " + reporte.getPuntuacion() + "): ");
            int nuevaPuntuacion = scanner.nextInt();
            reporte.setPuntuacion(nuevaPuntuacion);

            System.out.println("Reporte editado con éxito.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Método para buscar un empleado por su ID
    private empleado buscarEmpleadoPorId(String id) {
        for (IUDIGITAL.empleado empleado : empleados) {
            if (empleado.getNombre().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el sistema como administrador
        Empleados sistemaAdmin = new Empleados(true);

        // Crear empleados
        empleado emp1 = new empleado("Juan Pérez", "001");
        empleado emp2 = new empleado("María García", "002");

        // Añadir reportes a los empleados
        emp1.addReporte(new reporteDesempeno("2024-09-20", "Excelente trabajo en el proyecto", 9));
        emp1.addReporte(new reporteDesempeno("2024-09-25", "Mejorar puntualidad en reuniones", 7));

        emp2.addReporte(new reporteDesempeno("2024-09-22", "Buen desempeño en ventas", 8));

        // Añadir empleados al sistema
        sistemaAdmin.addEmpleado(emp1);
        sistemaAdmin.addEmpleado(emp2);

        // Visualizar reportes de empleados
        sistemaAdmin.visualizarReportesEmpleados();

        // Administrador edita reporte
        System.out.println("Introduce el ID del empleado para editar reportes (001 o 002): ");
        String idEmpleado = scanner.nextLine();

        sistemaAdmin.editarReportes(idEmpleado, scanner);

        // Volver a visualizar reportes después de la edición
        sistemaAdmin.visualizarReportesEmpleados();
    }
}