package DAO.Impl;

import DAO.AdminDao;
import Pojo.Admin;
import Utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin findAdminByNameAndPassword(String adminName, String password) {
        String sql = "SELECT * FROM admin WHERE adminName = ? AND password = ?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        Admin admin = null;
        ResultSet res = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, adminName);
            ps.setString(2, password);
            res = ps.executeQuery();
            if (res.next()) {
                admin = new Admin();
                admin.setAdminId(res.getInt("adminId"));
                admin.setAdminName(res.getString("adminName"));
                admin.setPassword(res.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return admin;
    }


}
