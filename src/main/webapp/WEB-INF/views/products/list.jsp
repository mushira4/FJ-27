<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc"%>
<cdc:page title="Products">
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user" />
		<spring:message code="user.welcome" arguments="${user.name}" />
	</sec:authorize>

	<table>
		<tr>
			<td>Titulo</td>
			<td>Detalhes</td>
		</tr>
		
		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.title}"/></td>
				<td>
					<c:url value="/products/${product.id}" var="linkDetalhar"/>
					<a href="${linkDetalhar}">Detalhar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</cdc:page>
