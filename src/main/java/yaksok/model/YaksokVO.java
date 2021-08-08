package yaksok.model;

import java.io.Serializable;
import java.sql.Date;
/*
 * create table yaksok(
    idx number(8) constraint yaksok_pk primary key,
    userid varchar2(30) not null,
    yaksokname varchar2(100) not null,
    unchecked number(20)
);
*/
public class YaksokVO implements Serializable {
	
	private String idx;
	private String userid;
	private String key;
	private String yaksokname;
	private Date indate;
	
	public YaksokVO() {
		
	}

	public YaksokVO(String idx, String userid, String yaksokname, Date indate, String key) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.yaksokname = yaksokname;
		this.key = key;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getYaksokname() {
		return yaksokname;
	}

	public void setYaksokname(String yaksokname) {
		this.yaksokname = yaksokname;
	}
	
	public Date getIndate() {
		return indate;
	}

	public void setYaksokname(Date indate) {
		this.indate = indate;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
