package DAO.Impl;

import Controller.BusinessController;
import DAO.BusinessDao;
import Pojo.Business;
import Utils.DBUtil;
import Utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessDaoImpl implements BusinessDao {

    private final Scanner sc = new Scanner(System.in);

    PreparedStatement ps = null;

    @Override
    public List<Business> findBusinessAll() {
        String sql = "SELECT * FROM business";
        Connection conn = DBUtil.getConnection();
        List<Business> list = new ArrayList<>();
        ResultSet res = null;
        try {
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Business business = new Business(
                        res.getInt("businessId"),
                        res.getString("password"),
                        res.getString("businessName"),
                        res.getString("businessAddress"),
                        res.getString("businessExplain"),
                        res.getDouble("starPrice"),
                        res.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return list;
    }

    @Override
    public int saveBusiness(Business business) {
        String sql = "INSERT INTO business (password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice) VALUES (?,?,?,?,?,?)";
        Connection conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, business.getPassword());
            ps.setString(2, business.getBusinessName());
            ps.setString(3, business.getBusinessAddress());
            ps.setString(4, business.getBusinessExplain());
            ps.setDouble(5, business.getStarPrice());
            ps.setDouble(6, business.getDeliveryPrice());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public int deleteBusiness(int businessId) {
        String sql = "DELETE FROM business WHERE businessId = ?";
        Connection conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, businessId);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return 0;
    }

    @Override
    public int editBusiness(Business business) {
        int res;
        Connection conn = DBUtil.getConnection();
        try {
            ps = conn.prepareStatement("UPDATE business SET businessAddress=?,businessExplain=?,starPrice=?,deliveryPrice=? WHERE businessId=?");
            ps.setString(1, business.getBusinessAddress());
            ps.setString(2, business.getBusinessExplain());
            ps.setDouble(3, business.getStarPrice());
            ps.setDouble(4, business.getDeliveryPrice());
            ps.setInt(5, business.getBusinessId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return res;
    }

    @Override
    public int updateBusinessPassword(String password, int businessId) {
        Connection conn = DBUtil.getConnection();
        int res;
        try {
            ps = conn.prepareStatement("UPDATE business SET password =? WHERE businessId=?");
            ps.setString(1, password);
            ps.setInt(2, businessId);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return res;
    }

    @Override
    public Business findBusinessById(int businessId) {
        Connection conn = DBUtil.getConnection();
        Business business = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM psbusiness WHERE businessId=?");
            ps.setInt(1, businessId);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                business = new Business();
                business.setBusinessId(resultSet.getInt("businessId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return business;
    }

    @Override
    public List<Business> findBusinessByCondition(Business condition) {
        StringBuilder sb = new StringBuilder("SELECT * FROM business WHERE TRUE ");
        //判断condition是非为空，拼接sql语句
        if (!StringUtil.isNull(condition.getBusinessName())) {
            sb.append(" and businessName LIKE '%" + condition.getBusinessName() + "%'");
        }
        if (!StringUtil.isNull(condition.getBusinessAddress())) {
            sb.append(" and businessAddress LIKE '%" + condition.getBusinessAddress() + "%'");
        }
        if (condition.getDeliveryPrice() != null) {
            sb.append(" and deliveryPrice <= " + condition.getDeliveryPrice());
        }
        String sql = sb.toString();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        List<Business> list = new ArrayList<>();
        ResultSet res = null;
        try {
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Business business = new Business(
                        res.getInt("businessId"),
                        res.getString("password"),
                        res.getString("businessName"),
                        res.getString("businessAddress"),
                        res.getString("businessExplain"),
                        res.getDouble("starPrice"),
                        res.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return list;
    }

    @Override
    public Business findBusinessByNameAndPassword(String businessName, String password) {
        String sql = "SELECT * FROM business WHERE businessName = ? AND password = ?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        Business business = null;
        ResultSet res = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, businessName);
            ps.setString(2, password);
            res = ps.executeQuery();
            if (res.next()) {
                 business = new Business(
                        res.getInt("businessId"),
                        res.getString("password"),
                        res.getString("businessName"),
                        res.getString("businessAddress"),
                        res.getString("businessExplain"),
                        res.getDouble("starPrice"),
                        res.getDouble("deliveryPrice"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return business;
    }


}
