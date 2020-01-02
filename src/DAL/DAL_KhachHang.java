/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAL_KhachHang {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
    
    public ArrayList<DTO_KhachHang> getListKhachHang()
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        ArrayList<DTO_KhachHang> result = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setName(rs.getString("tenKhachHang"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setAddress(rs.getString("address"));
                result.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                if(null != conn) { 
                    // cleanup resources, once after processing
                    rs.close();
                    ps.close();
                    // and then finally close connection
                    conn.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        
        return result;
    }
    
    public boolean addKhachHang(DTO_KhachHang kh)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        try {
            PreparedStatement pStmt=conn.prepareStatement("insert into KhachHang(tenKhachHang, sdt, email, address) "
               +"values(?,?,?,?)");
            pStmt.setString(1, kh.getName());
            pStmt.setString(2, kh.getSdt());
            pStmt.setString(3, kh.getEmail());
            pStmt.setString(4, kh.getAddress());
            
            pStmt.executeUpdate();           

        //pStmt.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public boolean deleteKhachHang(int id)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        try {
            PreparedStatement pStmt=conn.prepareStatement("delete from KhachHang where id = ?");
            pStmt.setInt(1, id);
            
            pStmt.executeUpdate();           

        //pStmt.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public boolean updateKhachHang(DTO_KhachHang kh)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        try {
            PreparedStatement pStmt=conn.prepareStatement("update KhachHang "
                    + "set tenKhachHang = ?, sdt = ?, email = ?, address = ?"
                    + " where id = ?");
            pStmt.setString(1, kh.getName());
            pStmt.setString(2, kh.getSdt());
            pStmt.setString(3, kh.getEmail());
            pStmt.setString(4, kh.getAddress());
            pStmt.setInt(5, kh.getId());
            
            pStmt.executeUpdate();           

        //pStmt.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public ArrayList<DTO_KhachHang> searchKhachHang(String name)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        
        ArrayList<DTO_KhachHang> result = new ArrayList<>();

        try {
            PreparedStatement pStmt=conn.prepareStatement("select * "
                + "from KhachHang "
                + "where tenKhachHang like ?");
            pStmt.setString(1, "%" +name + "%");
            rs = pStmt.executeQuery();
            
            while(rs.next())
            {
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setName(rs.getString("tenKhachHang"));
                kh.setSdt(rs.getString("sdt"));
                kh.setEmail(rs.getString("email"));
                kh.setAddress(rs.getString("address"));
                result.add(kh);
                
                System.out.println("DAL.DAL_KhachHang.searchKhachHang()");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                if(null != conn) { 
                    // cleanup resources, once after processing
                    rs.close();
                    // and then finally close connection
                    conn.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        
        return result;
    }
}
