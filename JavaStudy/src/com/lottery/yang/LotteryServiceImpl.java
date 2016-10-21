package com.lottery.yang;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class LotteryServiceImpl {
	
	//自定义测试方法 入口
/*	public static void main(String[] args) {
		//getSelect();
		String data = getMaxDataNum();
		System.out.println(data);
	}*/

	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mystudy?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username = "root";
		String password = "Meicai@2016";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int insert(Connection getConn, Lottery lottery) {
		Connection conn = getConn;
		int i = 0;
		String sql = "insert into " + "luckynumber (DataNum,L01,L02,L03,L04,L05,L06,L07,Lmoney,CreateUser,CreateTime) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, lottery.getDataNum());
			pstmt.setInt(2, lottery.getL01());
			pstmt.setInt(3, lottery.getL02());
			pstmt.setInt(4, lottery.getL03());
			pstmt.setInt(5, lottery.getL04());
			pstmt.setInt(6, lottery.getL05());
			pstmt.setInt(7, lottery.getL06());
			pstmt.setInt(8, lottery.getL07());
			pstmt.setInt(9, lottery.getLmoney());
			pstmt.setString(10, lottery.getCreateUser());
			pstmt.setString(11,  lottery.getCreateTime());

			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//查询获取最大期注值
	public static String getMaxDataNum() {
		String dateNum = null;
		Connection conn =  getConn();
		String sql = "SELECT MAX(DataNum) FROM luckynumber;";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println("获取查询期注");
			rs.next();// 该语句一定要加上，如果不交会报错。
		/*	会报如下错误
		 * java.sql.SQLException: Before start of result set
		 * */
			dateNum = rs.getString(1);		
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dateNum;
	}

	public static Integer getSelect() {
		Connection conn =  getConn();
		String sql = "select * from luckynumber";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					if (i<=8 && rs.getString(i).length()==1) {
						System.out.print(rs.getString(i) +"    ");
					}
					else if (i==9 && rs.getString(i).length()<7) {
						System.out.print(rs.getString(i) +"        ");
					}
					else {
						System.out.print(rs.getString(i)+"   ");
					}
					
					}
				System.out.println();
				System.out.println();
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
