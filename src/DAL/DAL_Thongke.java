/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_Account;
import DTO.DTO_thongkethu;
import GUI.frmTrangChu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huy
 */
public class DAL_Thongke {
     DTO_thongkethu acc = new DTO_thongkethu();
    ConnectToMSSQL a = new ConnectToMSSQL();
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    Statement st=null;
    public double thongketongthu(int thang,int nam)
    {
        double acc1 = 0;
        conn=a.getConnection();
        try {
                String sql ="select sum(tongtien) from HoaDonBan where month(ngayBan) = "+thang +" and year(ngayban) = "+nam;
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                
                while(rs.next())
                {
                    acc1 = rs.getDouble(1);
                }
                return acc1;
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
        
        return 0;
        //return acc1;
    }
     public double thongketongchi(int thang,int nam)
    {
        double acc1 = 0;
        conn=a.getConnection();
        try {
                String sql ="select sum(tongtien) from HoaDonNhap where month(ngaynhap) = "+thang+" and year(ngaynhap) = "+nam;
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                
                while(rs.next())
                {
                    acc1 = rs.getDouble(1);
                }
                return acc1;
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
        
        return 0;
        //return acc1;
    }
     public int thongkesoluot(int thang,int nam)
    {
        int acc1 = 0;
        conn=a.getConnection();
        try {
                String sql ="select count(id) from HoaDonBan where month(ngayban) = "+thang+" and year(ngayban) = "+nam;
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                
                while(rs.next())
                {
                    acc1 = rs.getInt(1);
                }
                return acc1;
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
        
        return 0;
        //return acc1;
    }
      public String thongkegiatang(int thang,int nam)
    {
        double acc = 0;
        double acc1 = 0;
        conn=a.getConnection();
        ResultSet rs1 = null;
        try {
            String sql1 ="select sum(tongTien) from HoaDonBan where month(ngayban) = "+(thang)+" and year(ngayban) = "+nam;
               
            String sql;
                if(thang == 1)
                    {
                         sql ="select sum(tongTien) from HoaDonBan where month(ngayban) = 12 and year(ngayban) = "+(nam-1);
                    }
                else
                    {
                        sql ="select sum(tongTien) from HoaDonBan where month(ngayban) = "+(thang-1)+" and year(ngayban) = "+nam;
                    }  
            st = conn.createStatement();
                rs = st.executeQuery(sql);
                
                while(rs.next())
                {
                    acc = rs.getDouble(1);
                    
                }
                rs1 = st.executeQuery(sql1);
                
                while(rs1.next())
                {
                    acc1 = rs1.getDouble(1);
                    
                }
                if(acc1/acc > 1.0)                 
                    return "Tăng "+((acc1 -acc)/acc)*100 +"%";
                else
                    return "Giảm "+((acc - acc1)/acc)*100 +"%";
                
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
        
        return "Lỗi";
        //return acc1;
    }
    public List<DTO_thongkethu> laydanhsachngayhoadontrongthag(int thang,int nam)
    {
        List<DTO_thongkethu> acc1 = new ArrayList<DTO_thongkethu>();
        conn=a.getConnection();
            try {
                String sql ="select day(ngayBan),sum(tongTien) from HoaDonBan where month(ngayban) = "+thang+" and year(ngayban) ="+nam+" group by day(ngayBan) ";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    DTO_thongkethu tkt = new DTO_thongkethu();
                    tkt.setngay(rs.getInt(1));
                    tkt.setdoanhthu(rs.getDouble(2));
                    acc1.add(tkt);
                }
                return acc1;
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
        
        
        
        return null;
    }
    
}
