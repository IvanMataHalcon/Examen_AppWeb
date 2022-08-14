package model;


import com.mysql.cj.MysqlConnection;
import utils.MySQLConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanUser> findAll(){
        List<BeanUser> users = new LinkedList<>();
        BeanUser user;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM user;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                user = new BeanUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setCurp(rs.getString("curp"));
                user.setBirthday(rs.getString("birthday"));
                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return users;
    }
    public BeanUser findOne(int id){
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM USER WHERE ID =?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()){
                BeanUser user = new BeanUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setCurp(rs.getString("curp"));
                user.setBirthday(rs.getString("birthday"));
                return user;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save", e);
        }finally {
            closeConnections();
        }
        return null;
    }
    public boolean save(BeanUser user) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO user" +
                    "(username,curp,birthday)" +
                    " VALUES (?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getCurp());
            pstm.setString(3, user.getBirthday());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }
    public boolean delete(int id){
        try {
            conn = new MySQLConnection().getConnection();
            String query = "DELETE FROM user WHERE id = ? ;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,"Error DELETE BOOK");
            return false;
        }finally {
            closeConnections();
        }
    }
    public void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }



}





