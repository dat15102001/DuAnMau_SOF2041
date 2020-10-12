/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static GiaoDien.QuanLyChuyenDe.modelQLCD;
import Helper.JDBCHelper;
import static Helper.JDBCHelper.rs;
import Model.ChuyenDe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyenvandat
 */
public class ChuyenDeDAO extends DAO<ChuyenDe, String> {

    public static List<ChuyenDe> listCD = new ArrayList<>();

    @Override
    public void Insert(ChuyenDe model) {
        String sql = "insert into ChuyenDe values(?,?,?,?,?,?)";
        JDBCHelper.executeUpdate(sql, model.getMaCD(), model.getTenCD(), model.getHocPhi(), model.getThoiLuong(), model.getHinh(), model.getMoTa());
    }

    @Override
    public void Update(ChuyenDe model) {
        String sql = "Update ChuyenDe set TenCD = ?,HocPhi = ?,ThoiLuong = ?,Hinh = ?,MoTa = ? where MaCD = ?";
        JDBCHelper.executeUpdate(sql, model.getTenCD(), model.getHocPhi(), model.getThoiLuong(), model.getHinh(), model.getMoTa(), model.getMaCD());
    }

    @Override
    public void Delete(String key) {
        String sql = "Delete from ChuyenDe where MaCD = ?";
        JDBCHelper.executeUpdate(sql, key);
    }

    @Override
    public void SelectAll() {
        String sql = "select * from ChuyenDe";
        JDBCHelper.executeQuery(sql);
        try {
            listCD.clear();
            modelQLCD.setRowCount(0);
            while (rs.next()) {
                String maCD = rs.getString(1);
                String tenCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                String hinh = rs.getString(5);
                String moTa = rs.getString(6);
                listCD.add(new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong, hinh, moTa));
                modelQLCD.addRow(new Object[]{maCD,tenCD,hocPhi,thoiLuong,hinh});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SelectAlladdCboCD() {
        String sql = "select * from ChuyenDe";
        JDBCHelper.executeQuery(sql);
        try {
            listCD.clear();
//            cboChuyenDe.removeAllItems();
            while (rs.next()) {
                String maCD = rs.getString(1);
                String tenCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                String hinh = rs.getString(5);
                String moTa = rs.getString(6);
                listCD.add(new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong, hinh, moTa));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SelectByID_NAme(){
        String sql = "select * from ChuyenDe";
        JDBCHelper.executeQuery(sql);
        try {
            listCD.clear();
            while (rs.next()) {
                String maCD = rs.getString(1);
                String tenCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                String hinh = rs.getString(5);
                String moTa = rs.getString(6);
                listCD.add(new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong, hinh, moTa));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SelectByID(String key) {
        String sql = "select * from ChuyenDe where MaCD = '" + key + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listCD.clear();
            modelQLCD.setRowCount(0);
            while (rs.next()) {
                String maCD = rs.getString(1);
                String tenCD = rs.getString(2);
                double hocPhi = rs.getDouble(3);
                int thoiLuong = rs.getInt(4);
                String hinh = rs.getString(5);
                String moTa = rs.getString(6);
                listCD.add(new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong, hinh, moTa));
                modelQLCD.addRow(new Object[]{maCD,tenCD,hocPhi,thoiLuong,hinh,moTa});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void selectBySQL(String sql, Object... args) {
        JOptionPane.showMessageDialog(null, "dhsadyeiwurow");
    }

}
