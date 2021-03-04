package repositories;

import data.interfaces.IDB;
import entities.BackendDev;
import entities.FrontendDev;
import repositories.interfaces.IBackendDevRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BackendDevRepository implements IBackendDevRepository {
        private final IDB db;

        public BackendDevRepository(IDB db) {
            this.db = db;
        }

        public List<BackendDev> getAllBackendDevs() {
            Connection con = null;

            try {
                con = this.db.getConnection();
                String sql = "SELECT * FROM BackEndDevelopers";
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                LinkedList backenddevs = new LinkedList();

                while(rs.next()) {
                    BackendDev backendDev = new BackendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                    backenddevs.add(backendDev);
                }

                LinkedList zxc3 = backenddevs;
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

        public List<BackendDev> getBackendDevByName(String name, String surname) {
            Connection con = null;

            try {
                con = this.db.getConnection();
                String sql = "SELECT * FROM BackEndDevelopers WHERE name = ? OR surname = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, surname);
                ResultSet rs = st.executeQuery();
                LinkedList backenddevs = new LinkedList();

                while(rs.next()) {
                    BackendDev backendDev = new BackendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                    backenddevs.add(backendDev);
                }

                LinkedList zxc5 = backenddevs;
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

        public List<BackendDev> getBackendDevByStatus(String status) {
            Connection con = null;

            try {
                con = this.db.getConnection();
                String sql = "SELECT * FROM BackEndDevelopers WHERE status = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, status);
                ResultSet rs = st.executeQuery();
                LinkedList backenddevs = new LinkedList();

                while(rs.next()) {
                    BackendDev backendDev = new BackendDev(rs.getInt("id"), rs.getString("name"), rs.getString("address"),rs.getString("status"), rs.getString("level"), rs.getString("department"));
                    backenddevs.add(backendDev);
                }

                LinkedList zxc4 = backenddevs;
                return zxc4;
            } catch (SQLException var19) {
                var19.printStackTrace();
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
