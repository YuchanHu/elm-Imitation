package DAO;

import Pojo.Admin;

/**
 *  管理员接口
 */

public interface AdminDao {
    /**
     *  定义一个查找管理员账号密码的方法
     * @param adminName 用户名
     * @param password  密码
     * @return  Admin对象
     */
    Admin findAdminByNameAndPassword(String adminName, String password);
}
