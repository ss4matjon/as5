package repositories.interfaces;

import entities.Manager;

import java.util.List;

public interface IManagerRepositories {
    public List<Manager> getAllManagers();
    public List<Manager> getManagerByName(String name, String surname);
}
