/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static GiaoDien.QuanLyNhanVienQuanTri.modelQLNV;
import Helper.JDBCHelper;
import static Helper.JDBCHelper.rs;
import Model.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenvandat
 */
public class NhanVienDAO extends DAO<NhanVien, String> {

    public static List<NhanVien> listNV = new ArrayList<>();

    @Override
    public void Insert(NhanVien model) {
        String sql = "insert into NhanVien values(?,?,?,?)";
        JDBCHelper.executeUpdate(sql, model.getMaNV(), model.getMatKhau(), model.getHoTen(), model.getVaiTro());
    }

    @Override
    public void Update(NhanVien model) {
        String sql = "Update NhanVien set MatKhau = ?,HoTen = ?,VaiTro = ? where MaNV = ?";
        JDBCHelper.executeUpdate(sql, model.getMatKhau(), model.getHoTen(), model.getVaiTro(), model.getMaNV());
    }

    public void UpdateMK(NhanVien model) {
        String sql = "Update NhanVien set MatKhau = ? where MaNV = ?";
        JDBCHelper.executeUpdate(sql, model.getMatKhau(),model.getMaNV());
    }

    @Override
    public void Delete(String key) {
        String sql = "Delete from NhanVien where MaNV = ?";
        JDBCHelper.executeUpdate(sql, key);
    }

    @Override
    public void SelectAll() {
        String sql = "select * from NhanVien";
        JDBCHelper.executeQuery(sql);
        try {
            listNV.clear();
            modelQLNV.setRowCount(0);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String matKhau = rs.getString(2);
                String hoTen = rs.getString(3);
                boolean vaiTro = rs.getBoolean(4);
                String tenVaiTro = "";
                if (vaiTro == true) {
                    tenVaiTro = "Nhân Viên";
                } else {
                    tenVaiTro = "Trưởng phòng";
                }
                listNV.add(new NhanVien(maNV, matKhau, hoTen, vaiTro));
                modelQLNV.addRow(new Object[]{maNV, matKhau, hoTen, tenVaiTro});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectAllDN() {
        String sql = "select * from NhanVien";
        JDBCHelper.executeQuery(sql);
        try {
            listNV.clear();
            while (rs.next()) {
                String maNV = rs.getString(1);
                String matKhau = rs.getString(2);
                String hoTen = rs.getString(3);
                boolean vaiTro = rs.getBoolean(4);
                listNV.add(new NhanVien(maNV, matKhau, hoTen, vaiTro));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SelectByID(String key) {
        String sql = "select * from NhanVien where MaNV = '" + key + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listNV.clear();
            modelQLNV.setRowCount(0);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String matKhau = rs.getString(2);
                String hoTen = rs.getString(3);
                boolean vaiTro = rs.getBoolean(4);
                listNV.add(new NhanVien(maNV, matKhau, hoTen, vaiTro));
                modelQLNV.addRow(new Object[]{maNV, matKhau, hoTen, vaiTro});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void selectBySQL(String sql, Object... args) {

    }

}
