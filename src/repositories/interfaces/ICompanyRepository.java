package repositories.interfaces;

import entities.Employee;

import java.util.List;

public interface ICompanyRepository {
    public List<Employee> getAllEmployees();
}
