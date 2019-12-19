/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhathuoc;

import ConnectSQLSever.ConnectToMSSQL;
import GUI.frmDangNhap;
import GUI.frmTrangChu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class QuanLyNhaThuoc {

    /**
     * @param args the command line arguments
     */
    public static ConnectToMSSQL s = new ConnectToMSSQL();
    public static Connection con = s.getConnection();
    public static frmTrangChu fTrangChu;
    public static frmDangNhap fDangNhap;
    public static void main(String[] args) {
        // TODO code application logic here
        fDangNhap = new frmDangNhap();
        fDangNhap.show();
        
        
    }
    
}
