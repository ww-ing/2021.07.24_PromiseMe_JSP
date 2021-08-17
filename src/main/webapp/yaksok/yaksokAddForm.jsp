<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp" />

	<div class="container">
	<h1 class="text-center text-primary m-4">약속등록</h1>
	<form name="f" action="yaksokAdd.me" method="post">
		<table class="table">
			<tr>
				<td width="20%">
				<b>*약속명</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-3">
					<input type="text" name="yaksokname" placeholder="YaksokName"
					 class="form-control">
					 </div>
				 </div>
				</td>
			</tr>
			<tr>
				<td width="20%">
				<b>이미지1</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-4">
					<input type="text" name="image1" placeholder="Image 1"
					class="form-control" >
					 </div>
				 </div>
				</td>
			</tr>
			
			<tr>
				<td width="20%">
				<b>이미지2</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-4">
					<input type="text" name="image2" placeholder="Image 2"
					 class="form-control">
				 	</div>
				 </div>
				</td>
			</tr>
						<tr>
				<td width="20%">
				<b>이미지3</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-4">
					<input type="text" name="image3" placeholder="Image 3"
				 	class="form-control">
				 	</div>
				 </div>
				</td>
			</tr>
			
			<tr>
				<td width="20%">
				<b>약속 연락처</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-3">
				<input type="text" name="hp1" maxlength="3"
				 placeholder="HP1"	 class="form-control">
					</div>
					<div class="col-md-3">
				<input type="text" name="hp2" maxlength="4" 
				placeholder="HP2"	 class="form-control">
					</div>
					<div class="col-md-3">
				<input type="text" name="hp3"  maxlength="4"
				 placeholder="HP3"	 class="form-control">
					</div>
				 </div>
				 <!-- row end -->
				 
				</td>
			</tr>
			<tr>
				<td width="20%">
				<b>우편번호</b>
				</td>
				<td width="80%">
				<div class="row">
					<div class="col-md-8">
					<input type="text" name="zipcode" placeholder="Zipcode"
						maxlength="5"
					 class="form-control">
					 </div>
					 <div class="col-md-4">
					 <button type="button" class="btn btn-primary">우편번호 확인</button>
					 </div>				 
				 </div>
				</td>
			</tr>
			
			<tr>
				<td width="20%">
				<b>주소</b>
				</td>
				<td width="80%">
			<input type="text" name="addr1"
			 placeholder="Address1" class="form-control mb-1">
			<input type="text" name="addr2" placeholder="Address2" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<button class="btn btn-success">등록</button>
					<button type="reset" class="btn btn-danger">다시쓰기</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="/foot.jsp" />