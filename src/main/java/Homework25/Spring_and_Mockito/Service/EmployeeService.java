package Homework25.Spring_and_Mockito.Service;

import Homework25.Spring_and_Mockito.exeption.EmployeeAlreadyAddedException;
import Homework25.Spring_and_Mockito.exeption.EmployeeNotFoundException;
import Homework25.Spring_and_Mockito.exeption.EmployeeStorageIsFullException;
import Homework25.Spring_and_Mockito.exeption.ValidateExeption;
import Homework25.Spring_and_Mockito.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServicee{
    private static final int MAX_EMPLOYEE = 8;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Liza",
                    "Fedorovna",
                    10000,
                    1),
            new Employee("Lina",
                    "limbovsky",
                    20000,
                    1),
            new Employee("Luna",
                    "Savech",
                    775130,
                    2),
            new Employee("Kolya",
                    "Zamanuhovich",
                    211100,
                    2),
            new Employee("Aly",
                    "Muhhamad",
                    99999999,
                    3),
            new Employee("Zina",
                    "Zvereva",
                    44543500,
                    3)
    ));


    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int deport) {
        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, deport);
        if (employees.size() > MAX_EMPLOYEE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        employees.removeIf(employee -> employee.getFirstName()
                .equals(firstName) && employee.getLastName().equals(lastName));
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        /*for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
            throw new EmployeeNotFoundException();

        }
        return null;

         */
    }
    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees);
    }


    public void validate(String... values) {
        for (String value : values) {
            if (!StringUtils.isEmpty(value)) {
                throw new ValidateExeption();
            }
        }
    }


}
