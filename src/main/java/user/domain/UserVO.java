package user.domain;

import java.sql.Date;

public class UserVO implements java.io.Serializable{

  //property => 멤버변수를 JSP에서는 프로터피라고 한다.
	private int idx;
	private String name;
	private String userid;
	private String pwd;
	private String hp1;
	private String hp2;
	private String hp3;
	private String zipcode;
	private String addr1;
	private String addr2;
	private java.sql.Date indate;
	private int mileage;
	private int mstate;//회원상태(일반회원:0,정지회원1,탈퇴회원:-1);

	public UserVO() {
		System.out.println("UserVO()호출됨...");
	}

	public UserVO(int idx, String name, String userid,
			String pwd, String hp1, String hp2, String hp3,
			String zipcode,
			String addr1, String addr2, Date indate,
			int mileage, int mstate) {
		super();
		this.idx = idx;
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.indate = indate;
		this.mileage = mileage;
		this.mstate = mstate;
	}

	//setter, getter---

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("name==="+name);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public java.sql.Date getIndate() {
		return indate;
	}

	public void setIndate(java.sql.Date indate) {
		this.indate = indate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	public String getAllHp() {
		return hp1+"-"+hp2+"-"+hp3;
	}
	public String getAllAddr() {
		return "["+zipcode+"] "+addr1+" "+addr2;
	}

	@Override
	public String toString() {
		return "UserVO [idx=" + idx + ", name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", hp1=" + hp1
				+ ", hp2=" + hp2 + ", hp3=" + hp3 + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", indate=" + indate + ", mileage=" + mileage + ", mstate=" + mstate + "]";
	}

}////////////////////////////////////