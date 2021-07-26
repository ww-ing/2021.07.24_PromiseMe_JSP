<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트명</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>    

<style>

</style>


<%	//컨텍츠명
	String myctx = request.getContextPath();
%>


	<script>
		function loginCheck(){
			
			//아이디 입력 체크
			if(!loginF.userid.value){
				alert('아이디를 입력하세요')
				loginF.userid.focus();
				return false;
			
			//비밀번호 입력 체크
			}else if(!loginF.pwd.value){
				alert('비밀번호를 입력하세요')
				loginF.pwd.focus();
				return false;
			}
			return true;

		}
	</script>

    <h1 class="text-center m-4 text-secondary"><a href="<%=myctx %>/main.jsp">약속해줘</a></h1>
    <div class="row">
    	<div class="col-md-4 offset-md-4">
    		<form name="loginF" action="loginEnd.jsp" method="post"
    		onsubmit="return loginCheck()">
    			<table class="table table-bordered">
    				
    				<!--아이디  -->
 				<tr>
 					<th>아이디</th>
 					<td>
 					<input type="text" name="userid"
 					class="form-control" autofocus="autofocus"
 					placeholder="ID">
 					</td>
 				</tr>
 				
 				<!--비밀번호  -->
 				<tr>
 					<th>비밀번호</th>
 					<td>
 					<input type="password" name="pwd" 
 					class="form-control"
 					placeholder="Password">
 					</td>
 				</tr>
    				
    				<tr>
    					<td colspan="2" class="text-right">
    						<label for="saveId" class="form-check">
    							<input type="checkbox" 
    							<%-- <%=(flag)?"checked":"" %> --%>
    							name="saveId" id="saveId">
    							아이디 저장
    							</input>
    							
    						</label>
    					</td>
    				</tr>
    				
    				<!--버튼  -->
    				<tr>
    					<td colspan="2" class="text-center">
    						<button class="btn btn-primary">Login</button>
    						<button class="btn btn-danger">회원가입</button>
    						
    					</td>
    				</tr>
    			</table>
    		
    		</form>
    	
    	</div>
    </div>

</body>
</html>