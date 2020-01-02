/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_Account;
import DAL.DAL_Thongke;
import DTO.DTO_thongkethu;
import java.util.List;

/**
 *
 * @author huy
 */
public class BLL_thongke {
    private DAL_Thongke acc = new DAL_Thongke();
    public double tongchi(int thang,int nam)
    {
        return acc.thongketongchi(thang,nam);
    }
     public double tongthu(int thang,int nam)
    {
        return acc.thongketongthu(thang,nam);
    }
     public int tongluot(int thang,int nam)
    {
        return acc.thongkesoluot(thang,nam);
    }
     public String doanhthutang(int thang,int nam)
    {
        return acc.thongkegiatang(thang,nam);
    }
     public List<DTO_thongkethu> danhsachhoadon(int thang,int nam)
    {
        return acc.laydanhsachngayhoadontrongthag(thang,nam);
    }
}
