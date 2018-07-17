package Bean;

public class TeacherBean {
	private String tno;   //教师编号
	private String tname; //教师名称
	private String tsex;  //教师性别
	private int tage;     //教师年龄
	private String ttitle;//职称
	private long ttel;    //电话号码
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public long getTtel() {
		return ttel;
	}
	public void setTtel(long ttel) {
		this.ttel = ttel;
	}
}
