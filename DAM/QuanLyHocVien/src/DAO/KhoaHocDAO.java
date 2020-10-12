/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static GiaoDien.QuanLyKhoaHoc.modelQLKH;
import Helper.JDBCHelper;
import static Helper.JDBCHelper.rs;
import Model.KhoaHoc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nguyenvandat
 */
public class KhoaHocDAO extends DAO<KhoaHoc, String> {
    
    public static List<KhoaHoc> listKH = new ArrayList<>();
        
    @Override
    public void Insert(KhoaHoc model) {
        String sql = "insert into KhoaHoc(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) values(?,?,?,?,?,?,?)";
        JDBCHelper.executeUpdate(sql, model.getMaCD(),model.getHocPhi(),model.getThoiLuong(),model.getNgayKG(),model.getGhiChu(),model.getMaNV(),model.getNgayTao());
    }

    @Override
    public void Update(KhoaHoc model) {
        String sql = "Update KhoaHoc set MaCD = ?,HocPhi = ?,ThoiLuong = ?,NgayKG = ?,GhiChu = ?,MaNV = ?,NgayTao = ? where MaKH = ?";
        JDBCHelper.executeUpdate(sql,model.getMaCD(),model.getHocPhi(),model.getThoiLuong(),model.getNgayKG(),model.getGhiChu(),model.getMaNV(),model.getNgayTao(),model.getMaKH());
    }

    @Override
    public void Delete(String key) {
        String sql = "Delete from KhoaHoc where MaKH = ?";
        JDBCHelper.executeUpdate(sql, key);
    }

    @Override
    public void SelectAll() {
        String sql = "select * from KhoaHoc";
        JDBCHelper.executeQuery(sql);
        try {
            listKH.clear();
            modelQLKH.setRowCount(0);
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String maCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                Date ngayKG = rs.getDate(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                Date ngayTao = rs.getDate(8);
                listKH.add(new KhoaHoc(maKH, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNV, ngayTao));
                modelQLKH.addRow(new Object[]{maKH,maCD,thoiLuong,hocPhi,ngayKG,maNV,ngayTao});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SelectByKhoaHoc() {
        String sql = "select * from KhoaHoc";
        JDBCHelper.executeQuery(sql);
        try {
            listKH.clear();
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String maCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                Date ngayKG = rs.getDate(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                Date ngayTao = rs.getDate(8);
                listKH.add(new KhoaHoc(maKH, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNV, ngayTao));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SelectByID(String key) {
        String sql = "select * from KhoaHoc where MaKH = '" + key + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listKH.clear();
            modelQLKH.setRowCount(0);
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String maCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                Date ngayKG = rs.getDate(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                Date ngayTao = rs.getDate(8);
                listKH.add(new KhoaHoc(maKH, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNV, ngayTao));
                modelQLKH.addRow(new Object[]{maKH,maCD,thoiLuong,hocPhi,ngayKG,maNV,ngayTao});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SelectByIDCboKH(String maChuyenDe) {
        String sql = "select * from KhoaHoc where MaCD = '" + maChuyenDe + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listKH.clear();
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String maCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                Date ngayKG = rs.getDate(5);
                String ghiChu = rs.getString(6);
                String maNV = rs.getString(7);
                Date ngayTao = rs.getDate(8);
                listKH.add(new KhoaHoc(maKH, maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNV, ngayTao));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void selectBySQL(String sql, Object... args) {
        
    }

}
