package controllers;

import entities.BackendDev;
import repositories.interfaces.IBackendDevRepository;

import java.util.List;

public class BackendDevController {
   private final IBackendDevRepository repo;

    public BackendDevController(IBackendDevRepository repo) {
        this.repo = repo;
    }

    public String getAllBackend(){
        List<BackendDev> list = repo.getAllBackendDevs();
        return list.toString();
    }

    public String getBackendByName(String name, String surname){
        List<BackendDev> list = repo.getBackendDevByName(name, surname);
        return (list.size() == 0 ? "Backend developer was not found." : list.toString());
    }

    public String getBackendByStatus(String status){
        List<BackendDev> list = repo.getBackendDevByStatus(status);
        return (list.size() == 0 ? "Backend developer was not found." : list.toString());
    }


}
