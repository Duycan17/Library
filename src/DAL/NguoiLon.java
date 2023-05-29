/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDate;

/**
 *
 * @author duy
 */
public class NguoiLon {
    private String maDG;
    private String diaChi;
    private String dienThoai;
    private LocalDate hanSD;

    public NguoiLon(String maDG, String diaChi, String dienThoai, LocalDate hanSD) {
        this.maDG = maDG;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.hanSD = hanSD;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public LocalDate getHanSD() {
        return hanSD;
    }

    public void setHanSD(LocalDate hanSD) {
        this.hanSD = hanSD;
    }
}