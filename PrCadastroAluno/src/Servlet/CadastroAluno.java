package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import PrAula24082015.Aluno;

/**
 * Servlet implementation class CadastroAluno
 */
@WebServlet("/CadastroAluno")
public class CadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>)sessao.getAttribute("listaAluno");
		
		Aluno aluno = pesquisar(Integer.parseInt(request.getParameter("ra")), listaAluno);
		
		request.setAttribute("edit", aluno);
		
		request.setAttribute("remove", aluno);
		
		request.getRequestDispatcher("CadastroAluno.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aux;
		Aluno aluno = new Aluno();
		
		HttpSession sessao = request.getSession();
		
		ArrayList<Aluno> listaAluno;
		
		listaAluno = (ArrayList<Aluno>)sessao.getAttribute("listaAluno");
		
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
			
			aux = request.getParameter("AnoConclusao");
			aluno.setAnoConclusao(Integer.parseInt(aux));
			
			listaAluno.add(aluno);
			
		}
			
		if(btn.equals("pesquisar")){
			aluno = pesquisar(Integer.parseInt(request.getParameter("ra")), listaAluno);
			String erro = null;
			
			if(aluno == null){
				erro = ("ALUNO NAO ENCONTRADO");	
			}

			request.setAttribute("erro", erro);
			request.setAttribute("n", aluno);
		}
		
		if (btn.equals("editar")) {
			aluno = pesquisar(Integer.parseInt(request.getParameter("ra")), listaAluno);
			
			aux = request.getParameter("ra");
			aluno.setRA(Integer.parseInt(aux));

			aux = request.getParameter("nome");
			aluno.setNome(aux);
			
			aux = request.getParameter("idade");
			aluno.setIdade(Integer.parseInt(aux));
			
			aux = request.getParameter("curso");
			aluno.setCurso(aux);
			
			aux = request.getParameter("AnoConclusao");
			aluno.setAnoConclusao(Integer.parseInt(aux));
		}
		
		request.getRequestDispatcher("CadastroAluno.jsp").forward(request, response);
	}
	
	private Aluno pesquisar(int ra, ArrayList<Aluno> listaAluno) {
		String erro = "";
		Aluno  n = null;
			
		if(listaAluno != null){
			for(Aluno a: listaAluno){
				if(ra == a.getRA()){
					n = a;			
					break;
				}
			}
		}
		
		return n;
	}
}