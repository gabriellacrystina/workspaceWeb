<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="modelo.Produto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
   Produto p = (Produto) session.getAttribute("produto");
   String codigo="", valor="", descricao="",fornecedor="";
   
   if(p!= null)
   {
	   codigo = ""+p.getCodigo();
	   valor  = ""+p.getValor();
	   descricao = p.getDescricao();
	   fornecedor =p.getFornecedor();
   }

   String erro = (String) session.getAttribute("erro");
   if(erro != null)
	   out.print("<h1>"+ erro + "</h1>");

   
%>
	<form action="cadastro" method="post">
		
		<br>Código <input type="text" name="codigo" value="<%=codigo %>"/> 
        <br>Valor <input type="text" name="valor"   value="<%=valor%>"/> 
        <br>Descrição <input type="text" name="descricao"  value="<%=descricao%>"/>
        <br>Fornecedor <input type="text" name="fornecedor" value="<%=fornecedor%>" />
        
        
	    <br><input type="submit" value="Salvar" name="btnSubmit"  /> <input
			type="submit" value="Pesquisar" name="btnSubmit" /> <input
			type="submit" value="Excluir" name="btnSubmit" /> <input
			type="submit" value="Alterar" name="btnSubmit" />
	</form>
	
	<%
	
	   ArrayList<Produto> lista = (ArrayList<Produto>) session.getAttribute("lista");
		if (lista != null)
			for (Produto prod : lista)
				out.println(prod.getCodigo());
	%>
	
	
	
    

</body>
</html>