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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DAL_NhanVien {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
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
                nv.setIdPhanQuyen(rs.getInt("idPhanQuyen"));
                nv.setIdAccount(rs.getInt("idAccount"));
                
                
                
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
//        String sql = "INSERT INTO NhanVien(hoTen,ngayVaoLam,ngaySinh,gioiTinh,diaChi,email,sdt,idAccount,idPhanQuyen)"
//                + " VALUE('"+nv.getHoTen()+"','"+nv.getNgayVaoLam().toString()+"','"+nv.getNgaySinh().toString()+
//                "','"+nv.getGioiTinh()+"','"+nv.getDiaChi()+"','"+nv.getEmail()+"','"+nv.getSdt()+"','"+nv.getIdAccount()+"','"+nv.getIdPhanQuyen()+"')";
        String sql = "INSERT INTO NhanVien(hoTen,ngayVaoLam,ngaySinh,gioiTinh,diaChi,email,sdt,idAccount,idPhanQuyen)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            String ngayVaoLam = nv.getNgayVaoLam()+"";
            String ngaySinh = nv.getNgaySinh()+"";
            ps.setDate(2, java.sql.Date.valueOf(ngayVaoLam));
            ps.setDate(3, java.sql.Date.valueOf(ngaySinh));
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getSdt());
            ps.setInt(8, nv.getIdAccount());
            ps.setInt(9, nv.getIdPhanQuyen());
            //ps.execute();
            themNV = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Thêm thành công!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Thêm thất bại!");
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
        String sql = "Delete NhanVien where id = "+ id;
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                if(null != conn) { 
                    // cleanup resources, once after processing
                    //rs.close();
                    st.close();
                    // and then finally close connection
                    conn.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        
    }
    public void suaNhanVien(DTO_NhanVien nv)
    {
        String sql = "Update NhanVien  set hoTen= ? ,ngayVaoLam= ?,ngaySinh=?,gioiTinh=?,diaChi=?,email=?,sdt=?,idPhanQuyen=? where id=?";
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            //st=conn.createStatement();
            //st.executeUpdate(sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            //String dateNgayVaoLam =  nv.getNgayVaoLam().toString();
            //String dateNgaySinh = nv.getNgaySinh().toString();
            //java.sql.Date dateNgayVaoLam; 
            //dateNgayVaoLam = new java.sql.Date(nv.getNgayVaoLam().getDate());
            //java.util.Date d1 = new java.util.Date(nv.getNgayVaoLam()+"");
            String ngayVaoLam = nv.getNgayVaoLam()+"";
            String ngaySinh = nv.getNgaySinh()+"";
            ps.setDate(2, java.sql.Date.valueOf(ngayVaoLam));
            ps.setDate(3, java.sql.Date.valueOf(ngaySinh));
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getSdt());
            //ps.setInt(8, nv.getIdAccount());
            ps.setInt(8, nv.getIdPhanQuyen());
            ps.setInt(9, nv.getId());
            //ps.execute();
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Thêm thành công!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Thêm thất bại!");
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
    }
    public ArrayList<DTO_NhanVien> timKiemNhanVien(String timKiem)
    {
        ArrayList<DTO_NhanVien> list = new ArrayList<>();
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        String sql = "Select * from NhanVien where hoTen like ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+timKiem+"%");
            rs=ps.executeQuery();
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
                nv.setIdPhanQuyen(rs.getInt("idPhanQuyen"));
                nv.setIdAccount(rs.getInt("idAccount"));
                
                
                
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
    
    
}
