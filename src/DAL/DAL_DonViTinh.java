/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import ConnectSQLSever.ConnectToMSSQL;
import DTO.DTO_Account;
import DTO.DTO_DonViTinh;
import DTO.DTO_HangHoa;
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
public class DAL_DonViTinh {
    
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    
    public ArrayList<DTO_DonViTinh> layDanhSachDonViTinh()
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        conn = a.getConnection();
        ArrayList<DTO_DonViTinh> list = new ArrayList<>();
        String sql = "SELECT * FROM DonViTinh";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                DTO_DonViTinh dvt = new DTO_DonViTinh();
                dvt.setId(rs.getInt("id"));
                dvt.setTen(rs.getString("tenDonViTinh"));
                
                list.add(dvt);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_DonViTinh.class.getName()).log(Level.SEVERE, null, ex);
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
    public DTO_DonViTinh layThongTinDonViTinh(int id)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        DTO_DonViTinh dvt = new DTO_DonViTinh();
        conn=a.getConnection();
            try {
                String sql ="Select * from DonViTinh where id ='"+id+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    dvt.setId(rs.getInt("id"));
                    dvt.setTen(rs.getString("tenDonViTinh"));
                    
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
            return dvt;
    }
    public DTO_DonViTinh layIDDonViTinh(String tenDVT)
    {
        ConnectToMSSQL a = new ConnectToMSSQL();
        DTO_DonViTinh dvt = new DTO_DonViTinh();
        conn=a.getConnection();
            try {
                String sql ="Select * from DonViTinh where tenDonViTinh ='"+tenDVT+"'";
                ps = conn.prepareStatement(sql);
                //ps.setInt(1, id);
                rs =ps.executeQuery();
                //System.out.println(ps.executeQuery());
                while(rs.next())
                {
                    dvt.setId(rs.getInt("id"));
                    System.out.println("DVT dal: "+ rs.getInt("id"));
                    dvt.setTen(rs.getString("tenDonViTinh"));
                    
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
            return dvt;
    }
    
}
