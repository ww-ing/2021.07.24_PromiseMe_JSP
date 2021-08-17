package member.model;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jdbc.util.DBUtil;


public class UserDAOMyBatis {
	
	private SqlSession ses;
	private final String NS="member.mapper.UserMapper";
	
	public SqlSessionFactory getSessionFactory() {
		
		String resource="common/config/mybatis-config.xml";
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		return factory;
		
	}//----------
	/**회원 등록*/
	public int insertUser(UserVO user) throws SQLException{
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertUser",user);
			return n;
		} finally {
			close();
		}
	}
	
	/**아이디로 회원 정보 검색*/
	public UserVO selectUserById(String userid) {
		try {
			ses=this.getSessionFactory().openSession();
			UserVO user=ses.selectOne(NS+".selectUserById",userid);
			return user;
		} finally {
			close();
		}
		
	}
	
	/**idx로 회원 정보 검색*/
	public UserVO selectUser(String idx) throws SQLException{
		try {
			ses=this.getSessionFactory().openSession(true);
			UserVO user=ses.selectOne(NS+".selectUser",idx);
			return user;
		} finally {
			close();
		}
		
	}//----------
	
	/**회원 정보 수정*/
	public int updateMyInfo(UserVO user) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateMyInfo",user);
			return n;
		} finally {
			close();
		}
		
	}
	
	/**닫아주기*/
	private void close() {
		if(ses!=null) ses.close();
		
	}//----------
	

}