package IUDIGITAL;

import java.util.ArrayList;
import java.util.List;

public class empleado {
    private String nombre;
    private String id;
    private List<reporteDesempeno> reportesDesempeno;

    public empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.reportesDesempeno = new ArrayList<>();
    }

    public void addReporte(reporteDesempeno reporte) {
        reportesDesempeno.add(reporte);
    }

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

    public String getId() {
        return id;
    }
}

