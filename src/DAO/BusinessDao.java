package DAO;

import Pojo.Business;

import java.util.List;

/**
 * 商家Dao接口
 */

public interface BusinessDao {
    /**
     *  查询所有商家信息列表
     * @return  商家列表
     */
    List<Business> findBusinessAll();

    /**
     *  新建商家信息
     * @param business 商家对象
     * @return 影响数据库的行数
     */
    int saveBusiness(Business business);

    /**
     *  删除商家信息
     * @param businessId    商家Id
     * @return 影响数据库的行数
     */
    int deleteBusiness(int businessId);

    /**
     *  修改商家信息
     * @param business  商家信息
     * @return 影响数据库的行数
     */
    int editBusiness(Business business);

    /**
     *  修改密码
     * @param password 新密码
     * @param businessId    商家id
     * @return 影响数据库的行数
     */
    int updateBusinessPassword(String password,int businessId);

    /**
     *  根据主键查询商家信息
     * @param bussinessId   主键
     * @return  商家信息
     */
    Business findBusinessById(int bussinessId);

    /**
     *  根据条件查询商家
     * @param condition  查询条件
     * @return  商家列表
     */
    List<Business> findBusinessByCondition(Business condition);

    /**
     *  根据商家名称及密码查询
     * @param businessName  商家名称
     * @param password  密码
     * @return  Business对象
     */
    Business findBusinessByNameAndPassword(String businessName,String password);
}
