package View;

import Controller.AdminController;
import Pojo.Admin;
import Pojo.Business;
import Utils.BusinessUtil;

import java.util.List;
import java.util.Scanner;

/**
 * 管理员程序功能入口
 */

public class ElmAdminEntry {
    public static void main(String[] args) {
        new ElmAdminEntry().work();
    }

    /**
     * 启动管理员用户界面
     */
    private Scanner sc = new Scanner(System.in);

    public void work() {
        System.out.println("-----------------------------------------");
        System.out.println("|\t\t\t 饿了么后台管理系统  \t\t\t|");
        System.out.println("-----------------------------------------");
        //调用AdminController中的登录方法
        AdminController ac = new AdminController();
        Admin admin = ac.login();
        if (admin != null) {
            System.out.println("登录成功");
            int temp = 0;
            List<Business> list;
            int res;
            while (temp != 5) {
                System.out.println("\n========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请输入你的选择：");
                temp = sc.nextInt();
                switch (temp) {
                    case 1:
                        list = ac.showAllBusiness();
                        if (list.size() != 0) {
                            BusinessUtil.showInfo(list);
                        } else {
                            System.out.println("您还没有添加任何商家！");
                        }
                        break;
                    case 2:
                        list = ac.findBusinessByCondition();
                        if (list.size() != 0) {
                            System.out.println("查询成功：");
                            BusinessUtil.showInfo(list);
                        } else {
                            System.out.println("没有符合条件的商家！");
                        }
                        break;
                    case 3:
                        res = ac.createBusiness();
                        if (res > 0) {
                            System.out.println("添加成功！");
                        } else {
                            System.out.println("添加失败！");
                        }
                        break;
                    case 4:
                        res = ac.deleteBusiness();
                        if (res > 0) {
                            System.out.println("删除成功！");
                        } else {
                            System.out.println("删除失败！");
                        }
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临饿了么后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("您选择的功能不存在,请重新输入1-5的整数");
                        break;
                }
            }
        } else {
            System.out.println("登录失败");
        }
    }
}
