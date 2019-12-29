/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_NhanVien;
import java.sql.Connection;
import java.sql.Date;
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
public class DAL_NhanVien {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public ArrayList<DTO_NhanVien> layDanhSachNhanVien()
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        ArrayList<DTO_NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                DTO_NhanVien nv = new DTO_NhanVien();
                nv.setId(Integer.parseInt(rs.getString("id")));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setEmail(rs.getString("email"));
                nv.setSdt(rs.getString("sdt"));
                nv.setIdAccount(rs.getInt("idAcount"));
                nv.setIdPhanQuyen(rs.getInt("idPhanQuyen"));
                list.add(nv);
                
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
        
        return list;
    }
    public int themNhanVien(DTO_NhanVien nv)
    {
        int themNV=0;
        
        String sql = "INSERT INTO NhanVien(hoTen,ngayVaoLam,ngaySinh,gioiTinh,diaChi,email,sdt,idAccount,idPhanQuyen)"
                + " VALUE(?,?,?,?,?,?,?,?,?)";
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, (Date) nv.getNgayVaoLam());
            ps.setDate(3, (Date) nv.getNgaySinh());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getSdt());
            ps.setInt(8, nv.getIdAccount());
            ps.setInt(9, nv.getIdPhanQuyen());
            themNV = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                if(null != conn) { 
                    // cleanup resources, once after processing
                    //rs.close();
                    ps.close();
                    // and then finally close connection
                    conn.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        
        return themNV;
    }
    public void xoaNhanVien(int id)
    {
        
    }
}
