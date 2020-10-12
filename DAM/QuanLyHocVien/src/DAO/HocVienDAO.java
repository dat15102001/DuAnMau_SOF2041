/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.NguoiHocDAO.listNH;
import static GiaoDien.QuanLyHocVien.modelHocVien;
import Helper.JDBCHelper;
import static Helper.JDBCHelper.rs;
import Model.HocVien;
import Model.NguoiHoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenvandat
 */
public class HocVienDAO extends DAO<HocVien, String> {

    public static List<HocVien> listHV = new ArrayList<>();
    NguoiHocDAO nh = new NguoiHocDAO();
    
    @Override
    public void Insert(HocVien model) {
        String sql = "Insert Into HocVien(MaKH,MaNH,Diem) Values(?,?,?)";
        JDBCHelper.executeUpdate(sql, model.getMaKH(), model.getMaNH(), model.getDiem());
    }

    @Override
    public void Update(HocVien model) {
        String sql = "Update HocVien set Diem = ? where MaHV = ?";
        JDBCHelper.executeUpdate(sql, model.getDiem(),model.getMaHV());
    }

    @Override
    public void Delete(String key) {
        String sql = "Delete from HocVien where MaHV = ?";
        JDBCHelper.executeUpdate(sql, key);
    }

    @Override
    public void SelectAll() {

    }

    @Override
    public void SelectByID(String key) {
        nh.SelectAll2();
        String sql = "select * from HocVien where MaKH = '" + key + "'";
        JDBCHelper.executeQuery(sql);
        try {
            listHV.clear();
            modelHocVien.setRowCount(0);
            int i = 0;
            while (rs.next()) {
                i++;
                int maHV = rs.getInt(1);
                int maKH = rs.getInt(2);
                String maNH = rs.getString(3);
                String tenNH = "";
                for (NguoiHoc nh : listNH) {
                    if (maNH.equals(nh.getMaNH())) {
                        tenNH = nh.getHoTen();
                    }
                }
                double diem = rs.getDouble(4);
                listHV.add(new HocVien(maHV, maKH, maNH, diem));
                modelHocVien.addRow(new Object[]{i,maHV,maNH,tenNH,diem});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void selectBySQL(String sql, Object... args) {

    }

}
