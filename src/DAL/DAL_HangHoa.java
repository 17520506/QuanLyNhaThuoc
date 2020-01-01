/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_HangHoa;
import DTO.DTO_NhanVien;
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
public class DAL_HangHoa {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
    public ArrayList<DTO_HangHoa> layDanhSachHangHoa()
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        ArrayList<DTO_HangHoa> list = new ArrayList<>();
        String sql = "SELECT * FROM HangHoa";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                DTO_HangHoa hh = new DTO_HangHoa();
                hh.setId(rs.getInt("id"));
                hh.setTenHangHoa(rs.getString("tenHangHoa"));
                hh.setIdDonViTinh(rs.getInt("idDonViTinh"));
                hh.setIdNhomHang(rs.getInt("idNhomHang"));
                hh.setGiaBan(rs.getLong("giaBan"));
                hh.setGiaNhap(rs.getLong("giaNhap"));
                hh.setSoLuong(rs.getInt("soLuong"));
                hh.setThanhPhan(rs.getString("thanhPhan"));
                hh.setCongDung(rs.getString("congDung"));
                list.add(hh);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public int themHangHoa(DTO_HangHoa hh)
    {
        int themHH=0;
     String sql = "INSERT INTO HangHoa(tenHangHoa,idNhomHang,idDonViTinh,congDung,thanhPhan,soLuong,giaNhap,giaBan)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,hh.getTenHangHoa() );
            ps.setInt(2, hh.getIdNhomHang());
            ps.setInt(3, hh.getIdDonViTinh());
            ps.setString(4, hh.getCongDung());
            ps.setString(5, hh.getThanhPhan());
            ps.setInt(6, hh.getSoLuong());
            ps.setLong(7, hh.getGiaNhap());
            ps.setLong(8, hh.getGiaBan());
            //ps.execute();
            themHH = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Thêm thành công!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return themHH;
    }
    
    public void xoaHangHoa(int id)
    {
        String sql = "Delete HangHoa where id = "+ id;
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAL_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    public void suaHangHoa(DTO_HangHoa hh)
    {
        String sql = "Update HangHoa  set tenHangHoa= ? ,idNhomHang= ?,idDonViTinh=?,congDung=?,thanhPhan=?,soLuong=?,giaNhap=?,giaBan=? where id=?";
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,hh.getTenHangHoa() );
            ps.setInt(2, hh.getIdNhomHang());
            ps.setInt(3, hh.getIdDonViTinh());
            ps.setString(4, hh.getCongDung());
            ps.setString(5, hh.getThanhPhan());
            ps.setInt(6, hh.getSoLuong());
            ps.setLong(7, hh.getGiaNhap());
            ps.setLong(8, hh.getGiaBan());
            ps.setInt(9, hh.getId());
            //ps.execute();
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Thêm thành công!");
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    public ArrayList<DTO_HangHoa> timKiemHangHoa(String timKiem)
    {
        ArrayList<DTO_HangHoa> list = new ArrayList<>();
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        String sql = "Select * from HangHoa where tenHangHoa like ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+timKiem+"%");
            rs=ps.executeQuery();
            while(rs.next())
            {
                DTO_HangHoa hh = new DTO_HangHoa();
                hh.setId(rs.getInt("id"));
                hh.setTenHangHoa(rs.getString("tenHangHoa"));
                hh.setIdDonViTinh(rs.getInt("idDonViTinh"));
                hh.setIdNhomHang(rs.getInt("idNhomHang"));
                hh.setThanhPhan(rs.getString("thanhPhan"));
                hh.setCongDung(rs.getString("congDung"));
                hh.setGiaBan(rs.getLong("giaBan"));
                hh.setGiaNhap(rs.getLong("giaNhap"));
                hh.setSoLuong(rs.getInt("soLuong"));
                
                list.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
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
