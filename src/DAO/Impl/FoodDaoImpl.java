package DAO.Impl;

import DAO.FoodDao;
import Pojo.Food;
import Utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {

    private PreparedStatement ps = null;
    private ResultSet res;

    @Override
    public int saveFood(Food food) {
        String sql = "INSERT INTO food (foodName,foodExplain,foodPrice,businessId) VALUES (?,?,?,?)";
        Connection conn = DBUtil.getConnection();
        int temp = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getFoodExplain());
            ps.setDouble(3, food.getFoodPrice());
            ps.setInt(4, food.getBusinessId());
            temp = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return temp;
    }

    @Override
    public int editFood(Food food) {
        String sql = "UPDATE food SET foodName = ?,foodExplain = ?,foodPrice = ? WHERE foodId =?";
        Connection conn = DBUtil.getConnection();
        int temp = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, food.getFoodName());
            ps.setString(2, food.getFoodExplain());
            ps.setDouble(3, food.getFoodPrice());
            ps.setInt(4, food.getFoodId());
            temp = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return temp;

    }

    @Override
    public Food findFoodById(int foodId) {
        String sql = "SELECT * FROM food where foodId =?";
        Connection conn = DBUtil.getConnection();
        Food food = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, foodId);
            res = ps.executeQuery();
            while (res.next()) {
                food = new Food();
                food.setFoodId(res.getInt("foodId"));
                food.setFoodName(res.getString("foodName"));
                food.setFoodExplain(res.getString("foodExplain"));
                food.setFoodPrice(res.getDouble("foodPrice"));
                food.setBusinessId(res.getInt("businessId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return food;
    }

    @Override
    public int deleteFood(int foodId) {
        String sql = "delete from food where foodId=?";
        Connection conn = DBUtil.getConnection();
        int temp = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, foodId);
            temp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return temp;
    }

    public List<Food> findFoodByBusinessId(int businessId) {
        String sql = "SELECT * FROM food WHERE businessId = ?";
        Connection conn = DBUtil.getConnection();
        List<Food> foodList = new ArrayList<>();
        int temp = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, businessId);
            res = ps.executeQuery();
            while (res.next()) {
                Food food = new Food();
                food.setFoodId(res.getInt("foodId"));
                food.setFoodName(res.getString("foodName"));
                food.setFoodExplain(res.getString("foodExplain"));
                food.setFoodPrice(res.getDouble("foodPrice"));
                food.setBusinessId(res.getInt("businessId"));
                foodList.add(food);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        return foodList;
    }
}
