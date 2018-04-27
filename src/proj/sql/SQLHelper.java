package sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SQLHelper {
	Connection con = null;// 创建一个数据库连接
	PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet result = null;// 创建一个结果集对象
	private static Properties properties;
	private final static String filePath = "resource.properties";

	static {
		try {
			// 加载Oracle驱动程序
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public SQLHelper() throws IOException {
		defaultLoader();
	}

	/** 默认属性文件 */
	private boolean defaultLoader() throws IOException {
		properties = new Properties();
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream(filePath);
			properties.load(in);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return false;
	}

	public void executeQuery(String sql, String[] values, String[] keywords) {
		try {
			System.out.println("开始尝试连接数据库！");
			String url = properties.getProperty("DB_ADDRESS");// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = properties.getProperty("DB_USERNAME");// 用户名,系统默认的账户名
			String password = properties.getProperty("DB_PASSWORD");// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("连接成功！");
			// String sql = ;// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			}
			System.out.println(pre.toString());
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			while (result.next()) {
				// 当结果集不为空时
				StringBuilder builder = new StringBuilder();

				for (int i = 0; i < keywords.length; i++) {
					builder.append(keywords[i] + ":" + result.getString(keywords[i]) + "\t");
				}
				System.out.println(builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void executeInsert(String sql, String[] values) {
		try {
			System.out.println("开始尝试连接数据库！");
			String url = properties.getProperty("DB_ADDRESS");// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = properties.getProperty("DB_USERNAME");// 用户名,系统默认的账户名
			String password = properties.getProperty("DB_PASSWORD");// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("连接成功！");
			// String sql = ;// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			}
			System.out.println(pre.toString());
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 将要修订的版本的信息写入数据库
	 * 
	 * @param sql
	 * @param values
	 */
	public void revise(String sql, String[] values) {
		try {
			System.out.println("开始尝试连接数据库！！");
			String url = properties.getProperty("DB_URL");// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = properties.getProperty("DB_USERNAME");// 用户名,系统默认的账户名
			String password = properties.getProperty("DB_PASSWORD");// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			// System.out.println("连接成功！！");
			// String sql = ;// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			}
			// System.out.println(pre.toString());
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数?????

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		String sql = "select * from HZ_QUERY_SUPPLIERS";
		String sql2 = "insert into HZ_QUERY_SUPPLIERS t (suppliers_id,t.suppliers_name) values(?,?)";
		new SQLHelper().executeInsert(sql2, new String[] { "123", "合众新能源汽车" });

	}
}
