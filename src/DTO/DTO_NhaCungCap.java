/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class DTO_NhaCungCap {

    private int id;
    private String tenNCC;
    private String sdt;
    private String email;
    private String diaChi;
    private double tongTienMua, noCanTra;
    private String ghiChu;

    public double getTongTienMua() {
        return tongTienMua;
    }

    public void setTongTienMua(double tongTienMua) {
        this.tongTienMua = tongTienMua;
    }

    public double getNoCanTra() {
        return noCanTra;
    }

    public void setNoCanTra(double noCanTra) {
        this.noCanTra = noCanTra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
