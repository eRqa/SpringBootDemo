package ru.ivlasov.springbootdemo.dao;

import ru.ivlasov.springbootdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee e);

    public Employee findEmployeeById(int id);

    public void deleteEmployee(int id);
}
