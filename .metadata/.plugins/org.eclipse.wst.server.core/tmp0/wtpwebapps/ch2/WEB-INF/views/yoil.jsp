<%@ page contentType="text/html; charset=utf-8" %> <!-- 입출력을 원활하게 나타내기 위해서 utf-8로 인코딩한다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
year=<%=request.getParameter("year") %>
<P>  ${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</P> <!-- EL이라고 한다... -->
</body>
</html>
<!-- YoilTellerMVC4에 맞추어진 View임. (myData로 저장하는 케이스)
다른 YoilTellerMVC에서는 제대로 뜨지 않을 확률 농후. -->