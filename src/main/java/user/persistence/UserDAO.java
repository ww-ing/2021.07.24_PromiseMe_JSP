package user.persistence;


import java.sql.*;
import java.util.*;
import jdbc.util.*;
import user.domain.*;

public class UserDAO {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public UserDAO() {
		System.out.println("UserDAO()생성됨...");
	}
	
	/**회원가입-INSERT문 수행
	 * 회원번호: MEMBER_SEQ시퀀스를 이용
	 * 등록일: SYSDATE함수 사용
	 * */
	
	public void close() {
		try {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public int createUser(UserVO user) throws SQLException{
		try {
			con=DBUtil.getCon();
			
			String sql = "insert into member"
					   +" values (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, 1000, 0)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getHp1());
			ps.setString(5, user.getHp2());
			ps.setString(6, user.getHp3());
			ps.setString(7, user.getZipcode());
			ps.setString(8, user.getAddr1());
			ps.setString(9, user.getAddr2());
			
			int cnt = ps.executeUpdate();
			System.out.println(cnt);
			return cnt;//업데이트한 값을 반환
			
		}finally {
			close();
		}
		
	}//----------------------------------------------
	
	//--총 회원수 구하기
	public int getTotalUser() throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="select count(idx) from member ";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			boolean b=rs.next();//있으면 true반환
			int cnt=0;
			if(b) {
				cnt=rs.getInt(1);//index1번 지정해서 꺼내옴
			}
			return cnt;
		} finally {
			close();
		}
		
	}
	
	//--검색한 총 회원수 구하기
	public int getTotalUser(String type, String keyword) throws SQLException{
		try {
			String colName="";
			switch(type) {
			case "1" : colName="name"; 
				break; 
			case "2" : colName="userid";
				break;
			case "3" : colName="hp1|hp2|hp3";
				break;
			
			}
			con=DBUtil.getCon();
			String sql="select count(idx) from member where "+colName+" like ?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			
			boolean b=rs.next();//있으면 true반환
			int cnt=0;
			if(b) {
				cnt=rs.getInt(1);//index1번 지정해서 꺼내옴
			}
			return cnt;
		} finally {
			close();
		}
		
	}
	
	/**아이디 중복 체크 -SELECT문 수행
	 * WHERE절에 USERID로 PK(IDX)를 가져온다
	 * RS의 커서를 이동했을 때 TRUE반환하면 "해당 아이디는 이미 존재==>FALSE를 반환"
	 * 					  FALSE를 반환하면 "해당 아이디는 없음"==>TRUE를 반환
	 * */
	
	public boolean idCheck(String userid) throws SQLException{
		try {
			con=DBUtil.getCon();
			
			String sql = "select idx from member where userid = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			boolean b = rs.next();
			System.out.println(b);
			
			return !b;
		}finally {
			close();
		}
		
	}//------------------------------------------------
	
	//--사용자 정보 조회
	public List<UserVO> listUser() throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="select * from member order by idx desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			List<UserVO> arr=makeList(rs);
			return arr;
			
		}finally {
			close();
		}
		
	}//---------------------------
	
	//--보여줄 회원의 정보 구하기
	public List<UserVO> listUser(int start, int end) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="select * from("
					+ " select rownum rn, a.* from("
					+ " (select * from member order by idx desc) a)"
					+ " )"
					+ " where rn between ? and ?";
			
			ps= con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			
			rs=ps.executeQuery();
			List<UserVO> arr=makeList(rs);
			return arr;
			
		}finally {
			close();
		}
		
	}//---------------------------
	
	//--회원 정보 리스트
	private List<UserVO> makeList(ResultSet rs) throws SQLException{
		List<UserVO> arr = new ArrayList<>();
		while(rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String userid=rs.getString("userid");
			String pwd=rs.getString("pwd");
			String hp1=rs.getString("hp1");
			String hp2=rs.getString("hp2");
			String hp3=rs.getString("hp3");
			String zipcode=rs.getString("zipcode");
			String addr1=rs.getString("addr1");
			String addr2=rs.getString("addr2");
			java.sql.Date indate=rs.getDate("indate");
			int mileage=rs.getInt("mileage");
			int mstate=rs.getInt("mstate");
			
			UserVO user = new UserVO(idx,name,userid,pwd,hp1,hp2,hp3,
					zipcode,addr1,addr2,indate,mileage,mstate);
			arr.add(user);
		}//while----
		return arr;
	}//-----------------
	
	/**회원번호(idx pk)로 회원정보 가져오기*/
	public UserVO selectUser(String idx) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="select * from member where idx=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, idx);
			rs=ps.executeQuery();
			
			List<UserVO> arr = makeList(rs);
			if(arr!=null && arr.size()==1) {
				UserVO user = arr.get(0);
				return user;
			}
			return null;
			
		}finally {
			close();
		}
		
	}//------------------------------
	
	//--회원 정보 수정
	public int updateUser(UserVO user) throws SQLException{
		try {
			con = DBUtil.getCon();
			//String sql = "update member set name=?, userid=?, pwd=?, hp1=?, hp2=?, hp3=?";
			//       sql+=" ,zipcode=?, addr1=?, addr2=?, mstate=? where idx=?";  
			StringBuilder buf
			= new StringBuilder("update member set name=?, userid=?, pwd=?, hp1=?, hp2=?, hp3=?");
			buf.append(" ,zipcode=?, addr1=?, addr2=?, mstate=? where idx=?");
			
			String sql = buf.toString();
			       //String은 원본을 변경하지 못함. immutable (불변성)
			       //문자열을 추가, 삭제, 변경 등의 작업을 해야 할 때는
			       //StringBuffer/StringBuilder 클래스를 이용해서 문자열을 편집한 뒤에
			       //toString()메소드를 이용해서 String으로 최종적으로 만들어 사용한다.
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getHp1());
			ps.setString(5, user.getHp2());
			ps.setString(6, user.getHp3());
			ps.setString(7, user.getZipcode());
			ps.setString(8, user.getAddr1());
			ps.setString(9, user.getAddr2());
			ps.setInt(10, user.getMstate());
			ps.setInt(11, user.getIdx());
			
			int n =ps.executeUpdate();
			return n;
			
		}finally {
			close();
		}
	}//-------------------------
	
	/**PK로 회원정보 삭제 처리*/
	public int deleteUser(String idx) throws SQLException{
		try {
			con=DBUtil.getCon();
			
			String sql = "delete from member where idx=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, idx);
			
			int n = ps.executeUpdate();
			return n;
		}finally {
			close();
		}
		
	}
	
	/**회원정보 검섹 - where 절에 like절 사용*/
	public List<UserVO> findUser(String type, String keyword)
	throws SQLException{
		try {
			String colName="";
			switch(type) {
				case "1": colName="name";
					break;
				case "2": colName="userid";
					break;
				case "3": colName="hp1||hp2||hp3";
					break;
			}
			
			con = DBUtil.getCon();
			
			String sql="select * from member where "+colName+" like ?";
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			
			return makeList(rs);
			
			
		}finally {
			close();
		}
	}//-----------------------------------------------
	
	/**회원정보 검섹 - where 절에 like절 사용*/
	public List<UserVO> findUser(String type, String keyword, int start, int end)
	throws SQLException{
		try {
			String colName="";
			switch(type) {
				case "1": colName="name";
					break;
				case "2": colName="userid";
					break;
				case "3": colName="hp1||hp2||hp3";
					break;
			}
			
			con = DBUtil.getCon();
			
			//String sql="select * from member where "+colName+" like ?";
			String sql="select * from("
					+ " select rownum rn, a.* from("
					+ "		(select * from member "
					+ "        where "+colName+" like ?"
					+ "        order by idx desc) a"
					+ "        )"
					+ "		)"
					+ " where rn between ? and ?";
			
			//System.out.println(sql);
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			rs=ps.executeQuery();
			
			return makeList(rs);
			
			
		}finally {
			close();
		}
	}//-----------------------------------------------
	
	/**로그인 체크*/
	public UserVO loginCheck(String id, String pwd) 
	throws SQLException,NotUserException
	{
		UserVO user = this.selectUserById(id);
		if(user==null) {
			//아이디가 존재하지 않는 경우 ==> 예외 발생 예정
			//사용자 정의 Exception
			throw new NotUserException(id+"란 아이디는 존재하지 않아요");
			//throw발생하면 로직은 밑으로 흘러내리지 않음
		}
		
		//비밀번호 체크
		String dbPwd=user.getPwd();
		if(!pwd.equals(dbPwd)) {
			//비밀번호가 불일치라면
			throw new NotUserException("비밀번호가 일치하지 않아요");
		}
		
		//여기까지오면 일치 (회원이 맞다면)
		return user;//해당 유저 반환
		
		
	}
	/*탈퇴회원(-1)을 제외한 일반회원(0), 정지회원(1)들의 데이터만 가지고 있는 member_view를
	 * 통해 로그인 체크를 하자.
	 * create or replace view member_view
	 * as
	 * select * from member where mstate>-1*/

	//--아이디로 회원 정보 검색
	public UserVO selectUserById(String id) throws SQLException {
		
		try {
			con=DBUtil.getCon();
			String sql="select * from member_view where userid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			List<UserVO> arr=this.makeList(rs);
			
			if(arr!=null && arr.size()==1) {
				UserVO user = arr.get(0);
				return user;
			}
			return null;
			
		} finally {
			close();
		}
		
	}//---------------------------------
	
}/////////////////////