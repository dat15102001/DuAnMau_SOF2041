/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguyenvandat
 */
public class JDBCHelper {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String hosting = "jdbc:mysql://localhost:3306/Polypro";
    private static String user = "root";
    private static String password = "Dat2982001";
    public static ResultSet rs = null;
    public static PreparedStatement ps = null;
    public static Connection con;
    
    public static Connection ketnoi() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(hosting, user, password);
            System.out.println("Connection succesfully!");
        } catch (Exception ex) {
            System.out.println("Connection Eror!");
        }
        return con;
    }

    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        if (sql.trim().startsWith("{")) {
            ps = con.prepareCall(sql);
        } else {
            ps = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            ps = prepareStatement(sql, args);
            try {
                ps.executeUpdate();
            } finally {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String sql) {
        try {
            ps = prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
