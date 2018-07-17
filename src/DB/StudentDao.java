package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.*;
import Bean.StudentBean;

public class StudentDao {
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;
	
	public StudentDao(){
		connection = new Base(3).getConnection();
	}

	
	//验证登录
	public boolean Login(String username,String password){   
		String sql = "SELECT Spassword FROM SUser WHERE Sno = ?";    //从表中获取密码     //***********需要进行个性化修改
		try {
			statement = connection.prepareStatement(sql);  //创建预编译处理对象
			statement.setString(1, username);//加入参数
			result = statement.executeQuery();
			if(result.next()){
				if(password.equals(result.getString(1).trim())){
					connection.close();
					statement.close();
					result.close();
					return true;
				}
				else {
					connection.close();
					statement.close();
					result.close();
					return false;
				}
			}
			else {
				connection.close();
				statement.close();
				result.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//自身验证登录用于辅助修改密码时的身份验证
	public boolean LoginSelf(String username,String password){   
		String sql = "SELECT Spassword FROM SUser WHERE Sno = ?";      //***********需要进行个性化修改
		try {
			statement = connection.prepareStatement(sql);  //创建预编译处理对象
			statement.setString(1, username);//加入参数
			result = statement.executeQuery();
			if(result.next()){
				if(password.equals(result.getString(1).trim())){
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//获取个人信息
	public StudentBean getInfo(String username){
		String sql = "SELECT * FROM Students WHERE Sno = ?";   //******需要修改    
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);//进行占位符的补充
			result = statement.executeQuery();
			StudentBean stu = new StudentBean();
			if(result.next()){//开始获取某个学生的信息
				stu.setSno(result.getString(1));
				stu.setSname(result.getString(2));
				stu.setSsex(result.getString(3));
				stu.setSage(result.getInt(4));
				stu.setSaddr(result.getString(5));
				stu.setScredit(result.getDouble(6));
				stu.setGno(result.getString(7));
				connection.close();
				statement.close();
				result.close();
				return stu;
			}
			else {
				connection.close();
				statement.close();
				result.close();
				return new StudentBean();
			}
			
		}catch(Exception e){
			System.out.println(e);
			return new StudentBean();
		}
	}
	
	//获取课程
	public ArrayList<CATBean> getCourse(String username,String data){
		System.out.println("ok1");
		String sql = "SELECT Stu_Info.Tname,Stu_Info.Cno,Stu_Info.Cname,Ctype,Credits,Cperiod,Stu_Info.Grade FROM Stu_Info,Courses WHERE Sno = ? AND Rterm = ? AND Stu_Info.Cno = Courses.Cno";    //**********需要个性化修改
		try{
			System.out.println("ok2");
			statement = connection.prepareStatement(sql);
			System.out.println("ok3");
			System.out.println(username);
			System.out.println(data);
			statement.setString(1, username);//加入参数
			statement.setString(2, data);
			System.out.println("ok4");
			result = statement.executeQuery();
			System.out.println("ok5");
			ArrayList<CATBean> cat = new ArrayList<CATBean>();
			while(result.next()){
				System.out.println("ok6");
				CATBean c = new CATBean();
				c.setTname(result.getString(1));
				c.setCno(result.getString(2));
				c.setCname(result.getString(3));
				c.setCtype(result.getString(4));
				c.setCredits(result.getDouble(5));
				c.setCperiod(result.getDouble(6));
				c.setGrade(result.getDouble(7));
				c.setRterm(data);
				cat.add(c);
			}
			connection.close();
			statement.close();
			result.close();
			System.out.println("ok7");
			return cat;
		}catch(Exception e){
			System.out.println("ok8");
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);
			return new ArrayList<CATBean>();
		}
	}
	
	//修改密码
	public boolean AlterPassword(String username,String password,String newpassword){
		if(LoginSelf(username,password)){
			String sql = "UPDATE SUser SET Spassword = ? WHERE Sno = ?";      //********需要个性化修改
			try{
				statement = connection.prepareStatement(sql);
				statement.setString(1, newpassword);
				statement.setString(2, username);
				int row = statement.executeUpdate();
				System.out.println(row);
				connection.close();
				statement.close();
				result.close();
				return row==1;
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
		}
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	
}
