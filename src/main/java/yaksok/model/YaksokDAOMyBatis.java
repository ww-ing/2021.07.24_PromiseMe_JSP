package yaksok.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
		try {
			
		} finally {
			close();
		}
		ses=this.getSessionFactory().openSession(true);
		int count=ses.selectOne(NS+".totalCount");
		if(ses!=null) ses.close();
		return count;
	}//----------
	
	//--------------------약속 정보
	
	/**약속 정보 리스트*/
	public List<YaksokVO> selectAllYaksok(String idx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			List<YaksokVO> arr=ses.selectList(NS+".selectAllYaksok",idx);
			return arr;
			
		} finally {
			close();
		}
		
	}
	
	/**약속 등록*/
	public int insertYaksok(YaksokVO yaksok) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertYaksok", yaksok);
			return n;
			
		} finally {
			close();
		}
		
	}
	
	/**약속 데이터 등록*/
	public int insertYaksokInfo(YaksokInfoVO yaksokInfo) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertYaksokInfo", yaksokInfo);
			return n;
			
		} finally {
			close();
		}
	}
	
	/**yidx로 약속 정보 선택*/
	public YaksokInfoVO selectYaksokInfo(String yidx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			YaksokInfoVO info=ses.selectOne(NS+".selectYaksokInfo",yidx);
			return info;
			
		} finally {
			close();
		}
	}
	
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
	
	//--------------------약속 OnOff 설정 페이지
	
	/**약속 OnOff 데이터 등록*/
	public int insertYaksokOnOff(YaksokOnOffVO yaksokOnOff) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertYaksokOnOff", yaksokOnOff);
			return n;
			
		} finally {
			close();
		}
	}
	
	/**약속 OnOff 정보 수정*/
	public int updateYaksokOnOff(YaksokOnOffVO yaksokOnOff) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateYaksokOnOff",yaksokOnOff);
			return n;
			
		} finally {
			close();
		}
	}
	
	/**yidx로 약속 OnOff 정보 부르기*/
	public YaksokOnOffVO selectYaksokOnOff(String yidx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			YaksokOnOffVO onoff=ses.selectOne(NS+".selectYaksokOnOff",yidx);
			return onoff;
			
		} finally {
			close();
		}
	}
	
	//--------------------약속 예약 정보	
	
	/**약속 url로 약속 정보 부르기*/
	public YaksokInfoVO selectYaksokInfoByURL(String yaksokURL) {
		try {
			ses=this.getSessionFactory().openSession(true);
			YaksokInfoVO info=ses.selectOne(NS+".selectYaksokInfoByURL",yaksokURL);
			return info;
			
		} finally {
			close();
		}
	}
	
	/**약속 예약 정보 등록*/
	public int insertYaksokReserve(YaksokReserveVO yaksokReserve) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertYaksokReserve",yaksokReserve);
			return n;
			
		} finally {
			close();
		}
		
	}
	
	/**약속 예약 정보 개수*/
	public int getYaksokReserveCount(String yidx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.selectOne(NS+".getYaksokReserveCount",yidx);
			return n;
			
		} finally {
			close();
		}

	}
	
	/**약속 예약 유저 정보 리스트 페이징*/
	public List<YaksokReserveVO> selectAllYaksokReserve(String yidx, int start, int end) {
		try {
			Map<String, String> map=new HashMap<>();
			map.put("yidx", yidx);
			map.put("start", String.valueOf(start));
			map.put("end", String.valueOf(end));
			
			ses=this.getSessionFactory().openSession(true);
			List<YaksokReserveVO> arr=ses.selectList(NS+".selectAllYaksokReserve",map);
			return arr;
			
		} finally {
			close();
		}
		
	}
	
	/**약속 예약 유저 정보*/
	public YaksokReserveVO selectYaksokReserve(String ridx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			YaksokReserveVO info=ses.selectOne(NS+".selectYaksokReserve",ridx);
			return info;
			
		} finally {
			close();
		}
	}
	
	/**약속 예약 유저 정보 수정*/
	public int updateYaksokReserve(String ridx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateYaksokReserve",ridx);
			return n;
			
		} finally {
			close();
		}
	}
	
	//---------------------캘린더
	
	/**약속 캘린더 일정 등록*/
	public int insertYaksokCalendar(YaksokCalendarVO yaksokCalendar) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertYaksokCalendar",yaksokCalendar);
			return n;
			
		} finally {
			close();
		}
	}
	
	/**약속 yidx로 캘린더 정보 불러오기*/
	public List<YaksokCalendarVO> selectAllYaksokCalendar(String yidx){
		try {
			ses=this.getSessionFactory().openSession(true);
			List<YaksokCalendarVO> arr=ses.selectList(NS+".selectAllYaksokCalendar",yidx);
			return arr;
		} finally {
			close();
		}
	}
	
	/**약속 일정 cidx로 캘린더 일정 정보 불러오기*/
	public YaksokCalendarVO selectYaksokCalendarSchedule(String cidx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			YaksokCalendarVO info=ses.selectOne(NS+".selectYaksokCalendarSchedule",cidx);
			return info;

		} finally {
			close();
		}
	}
	
	/**약속 캘린더 일정 수정*/
	public int updateYaksokCalendar(YaksokCalendarVO yaksokCalendar) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateYaksokCalendar",yaksokCalendar);
			return n;
		} finally {
			close();
		}
	}
	
	/**약속 캘린더 일정 삭제*/
	public int deleteYaksokCalendar(String cidx) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.delete(NS+".deleteYaksokCalendar",cidx);
			return n;
			
		} finally {
			close();
		}
	}
	
	private void close() {
		if(ses!=null) ses.close();
		
	}

}