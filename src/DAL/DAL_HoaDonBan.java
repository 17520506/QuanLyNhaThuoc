/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_HoaDonBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Truong Duy
 */
public class DAL_HoaDonBan {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
    
    public boolean addKhachHang(DTO_HoaDonBan hd)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        try {
            PreparedStatement pStmt=conn.prepareStatement("insert into HoaDonBan(idNhanVien, idKhachHang, ngayBan, tongTien, ghiChu) "
               +"values(?,?,?,?,?)");
            pStmt.setInt(1,hd.getIdNhanVien());
            pStmt.setInt(2,hd.getIdKhachHang());
            
            java.sql.Date sqlDate = new java.sql.Date(hd.getNgayBan().getTime());
            pStmt.setDate(3, sqlDate);
            
            pStmt.setInt(4,hd.getTongTien());
            pStmt.setString(4,hd.getGhiChu());
            
            pStmt.executeUpdate();           

        //pStmt.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
