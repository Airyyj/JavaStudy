package MysqlDemo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Connection;



public class ConnectMysqlDemo {

	static class Student {
        private String Id;
        private String Name;
        private String createTime;
        private String updateTime;

        Student(String Name, String createTime2, String updateTime2) {
            this.Id = null; //default
            this.Name = Name;
            this.setCreateTime(createTime2);
            this.setUpdateTime(updateTime2);
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime2) {
			this.createTime = createTime2;
		}

		public String getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(String updateTime2) {
			this.updateTime = updateTime2;
		}

       
}
	
	
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/Mytest?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	    String username = "root";
	    String password = "Meicai@2015";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}	
	
	private static int insert(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into timetable (Name,createTime,updateTime) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, student.getName());
	        pstmt.setString(2, student.getCreateTime());
	        pstmt.setString(3, student.getUpdateTime());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	private static int update(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update students set Age='" + student.getUpdateTime() + "' where Name='" + student.getName() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}	
	
	
	private static Integer getAll() {
	    Connection conn = getConn();
	    // 切换数据库表 ，时间类型为 int(10)
	    // String sql = "select * from connectmysql";
	    // 切换数据库表 ，时间类型为 datetime
	    String sql = "select * from timetable";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("++++++++++");
	        System.out.println(col);
	        System.out.println(rs.next());
	        System.out.println("^^^^^^^^^^");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                /*if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }*/
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	private static int delete(String name) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from students where Name='" + name + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}	
	


	public static void main(String args[]) {
		ConnectMysqlDemo.getAll();
	/*	时间类型为int
		int currentTime = (int) (System.currentTimeMillis()/1000);
		int updateTime = (int) (System.currentTimeMillis()/1000);
		
		*/
		
		// 切换时间类型为datetime 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String createTime = simpleDateFormat.format(currentTime);
		
		Date updatetime = new Date();
		
		String   updateTime = simpleDateFormat.format(updatetime);
		ConnectMysqlDemo.insert(new Student("Achilles", createTime,updateTime ));
		
		//ConnectMysqlDemo.insert(new Student("Kchilles", "Fale", "15"));
		
		//TestConnect.getAll();
		//TestConnect.update(new Student("Bean", "", "7"));
		//ConnectMysqlDemo.delete("Achilles");
		ConnectMysqlDemo.getAll();
	}


}
