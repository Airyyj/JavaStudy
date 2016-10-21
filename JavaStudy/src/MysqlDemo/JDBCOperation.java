package MysqlDemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class JDBCOperation {
	
	static class Student {
        private String Id;
        private String Name;
        private int  createTime;
        private int updateTime;

        Student(String Name, int  createTime, int updateTime) {
            this.setId(null); //default
            this.setName(Name);
            this.setCreateTime(createTime);
            this.setCreateTime(updateTime);
        }

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public int getCreateTime() {
			return createTime;
		}

		public void setCreateTime(int createTime) {
			this.createTime = createTime;
		}

		public int getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(int updateTime) {
			this.updateTime = updateTime;
		}

       
}
	
	
	
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/Mytest";
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
	    String sql = "insert into connectmysql (Name,createTime,updateTime) values(Tester,1464180869,1464180880)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, student.getName());
	        pstmt.setInt(2, student.getCreateTime());
	        pstmt.setInt(3, student.getUpdateTime());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	/*
	
	private static int update(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
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
	*/
	
	/*
	private static Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from students";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	*/
	
	/*
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
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// JDBCOperation.getAll();
		    JDBCOperation.insert(new Student("Tester",1464180869,1464180880));
		    /*JDBCOperation.getAll();
		    JDBCOperation.update(new Student("Bean", "", "7"));
		    JDBCOperation.delete("Achilles");
		    JDBCOperation.getAll();
*/
	}

}







/*

五、代码分析

在上述对数据库进行增删改查的过程中，可以发现其共性部分，即通用的流程：

(1)创建Connection对象、SQL查询命令字符串；

(2)对Connection对象传入SQL查询命令，获得PreparedStatement对象；

(3)对PreparedStatement对象执行executeUpdate()或executeQurey()获得结果；

(4)先后关闭PreparedStatement对象和Connection对象。

可见，使用JDBC时，最常打交道的是Connection、PreparedStatement这两个类，以及select中的ResultSet类。查阅Java API手册可以了解其具体的意义和方法。

下面引用的Java API的资料出自http://download.oracle.com/technetwork/java/javase/6/docs/zh/api/index.html。



Connection

java.sql 
接口 Connection

所有超级接口：
Wrapper
public interface Connectionextends Wrapper


与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。

Connection 对象的数据库能够提供描述其表、所支持的 SQL 语法、存储过程、此连接功能等等的信息。此信息是使用 getMetaData 方法获得的。



PreparedStatemnt

java.sql 
接口 PreparedStatement

所有超级接口：
Statement, Wrapper
所有已知子接口：
CallableStatement
public interface PreparedStatementextends Statement
表示预编译的 SQL 语句的对象。

SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。



常用方法

boolean  execute()

        在此 PreparedStatement 对象中执行 SQL 语句，该语句可以是任何种类的 SQL 语句。

ResultSet  executeQuery()

        在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象。

int  executeUpdate()

        在此 PreparedStatement 对象中执行 SQL 语句，该语句必须是一个 SQL 数据操作语言（Data Manipulation Language，DML）语句，比如 INSERT、UPDATE 或 DELETE 语句；或者是无返回内容的 SQL 语句，比如 DDL 语句。



ResultSet



java.sql 
接口 ResultSet

所有超级接口：
Wrapper
所有已知子接口：
CachedRowSet, FilteredRowSet, JdbcRowSet, JoinRowSet, RowSet, SyncResolver, WebRowSet
public interface ResultSetextends Wrapper
表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。



六、思考问题

1.每次SQL操作都需要建立和关闭连接，这势必会消耗大量的资源开销，如何避免？

分析：可以采用连接池，对连接进行统一维护，不必每次都建立和关闭。事实上这是很多对JDBC进行封装的工具所采用的。



2.Java代码中，传入的数据格式与数据库定义不同怎么办？如把Java的String对象赋值给数据库的tinyint属性。

分析：在执行SQL语句时，数据库会尝试进行转换。根据我的实验，如果用内容为纯字母的String对象传入tinyint的age属性时，会被转化成0。具体转化规则应该和数据库有关。





*/











