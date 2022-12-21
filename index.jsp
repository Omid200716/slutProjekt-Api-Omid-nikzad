<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather-app</title>
<link href="./Css/Stylesheet.css" rel="stylesheet">
</head>
<body>

<div class="container">
	<img class="indexImage" src="https://is2-ssl.mzstatic.com/image/thumb/Purple122/v4/b2/d0/ef/b2d0efa6-060a-76a5-d169-83ca6011c193/AppIcon-0-0-1x_U007emarketing-0-0-0-10-0-0-sRGB-0-0-0-GLES2_U002c0-512MB-85-220-0-0.png/512x512bb.jpg" >
	<div class="form-content">
		<form action="<%=request.getContextPath()%>/OWservlet" method="post">
			<input type="text" name="city" placeholder="city ..." />
			<br> 
			<input type="text" name="country" placeholder="country..." />
			<br> 
			<input type="submit" value="search">
		</form>
	</div>
</div>
</body>
</html>