package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.CATBean;
import Bean.ClassBean;
import Bean.CourseBean;
import Bean.MSBean;
import Bean.MajorBean;
import Bean.TeacherBean;

public class AdminDao {
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;
	
	public AdminDao(){
		connection = new Base(1).getConnection();
	}
	
	//锟斤拷锟斤拷锟酵放达拷锟斤拷锟斤拷锟斤拷锟叫讹拷锟斤拷
	public void Release(){   
		try {
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//锟斤拷证锟斤拷录
	public boolean Login(String username,String password){   
		if(username.equals("1")&&password.equals("1")){      //**********锟斤拷要锟斤拷锟捷革拷锟皆伙拷锟睫改癸拷锟斤拷员锟矫伙拷锟斤拷锟斤拷锟狡猴拷锟斤拷锟斤拷
			return true;
		}
		else return false;
	}

	
	/*public boolean Judge(){
		try{
		    String sql="SELECT Sno FROM Students";
		    statement = connection
		}
		return true;
	}*/
	
	/*锟斤拷锟斤拷员锟斤拷取锟轿程碉拷锟斤拷锟斤拷锟斤拷息*/
    public ArrayList<CATBean> CheckCourse(){
		try{
			String sql="SELECT Courses.Cno,Courses.Cname,Courses.Ctype,Courses.Credits,Courses.Cperiod,Teachers.Tname from Courses,Teach,Teachers where Courses.Cno=Teach.Cno and Teach.Tno=Teachers.Tno"; 
			statement = connection.prepareStatement(sql);
			result=statement.executeQuery();
			ArrayList<CATBean> array = new ArrayList<CATBean>();
			while(result.next()){
				CATBean c = new CATBean();
				c.setCno(result.getString(1));
				c.setCname(result.getString(2));
				c.setCtype(result.getString(3));
				c.setCredits(result.getDouble(4));
				c.setCperiod(result.getDouble(5));
				c.setTname(result.getString(6));
				array.add(c);
			}
			connection.close();
			statement.close();
			result.close();
			return array;
		}catch(Exception e){
			System.out.println(e);
			return new ArrayList<CATBean>();
		}
	}

	/*锟斤拷锟斤拷员锟斤拷锟捷课程憋拷呕锟饺★拷纬痰锟斤拷锟斤拷锟斤拷锟较�*/
	public CATBean CheckCourse(String cno){
		try{
			String sql="SELECT Courses.Cno,Courses.Cname,Courses.Ctype,Courses.Credits,Courses.Cperiod,Teachers.Tname from Courses,Teach,Teachers where Courses.Cno=? and Courses.Cno=Teach.Cno and Teach.Tno=Teachers.Tno"; 
			statement = connection.prepareStatement(sql);
			statement.setString(1,cno);
			result=statement.executeQuery();
			CATBean c = new CATBean();
			while(result.next()){
				c.setCno(result.getString(1));
				c.setCname(result.getString(2));
				c.setCtype(result.getString(3));
				c.setCredits(result.getDouble(4));
				c.setCperiod(result.getDouble(5));
				c.setTname(result.getString(6));
			}
			connection.close();
			statement.close();
			result.close();
			return c;
		}catch(Exception e){
			System.out.println(e);
			return new CATBean();
		}
		
	}

	/*锟斤拷锟斤拷员锟斤拷锟窖э拷锟斤拷锟较� */
	public boolean AddStudent(MSBean ms){
		try{
			String sql="Begin Transaction Del Insert into Students Values(?,?,?,?,?,null,?) Insert into SUser Values(?,?) Commit Transaction Del";
		    statement = connection.prepareStatement(sql);
			statement.setString(1,ms.getSno());
			statement.setString(2,ms.getSname());
			statement.setString(3,ms.getSsex());
			statement.setInt(4,ms.getSage());
			statement.setString(5,ms.getSaddr());
			statement.setString(6,ms.getGno());
			statement.setString(7,ms.getSno());
			statement.setString(8,"123456");
			statement.executeUpdate();
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}


	/*锟斤拷锟斤拷员锟斤拷咏锟绞︼拷锟较� */
	public boolean AddTeacher(TeacherBean t){
		try{
			String sql="Begin Transaction Del Insert into Teachers values(?,?,?,?,?,?) Insert into TUser values(?,?) Commit Transaction Del";
			statement=connection.prepareStatement(sql);
			statement.setString(1,t.getTno());
			statement.setString(2,t.getTname());
			statement.setString(3,t.getTsex());
			statement.setInt(4,t.getTage());
			statement.setString(5,t.getTtitle());
			statement.setLong(6,t.getTtel());
			statement.setString(7,t.getTno());
			statement.setString(8,"123456");
			statement.executeUpdate();
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
    }

    /*锟斤拷锟斤拷员锟斤拷涌纬锟斤拷锟较� */
    public boolean AddCourse(CATBean c){
		try{
		    String sql="Begin Transaction Del Insert Into Courses Values(?,?,?,?,?) Insert Into Teach Values(?,?)  Commit Transaction Del";
		    statement=connection.prepareStatement(sql);
		    statement.setString(1,c.getCno());
		    statement.setString(2,c.getCname());
		    statement.setString(3,c.getCtype());
	        statement.setDouble(4,c.getCredits());
			statement.setDouble(5,c.getCperiod());
			statement.setString(6,c.getTno());
		    statement.setString(7,c.getCno());
			statement.executeUpdate();
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	/*锟斤拷锟斤拷员锟斤拷专业锟斤拷锟斤拷锟斤拷 */
    public boolean AddMajor(String Mno,String Mname){
		try{
			String sql="Insert Into Major Values(?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1,Mno);
			statement.setString(2,Mname);
			statement.executeUpdate();
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}

	}

	/*锟斤拷锟斤拷员锟皆班级锟斤拷锟斤拷锟斤拷 */
    public boolean AddClass(String Gno,String Gname,String Mno){
		try{
			String sql="Insert Into Class Values(?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1,Gno);
			statement.setString(2,Gname);
			statement.setString(3,Mno);
			statement.executeUpdate();
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}

	}


	/*锟斤拷锟斤拷员锟斤拷锟斤拷学锟斤拷锟斤拷锟斤拷 */
	public boolean reSPasswoed(String []s){
		try{
			for(int i=0;i<s.length;i++){
				String sql="Update from TUser set Spassword='123456' where Sno=?";
				statement=connection.prepareStatement(sql);
				statement.setString(1,s[i]);
				statement.executeUpdate();
			}
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}


	/*锟斤拷锟斤拷员锟斤拷锟矫斤拷师锟斤拷锟斤拷 */
	public boolean reTPasswoed(String []t){
		try{
			for(int i=0;i<t.length;i++){
				String sql="Update from TUser set Tpassword='123456' where Tno=?";
				statement=connection.prepareStatement(sql);
				statement.setString(1,t[i]);
				statement.executeUpdate();
			}
			connection.close();
			statement.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}


	/*锟斤拷锟斤拷员锟介看学锟斤拷锟斤拷息 */
	public ArrayList<MSBean> CheckStudent(){
		String sql="select * from Admin_Stu_Info";
		try{
			statement = connection.prepareStatement(sql);
			result=statement.executeQuery();
			ArrayList<MSBean> array = new ArrayList<MSBean>();
			while(result.next()){
				MSBean ms = new MSBean();
				ms.setSno(result.getString(1));
				ms.setSname(result.getString(2));
				ms.setSsex(result.getString(3));
				ms.setSage(result.getInt(4));
				ms.setSaddr(result.getString(5));
				ms.setScredit(result.getDouble(6));
				ms.setGno(result.getString(7));
				ms.setMname(result.getString(10));
				array.add(ms);
			}
			connection.close();
			statement.close();
			result.close();
			return array;
		}catch(Exception e){
			System.out.println(e);
			return new ArrayList<MSBean>();
		}
	}

		/*锟斤拷锟斤拷员锟斤拷锟斤拷学锟斤拷锟斤拷挪榭囱э拷锟斤拷锟较� */
		public MSBean CheckStudent(String Sno){
			String sql="select * from Admin_Stu_Info where Sno=?";
			try{
				statement = connection.prepareStatement(sql);
				statement.setString(1,Sno);
				result=statement.executeQuery();
				MSBean ms = new MSBean();
				while(result.next()){
					ms.setSno(result.getString(1));
					ms.setSname(result.getString(2));
					ms.setSsex(result.getString(3));
					ms.setSage(result.getInt(4));
					ms.setSaddr(result.getString(5));
					ms.setScredit(result.getDouble(6));
					ms.setGno(result.getString(7));
					ms.setMname(result.getString(10));
				}
				connection.close();
				statement.close();
				result.close();
				return ms;
			}catch(Exception e){
				System.out.println(e);
				return new MSBean();
			}
		}
	

	/*锟斤拷锟斤拷员锟介看锟斤拷师锟斤拷息 */
	public ArrayList<TeacherBean> CheckTeacher(){
		try{
		    String sql="select * from Teachers";
			statement = connection.prepareStatement(sql);
			result=statement.executeQuery();
			ArrayList<TeacherBean> array = new ArrayList<TeacherBean>();
			while(result.next()){
				TeacherBean teacher = new TeacherBean();			
				teacher.setTno(result.getString(1));
				teacher.setTname(result.getString(2));
				teacher.setTsex(result.getString(3));
				teacher.setTage(result.getInt(4));
				teacher.setTtitle(result.getString(5));
				teacher.setTtel(result.getLong(6));
				array.add(teacher);
			}
			connection.close();
			statement.close();
			result.close();
			return array;
		}catch(Exception e){
			System.out.println(e);
			return new ArrayList<TeacherBean>();
		}
	}
	
	/*锟斤拷锟斤拷员锟斤拷锟捷斤拷师锟斤拷挪榭达拷锟绞︼拷锟较� */
	public TeacherBean CheckTeacher(String tno){
		try{
		    String sql="select * from Teachers where Tno=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1,tno);
			result=statement.executeQuery();
			TeacherBean teacher = new TeacherBean();			
			while(result.next()){
				teacher.setTno(result.getString(1));
				teacher.setTname(result.getString(2));
				teacher.setTsex(result.getString(3));
				teacher.setTage(result.getInt(4));
				teacher.setTtitle(result.getString(5));
				teacher.setTtel(result.getLong(6));
			}
			connection.close();
			statement.close();
			result.close();
			return teacher;
		}catch(Exception e){
			System.out.println(e);
			return new TeacherBean();
		}
	}

	
	/*锟斤拷锟斤拷员锟介看锟洁级锟斤拷息*/
    public ArrayList<ClassBean> CheckClass(){
    	try{
    		String sql="select * from Class";
    		statement = connection.prepareStatement(sql);
    		result=statement.executeQuery();
    		ArrayList<ClassBean> array = new ArrayList<ClassBean>();
    		while(result.next()){
    			ClassBean c = new ClassBean();
    			c.setGno(result.getString(1));
    			c.setGname(result.getString(2));
    			c.setMno(result.getString(3));
    			array.add(c);
    		}
    		connection.close();
    		statement.close();
    		result.close();
    		return array;
    	}catch(Exception e){
    		System.out.println(e);
    		return new ArrayList<ClassBean>();
    	}
    }
	
    /*锟斤拷锟斤拷员锟斤拷锟捷班级锟斤拷挪榭达拷嗉讹拷锟较�*/
    public ClassBean CheckClass(String gno){
    	try{
    		String sql="select * from Class where Gno=?";
    		statement = connection.prepareStatement(sql);
    		statement.setString(1,gno);
    		result=statement.executeQuery();
    		ClassBean c = new ClassBean();
    		while(result.next()){
    			c.setGno(result.getString(1));
    			c.setGname(result.getString(2));
    			c.setMno(result.getString(3));
    		}
    		connection.close();
    		statement.close();
    		result.close();
    		return c;
    	}catch(Exception e){
    		System.out.println(e);
    		return new ClassBean();
    	}
    }
    
	/*锟斤拷锟斤拷员锟介看专业锟斤拷息*/
    public ArrayList<MajorBean> CheckMajor(){
    	try{
    		String sql="select * from Major";
    		statement = connection.prepareStatement(sql);
    		result=statement.executeQuery();
    		ArrayList<MajorBean> array = new ArrayList<MajorBean>();
    		while(result.next()){
    			MajorBean m = new MajorBean();
    			m.setMno(result.getString(1));
    			m.setMname(result.getString(2));
    			array.add(m);
    		}
    		connection.close();
    		statement.close();
    		result.close();
    		return array;
    	}catch(Exception e){
    		System.out.println(e);
    		return new ArrayList<MajorBean>();
    	}
    }
    
	/*锟斤拷锟斤拷员锟斤拷锟斤拷专业锟斤拷挪榭醋ㄒ碉拷锟较�*/
    public MajorBean CheckMajor(String mno){
    	try{
    		String sql="select * from Major where Mno=?";
    		statement = connection.prepareStatement(sql);
    		statement.setString(1,mno);
    		result=statement.executeQuery();
    		MajorBean m = new MajorBean();
    		while(result.next()){
    			m.setMno(result.getString(1));
    			m.setMname(result.getString(2));
    		}
    		connection.close();
    		statement.close();
    		result.close();
    		return m;
    	}catch(Exception e){
    		System.out.println(e);
    		return new MajorBean();
    	}
    }
    
    /*锟斤拷锟斤拷员删锟斤拷锟轿筹拷锟斤拷息*/
    public boolean deleteCourse(String Cno){
    	try{
			String sql = "Begin Transaction Del DELETE FROM Class_Crs WHERE Class_Crs.Cno=? DELETE FROM Reports WHERE Reports.Cno=? DELETE FROM Reports WHERE Reports.Cno=? DELETE FROM Teach WHERE Teach.Cno=? DELETE FROM Courses WHERE Courses.Cno=? Commit Transaction Del";
    		statement = connection.prepareStatement(sql);
			statement.setString(1,Cno);
			statement.setString(2,Cno);
			statement.setString(3,Cno);
			statement.setString(4,Cno);
			statement.setString(5,Cno);
    		statement.executeUpdate();
			statement.close();
			connection.close();
			return true;
    	}catch(Exception e){
			System.out.println(e);
			return false;
    	}

    	
    }
    
    
    
    /*锟斤拷锟斤拷员删锟斤拷锟斤拷师锟斤拷息*/
    public boolean deleteTeacher(String Tno){
    	try{
    		String sql="Begin Transaction Del DELETE FROM TUser WHERE TUser.Tno=? DELETE FROM Reports WHERE Reports.Tno=? DELETE FROM Teach WHERE Teach.Tno=? DELETE FROM Teachers WHERE Teachers.Tno=? Commit Transaction Del";
    		statement = connection.prepareStatement(sql);
			statement.setString(1,Tno);
			statement.setString(2,Tno);
			statement.setString(3,Tno);
			statement.setString(4,Tno);
    		statement.executeUpdate();
			statement.close();
			connection.close();
			return true;
    	}catch(Exception e){
			System.out.println(e);
			return false;
    	}
    }
    
    /*锟斤拷锟斤拷员删锟斤拷学锟斤拷锟斤拷息*/
    public boolean deleteStudent(String Sno){
    	try{
    		String sql="Begin Transaction Del DELETE FROM SUser WHERE SUser.Sno=? DELETE FROM Reports WHERE Reports.Sno=? DELETE FROM Students WHERE Students.Sno=? Commit Transaction Del";
    		statement = connection.prepareStatement(sql);
			statement.setString(1,Sno);
			statement.setString(2,Sno);
			statement.setString(3,Sno);
    		statement.executeUpdate();
			statement.close();
			connection.close();
			return true;
    	}catch(Exception e){
			System.out.println(e);
			return false;
    	}
    }
    
    
    
}
