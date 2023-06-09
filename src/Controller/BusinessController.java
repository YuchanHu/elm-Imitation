package Controller;

import DAO.BusinessDao;
import DAO.Impl.BusinessDaoImpl;
import Pojo.Business;

import java.util.Scanner;

/**
 * Business 控制器
 */

public class BusinessController {
    private final Scanner sc = new Scanner(System.in);
    private final BusinessDao businessDao = new BusinessDaoImpl();

    /**
     * 商家登录功能
     *
     * @return 商家对象
     */
    public Business login() {
        System.out.println("请输入商家名称：");
        String businessName = sc.next();
        System.out.println("请输入商家的密码：");
        String password = sc.next();
        return businessDao.findBusinessByNameAndPassword(businessName, password);
    }

    public int editBusiness(Business business) {
        System.out.println("是否修改商家地址");
        String inputStr = sc.next();
        if (("y").equals(inputStr)) {
            System.out.println("请输入商家地址");
            business.setBusinessAddress(sc.next());
        }
        System.out.println("是否修改商家简介");
        inputStr = sc.next();
        if (("y").equals(inputStr)) {
            System.out.println("请输入商家简介");
            business.setBusinessExplain(sc.next());
        }
        System.out.println("是否修改起送费");
        inputStr = sc.next();
        if (("y").equals(inputStr)) {
            System.out.println("请输入起送费");
            business.setStarPrice(sc.nextDouble());
        }
        System.out.println("是否修改配送费");
        inputStr = sc.next();
        if (("y").equals(inputStr)) {
            System.out.println("请输入配送费");
            business.setDeliveryPrice(sc.nextDouble());
        }
        //调用Dao更新数据
        return businessDao.editBusiness(business);
    }

    public int editBusinessPwd(Business business) {
        System.out.println("修改密码功能：");
        System.out.println("请输入原密码");
        String oldPwd = sc.next();
        System.out.println("请输入新密码");
        String newPwd = sc.next();
        System.out.println("请再次输入新密码");
        String newPwd2 = sc.next();
        //对数据进行验证
        if (!business.getPassword().equals(oldPwd)) {
            System.out.println("原密码错误！");
            return 0;
        }
        if (newPwd != null) {
            if (!newPwd.equals(newPwd2)) {
                System.out.println("两次密码输入不一致");
                return 0;
            }
        }
        return businessDao.updateBusinessPassword(newPwd, business.getBusinessId());
    }
}
