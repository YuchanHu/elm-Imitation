package Utils;

import Pojo.Business;

import java.util.List;

/**
 *   显示商家信息工具类
 * @author Administrator
 *
 */
public class BusinessUtil {

    public static void showInfo(List<Business> businessList) {
        System.out.println("商家名称\t商家地址\t商家简介\t起始金额\t配送费");
        for (Business business : businessList) {
            System.out.println(business.getBusinessName() + "\t" + business.getBusinessAddress() + "\t" + business.getBusinessExplain() + "\t" +business.getStarPrice() + "\t" + business.getDeliveryPrice());
        }
    }
    public static void showInfo(Business business) {
        System.out.println("商家名称\t商家地址\t商家简介\t起始金额\t配送费");
        System.out.println(business.getBusinessName() + "\t" + business.getBusinessAddress() + "\t" + business.getBusinessExplain() + "\t" +business.getStarPrice() + "\t" + business.getDeliveryPrice());
    }
}