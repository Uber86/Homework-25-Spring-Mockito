package Homework25.Spring_and_Mockito.Service;


import Homework25.Spring_and_Mockito.model.Employee;

import java.util.Collection;

public interface EmployeeServicee {

    Employee addEmployee(String firstName, String lastName, int salary, int deport);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAll();
}

