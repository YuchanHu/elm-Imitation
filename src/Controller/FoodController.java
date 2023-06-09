package Controller;

import DAO.FoodDao;
import DAO.Impl.FoodDaoImpl;
import Pojo.Food;
import Utils.FoodUtil;

import java.util.List;
import java.util.Scanner;

public class FoodController {

    private final Scanner sc = new Scanner(System.in);
    private final FoodDao foodDao = new FoodDaoImpl();

    public int saveFood(int businessId) {
        Food food = new Food();
        System.out.println("请输入商品名称：");
        food.setFoodName(sc.next());
        System.out.println("请输入商品的简介");
        food.setFoodExplain(sc.next());
        System.out.println("请输入商品单价：");
        food.setFoodPrice(sc.nextDouble());
        food.setBusinessId(businessId);
        return foodDao.saveFood(food);
    }

    public List<Food> findFoodByBusinessId(int businessId) {
        return foodDao.findFoodByBusinessId(businessId);
    }

    public int editFood() {
        System.out.println("请输入要修改的商品ID：");
        int id = sc.nextInt();
        //根据id查询源对象
        Food food = foodDao.findFoodById(id);
        //展示对象信息
        FoodUtil.showInfo(food);
        System.out.println("您是否要修改食品名称？（y/n）");
        String inputStr = sc.next();
        if ("y".equals(inputStr)) {
            food.setFoodName(sc.next());
        }
        System.out.println("您是否要修改食品介绍？（y/n）");
        inputStr = sc.next();
        if ("y".equals(inputStr)) {
            food.setFoodExplain(sc.next());
        }
        System.out.println("您是否要修改食品单价？（y/n）");
        inputStr = sc.next();
        if ("y".equals(inputStr)) {
            food.setFoodPrice(sc.nextDouble());
        }
        return foodDao.editFood(food);
    }

    public int deleteFood() {
        System.out.println("请输入要删除商品的id：");
        int id = sc.nextInt();

        //调用dao
        return foodDao.deleteFood(id);
    }
}
