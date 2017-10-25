<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<!--<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"></jsp:useBean>-->
	<table border="1">
		<tr bgcolor="0785cc">
			<td><b>Id</b></td>
			<td><b>Nome</b></td>
			<td><b>E-mail</b></td>
			<td><b>Endereço</b></td>
			<td><b>Data de Nascimento</b></td>
			<td><b>Ação</b></td>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">			
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail não informado
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td><a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="mvc?logica=AdicionaContatoLogica">Adicionar</a><br/>
	<c:import url="rodape.jsp" />
</body>
</html>