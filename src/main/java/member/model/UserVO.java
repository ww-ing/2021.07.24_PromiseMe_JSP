package member.model;

import java.io.Serializable;
import java.sql.Date;

public class UserVO implements Serializable{

  //property => 멤버변수를 JSP에서는 프로터피라고 한다.
	private String idx;
	private String username;
	private String userid;
	private String pwd;
	private String hp1;
	private String hp2;
	private String hp3;
	private java.sql.Date indate;
	private String mstate;//회원상태(일반회원:0,정지회원1,탈퇴회원:-1);

	public UserVO() {
	}

	public UserVO(String idx, String username, String userid, String pwd, String hp1, String hp2, String hp3, Date indate,
			String mstate) {
		super();
		this.idx = idx;
		this.username = username;
		this.userid = userid;
		this.pwd = pwd;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.indate = indate;
		this.mstate = mstate;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public java.sql.Date getIndate() {
		return indate;
	}

	public void setIndate(java.sql.Date indate) {
		this.indate = indate;
	}

	public String getMstate() {
		return mstate;
	}

	public void setMstate(String mstate) {
		this.mstate = mstate;
	}

	
	

}////////////////////////////////////