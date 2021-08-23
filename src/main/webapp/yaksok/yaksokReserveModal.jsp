<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="myctx" value="${pageContext.request.contextPath}"/> 
  
		<!-- Modal Dialog -->
        <div class="modal" id="yaksokBookingModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="text-primary" style="margin:auto">약속해줘 예약</h4>
                        <button class="close" data-dismiss="modal">&times;</button>
                    </div>
					
                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form action="yaksokReserve.me" method="post">
                            <div class="form-group">
                                <label for="username">이름</label>
                                <input type="text" autofocus="autofocus" 
                                class="form-control" name="username">
                            </div>
                    
                            <div class="form-group">
                                <label for="hp">전화번호</label>
                                <input type="password" class="form-control" name="rhp">
                            </div>
                            
                            <div>
                            	<label for="hp">요청사항</label>
                            	<p><textarea name="rcontent"></textarea></p>
                            </div>
                            <div class="form-group text-center">
                            <button class="btn btn-primary btn-block">약속하기</button>
                            <button class="btn btn-danger" 
                            data-dismiss="modal">닫기</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- ---------- -->