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
        Employee emp = new Employee("John", "Doe", "123456789012345", DidacticFunction.ASSISTANT, 3000.0);
        assertFalse(employeeMock.addEmployee(emp));
    }

    @Test
    public void testAddEmployeeValidFunction() {
        Employee emp = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTANT, 3000.0);
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

}
