<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--top Page include  -->
    <jsp:include page="top.jsp"/>
    
    <!-- 본문 -->
    <div id="slideWrap" class="carousel slide" data-ride="carousel">

  <div class="carousel-inner" style="border: 1px solid purple">
    <div class="carousel-item active">
      <img src="images/1.jpg" alt="" width="1100" height="400">
    </div>
    <div class="carousel-item">
      <img src="images/2.jpg" alt="" width="1100" height="400">
    </div>
    <div class="carousel-item">
      <img src="images/3.jpg" alt="" width="1100" height="400">
    </div>
  </div>
  <h1 class="text-center">이건 어떠세요?</h1>
  
</div>

    <!--foot Page include  -->
    <jsp:include page="foot.jsp"/>