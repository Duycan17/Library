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
public class DocGia {
    private String maDG;
    private String tenDG;
    private LocalDate ngaySinh;

    public DocGia(String maDG, String tenDG, LocalDate ngaySinh) {
        this.maDG = maDG;
        this.tenDG = tenDG;
        this.ngaySinh = ngaySinh;
    }

    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}