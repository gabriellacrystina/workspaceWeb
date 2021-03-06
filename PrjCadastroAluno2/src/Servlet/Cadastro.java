package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PrAula.Aluno;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>)sessao.getAttribute("listaAluno");
		
		Aluno aluno;
		
		int i = pesquisar(Integer.parseInt(request.getParameter("ra")), listaAluno);
		aluno = listaAluno.get(i);
		
		request.setAttribute("editar", aluno);
		request.setAttribute("editarIndice", i);
		
		request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>)sessao.getAttribute("listaAluno");
	
		Aluno aluno = new Aluno();
		String aux;
		
		if(listaAluno == null){	
			listaAluno = new ArrayList<Aluno>();
			sessao.setAttribute("listaAluno", listaAluno);
		}
		
		String btn = request.getParameter("btnSubmit");
		
		if(btn.equals("salvar")){
			
			aux = request.getParameter("ra");
			aluno.setRA(Integer.parseInt(aux));
			
			aux = request.getParameter("nome");
			aluno.setNome(aux);
			
			aux = request.getParameter("idade");
			aluno.setIdade(Integer.parseInt(aux));
			
			aux = request.getParameter("curso");
			aluno.setCurso(aux);
			
			aux = request.getParameter("ac");
			aluno.setAnoConclusao(Integer.parseInt(aux));
			
			listaAluno.add(aluno);
					
		}
		
		if(btn.equals("pesquisar")){
			int i;
			
			i = pesquisar(Integer.parseInt(request.getParameter("ra")), listaAluno);
			
			String erro = "";
			
			if(i < 0 )
				erro = ("ALUNO NAO ENCONTRADO");	

			request.setAttribute("erro", erro);
			request.setAttribute("n", i);	
		}
		
		
		if(btn.equals("editar")){
			int indice = Integer.parseInt(request.getParameter("indice")) ;
			
			aluno = listaAluno.get(indice);
			
			aux = request.getParameter("ra");
			aluno.setRA(Integer.parseInt(aux));
			
			aux = request.getParameter("nome");
			aluno.setNome(aux);
			
			aux = request.getParameter("idade");
			aluno.setIdade(Integer.parseInt(aux));
			
			aux = request.getParameter("curso");
			aluno.setCurso(aux);
			
			aux = request.getParameter("ac");
			aluno.setAnoConclusao(Integer.parseInt(aux));
		}
		
		if(btn.equals("excluir")){
			int indice = Integer.parseInt(request.getParameter("indice")) ;
			listaAluno.remove(indice);
		}
		
		request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
	}
	
	private int pesquisar(int ra, ArrayList<Aluno> listaAluno ){
		int n = -1;
		Aluno a = null;	
		
		if(listaAluno != null){
			for(int i = 0; i < listaAluno.size(); i++){
				a = (Aluno)listaAluno.get(i);
				if(ra == a.getRA()){
					n = i;			
					break;
				}
			}
		}
		return n;
	}
}
