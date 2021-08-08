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
		//설계도
		String resource="common/config/mybatis-config.xml";
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		//공장 만들어주기
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		return factory;
		
	}//----------------
	
	public UserVO selectUser(String idx) throws SQLException{
		try {
			ses=this.getSessionFactory().openSession();
			UserVO arr=ses.selectOne(NS+".selectUser",idx);//여러개 올 때는 selectList 하나 올 때는 selectOne
			return arr;
		} finally {
			close();
		}
		
	}
	
	private void close() {
		if(ses!=null) ses.close();
		
	}

}
