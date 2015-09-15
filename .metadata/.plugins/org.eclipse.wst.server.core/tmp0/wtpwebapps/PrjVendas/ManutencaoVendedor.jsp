<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Vendedor" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manutencao de Vendedor</title>
	</head>
	<body>
		<form action="ManutencaoVendedor" method="post">
		
			<h1>Manutenção de Vendedor</h1>
				Codigo: <input type="text" name="codigo"><br><br>
				Nome: <input type="text" name="nome"><br><br>
			
			<input type="submit" name="btnSubmit" value="salvar">
			<input type="submit" name="btnSubmit" value="pesquisar">
			<input type="submit" name="btnSubmit" value="alterar">
			<input type="submit" name="btnSubmit" value="excluir"><br><br>
				
		</form>
		
		<!--Fim o formulario-->
		
		<%
			ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) session.getAttribute("listaVendedor");
		
			if(listaVendedor != null){
			%>	<!--Definindo a tabela que apresenta o resultado-->
				<table border="1" style="width:20%">
				<thead>
					<tr>
						<th>CODIGO</th>
						<th>NOME DO VENDEDOR</th>
					</tr>
				</thead>
				<%	
				
				for(Vendedor vendedor : listaVendedor){
				%>	
					<tr>
						<td><center><%=vendedor.getCodigo() %></center></td>
						<td><center><%=vendedor.getNome() %></center></td>
					</tr>
				<%	
				}
			}
			%>
		
			</table>
		<br><br><a href="Menu.jsp">VOLTAR</a><br>
	</body>
</html>