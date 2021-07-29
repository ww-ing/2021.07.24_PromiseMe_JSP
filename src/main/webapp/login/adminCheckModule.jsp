<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.domain.*"%>
    
<%--관리자 여부를 체크하는 모듈. 관리자만 사용 가능한 페이지에 이 모듈을 include한다 --%>

<%
	UserVO member=(UserVO) session.getAttribute("loginUser");
	if(member==null){
		%>
		<script>
			alert('로그인해야 이용할 수 있어요');
			location.href = "<%=request.getContextPath()%>/login/login.jsp";
		</script>
		<%
		return;
	}
	
	if(!member.getUserid().equals("admin")){
		%>
		<script>
			alert('관리자만 이용할 수 있어요');
			history.back();
		</script>
		<%
		return;
	}
	
	//관리자 계정이 정지 되었을 경우
	if(member.getMstate()==1){
		%>
		<script>
			alert('정지된 관리자입니다. 일반회원으로 전환해야 이용 가능합니다. 회원정보를 수정한 뒤 다시 로그인 하세요')
			location.href = "<%=request.getContextPath()%>/member/edit.jsp?idx=<%=member.getIdx()%>&mode=<%=member.getMstate()%>";
		</script>
		<%
		return;
	}
%>