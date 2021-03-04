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
    }

