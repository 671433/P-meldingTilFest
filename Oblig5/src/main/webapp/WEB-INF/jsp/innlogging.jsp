<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	
	<c:if test="${beskjed_message != null}">

   		 <p style="color: red">${beskjed_message}</p>
    
	</c:if>

	<c:if test="${error_message != null}">

   		 <p style="color: red">${error_message}</p>
    
	</c:if>
	
	<form method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>
	 
	<p>Hvis du ikke har en konto, kan du opprette en ny konto</p>
	<a href="paamelding">Gå til påmelding side</a>

</body>
</html>