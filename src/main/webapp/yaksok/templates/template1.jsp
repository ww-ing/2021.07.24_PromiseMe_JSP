 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	

	<c:if test="${edit ne 'edit'}">
	<button type="button" onclick="showTemplate('1','1')">수정</button>
	</c:if>
	
	<c:if test="${edit eq 'edit'}">
	<button type="button" onclick="submit()">저장</button>
	</c:if>
	
	<%--
	<h1>템플릿1</h1>
	
	<c:if test="${edit eq 'edit' }">
	<form name="info" action="yaksokEdit.me" method="post">
		<input type="hidden" name="yidx" value="${info.yidx}">
		
		<input type="text" name="yaksokurl" 
		class="form-control mb-1" value="${info.yaksokurl}">
		
		<input type="text" name="locate" 
		class="form-control mb-1" value="${info.locate}">
		
		<input type="text" name="number1_1" 
		class="form-control mb-1" value="${info.number1_1}">
		<input type="text" name="number1_2" 
		class="form-control mb-1" value="${info.number1_2}">
		<input type="text" name="number1_3" 
		class="form-control mb-1" value="${info.number1_3}">
		
		<input type="text" name="number2_1" 
		class="form-control mb-1" value="${info.number2_1}">
		<input type="text" name="number2_2" 
		class="form-control mb-1" value="${info.number2_2}">
		<input type="text" name="number2_3" 
		class="form-control mb-1" value="${info.number2_3}">
		
		<input type="text" name="image1" 
		class="form-control mb-1" value="${info.image1}">
		<input type="text" name="image2" 
		class="form-control mb-1" value="${info.image2}">
		<input type="text" name="image3" 
		class="form-control mb-1" value="${info.image3}">
		<input type="text" name="image4" 
		class="form-control mb-1" value="${info.image4}">
		<input type="text" name="image5" 
		class="form-control mb-1" value="${info.image5}">
		
		<input type="text" name="content_main_title" 
		class="form-control mb-1" value="${info.content_main_title}">
		<textarea name="content_main">${info.content_main}</textarea>
		
		<input type="text" name="content1_title" 
		class="form-control mb-1" value="${info.content1_title}">
		<textarea name="content1">${info.content1}</textarea>
		
		<input type="text" name="content2_title" 
		class="form-control mb-1" value="${info.content2_title}">
		<textarea name="content2">${info.content2}</textarea>
		
		<input type="text" name="content3_title" 
		class="form-control mb-1" value="${info.content3_title}">
		<textarea name="content3">${info.content3}</textarea>
		
		<input type="hidden" name="templates" value="1">
	</form>
	
	</c:if>
	<c:if test="${edit ne 'edit'}">
	<h1>${info.yidx}</h1>
	<h1>${info.yaksokurl}</h1>
	<h1>${info.locate}</h1>
	<h1>${info.number1_1}</h1>
	<h1>${info.number1_2}</h1>
	<h1>${info.number1_3}</h1>
	<h1>${info.number2_1}</h1>
	<h1>${info.number2_2}</h1>
	<h1>${info.number2_3}</h1>
	<h1>${info.image1}</h1>
	<h1>${info.image2}</h1>
	<h1>${info.image3}</h1>
	<h1>${info.image4}</h1>
	<h1>${info.image5}</h1>
	<h1>${info.content_main_title}</h1>
	<h1>${info.content_main}</h1>
	<h1>${info.content1_title}</h1>
	<h1>${info.content1}</h1>
	<h1>${info.content2_title}</h1>
	<h1>${info.content2}</h1>
	<h1>${info.content3_title}</h1>
	<h1>${info.content3}</h1>
	</c:if> --%>
	
	
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-5">
                <a class="navbar-brand" href="#">약속해줘 예약</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Services</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- 기본 페이지------------------------------------ -->
        <c:if test="${edit ne 'edit'}">
        <!-- Page Content-->
        <div class="container px-4 px-lg-5">
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5 text-center">
                <div class="col-lg-12"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
                <div class="col-lg-12">
                    <h1 class="font-weight-light">${info.content_main_title}</h1>
                    <p>${info.content_main}</p>
                    <a class="btn btn-primary" href="#!">예약하기</a>
                </div>
            </div>
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-5"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light">${info.content1_title}</h1>
                    <p>${info.content1}</p>
                </div>
            </div>
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-5"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light">${info.content2_title}</h1>
                    <p>${info.content2}</p>
                </div>
            </div>
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-5"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light">${info.content3_title}</h1>
                    <p>${info.content3}</p>
                </div>
            </div>
            <!-- Call to Action-->
            <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body"><p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p></div>
            </div>
            <!-- Content Row-->
            <div class="row gx-4 gx-lg-5">
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">오시는길</h2>
                            <p class="card-text">${info.locate}</p>
                            <a class="btn btn-primary" href="#!">지도보기</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">연락처</h2>
                            <p class="card-text">매장 번호 : ${info.number1_1}-${info.number1_2}-${info.number1_3}<br>
                            					 휴대폰 : ${info.number2_1}-${info.number2_2}-${info.number2_3}</p>
                        </div>  
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title">이메일</h2>
                            <p class="card-text">wdestinw@gmail.com</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:if>
        
        <!-- 수정 페이지------------------------------------ -->
        <c:if test="${edit eq 'edit'}">
        <!-- Page Content-->
        <form name="info" action="yaksokEdit.me" method="post">
        <div class="container px-4 px-lg-5">
            <!-- Heading Row-->
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
                <div class="col-lg-5">
                    <h1 class="font-weight-light"><input type="text" name="content_main_title" 
                    value="${info.content_main_title}"></h1>
                    <textarea name="content_main">${info.content_main}</textarea>
                    <a class="btn btn-primary" href="#!">예약하기</a>
                </div>
            </div>
            <!-- Call to Action-->
            <div class="card text-white bg-secondary my-5 py-4 text-center">
                <div class="card-body"><p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p></div>
            </div>
            <!-- Content Row-->
            <div class="row gx-4 gx-lg-5">
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title"><input type="text" name="content1_title" 
                    		value="${info.content1_title}"></h2>
                           	<textarea name="content1">${info.content1}</textarea>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title"><input type="text" name="content2_title" 
                    		value="${info.content2_title}"></h2>
                           	<textarea name="content2">${info.content2}</textarea>
                        </div>   	
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100">
                        <div class="card-body">
                            <h2 class="card-title"><input type="text" name="content3_title" 
                    		value="${info.content3_title}"></h2>
                           	<textarea name="content3">${info.content3}</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        </c:if>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4 px-lg-5"><p class="m-0 text-center text-white">Copyright &copy; (주) 약속하는사람들 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>