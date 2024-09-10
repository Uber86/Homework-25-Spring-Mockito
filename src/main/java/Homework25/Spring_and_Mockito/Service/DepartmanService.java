package Homework25.Spring_and_Mockito.Service;


import Homework25.Spring_and_Mockito.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmanService {

    private final EmployeeService employeeService;

    public DepartmanService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Integer employeeSumSalary(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .mapToInt(Employee::getSalary)
                .sum();
    }



    public Employee employeeMaxSalaryDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .max(comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee employeeMinSalaryDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .min(comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> employeeAllDep(int deport) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> deport == employee.getDeport())
                .toList();

    }


    public Map<Integer, List<Employee>> groupEmployeeDep() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDeport));

    }




}
