package repositories;


import data.interfaces.IDB;
import entities.Manager;
import repositories.interfaces.IManagerRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ManagerRepositories implements IManagerRepositories {
    private final IDB db;

    public ManagerRepositories(IDB db) {
        this.db = db;
    }

    public List<Manager> getAllManagers() {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM manager";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            LinkedList managers = new LinkedList();

            while(rs.next()) {
                Manager manager = new Manager(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("speciality"), rs.getString("hiredate"), rs.getString("salary"));
                managers.add(manager);
            }

            LinkedList var21 = managers;
            return var21;
        } catch (SQLException var18) {
            var18.printStackTrace();
        } catch (ClassNotFoundException var19) {
            var19.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException var17) {
                var17.printStackTrace();
            }

        }

        return null;
    }

    public List<Manager> getManagerByName(String name, String surname) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM manager WHERE name = ? OR surname = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, surname);
            ResultSet rs = st.executeQuery();
            LinkedList managers = new LinkedList();

            while(rs.next()) {
                Manager manager = new Manager(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("status"), rs.getString("level"), rs.getString("department"));
                managers.add(manager);
            }

            LinkedList var23 = managers;
            return var23;
        } catch (SQLException var20) {
            var20.printStackTrace();
        } catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException var19) {
                var19.printStackTrace();
            }

        }

        return null;
    }
}

