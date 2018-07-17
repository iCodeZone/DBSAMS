package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {   //用于实例化连接对象
	Connection conn;
	public Base(){
		conn=null;
	}
	public Base(int n){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   //如果都是sqlserver2016版本的应该都是这个包
		String username=null;
		String password = null;
		String dburl = "jdbc:sqlserver://localhost:1433;database=SAMS";   //**********数据库名称需要个性化修改，也就是database=什么需要修改
		switch(n){
		case 1:{   //管理员
			username="Adminr";         //**********管理员用户名称和密码需要个性化修改
			password="Adminr-Adminr";
		}break;
		case 2:{   //老师
			username="TUSER";         //**********教师用户名称和密码需要个性化修改
			password="TUSER-TUSER";
		}break;
		case 3:{   //学生
			username="SUSER";         //**********学生用户名称和密码需要个性化修改
			password="SUSER-SUSER";
		}break;
		}
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
}
