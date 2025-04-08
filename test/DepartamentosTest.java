package test;

import IUDIGITAL.Departamentos;
import IUDIGITAL.empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartamentosTest {

    private Departamentos dpto;
    private empleado emp1;
    private empleado emp2;

    @BeforeEach
    public void setUp() {
        dpto = new Departamentos();  // ✅ Constructor sin argumentos
        dpto.agregarDepartamento("Ventas");  // ✅ Agregamos manualmente el departamento

        emp1 = new empleado("Juan", "001");
        emp2 = new empleado("Ana", "002");
    }

    @Test
    public void testAgregarEmpleadoADepartamento() {
        dpto.agregarEmpleadoADepartamento("Ventas", emp1);

        // Asumimos que en tu clase Departamentos hay una forma de acceder a los empleados.
        // Para este ejemplo, deberías tener un método tipo `getEmpleadosPorDepartamento(String nombreDepto)`
        List<empleado> empleados = dpto.getEmpleadosPorDepartamento("Ventas");

        assertEquals(1, empleados.size());
        assertEquals("Juan", empleados.get(0).getNombre());
    }

    // Puedes agregar más pruebas aquí: eliminar, transferir, etc.
}

