package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.*;


//用于处理教师操作与数据库连接的部分
public class TeacherDao{     
	private Connection connection;        //获得连接对象
	private PreparedStatement statement;  //获得语句对象
	private ResultSet result;             //获得结果集
	
	public TeacherDao(){                  //实例化Base对象以获得连接对象
		connection = new Base(2).getConnection();
	}
	
	//用于验证登录
	public boolean Login(String username,String password){
		String sql = "SELECT Tpassword FROM TUser WHERE Tno = ?";    //*******************需要个性化修改
		try {
			statement = connection.prepareStatement(sql);  
			statement.setString(1, username);              
			result = statement.executeQuery();
			if(result.next()){
				if(password.equals((result.getString(1)).trim())){  
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
	
	//用于辅助修改密码来完成身份验证
	public boolean LoginSelf(String username,String password){
		String sql = "SELECT Tpassword FROM TUser WHERE Tno = ?";    //**********需要个性化修改
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			result = statement.executeQuery();
			if(result.next()){
				if(password.equals((result.getString(1)).trim())){
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

	//用于获取教师的信息
	public TeacherBean getInfo(String username){
		String sql = "SELECT * FROM Teachers WHERE Tno = ?";   //*********需要个性化修改
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);             
			result = statement.executeQuery();
			if(result.next()){
				TeacherBean teacher = new TeacherBean(); 
				teacher.setTno(result.getString(1));
				teacher.setTname(result.getString(2));
				teacher.setTsex(result.getString(3));
				teacher.setTage(result.getInt(4));
				teacher.setTtitle(result.getString(5));
				teacher.setTtel(result.getLong(6));
				connection.close();
				statement.close();
				result.close();
				return teacher;
			}
			else {
				connection.close();
				statement.close();
				result.close();
				return new TeacherBean();
			}
		}catch(Exception e){
			System.out.println(e);
			return new TeacherBean();
		}
	}
	
	//用于获取教师的所有所教的课程信息
	public ArrayList<CourseBean> getCourseInfo(String username,String date){
		String sql = "SELECT Stu_Info.Cno,Stu_Info.Cname,Ctype,Credits,Cperiod FROM Stu_Info,Courses WHERE Tno = ? AND Rterm = ? AND Stu_Info.Cno = Courses.Cno";    //**********************8闇�瑕佷釜鎬у寲淇敼琛ㄥ悕鍜屽睘鎬у悕
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, date);
			result = statement.executeQuery();
			ArrayList<CourseBean> courses = new ArrayList<CourseBean>();
			while(result.next()){
				CourseBean cource = new CourseBean();
				cource.setCno(result.getString(1));
				cource.setCname(result.getString(2));
				cource.setCtype(result.getString(3));
				cource.setCredits(result.getDouble(4));
				cource.setCperiod(result.getDouble(5));
				courses.add(cource);
			}
			connection.close();
			statement.close();
			result.close();
			return courses;
		}catch(Exception e){
			System.out.println(e);
			return new ArrayList<CourseBean>();
		}
	}
	
	//获取教师某节课的所有学生信息
	public ArrayList<MemberBean> getMember(String tno,String cno,String date){
		String sql = "SELECT Sname,Sno,Mname,Grade FROM Stu_Info WHERE Tno = ? AND Cno = ? AND Rterm = ?";   //************ 需要个性化修改
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(1, tno);
			statement.setString(2, cno);
			statement.setString(3, date);
			result = statement.executeQuery();
			ArrayList<MemberBean> mem = new ArrayList<MemberBean>();
			while(result.next()){
				MemberBean m = new MemberBean();
				m.setSname(result.getString(1));
				m.setSno(result.getString(2));
				m.setMname(result.getString(3));
				m.setGrade(result.getDouble(4));
				mem.add(m);
			}
			connection.close();
			statement.close();
			result.close();
			return mem;
		}catch(Exception e){
			System.out.println(e);
			return new ArrayList<MemberBean>(); 
		}
	}
	
	//用于修改某个班级的学生密码
	public boolean AlterGrade(ArrayList<MemberBean> m,double [] grade,String cno,String tno,String date){
		for(int i=0;i<m.size();i++){
			String sno = m.get(i).getSno();
			String sql = "UPDATE Reports SET Grade = ? WHERE Sno = ? AND Cno = ? AND Tno = ? AND Rterm = ?";    //************需要个性化修改
			try{
				statement = connection.prepareStatement(sql);
				statement.setDouble(1, grade[i]);     
				statement.setString(2, sno);
				statement.setString(3, cno);
				statement.setString(4, tno);
				statement.setString(5, date);
				statement.executeUpdate();
				if(m.get(i).getGrade()==0.0){               //如果是第一次修改课程成绩的话表示该门课结业，把改课学分加到学生总学分上
					sql = "UPDATE Students SET Scredit = Scredit + (SELECT Credits FROM Courses WHERE Cno = ?) WHERE Sno = ?";      //*****需要个性化修改
					statement = connection.prepareStatement(sql);
					statement.setString(1, cno);
					statement.setString(2, sno);
					statement.executeUpdate();
				}
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
		}
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	//修改密码
	public boolean AlterPassword(String username,String password,String newpassword){
		if(LoginSelf(username,password)){
			System.out.println("ok1");
			String sql = "UPDATE TUser SET Tpassword = ? WHERE Tno = ?";   //*******需要个性化修改
			try{
				statement = connection.prepareStatement(sql);
				statement.setString(1, newpassword);
				statement.setString(2, username);
				int row = statement.executeUpdate();
				connection.close();
				statement.close();
				result.close();
				System.out.println("ok2");
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
