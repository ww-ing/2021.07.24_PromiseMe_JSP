<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/login/loginCheckModule.jsp" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<jsp:include page="/top.jsp" />

<h1>약속관리 페이지</h1>
 <div class="col-12 m-3"> <button class="float-right">
 <a href="yaksokAddForm.me">NEW</a></button></div>
 
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
   <th>${yaksok.idx}</th>
   <th>${yaksok.yaksokname}</th>
   <th>${yaksok.indate}</th>
   <th class="text text-danger">0</th>
   <td><button><a href="yaksokSet.me?key=${yaksok.key}">관리</a></button></td>
</tr>
</c:forEach>
</table>

<jsp:include page="/foot.jsp" />