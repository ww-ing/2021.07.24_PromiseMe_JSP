<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myctx" value="${pageContext.request.contextPath}"/>   

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>약속해줘</title>
        <!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
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
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="main.me "><b>약속해줘</b></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="${myctx}/yaksokSetForm.me?yidx=${info.yidx}">템플릿</a></li>
                        <li class="nav-item"><a class="nav-link" href="${myctx}/yaksokStatistics.me">통계</a></li>
                        <li class="nav-item"><a class="nav-link" href="${myctx}/yaksokReserve.me">예약관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="${myctx}/yaksokSetting.me">설정</a></li>
                    </ul>
                </div>
            </div>
        </nav>	 

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