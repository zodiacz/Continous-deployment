<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome</title>
<style type="text/css">
</style>
  <link href="<c:url value='css/output.css'/>" rel="stylesheet" type="text/css" />
</head>

<body>
<p>Welcome to The SE234 Test flight</p>
<div class="login" id="login">
    <form:form action="validate" method="post" commandName="loginEntity">
  <p>username 
    <form:input path="userName" name="name"  />
    
  </p>
  <p>password 
    <label for="password"></label>
    <form:password  path="password" name="password"  />
    <form:errors path="password"> <div class="error">Stupid, input the password !!!</div></form:errors>
  </p>
  <p>
    <input type="submit" name="Login" id="LoginButton" value="Sign in" />
  </p>
      <c:if test="${empty var1}">
        <p class="error">
          ${errorMessage}
        </p>
      </c:if>
</form:form></div>
<p>&nbsp;</p>
</body>
</html>