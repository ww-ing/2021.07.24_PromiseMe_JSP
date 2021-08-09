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
	
	private String yidx;
	private String yaksokname;
	private Date indate;
	private String idx;
	
	public YaksokVO() {
		
	}

	public YaksokVO(String yidx, String yaksokname, Date indate, String idx) {
		super();
		this.yidx = yidx;
		this.yaksokname = yaksokname;
		this.indate = indate;
		this.idx = idx;
	}

	public String getYidx() {
		return yidx;
	}

	public void setYidx(String yidx) {
		this.yidx = yidx;
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

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}


}
