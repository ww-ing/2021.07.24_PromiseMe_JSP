<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	response.setHeader("Pragma","No-cache"); //HTTP 1.0 
	response.setDateHeader ("Expires", 0); 
	response.setHeader("Cache-Control","no-cache");
%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
	$(function(){
		showTemplate(${info.templates},'0');
	})
	
	function showTemplate(templates,editNum){
		$.ajax({
			type:'get',
			url:'yaksokSet.me?yidx='+${info.yidx}+'&&templates='+templates+'&&editNum='+editNum,
			cache:false,
			dataType:'html'
			
		}).done(function(res){
			$('#template').html(res);
		})
		.fail(function(err){
			alert('error: '+err.status);
		})
	}
	
    function submit() {
        document.forms["info"].submit();
    }

</script>

</head>
<body>
		<div class="text-center bg-dark">
			<button type="button" onclick="showTemplate('1','0')">템플릿1</button>
			<button type="button" onclick="showTemplate('2','0')">템플릿2</button>
			<button type="button" onclick="showTemplate('3','0')">템플릿3</button>
			<button type="button" onclick="showTemplate('4','0')">템플릿4</button>
			<button type="button" onclick="showTemplate('5','0')">템플릿5</button>
		</div>		
		
	<div id="template" class="pt-3"></div>
</body>
</html>