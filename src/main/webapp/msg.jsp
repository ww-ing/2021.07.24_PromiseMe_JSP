<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
    <%
    	String msg=(String)request.getAttribute("message");
    	String loc=(String)request.getAttribute("loc");
    %>
    
    <script>
    	alert('<%=msg%>');
    	location.href='<%=loc%>';
    </script>
--%>

<script>
	//el표현식
	alert('${message}');
	location.href='${loc}';
	
	//key값에서 찾음
	//session에서 찾음
	//application에서 찾음
	//null뜸
</script>

<%--
 
JSTL : Tag Library를 이용하여 제어문을 작성

--%>
