<%@ page import="java.util.*,
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.modelo.*,
				java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	
		<tr>
			<td><b>Nome</b></td>
			<td><b>E-mail</b></td>
			<td><b>Endereço</b></td>
			<td><b>Data de Nascimento</b></td>
		</tr>
	
		<%			
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos) {	
				
				String dataTemp = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
		%>
	
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=dataTemp %></td>
		</tr>
		
		<%
			}
		%>
		
	</table>
</body>
</html>