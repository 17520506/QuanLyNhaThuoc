/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_Account;

/**
 *
 * @author ADMIN
 */
public class BLL_Account {
    private DAL_Account acc = new DAL_Account();
    public boolean KiemTraTaiKhoan(String tk,String mk)
    {
        return acc.KiemTraTaiKhoan(tk, mk);
    }
}
