package repositories.interfaces;

public interface IEmployeeRepositories {
    String manage();
    void setDoingDuration(int day);
    void setPenalty(int penalty);
    void setBonus(int bonus);
}
