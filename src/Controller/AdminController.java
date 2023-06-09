package Controller;

import DAO.AdminDao;
import DAO.BusinessDao;
import DAO.Impl.AdminDaoImpl;
import DAO.Impl.BusinessDaoImpl;
import Pojo.Admin;
import Pojo.Business;

import java.util.List;
import java.util.Scanner;

/**
 * Admin 控制器
 */

public class AdminController {

    private final Scanner sc = new Scanner(System.in);
    AdminDao adminDao = new AdminDaoImpl();
    private final BusinessDao businessDao = new BusinessDaoImpl();

    /**
     * 管理员登录功能
     *
     * @return 管理员对象
     */
    public Admin login() {
        System.out.println("请输入管理员账号：");
        String adminName = sc.next();
        System.out.println("请输入管理员的密码：");
        String password = sc.next();
        //调用DAO中验证用户名密码的方法
        return adminDao.findAdminByNameAndPassword(adminName, password);
    }

    /**
     * 展示所有商家列表
     */
    public List<Business> showAllBusiness() {
        //调用DAO中显示所有商家的方法
        return businessDao.findBusinessAll();
    }

    /**
     * 创建新商家
     */
    public int createBusiness() {
        Business business = new Business();
        System.out.println("请输入新建商家的密码：");
        business.setPassword(sc.next());
        System.out.println("请输入新建商家的名字：");
        business.setBusinessName(sc.next());
        System.out.println("请输入新建商家的地址：");
        business.setBusinessAddress(sc.next());
        System.out.println("请输入新建商家的简介：");
        business.setBusinessExplain(sc.next());
        System.out.println("请输入新建商家的起送费：");
        business.setStarPrice(sc.nextDouble());
        System.out.println("请输入新建商家的配送费：");
        business.setDeliveryPrice(sc.nextDouble());
        //调用DAO中存储商家对象的方法
        return businessDao.saveBusiness(business);
    }

    public int deleteBusiness() {
        System.out.println("请输入要删除的商家id：");
        int businessId = sc.nextInt();
        return businessDao.deleteBusiness(businessId);
    }

    public List<Business> findBusinessByCondition() {
        String businessName = null;
        String businessAddress = null;
        Double deliveryPrice = null;
        System.out.println("请输入查询条件：");
        System.out.println("请选择是否需要商家名称（y/n）");
        String inputStr = sc.next();
        if (inputStr.equals("y")) {
            System.out.println("输入商家名称");
            businessName = sc.next();
        }
        System.out.println("请选择是否需要商家地址（y/n）");
        inputStr = sc.next();
        if (inputStr.equals("y")) {
            System.out.println("输入商家地址");
            businessAddress = sc.next();
        }
        System.out.println("请选择是否需要配送费（y/n）");
        inputStr = sc.next();
        if (inputStr.equals("y")) {
            System.out.println("输入配送费");
            deliveryPrice = sc.nextDouble();
        }
        Business condition = new Business();
        condition.setBusinessName(businessName);
        condition.setBusinessAddress(businessAddress);
        condition.setDeliveryPrice(deliveryPrice);
        return businessDao.findBusinessByCondition(condition);
    }

}
