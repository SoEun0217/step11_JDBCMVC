package kosta.mvc.model.util;

import java.io.FileInputStream;

/**
 * DB������ �ʿ��� �ε�,����,�ݱ� ��� ����
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	private static Properties proFile=new Properties();
	
	public static Properties getProFile() {
		return proFile;
	}
	/**
	 * �ε�
	 */
	

	static {
		try {
			//2���� properties ������ �ε��ؼ� Properties��ü�� �����Ѵ�.
			proFile.load(new FileInputStream("resources/board.properties"));
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			
			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	// Ŀ�ؼ��� �����ϸ� �ȵȴ�.�׻�close�� ���ش�.����ó�� ��������(�ֳ�?��¼�� DAO���� ����ó���ؾ��ϴϱ�
	// ���ʿ��� ���Ƽ�����
	// static���̴� ����:ȣ���Ҷ����� �����ϱ⺸�� �ٷ� �����ϴ°� ����.������ ��������� ������ ���� �����ϱ�
	// static���� ���� �ȴ�.
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"),proFile.getProperty("userName"), proFile.getProperty("userPass"));
	}

	/**
	 * �ݱ�(select�ΰ��)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ݱ� (insert,update,delete �� ���)
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();// �����ϱ� ������°�!
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
