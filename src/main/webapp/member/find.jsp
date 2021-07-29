<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, user.domain.*" %>
<!--관리자 여부 체크 모듈 include-----------  -->
<%@ include file="/login/adminCheckModule.jsp" %>
<!-------------------------------------  -->

<jsp:include page="/top.jsp" />
<%
	//검색유형과 검색어 받기
	String findType = request.getParameter("findType");
	String findKeyword = request.getParameter("findKeyword");
	if(findType==null||findKeyword==null||findType.trim().isEmpty()){
		%>
		<script>
			alert('검색유형을 선택하세요');
			location.href='list.jsp';
		</script>
		<%
		return;
	}
%>

<jsp:useBean id="userDao" class="user.persistence.UserDAO" scope="session"/>
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
   List<UserVO> userList=userDao.findUser(findType, findKeyword);

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

<h1 class="text-center m-3">[검색어:<%=findKeyword %> ] 검색 결과</h1>

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
	<input type="text" name="findkeyword" placeholder="검색어를 입력하세요" 
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
} // if
%>
<!-- -------------------------- -->
</table>

<jsp:include page="/foot.jsp" />