package Homework25.Spring_and_Mockito.model;

import Homework25.Spring_and_Mockito.exeption.ThereIsNoDeportation;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private  int salary;
    private  int deport;


    public Employee(String firstName, String lastName, int salary, int deport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        if (salary < 0) {
            throw new RuntimeException();
        }
        this.deport = deport;
        if (deport <= 0 && deport > 5) {
            throw new ThereIsNoDeportation();
        }
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDeport() {
        return deport;
    }

    public void setDeport(int deport) {
        this.deport = deport;
    }

    @Override
    public String toString() {
        return "Сотрудник " +
                "Имя " + firstName +
                "Фамилия " + lastName +
                "Зарплата " + salary +
                "Отдел " + deport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(deport, employee.deport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, deport);
    }
}




