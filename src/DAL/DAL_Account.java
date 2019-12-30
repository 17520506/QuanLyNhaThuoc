/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_Account;
import GUI.frmTrangChu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author ADMIN
 */
public class DAL_Account {
    DTO_Account acc = new DTO_Account();
    ConnectToMSSQL a = new ConnectToMSSQL();
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
    public void taoTaiKhoan(String taikhoan, String mk)
    {
        DTO_Account acc1 = new DTO_Account();
        conn=a.getConnection();
        try {
                String sql ="Insert into Account(username,password) values ('"+taikhoan+"','"+mk+"')";
                st = conn.createStatement();
                st.executeUpdate(sql);
                
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        //return acc1;
    }
    public void xoaTaiKhoan(int id)
    {
        String sql = "Delete Account where id = "+ id;
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
    public void suaTaiKhoan(String taikhoan, String mk, int id)
    {
        //DTO_Account acc1 = new DTO_Account();
        conn=a.getConnection();
        try {
                String sql ="Update Account set username=?,password=? where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, taikhoan);
                ps.setString(2, mk);
                ps.setInt(3, id);
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
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
    public DTO_Account layIDTaiKhoan(String taikhoan, String mk)
    {
        DTO_Account acc1 = new DTO_Account();
        conn=a.getConnection();
            try {
                String sql ="Select * from Account where username ='"+taikhoan+"'and password = '"+mk+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    acc1.setId(rs.getInt("id"));
                    acc1.setUserName(rs.getString("username"));
                    acc1.setPassWord(rs.getString("password"));
                    System.out.println("username:"+acc1.getUserName()+"\tpassword:"+acc1.getPassWord());
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
        
        
        
        return acc1;
    }
    public DTO_Account layThongTinTaiKhoan(int id)
    {
        DTO_Account acc1 = new DTO_Account();
        conn=a.getConnection();
            try {
                String sql ="Select * from Account where id ='"+id+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    acc1.setId(rs.getInt("id"));
                    acc1.setUserName(rs.getString("username"));
                    acc1.setPassWord(rs.getString("password"));
                    System.out.println("username:"+acc1.getUserName()+"\tpassword:"+acc1.getPassWord());
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
            return acc1;
    }
    public boolean KiemTraTaiKhoan(String tk,String mk)
    {
        boolean kq = false;
        String truyVan = "select * from Account where username='" + tk + "' and password='" + mk + "'";
        System.out.println(truyVan);
        ResultSet rs = quanlynhathuoc.QuanLyNhaThuoc.s.ExcuteQueryGetTable(truyVan);

        try {
            if (rs.next()) {
                kq = true;
                acc.setUserName(rs.getString("username"));
                acc.setPassWord(rs.getString("password"));
                            }
        } catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }
        return kq;
    }
    public long KiemTraQuyen(String tk,String mk)
    {
        long quyen=0;
        String truyVan = "select phanquyen from tblnhanvien a,tblaccount b where a.userid = b.id ";
        ResultSet rs = quanlynhathuoc.QuanLyNhaThuoc.s.ExcuteQueryGetTable(truyVan);
        try {
            quyen= rs.getLong("phanquyen");
        } catch (SQLException ex) {
            Logger.getLogger(DAL_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return quyen;
    }
    
}
