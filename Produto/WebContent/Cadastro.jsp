<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="PrAula24082015.Produto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<form action="Cadastro" method="post">
	
		<h1>Cadastro de Produtos</h1>
		<br>
		Código:<input type="text" name="codigo"><br><br>
		Valor:<input type="text" name="valor"><br><br>
		Descricao:<input type="text" name="descricao"><br><br>
		Fornecedor:<input type="text" name="fornecedor" size="15"><br><br>
		<input type="submit" name="enviar" value="Cadastrar">
	
	</form>
	<br>
	<br>
	<table id = "t1" border="1" style="width:40%">
		<thead>
			<td>CODIGO</td>
			<td>VALOR</td>
			<td>DESCRICAO</td>
			<td>FORNECEDOR</td>
		</thead>
		
	<%
		ArrayList<Produto> lista = (ArrayList<Produto>) session.getAttribute("lista");
	
		if(lista != null){
			for(Produto p: lista){
			%>
			<tr>
				<td><%= p.getCodigo()%></td>
				<td><%= p.getValor()%></td>
				<td><%= p.getDescricao()%></td>
				<td><%= p.getFornecedor()%></td>
			</tr>
			<%
			}
		}
	%>
	</table>
</body>
</html>