package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {   //����ʵ�������Ӷ���
	Connection conn;
	public Base(){
		conn=null;
	}
	public Base(int n){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   //�������sqlserver2016�汾��Ӧ�ö��������
		String username=null;
		String password = null;
		String dburl = "jdbc:sqlserver://localhost:1433;database=SAMS";   //**********���ݿ�������Ҫ���Ի��޸ģ�Ҳ����database=ʲô��Ҫ�޸�
		switch(n){
		case 1:{   //����Ա
			username="Adminr";         //**********����Ա�û����ƺ�������Ҫ���Ի��޸�
			password="Adminr-Adminr";
		}break;
		case 2:{   //��ʦ
			username="TUSER";         //**********��ʦ�û����ƺ�������Ҫ���Ի��޸�
			password="TUSER-TUSER";
		}break;
		case 3:{   //ѧ��
			username="SUSER";         //**********ѧ���û����ƺ�������Ҫ���Ի��޸�
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
