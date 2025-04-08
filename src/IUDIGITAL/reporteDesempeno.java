package IUDIGITAL;

public class reporteDesempeno {
    private String fecha;
    private String descripcion;
    private int puntuacion;

    public reporteDesempeno(String fecha, String descripcion, int puntuacion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Descripción: " + descripcion + ", Puntuación: " + puntuacion;
    }
}

