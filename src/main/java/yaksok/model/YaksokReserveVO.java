package yaksok.model;

import java.io.Serializable;
import java.sql.Date;

public class YaksokReserveVO implements Serializable {
	
	private String ridx;
	private String rusername;
	private String rhp1;
	private String rhp2;
	private String rhp3;
	private String rcontent;
	private Date rindate;
	private String rcheckedstate;
	private String yidx;
	
	public YaksokReserveVO(String ridx, String rusername, String rhp1, String rhp2, String rhp3, String rcontent,
			Date rindate, String rcheckedstate, String yidx) {
		super();
		this.ridx = ridx;
		this.rusername = rusername;
		this.rhp1 = rhp1;
		this.rhp2 = rhp2;
		this.rhp3 = rhp3;
		this.rcontent = rcontent;
		this.rindate = rindate;
		this.rcheckedstate = rcheckedstate;
		this.yidx = yidx;
	}
	
	
	public YaksokReserveVO() {
		
	}
	
	public String getRidx() {
		return ridx;
	}
	public void setRidx(String ridx) {
		this.ridx = ridx;
	}
	public String getrusername() {
		return rusername;
	}
	public void setrusername(String rusername) {
		this.rusername = rusername;
	}
	public String getHp1() {
		return rhp1;
	}
	public void setHp1(String rhp1) {
		this.rhp1 = rhp1;
	}
	public String getHp2() {
		return rhp2;
	}
	public void setHp2(String rhp2) {
		this.rhp2 = rhp2;
	}
	public String getHp3() {
		return rhp3;
	}
	public void setHp3(String rhp3) {
		this.rhp3 = rhp3;
	}
	public String getrcontent() {
		return rcontent;
	}
	public void setrcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public Date getrindate() {
		return rindate;
	}
	public void setrindate(Date rindate) {
		this.rindate = rindate;
	}
	public String getrcheckedstate() {
		return rcheckedstate;
	}
	public void setrcheckedstate(String rcheckedstate) {
		this.rcheckedstate = rcheckedstate;
	}
	public String getYidx() {
		return yidx;
	}
	public void setYidx(String yidx) {
		this.yidx = yidx;
	}

}
