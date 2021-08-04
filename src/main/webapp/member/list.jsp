<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, user.domain.*" %>
<!--관리자 여부 체크 모듈 include-----------  -->
<%@ include file="/login/adminCheckModule.jsp" %>
<!-------------------------------------  -->

<jsp:include page="/top.jsp" />


<%-- UserDAO 빈 객체 생성해서 ==> useBean 액션 사용 
   listUser() 호출한 뒤, 받아온 List 반복문 출력 --%>
   
<%-- <jsp:useBean id="conPool" class="common.pool.ConnectionPoolBean" scope="application"/> --%>

<jsp:useBean id="userDao" class="user.persistence.UserDAO" scope="session"/> 

<%-- <jsp:setProperty name="userDao" property="pool" value="<%=conPool %>"/> --%>

<style>
   .txt0{
      color:blue;
   }
   .txt1{
      color:orange;
   }
   .txt-1{
      color:red;
   }
</style>

<%
	//현재 보여줄 페이지 번호를 받자.
	String cpStr = request.getParameter("cpage");
	if(cpStr==null || cpStr.trim().isEmpty()){
		cpStr="1";//파라미터가 없다면 1페이지를 기본값으로 지정
		
	}
	
	int cpage = Integer.parseInt(cpStr.trim());//공백제거한 값을 int로 전환
	if(cpage<1){//파라미터 값이 유효하지 않을경우
		cpage = 1;//첫 페이지 보여주기
	}
	
	

	/*페이지 수 정하기  */
	int totalCount = userDao.getTotalUser();

	int pageSize = 5;//한 페이지 당 보여줄 목록 개수를 10개로 정하자
	
	int pageCount = 0;
	/*
	if(totalCount%pageSize==0){//10명 20명 30명... 있을 경우
		pageCount = totalCount/pageSize;
	}else{
		pageCount = totalCount/pageSize +1;
	}
	*/
	pageCount = (totalCount-1)/pageSize+1;
	
	//3페이지가 끝인데 100페이지 보여달라고 할 때
	if(cpage>pageCount){
		cpage = pageCount;//마지막 페이지로 설정
	}
	
	int end = cpage * pageSize;
	//int start = end - (pageSize -1);
	int start = end - pageSize +1;
	
	List<UserVO> userList = userDao.listUser(start, end);
  	if(userList==null){
	   
			%>
			<script>
			   alert('서버 오류입니다.');
			   location.href="../index.jsp";
			</script>
			<%
			
		return;
   }
%>

<h1 class="text-center m-3">[관리자 페이지]</h1>

<div class="row m-5">
<div class="col-md-10 offset-md-1 text-center">
<!--  검색폼------------>
<form name="findF" action="find.jsp" class="form-inline">
	<select name="findType" class="form-control mr-2">
		<option value="">::검색 유형::</option>
		<option value="1">회원이름</option>
		<option value="2">아이디</option>
		<option value="3">연락처</option>
	</select>
	<input type="text" name="findKeyword" placeholder="검색어를 입력하세요" 
	class="form-control mr-2">
	<button class="btn btn-success">검 색</button>
</form>
<!--  ---------------->
</div>
</div>

<table class="table table-striped">
<tr>
   <th>번호</th>
   <th>이름</th>
   <th>아이디</th>
   <th>연락처</th>
   <th>회원상태</th>
   <th>수정|삭제</th>
</tr>
<!-- ---------------------------->
<%
if(userList.size()==0){
   %>
   <tr>
      <td colspan="6">
      <b>데이터가 없습니다.</b>
      </td>
   </tr>
   <%
} else{
   for(UserVO user: userList){
      String str=(user.getMstate()==0)? "일반회원":(user.getMstate()==1)? "정지회원": "탈퇴회원";
   %>
   <tr>
      <th><%=user.getIdx() %></th>
      <th><%=user.getName() %></th>
      <th><%=user.getUserid() %></th>
      <th><%=user.getAllHp() %></th>
      <th class="txt<%=user.getMstate() %>"><%=str %></th>
      <td><a href="edit.jsp?idx=<%=user.getIdx()%>">수정</a>
	  <a href="delete.jsp?idx=<%=user.getIdx()%>">삭제</a></td>
   </tr>
   <%
   } // for
} // else 
%>
<!-- 페이지 네비게이션-------------------------- -->
	<tr>
		<td colspan="4" class="text-center">
		<ul class="pagination justify-content-center">
		
		<!-- Prev  -->
		<li class="page-item">
		<a class="page-link" href="list.me?cpage=<%=cpage-1%>">이전</a>
		</li>
			<%
			
			for(int i=1; i<=pageCount; i++){
				String str = (cpage==i)?"active":"";
			%>
			<li class="page-item <%=str%>">
			<a class="page-link" href="list.me?cpage=<%=i%>"><%=i%></a>
			</li>
			<%-- [<a href="list.jsp?cpage=<%=i%>"> <%=i%> </a>] --%>
			<%
			}
			%>
		<!-- Next -->
		<li class="page-item">
		<a class="page-link" href="list.me?cpage=<%=cpage+1%>">다음</a>
		</li>
		
		</ul>	
		</td>
		<td colspan="2" class="text-right pr-3">
		<b>총 회원수</b>:<span class="text-primary"><%=totalCount %> 명</span>
		</td>
	</tr>

</table>

<jsp:include page="/foot.jsp" />