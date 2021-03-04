package controllers;

import entities.BackendDev;
import entities.FrontendDev;
import repositories.FrontendDevRepository;
import repositories.interfaces.IBackendDevRepository;
import repositories.interfaces.IFrontendDevRepository;

import java.util.List;

public class FrontendDevController {
    private final IFrontendDevRepository repo;
    public FrontendDevController(IFrontendDevRepository repo) {
        this.repo = repo;
    }
    public String getAllFrontend(){
        List<FrontendDev> list = repo.getAllFrontendDevs();
        return list.toString();
    }

    public String getFrontendByName(String name, String surname){
        List<FrontendDev> list = repo.getFrontendByName(name, surname);
        return (list.size() == 0 ? "Backend developer was not found." : list.toString());
    }

    public String getBackendByStatus(String status){
        List<FrontendDev> list = repo.getFrontEndByStatus(status);
        return (list.size() == 0 ? "Backend developer was not found." : list.toString());
    }
}
