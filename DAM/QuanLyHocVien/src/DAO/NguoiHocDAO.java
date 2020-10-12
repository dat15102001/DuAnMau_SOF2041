/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static GiaoDien.QuanLyNguoiHoc.modelQLNH;
import Helper.JDBCHelper;
import static Helper.JDBCHelper.rs;
import Model.NguoiHoc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguyenvandat
 */
public class NguoiHocDAO extends DAO<NguoiHoc, String> {

    public static List<NguoiHoc> listNH = new ArrayList<>();

    @Override
    public void Insert(NguoiHoc model) {
        String sql = "insert into NguoiHoc values(?,?,?,?,?,?,?,?,?)";
        JDBCHelper.executeUpdate(sql, model.getMaNH(), model.getHoTen(), model.getNgaySinh(), model.getGioiTinh(),
                model.getDienThoai(), model.getEmail(), model.getGhiChu(), model.getMaNV(), model.getNgayDK());
    }

    @Override
    public void Update(NguoiHoc model) {
        String sql = "Update NguoiHoc set HoTen = ?,NgaySinh = ?,GioiTinh = ?,DienThoai = ?,Email = ?,GhiChu = ?,MaNV = ?,NgayDK = ? where MaNH = ?";
        JDBCHelper.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(), model.getGioiTinh(),
                model.getDienThoai(), model.getEmail(), model.getGhiChu(), model.getMaNV(), model.getNgayDK(), model.getMaNH());
    }

    @Override
    public void Delete(String key) {
        String sql = "Delete from NguoiHoc where MaNH = ?";
        JDBCHelper.executeUpdate(sql, key);
    }

    @Override
    public void SelectAll() {
        String sql = "select * from NguoiHoc";
        JDBCHelper.executeQuery(sql);
        try {
            listNH.clear();
            modelQLNH.setRowCount(0);
            while (rs.next()) {
                String maNH = rs.getString(1);
                String hoTen = rs.getString(2);
                Date ngaySinh = rs.getDate(3);
                boolean gioiTinh = rs.getBoolean(4);
                String gt = "";
                if (gioiTinh == true) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String dienThoai = rs.getString(5);
                String email = rs.getString(6);
                String ghiChu = rs.getString(7);
                String maNV = rs.getString(8);
                Date ngayDK = rs.getDate(9);
                listNH.add(new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDK));
                modelQLNH.addRow(new Object[]{maNH, hoTen, gt, dienThoai, ngaySinh, email, maNV, ngayDK, ghiChu});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectAll2() {
        String sql = "select * from NguoiHoc";
        JDBCHelper.executeQuery(sql);
        try {
            listNH.clear();
            while (rs.next()) {
                String maNH = rs.getString(1);
                String hoTen = rs.getString(2);
                Date ngaySinh = rs.getDate(3);
                boolean gioiTinh = rs.getBoolean(4);
                String gt = "";
                if (gioiTinh == true) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String dienThoai = rs.getString(5);
                String email = rs.getString(6);
                String ghiChu = rs.getString(7);
                String maNV = rs.getString(8);
                Date ngayDK = rs.getDate(9);
                listNH.add(new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDK));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectByName(String name) {
        String sql = "select * from NguoiHoc where HoTen like '%" + name + "%'";
        JDBCHelper.executeQuery(sql);
        try {
            listNH.clear();
            modelQLNH.setRowCount(0);
            while (rs.next()) {
                String maNH = rs.getString(1);
                String hoTen = rs.getString(2);
                Date ngaySinh = rs.getDate(3);
                boolean gioiTinh = rs.getBoolean(4);
                String gt = "";
                if (gioiTinh == true) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String dienThoai = rs.getString(5);
                String email = rs.getString(6);
                String ghiChu = rs.getString(7);
                String maNV = rs.getString(8);
                Date ngayDK = rs.getDate(9);
                listNH.add(new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDK));
                modelQLNH.addRow(new Object[]{maNH, hoTen, gt, dienThoai, ngaySinh, email, maNV, ngayDK, ghiChu});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SelectByID(String key) {
        String sql = "select * from NguoiHoc where MaNH = '" + key + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listNH.clear();
            modelQLNH.setRowCount(0);
            while (rs.next()) {
                String maNH = rs.getString(1);
                String hoTen = rs.getString(2);
                Date ngaySinh = rs.getDate(3);
                boolean gioiTinh = rs.getBoolean(4);
                String dienThoai = rs.getString(5);
                String email = rs.getString(6);
                String ghiChu = rs.getString(7);
                String maNV = rs.getString(8);
                Date ngayDK = rs.getDate(9);
                listNH.add(new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDK));
                modelQLNH.addRow(new Object[]{maNH, hoTen, gioiTinh, dienThoai, ngaySinh, email, maNV, ngayDK, ghiChu});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void selectBySQL(String sql, Object... args) {

    }

}
