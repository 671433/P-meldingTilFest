<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${fornavn}<br />
		&nbsp;&nbsp;&nbsp;${etternavn }<br />
		&nbsp;&nbsp;&nbsp;${mobil }<br /> 
		&nbsp;&nbsp;&nbsp;${kjonn}
	</p>
	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>