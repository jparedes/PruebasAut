<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table border="1"><tr><td>
		<s:form id="crearUsuarioForm" action="crearUsuario">
			<s:textfield name="login" label="Login" />
			<s:password name="password" label="Password" />
			<s:textfield name="email" label="Email" />
			<s:submit name="submit" />
		</s:form>
	</td></tr></table>
	</div>
</body>
</html>