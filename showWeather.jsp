<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="modle.WeatherBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>the weather</title>
<link href="Css/Stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>


<div id="container2">
<%
	WeatherBean wBean = (WeatherBean) session.getAttribute("wBeanLabel");
	

	double number = Double.parseDouble(wBean.getTempratur());
	number = number - 273.15;
	int number2 = (int) Math.round(number);
	%>

	<%
	String icon = wBean.getIcon();
	%>

	<div class="icon">
		<img alt="" src="https://openweathermap.org/img/wn/<%=icon%>@2x.png" />
	</div>

	<h2>
		<%
		String provinse = wBean.getProvince();
		out.print(wBean.getCityStr() + "  " + number2 + " °C ");
		%>
	</h2>
	
	<h2>
	<%
	out.print(wBean.getCloudsStr());
	%>
	</h2>

	<p>
		<%
		out.print(wBean.getProvince() + " in " + wBean.getCountryStr());
		%>
	</p>


	<p><%
		out.print(wBean.getCountryStr() + " sun is upp:" + wBean.getTime());
		%>
	</p>
	
	<%
	Cookie[] cookies = request.getCookies();
	String tempCity = "";
	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("cookie")) {
			tempCity = cookies[i].getValue();
		}

	}
	tempCity = tempCity + "-";
	String[] arrCity = new String[1];
	arrCity = tempCity.split("-");

	String tempCountry = "-";
	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("country")) {
			tempCountry = cookies[i].getValue();
		}
	}

	tempCountry = tempCountry + "-";
	String[] arrCountry = new String[1];
	arrCountry = tempCountry.split("-");

	for (int i = 0; i < arrCity.length; i++) {
	%>
	<br>
	<a href="OWservlet?city=<%=arrCity[i]%>&country=<%=arrCountry[i]%>">Search history: <%=arrCity[i]%>
		<%=arrCountry[i]%></a>
	<%
	}
	%>
</div>
	<jsp:include page="../index.jsp" />
</body>
</html>