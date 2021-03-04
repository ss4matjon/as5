package controllers;

import entities.BackendDev;
import entities.Manager;
import repositories.interfaces.IBackendDevRepository;
import repositories.interfaces.IManagerRepositories;

import java.util.List;

public class ManagerController {
    private final IManagerRepositories repo;
    public ManagerController(IManagerRepositories repo) {
        this.repo = repo;
    }
    public String getAllManagers(){
        List<Manager> list = repo.getAllManagers();
        return list.toString();
    }

    public String getManagerByName(String name, String surname){
        List<Manager> list = repo.getManagerByName(name, surname);
        return (list.size() == 0 ? "Backend developer was not found." : list.toString());
    }
}
