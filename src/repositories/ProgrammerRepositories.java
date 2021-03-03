package repositories;

import data.interfaces.IDB;
import entities.FrontendDev;
import entities.Programmer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProgrammerRepositories {
    private final IDB db;

    public ProgrammerRepositories(IDB db) {
        this.db = db;
    }

    public List<Programmer> getAllProgrammers() {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM programmer";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            LinkedList programmers = new LinkedList();

            while(rs.next()) {
                Programmer programmer = new Programmer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                programmers.add(programmer);
            }

            LinkedList var21 = programmers;
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

    public List<Programmer> getProgrammerByName(String name, String surname) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM programmer WHERE name = ? OR surname = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, surname);
            ResultSet rs = st.executeQuery();
            LinkedList programmers = new LinkedList();

            while(rs.next()) {
                Programmer programmer = new Programmer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                programmers.add(programmer);
            }

            LinkedList var23 = programmers;
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

    public List<Programmer> getProgrammerByStatus(String status) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM programmer WHERE status = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            LinkedList programmers = new LinkedList();

            while(rs.next()) {
                Programmer programmer = new Programmer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                programmers.add(programmer);
            }

            LinkedList var22 = programmers;
            return var22;
        } catch (SQLException var19) {
            var19.printStackTrace();
        } catch (ClassNotFoundException var20) {
            var20.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException var18) {
                var18.printStackTrace();
            }

        }

        return null;
    }

    public List<FrontendDev> getAllDesigners() {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM designer";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            LinkedList designers = new LinkedList();

            while(rs.next()) {
                FrontendDev frontendDev = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                designers.add(frontendDev);
            }

            LinkedList var21 = designers;
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

    public List<FrontendDev> getDesignerByName(String name, String surname) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM designer WHERE name = ? OR surname = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, surname);
            ResultSet rs = st.executeQuery();
            LinkedList designers = new LinkedList();

            while(rs.next()) {
                FrontendDev designer = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                designers.add(designer);
            }

            LinkedList var23 = designers;
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

    public List<FrontendDev> getDesignerByStatus(String status) {
        Connection con = null;

        try {
            con = this.db.getConnection();
            String sql = "SELECT * FROM designer WHERE status = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, status);
            ResultSet rs = st.executeQuery();
            LinkedList designers = new LinkedList();

            while(rs.next()) {
                FrontendDev designer = new FrontendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                designers.add(designer);
            }

            LinkedList var22 = designers;
            return var22;
        } catch (SQLException var19) {
            var19.printStackTrace();
        } catch (ClassNotFoundException var20) {
            var20.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException var18) {
                var18.printStackTrace();
            }

        }

        return null;
    }
}
