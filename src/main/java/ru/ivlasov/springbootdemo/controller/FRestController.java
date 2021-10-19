package ru.ivlasov.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ivlasov.springbootdemo.entity.Employee;
import ru.ivlasov.springbootdemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee e = employeeService.findEmployeeById(id);
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        employeeService.saveEmployee(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee e) {
        employeeService.saveEmployee(e);
        return e;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee emp = employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

}
