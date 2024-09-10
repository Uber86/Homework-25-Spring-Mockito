package Homework25.Spring_and_Mockito.controller;


import Homework25.Spring_and_Mockito.Service.DepartmanService;
import Homework25.Spring_and_Mockito.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmanController {

    private final DepartmanService departmanService;

    public DepartmanController(DepartmanService departmanService) {
        this.departmanService = departmanService;
    }

    // возвращение сотрудника по депортаменту
    @GetMapping(path = "/{id}/employees")
    public List<Employee> all(@PathVariable Integer id) {
        return departmanService.employeeAllDep(id);
    }


    // возвращает сумму зарплат по департаменту.
    @GetMapping(path = "/{id}/salary/sum")
    public int sum (@PathVariable Integer id) {
        return departmanService.employeeSumSalary(id    );
    }



    // возварщение сотрудника по максимальной зарплате
    @GetMapping(path = "/{id}/salary/max")
    public Employee max(@PathVariable Integer id) {
        return departmanService.employeeMaxSalaryDep(id);
    }

    // возварщение сотрудника по минимальной зарплате
    @GetMapping(path = "/{id}/salary/min")
    public Employee min(@PathVariable Integer id) {
        return departmanService.employeeMinSalaryDep(id);

    }

    //возвращает сотрудников, сгруппированых по отделам
    @GetMapping (path = "/employees")
    public Map<Integer, List<Employee>> all() {
        return departmanService.groupEmployeeDep();
    }

}
