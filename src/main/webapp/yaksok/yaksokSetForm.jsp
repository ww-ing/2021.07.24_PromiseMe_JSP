<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
 
<jsp:include page="/top.jsp" />   

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
	
<jsp:include page="/foot.jsp" />   