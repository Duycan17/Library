/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DocGiaDAL;
import java.util.Date;

/**
 *
 * @author duy
 */
public class DocGiaBLL {
    private DocGiaDAL docGiaDAL;

    public DocGiaBLL() {
        docGiaDAL = new DocGiaDAL();
    }

    public boolean themDocGiaTreEm(String maDG, String tenDG, Date ngaySinh, String diaChi, String dienThoai, Date hanSD, String soThich,String maDGNguoiLon) {
        if (!docGiaDAL.tonTaiDocGia(maDG)) {
            return docGiaDAL.themDocGiaTreEm(maDG, tenDG, ngaySinh, diaChi, dienThoai, hanSD, soThich,maDGNguoiLon);
        }
        return false;
    }

    public boolean xoaDocGia(String maDG) {
        if (docGiaDAL.tonTaiDocGia(maDG)) {
            return docGiaDAL.xoaDocGia(maDG);
        }
        return false;
    }

    public boolean capNhatDocGia(String maDG, String tenDG, Date ngaySinh,String diaChi, String dienThoai, Date hanSD, String soThich, String maDGNguoiLon) {
        if (docGiaDAL.tonTaiDocGia(maDG)) {
            return docGiaDAL.capNhatDocGia(maDG, tenDG, ngaySinh, diaChi, dienThoai, hanSD, soThich, maDGNguoiLon);
        }
        return false;
    }

    public void lamMoi() {
        // Perform any necessary logic to clear/reset input fields
    }

    public void closeConnection() {
        docGiaDAL.closeConnection();
    }
}