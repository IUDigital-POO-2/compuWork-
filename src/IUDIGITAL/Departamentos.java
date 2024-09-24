package IUDIGITAL;

import java.util.ArrayList;
import java.util.List;

// Clase para representar a un Empleado
class Employee {
    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empleado: " + name + ", ID: " + id;
    }
}

// Clase para representar un Departamento
public class Departamentos {
    private String departmentName;
    private List<Employee> employees;

    public Departamentos(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Método para añadir un nuevo empleado
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println(employee.getName() + " ha sido añadido al departamento " + departmentName);
    }

    // Método para eliminar un empleado
    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getId().equals(employeeId));
        System.out.println("Empleado con ID: " + employeeId + " ha sido eliminado del departamento " + departmentName);
    }

    // Método para transferir un empleado a otro departamento
    public void transferEmployee(Employee employee, Departamentos newDepartment) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            newDepartment.addEmployee(employee);
            System.out.println(employee.getName() + " ha sido transferido a " + newDepartment.getDepartmentName());
        } else {
            System.out.println("El empleado " + employee.getName() + " no pertenece a este departamento.");
        }
    }

    // Método para obtener el nombre del departamento
    public String getDepartmentName() {
        return departmentName;
    }

    // Método para listar los empleados en el departamento
    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No hay empleados en el departamento " + departmentName);
        } else {
            System.out.println("Empleados en el departamento " + departmentName + ":");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        // Crear algunos empleados
        Employee emp1 = new Employee("Juan Pérez", "001");
        Employee emp2 = new Employee("María García", "002");

        // Crear departamentos
        Departamentos itDepartment = new Departamentos("IT");
        Departamentos hrDepartment = new Departamentos("HR");

        // Añadir empleados al departamento IT
        itDepartment.addEmployee(emp1);
        itDepartment.addEmployee(emp2);

        // Listar empleados en IT
        itDepartment.listEmployees();

        // Transferir un empleado a HR
        itDepartment.transferEmployee(emp2, hrDepartment);

        // Listar empleados después de la transferencia
        itDepartment.listEmployees();
        hrDepartment.listEmployees();

        // Eliminar un empleado
        itDepartment.removeEmployee("001");

        // Listar empleados después de la eliminación
        itDepartment.listEmployees();
    }
}