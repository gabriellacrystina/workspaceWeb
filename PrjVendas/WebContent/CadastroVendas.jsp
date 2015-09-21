<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Vendedor" %>
<%@ page import="Modelo.Regiao" %>
<%@ page import="Modelo.Venda" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro de Vendas</title>
	</head>
	<body>
		<form action="CadastroVendas" method="post">
		
		<h1>Cadastro de Vendas</h1>
		
		Vendedor:
		<select name="vendedor">
		<%
			ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) session.getAttribute("listaVendedor");
			ArrayList<Venda> listaVendas = (ArrayList<Venda>) session.getAttribute("listaVendas");	
		
			if(listaVendedor != null){
				for(int i = 0; i < listaVendedor.size(); i++){
				%>
					<option value="<%=i%>"><%=listaVendedor.get(i).getNome()%></option>
				<%	
				}
			}	
			%>	
		</select><br><br>
		Valor: <input type="text" name="valor"><br><br>
		Regiao:
		<select name="regiao">
			<%
				for(Regiao regiao: Regiao.values()){
				%>	
					<option value = "<%=regiao.name()%>"><%=regiao.name()%></option>
				<%	
				}
			%>
		</select><br><br>
		<input type="submit" name="btnSubmit" value="salvar"><br><br>
		</form>
		<!--Fim o formulario-->
		
		<table border="1" style="width:30%">
			<thead>
				<tr>
					<th>NUMERO</th>
					<th>VENDEDOR</th>
					<th>VALOR</th>
					<th>REGIAO</th>
				</tr>
			</thead>
			<%
				if(listaVendas != null){	
					for(Venda vendas : listaVendas){
					%>
						<tr>
							<td><center><%= vendas.getNumeroVenda() %></center></td>
							<td><center><%= vendas.getVendedor().getNome() %></center></td>
							<td><center><%= vendas.getValorVenda() %></center></td>
							<td><center><%= vendas.getRegiao() %></center></td>
						</tr>
					<%	
					}
				}
			%>
		</table>
		<br><br><a href="Menu.jsp">VOLTAR</a>
	</body>
</html>