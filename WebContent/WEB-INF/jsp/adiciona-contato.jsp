
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Adiciona contatos</title>
<link href="js/jquery-ui.css" rel="stylesheet">
<script src="js/external/jquery/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<form action="mvc?logica=AdicionaContatoLogica" method="post">
		<h1>Contato:</h1>
		<table>
		<tr>
			<td>
				Nome: 
			</td>
			<td>
				<input type="text" name="nome" />
			</td>
		</tr>
		<tr>
			<td>
				E-mail:
			</td>
			<td>
				<input type="text" name="email" />
			</td>
		</tr>
		<tr>
			<td>
				Endereço: 
			</td>
			<td>
				<input type="text" name="endereco" />
			</td>
		</tr>
		<tr>
			<td>
				Data Nascimento: 
			</td>
			<td>
				<!-- <input type="text" name="dataNascimento" /> -->
				<caelum:campoData id="dataNascimento" />
			</td>
		</tr>
		</table>
				
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>