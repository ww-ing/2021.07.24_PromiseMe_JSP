package yaksok.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class YaksokDAOMyBatis {
	
	private SqlSession ses;
	private final String NS="yaksok.mapper.YaksokMapper";
	
	public SqlSessionFactory getSessionFactory() {
		
		String resource="common/config/mybatis-config.xml";
		InputStream is=null;
		try {
			is=Resources.getResourceAsStream(resource);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		return factory;
		
	}//----------
	
	/**샘플 테스트*/
	public int getTableCount() {
		ses=this.getSessionFactory().openSession();
		
		int count=ses.selectOne(NS+".totalCount");
		if(ses!=null) ses.close();
		return count;
	}//----------
	
	/**모든 약속 불러오기*/
	public List<YaksokVO> selectAllYaksok(String userid) {
		try {
			ses=this.getSessionFactory().openSession();
			List<YaksokVO> arr=ses.selectList(NS+".selectAllYaksok",userid);
			return arr;
			
		} finally {
			close();
		}
		
		
	}//----------
	
	/**약속 등록*/
	public int insertYaksok(YaksokVO yaksok) {
		try {
			ses=this.getSessionFactory().openSession(true);
			
			int suc=ses.insert(NS+".insertYaksok", yaksok);
			
			return suc;
			
		} finally {
			close();
		}
		
	}
	
	/**약속 데이터 등록*/
	public int insertYaksokInfo(YaksokInfoVO yaksokInfo) {
		try {
			ses=this.getSessionFactory().openSession(true);
			
			int suc=ses.insert(NS+".insertYaksokInfo", yaksokInfo);
			
			return suc;
			
		} finally {
			close();
		}
	}//-----------
	
	/**약속 정보 선택*/
	public YaksokInfoVO selectYaksokInfo(String yidx) {
		try {
			ses=this.getSessionFactory().openSession();
			YaksokInfoVO arr=ses.selectOne(NS+".selectYaksokInfo",yidx);
			return arr;
			
		} finally {
			close();
		}
	}//-----------
	
	/**약속 정보 수정*/
	public int updateYaksokInfo(YaksokInfoVO yaksokInfo) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateYaksokInfo",yaksokInfo);
			return n;
			
		} finally {
			close();
		}
	}
	
	private void close() {
		if(ses!=null) ses.close();
		
	}//----------

}