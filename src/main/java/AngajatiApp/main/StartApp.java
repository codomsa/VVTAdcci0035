package AngajatiApp.main;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeImpl;
import AngajatiApp.repository.EmployeeRepositoryInterface;

import java.util.Scanner;

import AngajatiApp.controller.EmployeeController;

//functionalitati
//i.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//ii.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//iii.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

public class StartApp {

    private static Scanner scanner;

    public static void main(String[] args) {
        EmployeeRepositoryInterface employeesRepository = new EmployeeImpl();
        EmployeeController employeeController = new EmployeeController(employeesRepository);
        scanner = new Scanner(System.in);
        while (true) {
            employeeController.printMenu();

            try {
                int command = scanner.nextInt();

                switch (command) {
                    case 1:
                        Employee employee = getEmployeeFromInput();
                        employeeController.addEmployee(employee);
                        System.out.println("Employee was added");
                        break;
                    case 2:
                        System.out.println("Employee ID: ");
                        int idOldEmployee = scanner.nextInt();
                        Employee oldEmployee = employeeController.findEmployeeById(idOldEmployee);
                        System.out.println("Employee function: ");
                        String newFunction = scanner.next();
                        employeeController.modifyEmployee(oldEmployee, getDidacticFunction(newFunction));
                        break;
                    case 3:
                        for (Employee employeeItem : employeeController.getSortedEmployeeList()) {
                            System.out.println(employeeItem.toString());
                        }
                        break;
					case 0:
						System.out.println("Exit!");
						return;
					default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid character!");
                scanner.next();
            }
        }
    }

    private static Employee getEmployeeFromInput() {
        System.out.println("First name: ");
        String firstName = scanner.next();
        System.out.println("Last name: ");
        String lastName = scanner.next();
        System.out.println("CNP: ");
        String cnp = scanner.next();
        System.out.println("Function: ");
        String didacticFuntion = scanner.next();
        System.out.println("Salary: ");
        Double salary = scanner.nextDouble();
        return new Employee(firstName, lastName, cnp, getDidacticFunction(didacticFuntion), salary);
    }

    private static DidacticFunction getDidacticFunction(String didacticFunction) {
        if (didacticFunction.equalsIgnoreCase("ASSISTANT")) {
            return DidacticFunction.ASSISTANT;
        }
        if (didacticFunction.equalsIgnoreCase("LECTURER")) {
            return DidacticFunction.LECTURER;
        }
        if (didacticFunction.equalsIgnoreCase("PROFESSOR")) {
            return DidacticFunction.PROFESSOR;
        }
        if (didacticFunction.equalsIgnoreCase("ASSOCIATE")) {
            return DidacticFunction.ASSOCIATE;
        }
        return DidacticFunction.ASSISTANT;
    }

}
