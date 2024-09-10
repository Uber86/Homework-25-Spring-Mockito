package Homework25.Spring_and_Mockito.Service;


import Homework25.Spring_and_Mockito.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmanServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmanService departmanService;

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Liza", "Fedorovna", 10000, 1),
                new Employee("Lina", "limbovsky", 20000, 1),
                new Employee("Luna", "Savech", 775130, 2),
                new Employee("Kolya", "Zamanuhovich", 211100, 2),
                new Employee("Aly", "Muhhamad", 99999999, 3),
                new Employee("Zina", "Zvereva", 44543500, 3)
        ));
        when(employeeServiceMock.getAll()).thenReturn(employees);

    }


    @Test
    public void testEmployeeSumSalary() {
        assertEquals(30000, departmanService.employeeSumSalary(1));
        assertDoesNotThrow(()->departmanService.employeeSumSalary(2));

        //assertThat(departmanService.employeeSumSalary(1), 30000);
        //doReturn(30000).when().employeeSumSalary(1);
    }




    @Test
    public void testEmployeeMaxSalary() {
        assertEquals(new Employee("Lina", "limbovsky", 20000, 1), departmanService.employeeMaxSalaryDep(1));
        assertNull(departmanService.employeeMaxSalaryDep(-1));
    }
    @Test
    public void testEmployeeMinSalary() {
        assertEquals(new Employee("Liza", "Fedorovna", 10000, 1), departmanService.employeeMinSalaryDep(1));
        assertNull(departmanService.employeeMinSalaryDep(-1));
    }

    @Test
    public void testAllDepartment() {
        assertThat(departmanService.employeeAllDep(1)).containsExactly(
                new Employee("Liza", "Fedorovna", 10000, 1),
                new Employee("Lina", "limbovsky", 20000, 1));

        assertThat(departmanService.employeeAllDep(2)).containsExactly(
                new Employee("Luna", "Savech", 775130, 2),
                new Employee("Kolya", "Zamanuhovich", 211100, 2));
    }

    @Test
    public void testGroupEmployeeDep () {
        assertThat(departmanService.groupEmployeeDep()).isEqualTo(
                Map.of(1, List.of(new Employee("Liza", "Fedorovna", 10000, 1), new Employee("Lina", "limbovsky", 20000, 1)),
                        2, List.of( new Employee("Luna", "Savech", 775130, 2), new Employee("Kolya", "Zamanuhovich", 211100, 2)),
                        3, List.of(new Employee("Aly", "Muhhamad", 99999999, 3), new Employee("Zina", "Zvereva", 44543500, 3))
                )
        );

    }










}