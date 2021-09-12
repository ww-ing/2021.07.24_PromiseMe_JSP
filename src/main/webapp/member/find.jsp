<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/top.jsp" />

<h1 class="text-center m-3">[검색어:${ findKeyword } ] 검색 결과</h1>

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
  
  
  
   <tr>
      <th>${user.getIdx() }</th>
      <th>${user.getName() }</th>
      <th>${user.getUserid() }</th>
      <th>${user.getAllHp() }</th>
      <th> ${user.getMstate() }</th>
      <td><a href="delete.jsp?idx=${user.getIdx()}">삭제</a></td>
   </tr>
<!-- -------------------------- -->
</table>

<jsp:include page="/foot.jsp" />