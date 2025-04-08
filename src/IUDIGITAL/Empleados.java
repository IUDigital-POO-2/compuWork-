package IUDIGITAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleados {
    private List<empleado> empleados;
    private boolean esAdministrador;

    public Empleados(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
        this.empleados = new ArrayList<>();
    }

    // Método público para acceder a la lista de empleados (requerido por los tests)
    public List<empleado> getEmpleados() {
        return empleados;
    }


    public void addEmpleado(empleado empleado) {
        empleados.add(empleado);
    }

    public void visualizarReportesEmpleados() {
        for (empleado empleado : empleados) {
            empleado.visualizarReportes();
        }
    }

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
        scanner.nextLine();

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

    private empleado buscarEmpleadoPorId(String id) {
        for (empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleados sistemaAdmin = new Empleados(true);

        empleado emp1 = new empleado("Juan Pérez", "001");
        empleado emp2 = new empleado("María García", "002");

        emp1.addReporte(new reporteDesempeno("2024-09-20", "Excelente trabajo en el proyecto", 9));
        emp1.addReporte(new reporteDesempeno("2024-09-25", "Mejorar puntualidad en reuniones", 7));
        emp2.addReporte(new reporteDesempeno("2024-09-22", "Buen desempeño en ventas", 8));

        sistemaAdmin.addEmpleado(emp1);
        sistemaAdmin.addEmpleado(emp2);

        sistemaAdmin.visualizarReportesEmpleados();

        System.out.println("Introduce el ID del empleado para editar reportes (001 o 002): ");
        String idEmpleado = scanner.nextLine();

        sistemaAdmin.editarReportes(idEmpleado, scanner);
        sistemaAdmin.visualizarReportesEmpleados();
    }
}
