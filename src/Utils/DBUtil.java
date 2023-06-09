package Utils;
/**
 *   JDBC工具类
 * @author Administrator
 *
 */

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
	private static String url;
	private static String userName;
	private static String password;
	private static String driver;
	
	//读取配置文件
	static {
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("config/DB.properties");
			Properties pro = new Properties();
			pro.load(in);
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			userName = pro.getProperty("jdbc.userName");
			password = pro.getProperty("jdbc.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//创建连接
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭资源
	public static void close(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stat) {
		
		try {
			if(stat != null) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet res) {
		
		try {
			if(res != null) {
				res.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
