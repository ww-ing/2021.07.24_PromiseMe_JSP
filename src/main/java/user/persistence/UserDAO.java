package user.persistence;


import java.sql.*;
import java.util.*;
import jdbc.util.*;
import member.model.UserVO;

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
			String idx = rs.getString("idx");
			String name = rs.getString("name");
			String userid=rs.getString("userid");
			String pwd=rs.getString("pwd");
			String hp1=rs.getString("hp1");
			String hp2=rs.getString("hp2");
			String hp3=rs.getString("hp3");
			java.sql.Date indate=rs.getDate("indate");
			String mstate=rs.getString("mstate");
			
			UserVO user = new UserVO(idx,name,userid,pwd,hp1,hp2,hp3,indate,mstate);
			arr.add(user);
		}//while----
		return arr;
	}//-----------------
	
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
	
	
	public void close() {
		try {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
}/////////////////////