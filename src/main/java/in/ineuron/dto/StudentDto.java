package in.ineuron.dto;
import java.io.Serializable;


public class StudentDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int sid;
	private String sname;
	private String saddress; 
	private int sage;
	private float savg;
	
	private String grade;
	
	public float getSavg() {
		return savg;
	}

	public void setSavg(float savg) {
		this.savg = savg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public float getAvg() {
		return savg;
	}

	public void setAvg(float savg) {
		this.savg = savg;
	}

	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + ", savg="
				+ savg + ", grade=" + grade + "]";
	}
	
}
