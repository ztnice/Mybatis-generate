package sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SQLHelper {
	Connection con = null;// ����һ�����ݿ�����
	PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
	ResultSet result = null;// ����һ�����������
	private static Properties properties;
	private final static String filePath = "resource.properties";

	static {
		try {
			// ����Oracle��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public SQLHelper() throws IOException {
		defaultLoader();
	}

	/** Ĭ�������ļ� */
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
			System.out.println("��ʼ�����������ݿ⣡");
			String url = properties.getProperty("DB_ADDRESS");// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
			String user = properties.getProperty("DB_USERNAME");// �û���,ϵͳĬ�ϵ��˻���
			String password = properties.getProperty("DB_PASSWORD");// �㰲װʱѡ���õ�����
			con = DriverManager.getConnection(url, user, password);// ��ȡ����
			System.out.println("���ӳɹ���");
			// String sql = ;// Ԥ������䣬�������������
			pre = con.prepareStatement(sql);// ʵ����Ԥ�������
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
			}
			System.out.println(pre.toString());
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
			while (result.next()) {
				// ���������Ϊ��ʱ
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
				// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
				// ע��رյ�˳�����ʹ�õ����ȹر�
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("���ݿ������ѹرգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void executeInsert(String sql, String[] values) {
		try {
			System.out.println("��ʼ�����������ݿ⣡");
			String url = properties.getProperty("DB_ADDRESS");// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
			String user = properties.getProperty("DB_USERNAME");// �û���,ϵͳĬ�ϵ��˻���
			String password = properties.getProperty("DB_PASSWORD");// �㰲װʱѡ���õ�����
			con = DriverManager.getConnection(url, user, password);// ��ȡ����
			System.out.println("���ӳɹ���");
			// String sql = ;// Ԥ������䣬�������������
			pre = con.prepareStatement(sql);// ʵ����Ԥ�������
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
			}
			System.out.println(pre.toString());
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
				// ע��رյ�˳�����ʹ�õ����ȹر�
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("���ݿ������ѹرգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ��Ҫ�޶��İ汾����Ϣд�����ݿ�
	 * 
	 * @param sql
	 * @param values
	 */
	public void revise(String sql, String[] values) {
		try {
			System.out.println("��ʼ�����������ݿ⣡��");
			String url = properties.getProperty("DB_URL");// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
			String user = properties.getProperty("DB_USERNAME");// �û���,ϵͳĬ�ϵ��˻���
			String password = properties.getProperty("DB_PASSWORD");// �㰲װʱѡ���õ�����
			con = DriverManager.getConnection(url, user, password);// ��ȡ����
			// System.out.println("���ӳɹ�����");
			// String sql = ;// Ԥ������䣬�������������
			pre = con.prepareStatement(sql);// ʵ����Ԥ�������
			for (int i = 0; i < values.length; i++) {
				pre.setString(i + 1, String.valueOf(values[i]));// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
			}
			// System.out.println(pre.toString());
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���?????

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
				// ע��رյ�˳�����ʹ�õ����ȹر�
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("���ݿ������ѹرգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) throws IOException {
//		@SuppressWarnings("unused")
//		String sql = "select * from HZ_QUERY_SUPPLIERS";
//		String sql2 = "insert into HZ_QUERY_SUPPLIERS t (suppliers_id,t.suppliers_name) values(?,?)";
//		new SQLHelper().executeInsert(sql2, new String[] { "123", "��������Դ����" });
//
//	}
}
