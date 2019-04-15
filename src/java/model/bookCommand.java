package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bookCommand {

    public static void addBook(Truyen truyen) throws ClassNotFoundException {
        Connection cn = dbCon.openConnect();
        PreparedStatement ps = null;

        if (cn != null) {
            try {
                ps = cn.prepareStatement("insert into truyen (tenTruyen, tacGia) values (?,?)");
                ps.setString(1, truyen.getTenTruyen());
                ps.setString(2, truyen.getTacGia());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(bookCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Truyen findBook(String ten) throws ClassNotFoundException {
        Connection cn = dbCon.openConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Truyen truyen = null;
        
        if (cn != null) {
            try {
                ps = cn.prepareStatement("select * from truyen where tenTruyen=?");
                ps.setString(1, ten);
                rs = ps.executeQuery();
                while (rs.next()) {
                    truyen = new Truyen();
                    truyen.setTenTruyen(rs.getString("tenTruyen"));
                    truyen.setTacGia(rs.getString("tacGia"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(bookCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return truyen;
    }

    public static void updateBook(Truyen truyen) throws ClassNotFoundException {
        Connection cn = dbCon.openConnect();
        PreparedStatement ps = null;

        if (cn != null) {
            try {
                ps = cn.prepareStatement("update truyen set tacGia=? where tenTruyen=?");
                ps.setString(1, truyen.getTacGia());
                
                ps.setString(2, truyen.getTenTruyen());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(bookCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void delBook(String ten) throws ClassNotFoundException {
        Connection cn = dbCon.openConnect();
        PreparedStatement ps = null;

        if (cn != null) {
            try {
                ps = cn.prepareStatement("delete from truyen where tenTruyen=?");
                ps.setString(1, ten);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(bookCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<Truyen> getListBook() throws ClassNotFoundException {
        List<Truyen> listBook = new ArrayList<>();

        Connection cn = dbCon.openConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (cn != null) {
            try {
                ps = cn.prepareStatement("select * from truyen");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Truyen truyen = new Truyen();
                    truyen.setTenTruyen(rs.getString("tenTruyen"));
                    truyen.setTacGia(rs.getString("tacGia"));
                    listBook.add(truyen);
                }
            } catch (SQLException ex) {
                Logger.getLogger(bookCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listBook;
    }
}
