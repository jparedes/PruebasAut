<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Usuarios</title>
	</head>
	<body>
		<div align="center">
			<table width="50%" border="1">
				<tr>
					<th>ID</th>
					<th>Login</th>
					<th>Password</th>
					<th>Email</th>
					<th>Fecha registro</th>
				</tr>
				
				<s:iterator value="usuarios" var="usu">
					<tr>
						<td>${usu.id}</td>
						<td>${usu.login}</td>
						<td>${usu.password}</td>
						<td>${usu.email}</td>
						<td>${usu.fechaRegistro}</td>
					</tr>
				</s:iterator>
			</table>
			
			<br />
			<a href="crearUsuario.jsp">Crear usuario nuevo</a>
			
		</div>
	
	</body>
</html>
