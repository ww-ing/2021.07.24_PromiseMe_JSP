package member.model;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.domain.UserVO;

public class UserDAOMybatis {
	
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
	
	/**회원 선택*/
	public UserVO selectUser(String idx) throws SQLException{
		try {
			ses=this.getSessionFactory().openSession();
			UserVO arr=ses.selectOne(NS+".selectUser",idx);
			return arr;
		} finally {
			close();
		}
		
	}//----------
	
	private void close() {
		if(ses!=null) ses.close();
		
	}//----------

}
