<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="PrAula24082015.Aluno"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CadastroAluno</title>
</head>
	<body>
		<form action="CadastroAluno" method = "post">
		
		<!--Definindo o formulario-->
			
			<h1>Cadastro de Alunos</h1>
			<br><br>
			
			<%
				Aluno edit = (Aluno) request.getAttribute("edit");
				String ra = "", nome = "", idade = "", curso = "", ano = "";
				
				if (edit != null) {
					ra = Integer.toString(edit.getRA());
					nome = edit.getNome();
					idade = Integer.toString(edit.getIdade());
					curso = edit.getCurso();
					ano = Integer.toString(edit.getAnoConclusao());
				}
			%>
		
			Ra <input type="number" name="ra" value="<%=ra%>"><br><br>
			Nome <input type="text" name="nome" value="<%=nome%>"><br><br>
			Idade <input type="number" name="idade" value="<%=idade%>"><br><br>
			Curso <input type="text" name="curso" value="<%=curso%>"><br><br>
			Ano de Conclusao <input type="text" name="AnoConclusao" value="<%=ano%>"><br><br>
			
			<input type="submit" value="salvar" name="btnSubmit">
			<input type="submit" value="editar" name="btnSubmit">
			<input type="submit" value="pesquisar" name="btnSubmit">
			<input type="submit" value="excluir" name="btnSubmit">
			<br><br>			
		</form>
		<!--Fim o formulario-->
		
		<!--Definindo a tabela que apresenta o resultado-->
		<%
			ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) session.getAttribute("listaAluno");
			Aluno aux = (Aluno) request.getAttribute("n");
			String erro = (String) request.getAttribute("erro");
			
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
								<th>A��es</th>
							</tr>
						</thead>
						
						<tbody>
							<%
								if (aux != null) {
									%>			
										<tr>
											<td><%=aux.getRA() %></td>
											<td><%=aux.getNome() %></td>
											<td><%=aux.getIdade() %></td>
											<td><%=aux.getCurso()  %></td>
											<td><%=aux.getAnoConclusao() %></td>
											<td>
												<a href="CadastroAluno?ra=<%=aux.getRA() %>">Editar</a>
											</td>
										</tr>
									<%
								} else if (erro != null && !erro.equals("")) {
									%>			
										<tr>
											<td colspan="6" style="text-align: center;"><%=erro%></td>
										</tr>
									<%
								} else {
									for(Aluno aluno: listaAluno){
										%>			
											<tr>
												<td><%=aluno.getRA() %></td>
												<td><%=aluno.getNome() %></td>
												<td><%=aluno.getIdade() %></td>
												<td><%=aluno.getCurso()  %></td>
												<td><%=aluno.getAnoConclusao() %></td>
												<td>
													<a href="CadastroAluno?ra=<%=aluno.getRA() %>">Editar</a>
												</td>
											</tr>
										<%
									}
								}
							%>
						</tbody>
					</table>
				<%
			}
		%>
	</body>
</html>