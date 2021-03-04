package controllers;

import entities.BackendDev;
import entities.Employee;
import repositories.interfaces.IBackendDevRepository;
import repositories.interfaces.ICompanyRepository;

import java.util.List;

public class CompanyController {
    private final ICompanyRepository repo;

    public CompanyController(ICompanyRepository repo) {
        this.repo = repo;
    }
    public String getAllEmployee(){
        List<Employee> list = repo.getAllEmployees();
        return list.toString();
    }
}
