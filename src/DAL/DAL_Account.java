/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_Account;
import GUI.frmTrangChu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author ADMIN
 */
public class DAL_Account {
    DTO_Account acc = new DTO_Account();
    
    
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
