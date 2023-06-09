package Utils;

import Pojo.Food;

import java.util.List;

/**
 * 显示食品信息工具类
 *
 * @author Administrator
 */
public class FoodUtil {
    public static void showInfo(List<Food> foodList) {
        System.out.println("食品ID\t食品名称\t食品简介\t食品价格\t商家ID");
        for (Food food : foodList) {
            System.out.println(food.getFoodId() + "\t" + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice() + "\t" + food.getBusinessId());
        }
    }

    public static void showInfo(Food food) {
        System.out.println("食品ID\t食品名称\t食品简介\t食品价格\t商家ID");
        System.out.println(food.getFoodId() + "\t" + "\t" + food.getFoodName() + "\t" + food.getFoodExplain() + "\t" + food.getFoodPrice() + "\t" + food.getBusinessId());
    }
}
