<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Currency converter</title>

</head>
<body>
<h1>Currency converter</h1>
<p><div id="returnMessage">${message}</div><br/>

<form:form method="POST" commandName="currencyConverterForm" action="${pageContext.request.contextPath}/calculate.html">

		<table>
		    <tr> <td>
		    <form:errors path="*" cssClass="errorblock" element="div"/>
		    </td> </tr> 
			<tr>
			    <td><b>Data to convert:</b></td>
                <td><form:input path="money" /></td>
                
                <td>Currency 1 :</td>
                <td><form:select name="selectedCurrencyCode1" path="selectedCurrencyCode1" items="${currencyItems}" /></td>
				<td>Currency 2 :</td>
				<td><form:select name="selectedCurrencyCode2" path="selectedCurrencyCode2" items="${currencyItems}" /></td>
				<td><input type="submit" name="Convert" value="Convert"/></td>
			</tr>
			<tr>
			<td></td>
			<td colspan="5"><form:errors path="money" cssClass="error" /></td>
			<td></td>
			
			</tr>
		</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>