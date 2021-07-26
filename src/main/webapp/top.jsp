<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
%>

<!-- navbar---------------------------------------------  -->
<nav class="navbar navbar-expand-sm bg-white navbar-white">

  <!-- Links -->
  <ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link" href="<%=myctx%>/login/login.jsp"><h3>로그인</h3></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%=myctx%>/join/join.jsp"><h3>회원가입</h3></a>
      </li>
  </ul>
</nav>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="<%=myctx%>/main.jsp">약속해줘</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">예약하기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">미리보기</a>
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
		<div class="col-md-8 ">