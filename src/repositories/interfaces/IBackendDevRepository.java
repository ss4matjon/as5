package repositories.interfaces;

import entities.BackendDev;

import java.util.List;

public interface IBackendDevRepository {
    public List<BackendDev> getAllBackendDevs();
    public List<BackendDev> getBackendDevByName(String name, String surname);
    public List<BackendDev> getBackendDevByStatus(String status);
}
