package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PrAula24082015.Produto;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aux;
		Produto p = new Produto();
		
		
		HttpSession sessao = request.getSession();
		ArrayList<Produto> lista;
		
		lista = (ArrayList<Produto>)sessao.getAttribute("lista");
				
		if(lista == null){
			
			lista = new ArrayList<Produto>();
			sessao.setAttribute("lista", lista);
		}
			
		aux = request.getParameter("codigo");
		p.setCodigo(Integer.parseInt(aux));
		
		aux = request.getParameter("valor");
		p.setValor(Double.parseDouble(aux));
		
		aux = request.getParameter("descricao");
		p.setDescricao(aux);
		
		aux = request.getParameter("fornecedor");
		p.setFornecedor(aux);
		
		lista.add(p);
		
		request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
	}

}
