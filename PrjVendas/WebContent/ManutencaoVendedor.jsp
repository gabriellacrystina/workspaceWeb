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
				Codigo: <input type="text" name="codigo" ><br><br>
				Nome: <input type="text" name="nome"><br><br>
			
			<input type="submit" name="btnSubmit" value="salvar">
			<input type="submit" name="btnSubmit" value="pesquisar">
			<input type="submit" name="btnSubmit" value="alterar">
			<input type="submit" name="btnSubmit" value="excluir"><br><br>
				
		</form>
		
		<!--Fim o formulario-->
		
		<%
			ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) session.getAttribute("listaVendedor");
		
			if(listaVendedor != null && listaVendedor.size() > 0){
			%>	<!--Definindo a tabela que apresenta o resultado-->
				<table border="1" style="width:20%">
				<thead>
					<tr>
						<th>CODIGO</th>
						<th>NOME DO VENDEDOR</th>
					</tr>
				</thead>
				<%
					//Pesquisa : objeto da pesquisa ou string de erro. 
					Vendedor pesquisar = (Vendedor) request.getAttribute("vendedor");
					String erro = (String) request.getAttribute("erro");
					
					if(pesquisar != null){
					%>			
						<tr>
							<td><%=pesquisar.getCodigo() %></td>
							<td><%=pesquisar.getNome() %></td>
						</tr>
					<%
					}else if(erro != null && !erro.equals("")){
						%>
						<tr>
							<td colspan="3" style="text-align: center;"><%=erro%></td>
						</tr>
						<%	
						}else{//Apresenta o conteudo da Lista
							for(Vendedor vendedor : listaVendedor){
							%>
								<tr>
									<td><center><%=vendedor.getCodigo() %></center></td>
									<td><center><%=vendedor.getNome() %></center></td>
								</tr>
							<%	
							}	
						}	
			}
			%>
		
			</table>
		<br><br><a href="Menu.jsp">VOLTAR</a><br>
	</body>
</html>