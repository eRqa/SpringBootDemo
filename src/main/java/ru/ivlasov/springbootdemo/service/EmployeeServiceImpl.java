package ru.ivlasov.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivlasov.springbootdemo.dao.EmployeeDAO;
import ru.ivlasov.springbootdemo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee e) {
        employeeDAO.saveEmployee(e);
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
