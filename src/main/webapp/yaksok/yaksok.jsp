<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<jsp:include page="/top.jsp" />

	<h1 class="text-center">약속관리</h1>
	 <div class="col-12 m-3"> 
	 <button class="text-right">
	 <a href="yaksokAddForm.me">NEW</a>
	 </button></div>
	 
	<table class="table table-striped">
		<tr>
		   <th>번호</th>
		   <th>약속명</th>
		   <th>등록일</th>
		   <th>미확인</th>
		   <th>관리</th>
		</tr>
		
		<c:forEach var="yaksok" items="${yaksokList}">
		<tr>
		   <th>${yaksok.yidx}</th>
		   <th>${yaksok.yaksokname}</th>
		   <th>${yaksok.indate}</th>
		   <th class="text text-danger">0</th>
		   
		   <td>   
		    <form class="form-inline" action="yaksokMenu.me" method="post">
		   		<input type="hidden" name="yidx" value="${yaksok.yidx}">
				<button>관리</button>
			</form>
		   </td>
		</tr>
		</c:forEach>
	</table>

<jsp:include page="/foot.jsp" />