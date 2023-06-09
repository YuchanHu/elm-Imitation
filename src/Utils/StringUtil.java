package Utils;

/**
 *   字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {

    /**
     *   判断字符串是否为空
     * @param str
     * @return 字符串为空返回true，否则返回false
     */
    public static boolean isNull(String str) {

        return str == null || str.length() == 0;
        //return !(str != null && str.length() > 0);
    }
}
