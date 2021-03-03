package entities;

import entities.interfaces.INonprogrammer_member;

public class Manager extends Employee implements INonprogrammer_member {
    private int salary;
    public Manager(int EmpId, String Name, String address, String status, String level, int Department){
        super(EmpId, Name, address, status, level, Department);
    }
    public void setSalary(int money){
        this.salary=money;
    }
    public int gettingSalary(){
        return salary;
    }
    public void setDoingDuration(int day){
        Programmer.deadline=day;
        FrontendDev.deadline=day;
    }
    public void setBonus(int bonus){
        Programmer.Bonus=bonus;
        FrontendDev.Bonus=bonus;
    }
    public void setPenalty(int penalty){
        Programmer.Penalty=penalty;
        FrontendDev.Penalty=penalty;
    }
    public String manage(){
        return super.getName()+ " manage the department "+super.getDepartment();
    }
    public String work(){
        return super.getName()+ " works in IT company as manager";
    }
    public String getSalary(){
        return "He get salary "+gettingSalary()+"$ permonth.";
    }
    public void ManagerInfo(){
        System.out.println(work());
        System.out.println(getSalary());
        System.out.println(manage());
    }
}
