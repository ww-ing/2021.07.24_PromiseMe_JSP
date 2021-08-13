<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	
	<c:set var="readonly" value="${readonly}" />

	<c:if test="${readonly eq 'readonly'}">
	<button type="button" onclick="showTemplate('2','1')">수정</button>
	</c:if>
	
	<c:if test="${readonly ne 'readonly'}">
	<button type="button" onclick="submit()">저장</button>
	</c:if>
	
	<h1>템플릿2</h1>
	<form name="info" action="yaksokEdit.me" method="post">
		<input type="hidden" name="yidx" value="${info.yidx}">
		
		<input type="text" name="yaksokurl" ${readonly}
		class="form-control mb-1" value="${info.yaksokurl}">
		
		<input type="text" name="locate" ${readonly}
		class="form-control mb-1" value="${info.locate}">
		
		<input type="text" name="number1_1" ${readonly}
		class="form-control mb-1" value="${info.number1_1}">
		<input type="text" name="number1_2" ${readonly}
		class="form-control mb-1" value="${info.number1_2}">
		<input type="text" name="number1_3" ${readonly}
		class="form-control mb-1" value="${info.number1_3}">
		
		<input type="text" name="number2_1" ${readonly}
		class="form-control mb-1" value="${info.number2_1}">
		<input type="text" name="number2_2" ${readonly}
		class="form-control mb-1" value="${info.number2_2}">
		<input type="text" name="number2_3" ${readonly}
		class="form-control mb-1" value="${info.number2_3}">
		
		<input type="text" name="image1" ${readonly}
		class="form-control mb-1" value="${info.image1}">
		<input type="text" name="image2" ${readonly}
		class="form-control mb-1" value="${info.image2}">
		<input type="text" name="image3" ${readonly}
		class="form-control mb-1" value="${info.image3}">
		<input type="text" name="image4" ${readonly}
		class="form-control mb-1" value="${info.image4}">
		<input type="text" name="image5" ${readonly}
		class="form-control mb-1" value="${info.image5}">
		
		<input type="text" name="content_main_title" ${readonly}
		class="form-control mb-1" value="${info.content_main_title}">
		<input type="text" name="content_main" ${readonly}
		class="form-control mb-1" value="${info.content_main}">
		
		<input type="text" name="content1_title" ${readonly}
		class="form-control mb-1" value="${info.content1_title}">
		<input type="text" name="content1" ${readonly}
		class="form-control mb-1" value="${info.content1}">
		
		<input type="text" name="content2_title" ${readonly}
		class="form-control mb-1" value="${info.content2_title}">
		<input type="text" name="content2" ${readonly}
		class="form-control mb-1" value="${info.content2}">
		
		<input type="text" name="content3_title" ${readonly}
		class="form-control mb-1" value="${info.content3_title}">
		<input type="text" name="content3" ${readonly}
		class="form-control mb-1" value="${info.content3}">
		
		<input type="hidden" name="templates" value="2">
	</form>