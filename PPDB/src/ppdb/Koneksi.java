/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class Koneksi {
    private static Connection connect;
    
//    private String driverName = "com.mysql.jdbc.Drive";
//    private String url = "jdbc:mysql://localhost:3306/siswa_baru";
//    private String username = "root";
//    private String password = "";
    
    public static Connection koneksiDB() throws SQLException {
        try {
            String URL ="jdbc:mysql://localhost/siswa_baru";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connect = (Connection) DriverManager.getConnection(URL,user,pass);
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal","Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
         return connect;
    }
    
    
    
}
