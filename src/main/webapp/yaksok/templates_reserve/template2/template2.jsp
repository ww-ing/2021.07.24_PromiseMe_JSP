<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <script src="https://code.jquery.com/jquery-latest.js"></script>
        <title>약속해줘</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="yaksok/assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="yaksok/css/styles.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-latest.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
		<link href="yaksok/templates_reserve/template2/css/font-awesome.min.css" rel="stylesheet" type="text/css">		
		<link href="yaksok/templates_reserve/template2/css/templatemo_style.css" rel="stylesheet" type="text/css"> 
		</head>
		
		<body>
		<div class="templatemo-container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
			<h2 class="logo-left hidden-xs margin-bottom-60">약속해줘</h2>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h2 class="logo-right hidden-xs margin-bottom-60">예약</h2>
			<div class="tm-right-inner-container">
				<h1 class="templatemo-header">${info.content_main_title}</h1>
				<img src="yaksok/templates_reserve/template2/images/wooden-desk.jpg" alt="Wooden Desk" class="img-thumbnail">
				<a class="btn btn-secondary " href="#yaksokBookingModal" data-toggle="modal">예약하기</a>
				<article>
					<h2>${info.content1_title}</h2>
					<p>${info.content1}</p>
				</article>
				<article>
					<h2>${info.content2_title}</h2>
					<p>${info.content2}</p>
				</article>
				<article>
					<h2>${info.content3_title}</h2>
					<p>${info.content3}</p>
				</article>
				
				<br><br>
				<div>
					<div>
						<h3>연락처</h3>
						<p>${info.number1_1}-${info.number1_2}-${info.number1_1}</p>
					</div>
					<br>
					<div>	
						<h3>위치</h3>
						<p>${info.locate}</p>
						<a class="btn btn-secondary" href="#!">지도보기</a>
					</div>		
				</div>
            	<div class="card text-white bg-secondary my-5 py-4 text-center">
                	<div class="card-body"><p class="text-white m-0">지금 바로 예약 플랫폼의 주인이 되어보세요! <a href="start.me">약속하기 바로가기</a></p></div>
            	</div>
				
				<footer>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">Copyright &copy; (주) 약속하는사람들 2021</p>
				</footer>
				<!-- yaksokBookingModal.jsp의 소스를 include------------------------ -->
				<%@ include file="/yaksok/yaksokReserveModal.jsp"%>
		  		<!-- ------------------------------------------------------------- -->
			</div>
		</div>
	</div>
	</body>
</html>		