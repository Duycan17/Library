/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author duy
 */
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocGiaDAL {
    private Connection conn;

    public DocGiaDAL() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      

    // Phương thức kiểm tra sự tồn tại độc giả trong bảng độc giả
    public boolean tonTaiDocGia(String maDG) {
        try {
            PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM DocGia WHERE MaDG = ?");
            selectStmt.setString(1, maDG);
            ResultSet rs = selectStmt.executeQuery();

            boolean result = rs.next();

            rs.close();
            selectStmt.close();

            return result;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức thêm 1 độc giả trẻ em
    public boolean themDocGiaTreEm(String maDG, String tenDG, Date ngaySinh, String diaChi, String dienThoai, Date hanSD, String soThich, String maDGNguoiLon) {
        try {
            // Thêm độc giả vào bảng DocGia
            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO DocGia(MaDG, TenDG, NgaySinh) VALUES (?, ?, ?)");
            insertStmt.setString(1, maDG);
            insertStmt.setString(2, tenDG);
            insertStmt.setDate(3, (java.sql.Date) ngaySinh);
            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted <= 0) {
                insertStmt.close();
                return false;
            }

            // Thêm độc giả vào bảng TreEm
            insertStmt = conn.prepareStatement("INSERT INTO TreEm(MaDG, MaDG_NguoiLon, SoThich) VALUES (?, ?, ?)");
            insertStmt.setString(1, maDG);
            insertStmt.setString(2, maDGNguoiLon);
            insertStmt.setString(3, soThich);
            rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted <= 0) {
                insertStmt.close();
                return false;
            }

            insertStmt.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức xóa 1 độc giả
    public boolean xoaDocGia(String maDG) {
        try {
            // Xóa độcgiả khỏi bảng TreEm
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM TreEm WHERE MaDG = ?");
            deleteStmt.setString(1, maDG);
            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted <= 0) {
                deleteStmt.close();
                return false;
            }

            // Xóa độc giả khỏi bảng DocGia
            deleteStmt = conn.prepareStatement("DELETE FROM DocGia WHERE MaDG = ?");
            deleteStmt.setString(1, maDG);
            rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted <= 0) {
                deleteStmt.close();
                return false;
            }

            deleteStmt.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức cập nhật 1 độc giả
    public boolean capNhatDocGia(String maDG, String tenDG, Date ngaySinh, String diaChi, String dienThoai, Date hanSD, String soThich, String maDGNguoiLon) {
        try {
            // Cập nhật thông tin độc giả trong bảng DocGia
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE DocGia SET TenDG = ?, NgaySinh = ? WHERE MaDG = ?");
            updateStmt.setString(1,tenDG);
            updateStmt.setDate(2, (java.sql.Date) ngaySinh);
            updateStmt.setString(3, maDG);
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated <= 0) {
                updateStmt.close();
                return false;
            }

            // Cập nhật thông tin độc giả trẻ em trong bảng TreEm
            updateStmt = conn.prepareStatement("UPDATE TreEm SET MaDG_NguoiLon = ?, SoThich = ? WHERE MaDG = ?");
            updateStmt.setString(1, maDGNguoiLon);
            updateStmt.setString(2, soThich);
            updateStmt.setString(3, maDG);
            rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated <= 0) {
                updateStmt.close();
                return false;
            }

            updateStmt.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức đóng kết nối
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}