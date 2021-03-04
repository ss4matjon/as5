package repositories;

import data.interfaces.IDB;
import entities.FrontendDev;
import repositories.interfaces.IFrontendDevRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FrontendDevRepository implements IFrontendDevRepository {
    private final IDB db;

    public FrontendDevRepository(IDB db) {
        this.db = db;
    }

    public List<FrontendDev> getAllFrontendDevs() {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM FrontEndDevelopers";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            LinkedList designers = new LinkedList();

            while(rs.next()) {
                FrontendDev frontendDev = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                designers.add(frontendDev);
            }

            LinkedList zxc3 = designers;
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

    public List<FrontendDev> getFrontendByName(String name, String surname) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM FrontEndDevelopers WHERE name = ? OR surname = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, surname);
            ResultSet rs = st.executeQuery();
            LinkedList frontenddevs = new LinkedList();

            while(rs.next()) {
                FrontendDev frontendDev = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                frontenddevs.add(frontendDev);
            }

            LinkedList zxc5 = frontenddevs;
            return zxc5;
        } catch (SQLException zxc2) {
            zxc2.printStackTrace();
        } catch (ClassNotFoundException zxc3) {
            zxc3.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException zxc1) {
                zxc1.printStackTrace();
            }

        }

        return null;
    }

    public List<FrontendDev> getFrontEndByStatus(String status) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM FrontEndDevelopers WHERE status = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            LinkedList frontenddevs = new LinkedList();

            while(rs.next()) {
                FrontendDev frontendDev = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                frontenddevs.add(frontendDev);
            }

            LinkedList zxc3 = frontenddevs;
            return zxc3;
        } catch (SQLException zxc1) {
            zxc1.printStackTrace();
        } catch (ClassNotFoundException zxc2) {
            zxc2.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException zxc0) {
                zxc0.printStackTrace();
            }

        }

        return null;
    }
}
