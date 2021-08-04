<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.domain.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약속해줘</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>


<%	//컨텍츠명
	String myctx = request.getContextPath();

	//세션에 저장된 loginUser 꺼내기
	UserVO loginUser = (UserVO) session.getAttribute("loginUser");
	
	boolean isLogin =(loginUser==null)? false: true;//로그인 했다면 true
%>

<!-- navbar---------------------------------------------  -->
<nav class="navbar navbar-expand-sm bg-white navbar-white" id="top">

  <!-- Links -->
  <ul class="navbar-nav ml-auto">
  
<%
	//로그인일 경우
	if(isLogin){
%>	
    
    <li class="nav-item">
      <a class="nav-link" href="logout.me"><h3>로그아웃</h3></a>
    </li>
    
	<li class="nav-item">
      <a class="nav-link text-dark" href="#"><h4><%=loginUser.getUserid()%></h4>
      <%--<%=loginTime %>  --%>
      </a>
    </li>    
<%    
	//로그아웃일 경우
    }else{
%>	    	
	<li class="nav-item">
      <a class="nav-link" href="login.me"><h3>로그인</h3></a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="join.me"><h3>회원가입</h3></a>
    </li>    
<%    	
    }
%>  


  </ul>
</nav>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="main.me">약속해줘</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">예약하기</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="myInfo.me">내 정보</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="list.me">회원목록</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="#">팀원모집</a>
    </li>    
    
    <li class="nav-item">
      <a class="nav-link" href="#">고객센터</a>
    </li>
  </ul>
</nav>
	<div class="jumbotron text-center" style="margin-bottom:0">
		<h1>약속해줘</h1>
		<p>쉽고 빠르게 예약 하세요</p>
	</div>
<!--  ------------------------------------------------------ -->

<!--  container content------------------------------------- -->
<div class="container mt-5" style="height:700px;">
	<div class="row">
		<!-- <div class="col-md-8 "> -->