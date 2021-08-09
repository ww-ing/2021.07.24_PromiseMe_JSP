<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
    idx number(8) constraint yaksok_info_pk primary key,
    yaksokname varchar2(100) not null,
    yaksokurl varchar2(3000),
    locate varchar2(3000),
    number1_1 varchar2(100),
    number1_2 varchar2(100),
    number1_3 varchar2(100),
    number2_1 varchar2(100),
    number2_2 varchar2(100),
    number2_3 varchar2(100),
    image1 varchar2(1000),
    image2 varchar2(1000),
    image3 varchar2(1000),
    image4 varchar2(1000),
    image5 varchar2(1000),
    content_main_title varchar2(1000),
    content_main varchar2(3000),
    content1_title varchar2(1000),
    content1 varchar2(3000),
    content2_title varchar2(1000),
    content2 varchar2(3000),
    content3_title varchar2(1000),
    content3 varchar2(3000),
    key varchar2(30) not null
     -->
<body>
	<h2>yaksok=${info}</h2>
	<h2>yidx=${yidx}</h2>
	<h2>yaksokurl=${info.yaksokurl}</h2>
	<h2>locate=${info.locate}</h2>
	<h2>number1_1=${info.number1_1}</h2>
	<h2>number1_2=${info.number1_2}</h2>
	<h2>number1_3=${info.number1_3}</h2>
	<h2>number2_1=${info.number2_1}</h2>
	<h2>number2_2=${info.number2_2}</h2>
	<h2>number2_3=${info.number2_3}</h2>
	<h2>image1=${info.image1}</h2>
	<h2>image2=${info.image2}</h2>
	<h2>image3=${info.image3}</h2>
	<h2>image4=${info.image4}</h2>
	<h2>image5=${info.image5}</h2>
	<h2>content_main_title=${info.content_main_title}</h2>
	<h2>content_main=${info.content_main}</h2>
	<h2>content1_title=${info.content1_title}</h2>
	<h2>content1=${info.content1}</h2>
	<h2>content2_title=${info.content2_title}</h2>
	<h2>content2=${info.content2}</h2>
	<h2>content3_title=${info.content3_title}</h2>
	<h2>content3=${info.content3}</h2>
	<h2>templates=${info.templates}</h2>
</body>
</html>