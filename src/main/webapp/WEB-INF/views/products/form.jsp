<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="cdc"%>
<cdc:page title="Products">
	<springForm:form action="${spring:mvcUrl(\"saveProduct\").build()}" 
			method="post" 
			commandName="product"
			enctype="multipart/form-data">
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
			<label for="summary">Sumário do livro</label>
			<input type="file" name="summary" id="summary">
			<springForm:errors path="summaryPath"/>
		</div>
		<div>
			<input type="submit" value="Enviar" />
		</div>
	</springForm:form>
</cdc:page>