/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author duy
 */
public class TreEm {
    private String maDG;
    private String maDG_NguoiLon;
    private String soThich;

    public TreEm(String maDG, String maDG_NguoiLon, String soThich) {
        this.maDG = maDG;
        this.maDG_NguoiLon = maDG_NguoiLon;
        this.soThich = soThich;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getMaDG_NguoiLon() {
        return maDG_NguoiLon;
    }

    public void setMaDG_NguoiLon(String maDG_NguoiLon) {
        this.maDG_NguoiLon = maDG_NguoiLon;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }
}