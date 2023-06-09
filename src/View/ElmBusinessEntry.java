package View;

import Controller.BusinessController;
import Controller.FoodController;
import DAO.FoodDao;
import Pojo.Business;
import Utils.BusinessUtil;
import Utils.FoodUtil;

import java.util.List;
import java.util.Scanner;

/**
 * 商家程序功能入口
 */

public class ElmBusinessEntry {
    private final BusinessController bc = new BusinessController();
    private final FoodController fc = new FoodController();
    public static void main(String[] args) {
        new ElmBusinessEntry().work();
    }
    private final Scanner sc = new Scanner(System.in);

    public void work() {
        System.out.println("-------------------------------------------");
        System.out.println("|\t\t\t 饿了么商家后台管理系统  \t\t\t|");
        System.out.println("-------------------------------------------");
        Business business = bc.login();
        if (business != null) {
            System.out.println("登录成功");
            int menu = 0;
            int count = 0;
            while (menu != 5) {
                System.out.println("\n======= 一级菜单（商家管理）1.查看商家信息=2.修改商家信息=3.更新密码=4.所属商品管理=5.退出系统=======");
                System.out.println("请输入你的选择：");
                menu = sc.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println("当前商家信息为：");
                        BusinessUtil.showInfo(business);
                        break;
                    case 2:
                         count = bc.editBusiness(business);
                        if (count>0){
                            System.out.println("修改成功！");
                        }else {
                            System.out.println("修改失败！");
                        }
                        break;
                    case 3:
                        count = bc.editBusinessPwd(business);
                        if (count>0){
                            System.out.println("修改密码成功！");
                        }else {
                            System.out.println("修改密码失败！");
                        }
                        break;
                    case 4:
                        foodManager(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("欢迎下次使用本系统，再见！");
                        break;
                    default:
                        System.out.println("请输入1-5的选项");
                        break;
                }
            }
        } else {
            System.out.println("用户名或密码错误！");
        }

    }
    private void foodManager(int businessId){
        int count;
        int menu = 0;
        while(menu!=5) {
            //输出二级菜单
            System.out.println("\n======= 二级菜单（食品管理）1.查看食品列表=2.新增食品=3.修改食品=4.删除食品=5.返回一级菜单 =======");
            System.out.println("请输入你的选择：");
            menu = sc.nextInt();
            switch(menu) {
                case 1:
                    FoodUtil.showInfo(fc.findFoodByBusinessId(businessId));
                    break;
                case 2:
                    count = fc.saveFood(businessId);
                    if (count>0){
                        System.out.println("添加食品成功！");
                    }else {
                        System.out.println("添加食品失败");
                    }
                    break;
                case 3:
                    count = fc.editFood();
                    if (count>0){
                        System.out.println("修改食品成功！");
                    }else {
                        System.out.println("修改食品失败");
                    }
                    break;
                case 4:
                    count = fc.deleteFood();
                    if(count > 0) {
                        System.out.println("删除食品成功");
                    }else {
                        System.out.println("删除食品失败");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个选项！\n");
                    break;
            }
        }
    }
}
