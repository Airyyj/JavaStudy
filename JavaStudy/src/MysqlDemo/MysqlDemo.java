/*

package MysqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDemo {
	public static final String url = "jdbc:mysql://127.0.0.1/Mytest?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","123456");
	这个地方改成conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
	
	
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "Meicai@2015";

	public Connection conn = null;
	public PreparedStatement pst = null;

	
	// 创建构造函数
	public  MysqlDemo(String sql) {
		try {
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url, user, password);//获取连接
			pst = conn.prepareStatement(sql);//准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
*/