<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->  
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>

	
    <c:if test="${feilmeldinger != null}">

   		 <p style="color: red">${feilmeldinger}</p>
    
	</c:if>
	
	 <c:if test="${error_message != null}">

   		 <p style="color: red">${error_message}</p>
    
	</c:if>
	
	<c:if test="${error2_message != null}">

   		 <p style="color: red">${error2_message}</p>
    
	</c:if>
	
	<form method="post">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="Skriv ditt fornavn her" />
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="Skriv ditt etternavn her" />
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value="Skriv din mobil nummer her" />
			
			<label>Passord</label>
			<input type="password" name="hash" />
			<label>Passord repetert</label>
			<input type="password" name="salt" />
			
			<label>Kjønn</label> 
			<input type="radio" name="kjonn" value="mann" checked="checked" />mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne
			     
			<br><br><button type="submit">Meld meg på</button>
		</fieldset>
	</form>
</body>
</html>
