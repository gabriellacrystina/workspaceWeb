<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Vendedor" %>  
<%@ page import="Modelo.Venda" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Relatorio por Vendedor</title>
	</head>
	<body>
		<form action="RelatorioVendasVendedor" method="post">
		
			<h1>Relatório de Vendas por Vendedor</h1><br>
			Vendedor:
			<select name="vendedor">
			<%
				ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) session.getAttribute("listaVendedor");	
			
				if(listaVendedor != null){
					for(int i = 0; i < listaVendedor.size(); i++){
					%>
						<option value="<%=i%>"><%=listaVendedor.get(i).getNome()%></option>
					<%	
					}
				}	
				%>	
			</select><br><br>
			<input type="submit" name="btnSubmit" value="Gerar Relatório"><br><br><br>
		</form>
		<!--Fim o formulario-->
		
		<!--Inicio da definicao da tabela-->
		<table border="1" style="width:30%">
		<thead>
			<tr>
				<th>NUMERO</th>
				<th>VALOR</th>
				<th>REGIAO</th>
			</tr>
		</thead>
		<%
		Vendedor vendedor = (Vendedor) session.getAttribute("v");
		int qtde = 0;
		double total = 0;
		
		if(vendedor!= null){
			for(Venda venda: vendedor.getVendas()){
			%>	
				<tr>
					<td><center><%=venda.getNumeroVenda() %></center></td>
					<td><center><%= venda.getValorVenda() %></center></td>
					<td><center><%= venda.getRegiao() %></center></td>
					<% qtde++;
					   total += venda.getValorVenda(); 
					%>
				</tr>
			<%		
			}
		}
		%>
		</table><br>
		<% 
			if(vendedor!= null){
			%>
			<div>
				NOME: <%= vendedor.getNome()%><br>
				QUANTIDADE DE VENDAS: <%=qtde%><br>
				TOTAL: <%=total%>
			</div><br><br>
			<% 
			}
		%>
		<a href="Menu.jsp">VOLTAR</a><br>
	</body>
</html>