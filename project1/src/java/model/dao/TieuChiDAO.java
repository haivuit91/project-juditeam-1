/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.service.TieuChiDAOService;
import model.entities.TieuChi;

/**
 *
 * @author Admin
 */
public class TieuChiDAO implements TieuChiDAOService {

    private static TieuChiDAO tcDAO;

    public static TieuChiDAO getInstance() {
        if (tcDAO == null) {
            tcDAO = new TieuChiDAO();
        }
        return tcDAO;
    }

    @Override
    public List<TieuChi> getTCList() {
        List<TieuChi> tcList = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TieuChi tc = new TieuChi();
                tc.setMaTC(rs.getInt("maTC"));
                tc.setTenTC(rs.getString("tenTC"));
                tcList.add(tc);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tcList;
    }

    @Override
    public TieuChi getTCByName(String tenTC) {
        TieuChi tc = new TieuChi();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where UPPER(tenTC) = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenTC.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tc.setMaTC(rs.getInt("maTC"));
                tc.setTenTC(rs.getString("tenTC"));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tc;
    }

    @Override
    public TieuChi getTCByID(int maTC) {
        TieuChi tc = new TieuChi();
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "select * from tbl_tieuchi where maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTC);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tc.setMaTC(rs.getInt("maTC"));
                tc.setTenTC(rs.getString("tenTC"));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tc;
    }

    @Override
    public boolean createTC(TieuChi tc) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "insert into tbl_tieuchi(tenTC) values(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tc.getTenTC());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean updateTC(TieuChi tc) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "update tbl_tieuchi set tenTC = ? where maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tc.getTenTC());
            pstmt.setInt(2, tc.getMaTC());
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public boolean deteleTC(int maTC) {
        boolean isCheck = false;
        try {
            Connection conn = ConnectionFactory.getConnection();
            String sql = "delete from tbl_tieuchi where maTC = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, maTC);
            pstmt.executeUpdate();
            isCheck = true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isCheck;
    }

}
