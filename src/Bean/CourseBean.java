package Bean;

public class CourseBean {
	private String cno;   //�γ̱��
	private String cname; //�γ�����
	private String ctype; //�γ�����
	private double credits;  //�γ�ѧ��
	private double cperiod;  //�γ�ѧʱ
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
