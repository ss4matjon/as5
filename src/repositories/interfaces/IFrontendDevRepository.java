package repositories.interfaces;

import entities.FrontendDev;

import java.util.List;

public interface IFrontendDevRepository {
    public List<FrontendDev> getAllFrontendDevs();
    public List<FrontendDev> getFrontendByName(String name, String surname);
    public List<FrontendDev> getFrontEndByStatus(String status);
}
