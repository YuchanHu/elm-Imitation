package DAO;

import Pojo.Food;

import java.util.List;

/**
 * 食品类Dao接口
 */

public interface FoodDao {
    /**
     * 根据商家ID查询食品列表
     *
     * @param businessId 商家id
     * @return 食品列表
     */
    List<Food> findFoodByBusinessId(int businessId);

    /**
     * 新增食品
     *
     * @param food 食品信息
     * @return 影响数据库行数
     */
    int saveFood(Food food);

    /**
     * 修改食品信息
     *
     * @param food 食品信息
     * @return 影响数据库行数
     */
    int editFood(Food food);

    /**
     * 根据主键查找食品信息
     *
     * @param foodId 食品Id
     * @return 食品信息
     */
    Food findFoodById(int foodId);

    /**
     * 根据主键删除食品信息
     *
     * @param foodId 食品Id
     * @return 影响数据库行数
     */
    int deleteFood(int foodId);
}
