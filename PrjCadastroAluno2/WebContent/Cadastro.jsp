<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="PrAula.Aluno"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro</title>
	</head>
		<body>
			<form action = "Cadastro" method = "post">
				<h2>Cadastro de Aluno</h2>
				<br><br>
				
				<%
					Aluno editar = (Aluno) request.getAttribute("editar");
					String ra = "", nome = "", idade = "", curso = "", ano = "";
					
					if (editar != null) {
						ra = Integer.toString(editar.getRA());
						nome = editar.getNome();
						idade = Integer.toString(editar.getIdade());
						curso = editar.getCurso();
						ano = Integer.toString(editar.getAnoConclusao());
					}
					
					Object auxiliar = request.getAttribute("editarIndice");
					int indice = 0;
					if ( auxiliar != null ) {
						indice = (int) auxiliar;
					}
				%>
				
				<input type="hidden" name="indice" value="<%=indice%>">
				
				RA <input type="text" name="ra" value="<%=ra%>"><br><br>
				Nome <input type="text" name="nome" value="<%=nome%>"><br><br>
				Idade <input type="text" name="idade" value="<%=idade%>"><br><br>
				Curso <input type="text" name="curso" value="<%=curso%>"><br><br>
				Ano de Conclus�o <input type="text" name="ac" value="<%=ano%>"><br><br>
				
				<input type="submit" name="btnSubmit" value="salvar">
				<input type="submit" name="btnSubmit" value="pesquisar">
				<input type="submit" name="btnSubmit" value="editar">
				<input type="submit" name="btnSubmit" value="excluir"><br><br>
						
			</form>
			<%
			//Monta a tabela
			ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) session.getAttribute("listaAluno");

			
			if (listaAluno != null && listaAluno.size() > 0) {
				%> 
				<table border="1" style="width:40%">
						<thead>
							<tr>
								<th>RA</th>
								<th>NOME</th>
								<th>IDADE</th>
								<th>CURSO</th>
								<th>ANO DE CONCLUSAO</th>
								<th><center>A��ES</center></th>
							</tr>
						</thead>
						<%
						//Resultado da pesquisa
						
						//Pesquisa
						int aux = -1;
						
						Object obj = request.getAttribute("n");
						if(obj != null){
							aux = (int) obj;
							
						}
						String erro = (String) request.getAttribute("erro");
						if (aux >= 0){
						Aluno a = listaAluno.get(aux);
						%>			
							<tr>
								<td><%=a.getRA() %></td>
								<td><%=a.getNome() %></td>
								<td><%=a.getIdade() %></td>
								<td><%=a.getCurso()  %></td>
								<td><%=a.getAnoConclusao() %></td>
								<td>
									<a href="Cadastro?ra=<%=a.getRA() %>">Editar</a>
									
								</td>
							</tr>
						<%
					} else if (erro != null && !erro.equals("")) {
						%>			
							<tr>
								<td colspan="6" style="text-align: center;"><%=erro%></td>
							</tr>
						<%
					}else{
						//Mostra o Conteudo da lista
						for(Aluno aluno: listaAluno){
							%>			
								<tr>
									<td><center><%=aluno.getRA() %></center></td>
									<td><center><%=aluno.getNome() %></center></td>
									<td><center><%=aluno.getIdade() %></center></td>
									<td><center><%=aluno.getCurso()  %></center></td>
									<td><center><%=aluno.getAnoConclusao() %></center></td>
									<td>
										<a href="Cadastro?ra=<%=aluno.getRA() %>">Editar </a>
									</td>
								</tr>
							<%
						}
					}	
						%>
				</table>
				<%
			}
			%>
		</body>
</html>