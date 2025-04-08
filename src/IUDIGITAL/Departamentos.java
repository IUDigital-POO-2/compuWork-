package IUDIGITAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Departamentos {
    private Map<String, List<empleado>> departamentos;

    // Constructor por defecto
    public Departamentos() {
        this.departamentos = new HashMap<>();
    }

    // Agregar un nuevo departamento
    public void agregarDepartamento(String nombreDepto) {
        if (!departamentos.containsKey(nombreDepto)) {
            departamentos.put(nombreDepto, new ArrayList<>());
            System.out.println("Departamento '" + nombreDepto + "' creado exitosamente.");
        } else {
            System.out.println("El departamento ya existe.");
        }
    }

    // Agregar empleado a un departamento
    public void agregarEmpleadoADepartamento(String nombreDepto, empleado emp) {
        if (departamentos.containsKey(nombreDepto)) {
            departamentos.get(nombreDepto).add(emp);
            System.out.println("Empleado " + emp.getNombre() + " agregado al departamento " + nombreDepto + ".");
        } else {
            System.out.println("El departamento '" + nombreDepto + "' no existe.");
        }
    }

    // Eliminar empleado de un departamento
    public void eliminarEmpleadoDeDepartamento(String nombreDepto, String idEmpleado) {
        if (departamentos.containsKey(nombreDepto)) {
            List<empleado> lista = departamentos.get(nombreDepto);
            boolean eliminado = lista.removeIf(e -> e.getId().equals(idEmpleado));
            if (eliminado) {
                System.out.println("Empleado con ID " + idEmpleado + " eliminado del departamento " + nombreDepto + ".");
            } else {
                System.out.println("Empleado no encontrado en ese departamento.");
            }
        } else {
            System.out.println("El departamento no existe.");
        }
    }

    // Transferir empleado entre departamentos
    public void transferirEmpleado(String idEmpleado, String deptoOrigen, String deptoDestino) {
        if (departamentos.containsKey(deptoOrigen) && departamentos.containsKey(deptoDestino)) {
            List<empleado> origen = departamentos.get(deptoOrigen);
            for (empleado e : origen) {
                if (e.getId().equals(idEmpleado)) {
                    origen.remove(e);
                    departamentos.get(deptoDestino).add(e);
                    System.out.println("Empleado transferido de " + deptoOrigen + " a " + deptoDestino);
                    return;
                }
            }
            System.out.println("Empleado no encontrado en el departamento de origen.");
        } else {
            System.out.println("Uno o ambos departamentos no existen.");
        }
    }

    // Listar todos los empleados por departamento
    public void listarEmpleadosPorDepartamento() {
        for (String depto : departamentos.keySet()) {
            System.out.println("\nDepartamento: " + depto);
            List<empleado> lista = departamentos.get(depto);
            if (lista.isEmpty()) {
                System.out.println("  Sin empleados.");
            } else {
                for (empleado e : lista) {
                    System.out.println("  - " + e.getNombre() + " (ID: " + e.getId() + ")");
                }
            }
        }
    }
    public List<empleado> getEmpleadosPorDepartamento(String nombreDepto) {
        return departamentos.getOrDefault(nombreDepto, new ArrayList<>());
    }

}