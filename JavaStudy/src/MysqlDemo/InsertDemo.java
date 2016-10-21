/*package MysqlDemo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertDemo {
	
	static String sql = null;
	static MysqlDemo db1 = null;
	static ResultSet ret = null;
	//select *from connectmysql

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		insert();
		
		
		db1 = new MysqlDemo(sql);//创建DBHelper对象

		db1.close();//关闭连接
	}
	
	 public static int insert()  
	    {  
	        int i=0;  
	        String sql="insert into (表名)(列名1,列明2) values(?,?)";  
	        db1 = new MysqlDemo(sql);//创建DBHelper对象
	        try{  
	            PreparedStatement preStmt =cnn.prepareStatement(sql);  
	            preStmt.setString(1,"值");  
	            preStmt.setString(2,"值");//或者：preStmt.setInt(1,值);  
	            i=preStmt.executeUpdate();  
	        }  
	        catch (SQLException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        return i;//返回影响的行数，1为执行成功  
	    }  
		
	
	
	
	
	

}
*/