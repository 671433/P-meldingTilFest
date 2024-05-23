<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
<title>registerAnsatt</title>
</head>
<body>

	<P>Hello</P>
	<p>${feilmelding } </p>
	
	<form action="reg" method="post">
	
			<fieldset>
			<legend>fornavn</legend>
			  <p> Fornavn	<input type="text" name="fornavn"/> </p>
				
			</fieldset><br>
			
			
			<fieldset>
			<legend>Etternavn</legend>
				<p> Etternavn<input type="text" name="etternavn"/> </p>
			</fieldset><br>
			
			
			<fieldset>
			<legend>Fodseldato</legend>
				<p> Fodseldato<input type="number" name="fodseldato"/></p>
			</fieldset><br>
			
			
			<fieldset>
			<legend>kjønn</legend>
			<p>
				<input type="radio" name="kjonn" value="M" checked="checked"/>M
				<input type="radio" name="kjonn" value="K"/> K
				
				</P>
			</fieldset><br>
			
			
			<fieldset>
			<legend>startdato</legend>
			<p>
			startdato	<input type="number" name="startdato"/> 
				
			</p>
			</fieldset><br>
			
			
			<fieldset>
			<legend>stilling</legend>
				<select name="stilling">
				<option  value="Utvikle" selected="Utvikle">Utvikle</option>
				<option  value="Ãkonom"/>Åkonomi</option>
				<option   value="Sjef"/>Sjef</option>
				</select>
			</fieldset><br>
			
			
			<fieldset>
			<legend>månedslønn</legend>
				<input type="number" name="maanedslonn"/>
				
			</fieldset><br>
			
			<fieldset>
			<legend>submit</legend>
			<p>
			<input type="submit" name="sende data"/> 
				
			</p>
			</fieldset><br>
			
			
			
			
		
		
		
		
	</form>

</body>
</html>