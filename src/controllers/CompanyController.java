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
    public String getTotalCost(){
        int total = repo.getTotalCost();
        return total != -1 ? "Total value of IT company " + total + "$" : "Failed";
    }
}
