package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeMockTest {

    private EmployeeMock employeeMock;

    @BeforeEach
    public void setup() {
        employeeMock = new EmployeeMock();
    }

    @Test
    public void testAddEmployeeValidCNP() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);
        assertTrue(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeTooLongCNP() {
        Employee emp = new Employee("John", "Doe", "12345678901234", DidacticFunction.ASSISTANT, 3000.0);
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeTooShortCNP() {
        Employee emp = new Employee("John", "Doe", "123456789012", DidacticFunction.ASSISTANT, 3000.0);
        assertFalse(employeeMock.addEmployee(emp));
    }
    @Test
    public void testAddEmployeeValidFunctionASSI() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);
        assertTrue(employeeMock.addEmployee(emp));
    }
    @Test
    public void testAddEmployeeValidFunctionLECT() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.LECTURER, 3000.0);
        assertTrue(employeeMock.addEmployee(emp));
    }    @Test
    public void testAddEmployeeValidFunctionPROF() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.PROFESSOR, 3000.0);
        assertTrue(employeeMock.addEmployee(emp));
    }    @Test
    public void testAddEmployeeValidFunctionASSO() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSOCIATE, 3000.0);
        assertTrue(employeeMock.addEmployee(emp));
    }
    @Test
    public void testAddEmployeeFirstNameMoreThanTwoChars() {
        Employee emp = new Employee("Joh", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);;
        assertTrue(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeFirstNameLessThanTwoChars() {
        Employee emp = new Employee("Jo", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);;
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeLastNameMoreThanTwoChars() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);;
        assertTrue(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeLastNameLessThanTwoChars() {
        Employee emp = new Employee("John", "Do", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);;
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeValidSalary() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 0.1);;
        assertTrue(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeZeroSalary() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 0.0);;
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeNegativeSalary() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, -0.1);;
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testModifyEmployeeFunction_Valid() {
        Employee e = new Employee("Test", "User", "1234567890876", DidacticFunction.ASSISTANT, 200d);
        employeeMock.addEmployee(e);
        employeeMock.modifyEmployeeFunction(e, DidacticFunction.ASSOCIATE);
        assertEquals(DidacticFunction.ASSOCIATE, e.getFunction());
    }

    @Test
    public void testModifyEmployeeFunction_NullEmployee() {
        Employee e = null;
        assertDoesNotThrow(() -> employeeMock.modifyEmployeeFunction(e, DidacticFunction.ASSOCIATE));
    }

    @Test
    public void testModifyEmployeeFunction_InvalidEmployee() {
        Employee e = new Employee("TestInvalid", "UserInvalid", "INVALID_CNP", DidacticFunction.ASSISTANT, -1d);
        employeeMock.modifyEmployeeFunction(e, DidacticFunction.ASSOCIATE);
        assertFalse(employeeMock.getEmployeeList().contains(e));
    }

    @Test
    public void testModifyEmployeeFunction_EmployeeNotInList() {
        Employee e = new Employee("TestNotInList", "UserNotInList", "1234567890000", DidacticFunction.ASSISTANT, 200d);
        employeeMock.modifyEmployeeFunction(e, DidacticFunction.ASSOCIATE);
        assertFalse(employeeMock.getEmployeeList().contains(e));
    }

    @Test
    public void testModifyEmployeeFunction_EmployeeInList() {
        Employee e = new Employee("TestInList", "UserInList", "1234567891111", DidacticFunction.ASSISTANT, 200d);
        employeeMock.addEmployee(e);
        employeeMock.modifyEmployeeFunction(e, DidacticFunction.ASSOCIATE);
        assertEquals(DidacticFunction.ASSOCIATE, e.getFunction());
    }

}
