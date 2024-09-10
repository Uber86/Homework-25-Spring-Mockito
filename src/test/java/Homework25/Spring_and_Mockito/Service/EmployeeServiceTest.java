package Homework25.Spring_and_Mockito.Service;


import Homework25.Spring_and_Mockito.exeption.EmployeeAlreadyAddedException;
import Homework25.Spring_and_Mockito.exeption.EmployeeNotFoundException;
import Homework25.Spring_and_Mockito.exeption.EmployeeStorageIsFullException;
import Homework25.Spring_and_Mockito.exeption.ValidateExeption;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {
    EmployeeService service = new EmployeeService();


    @Test
    void testAdd() {
        assertThat(service.getAll()).size().isEqualTo(6);
        var emp = service.addEmployee("Lemon", "Lemonad",3600 ,3);
        assertThat(emp.getFirstName()).isEqualTo("Lemon");
        assertThat(emp.getLastName()).isEqualTo("Lemonad");
        assertThat(emp.getSalary()).isEqualTo(3600);
        assertThat(emp.getDeport()).isEqualTo(3);

        assertThat(service.getAll()).size().isEqualTo(7);
        assertThat(service.getAll()).contains(emp);
    }

    @Test
    void testAddAlreadyExist() {
        var emp = service.addEmployee("Lemon", "Lemonad", 3600,3);
        assertThat(emp).isNotNull();

        assertThrows
                (EmployeeAlreadyAddedException.class,
                ()->service.addEmployee("Lemon", "Lemonad", 3600,3));

    }

    @Test
    void testAddMaxSize() {
        service.addEmployee("Lemon1", "Lemonad2", 4600,4);
        service.addEmployee("Lemon2", "Lemonad2", 5600,2);
        service.addEmployee("Lemon3", "Lemonad3", 4600,2);
        assertThrows(EmployeeStorageIsFullException.class,
                () -> service.addEmployee("Lemon4", "Lemonad4", 3600, 3));
    }

    @Test
    void testAddNegativeSalary() {
        assertThrows(RuntimeException.class, () -> service.addEmployee("Lemon", "Lemonad", -3600, 3));


    }

    @Test
    void testFindEmp() {
        service.addEmployee("Lemon", "Lemonad", 3600, 3);
        var actual = service.findEmployee("Lemon", "Lemonad");

        assertThat(actual).isNotNull();
        assertThat(actual.getFirstName()).isEqualTo("Lemon");
        assertThat(actual.getLastName()).isEqualTo("Lemonad");
        assertThat(actual.getSalary()).isEqualTo(3600);
        assertThat(actual.getDeport()).isEqualTo(3);

        assertThrows(EmployeeNotFoundException.class, () -> service.findEmployee("Lemon1", "Lemonad1"));


    }

    @Test
    void testRemoveEmpl() {
        service.addEmployee("Lemon1", "Lemonad2", 4600,4);
        service.addEmployee("Lemon2", "Lemonad2", 5600,2);
        service.addEmployee("Lemon3", "Lemonad3", 4600,2);
        assertThrows(EmployeeNotFoundException.class, () -> service.removeEmployee("Lemon2", "Lemonad2"));
        assertThrows(EmployeeNotFoundException.class, () -> service.removeEmployee("Lemon1", "Lemonad1"));
        //service.removeEmployee("Lemon1", "Lemonad2");
    }

    @Test
    void validataTest() {
        assertThrows(ValidateExeption.class, () -> service.validate("123Last", "vizards2"));
    }




}