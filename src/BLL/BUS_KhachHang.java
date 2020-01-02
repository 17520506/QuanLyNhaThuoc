/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_KhachHang;
import DTO.DTO_KhachHang;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BUS_KhachHang {
    
    DAL_KhachHang kh;
    public ArrayList<DTO_KhachHang> getListKhachHang()
    {
        kh = new DAL_KhachHang();
        return kh.getListKhachHang();
    }
    
    public boolean addKhachHang(DTO_KhachHang k)
    {
        kh = new DAL_KhachHang();
        return kh.addKhachHang(k);
    }
    
    public boolean deleteKhachHang(int id)
    {
        kh = new DAL_KhachHang();
        return kh.deleteKhachHang(id);
    }
    
    public boolean updateKhachHang(DTO_KhachHang k)
    {
        kh = new DAL_KhachHang();
        return kh.updateKhachHang(k);
    }
    
        public ArrayList<DTO_KhachHang> searchKhachHang(String name)
    {
        kh = new DAL_KhachHang();
        return kh.searchKhachHang(name);
    }
}
