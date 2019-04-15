package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbCon {

    public dbCon() {
    }
    
    public static Connection openConnect() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demostructs2", "root", "");
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeConnect(ResultSet rs, PreparedStatement ps, Connection cn) {
        try {
            if(rs!=null && rs.isClosed())
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(ps!=null && ps.isClosed())
                ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(cn!=null && cn.isClosed())
                cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
