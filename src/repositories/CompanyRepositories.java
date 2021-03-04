package repositories;

import data.interfaces.IDB;
import entities.BackendDev;
import entities.Employee;
import entities.FrontendDev;
import entities.Manager;
import repositories.interfaces.ICompanyRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CompanyRepositories implements ICompanyRepository {
    private final IDB db;

    public CompanyRepositories(IDB db){
        this.db =db;
    }

    public List<Employee> getAllEmployees(){
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM BackEndDevelopers";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            LinkedList company = new LinkedList();

            con = this.db.getConnection();
            String sql1 = "SELECT * FROM FrontEndDevelopers";
            PreparedStatement st1 = con.prepareStatement(sql);
            ResultSet rs1 = st.executeQuery();

            con = this.db.getConnection();
            String sql2 = "SELECT * FROM manager";
            PreparedStatement st2 = con.prepareStatement(sql);
            ResultSet rs2 = st.executeQuery();

            while(rs.next()) {
                Employee backendDev = new BackendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                company.add(backendDev);
                Employee frontendDev = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                company.add(frontendDev);
                Employee manager = new Manager(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                company.add(manager);
            }
            LinkedList zxc3 = company;
            return zxc3;
        } catch (SQLException zxc0) {
            zxc0.printStackTrace();
        } catch (ClassNotFoundException zxc1) {
            zxc1.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException zxc) {
                zxc.printStackTrace();
            }

        }

        return null;
    }

    public int getTotalCost(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql ="SELECT SUM(salary) FROM BackEndDevelopers";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int sum_backEnd = -1;
            if(rs.next()) {
                sum_backEnd = rs.getInt("sum");
            }
            sql ="SELECT SUM(salary) FROM FrontEndDevelopers";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int sum_frontEnd = 0;
            if(rs.next()){
                sum_frontEnd = rs.getInt("sum");
            }

            sql ="SELECT SUM(salary) FROM manager";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int sum_manager = 0;
            if(rs.next()) {
                sum_manager = rs.getInt("sum");
            }
            return sum_backEnd+sum_frontEnd+sum_manager;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return -1;
    }
}

