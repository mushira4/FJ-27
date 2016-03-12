<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc"%>
<cdc:page title="AUthentication">
	<h3>Login</h3>
	<form:form servletRelativeAction="/login">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="logar"></td>
			</tr>
		</table>
	</form:form>
</cdc:page>
