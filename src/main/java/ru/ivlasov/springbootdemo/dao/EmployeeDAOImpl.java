package ru.ivlasov.springbootdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ivlasov.springbootdemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Query q = entityManager.createQuery("FROM Employee");
        List<Employee> employees = q.getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee e) {
        Employee newEmployee = entityManager.merge(e);
        e.setId(newEmployee.getId());
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee e = entityManager.find(Employee.class, id);
        return e;
    }

    @Override
    public void deleteEmployee(int id) {
        Query q = entityManager.createQuery("delete from Employee " +
                "where id =: empId");
        q.setParameter("empId", id);
        q.executeUpdate();
    }

}
