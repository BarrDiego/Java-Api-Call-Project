<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Weather Search</title>
</head>
<body>
	<form:form id="my_search" action="my_result" modelAttribute="my_search" method="POST">
        <form:label>Ciudad/City <form:input type="text" id="city" path="city" name="city"/> </form:label><br>
        <form:label>Provincia/State <form:input type="text" id="state" path="state" name="state"/> </form:label><br>
        <form:label> Pais/Country <form:input type="text" id="country" path="country" name="country"/> </form:label>
        <br><hr><br>
        <form:button id="btnBuscar" type="button" name="btnBuscar">Buscar</form:button>
        <br>
        <hr>
        <br>
	</form:form>
	
	<table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
    </table>



</body>
</html>