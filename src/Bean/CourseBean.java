package Bean;

public class CourseBean {
	private String cno;   //课程编号
	private String cname; //课程名称
	private String ctype; //课程类型
	private double credits;  //课程学分
	private double cperiod;  //课程学时
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	public double getCperiod() {
		return cperiod;
	}
	public void setCperiod(double cperiod) {
		this.cperiod = cperiod;
	}
}
