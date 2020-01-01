/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_DonViTinh;
import DTO.DTO_LoaiHang;
import GUI.frmTrangChu;
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
public class DAL_LoaiHang {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    
    public ArrayList<DTO_LoaiHang> layDanhSachLoaiHang()
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        ArrayList<DTO_LoaiHang> list = new ArrayList<>();
        String sql = "SELECT * FROM NhomHang";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                DTO_LoaiHang lh = new DTO_LoaiHang();
                lh.setId(rs.getInt("id"));
                lh.setTen(rs.getString("tenNhomHang"));
                
                list.add(lh);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiHang.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return list;
    }
    
    public DTO_LoaiHang layThongTinLoaiHang(int id)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        DTO_LoaiHang lh = new DTO_LoaiHang();
        conn=a.getConnection();
            try {
                String sql ="Select * from NhomHang where id ='"+id+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    lh.setId(rs.getInt("id"));
                    lh.setTen(rs.getString("tenNhomHang"));
                    
                }
                //System.out.println("OKe1");
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
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
            return lh;
    }
    
    public DTO_LoaiHang layIDLoaiHang(String tenLH)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        DTO_LoaiHang lh = new DTO_LoaiHang();
        conn=a.getConnection();
            try {
                String sql ="Select * from NhomHang where tenNhomHang ='"+tenLH+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    lh.setId(rs.getInt("id"));
                    lh.setTen(rs.getString("tenNhomHang"));
                    
                }
                //System.out.println("OKe1");
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
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
            return lh;
    }
}
