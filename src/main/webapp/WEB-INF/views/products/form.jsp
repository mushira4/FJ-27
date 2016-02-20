<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de livros</title>
</head>
<body>
	<springForm:form action="${spring:mvcUrl('saveProduct').build()}" method="post" commandName="product">
		<div>
			<label for="title">Título</label> 
			<springForm:input path="title" id="title" />
			<springForm:errors path="title"/>
		</div>

		<div>
			<label for="description">Descrição</label>
			<springForm:textarea rows="10" cols="20" path="description" id="description"/>
			<springForm:errors path="description"/>
		</div>
		<div>
			<label for="numberOfPages">Número de páginas</label> 
			<springForm:input path="numberOfPages" id="numberOfPages" />
			<springForm:errors path="numberOfPages"/>
		</div>
		<div>
			<label for="releaseDate">Data de lançamento</label>
			<springForm:input path="releaseDate" id="releaseDate" />
			<springForm:errors path="releaseDate"/>
		</div>
		<div>
			<c:forEach items="${types}" var="bookType" varStatus="status">
				<div>
					<label for="price_${bookType}">${bookType}</label> 
						<input type="text" name="prices[${status.index}].value" id="price_${bookType}" /> 
						<input type="hidden"name="prices[${status.index}].bookType" value="${bookType}" />
				</div>
			</c:forEach>
		</div>

		<div>
			<input type="submit" value="Enviar" />
		</div>
	</springForm:form>
</body>
</html>