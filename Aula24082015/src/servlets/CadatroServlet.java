package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Produto;

/**
 * Servlet implementation class CadatroServlet
 */
@WebServlet("/cadastro")
public class CadatroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadatroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		ArrayList<Produto> lista;

		lista = (ArrayList<Produto>) sessao.getAttribute("lista");
		sessao.setAttribute("produto", null);
		sessao.setAttribute("erro", null);
		
		if (lista == null) {
			lista = new ArrayList<Produto>();
			sessao.setAttribute("lista", lista);
		}
		String btn = request.getParameter("btnSubmit");

		if (btn.equals("Salvar")) {
            salvar(request, response, lista);
		}
		else
		{
			if(btn.equals("Pesquisar"))
			{
				pesquisar(request, response, lista, sessao);
			}
		}

		request.getRequestDispatcher("cadastro.jsp").forward(request, response);

	}

	private void pesquisar(HttpServletRequest request,	HttpServletResponse response, ArrayList<Produto> lista, HttpSession sessao) {
		
		int codigo  = Integer.parseInt(request.getParameter("codigo"));
		Produto aux=null;		
		for(Produto p : lista)
		{
			if(p.getCodigo() == codigo)
			{
				aux = p;
				break;
			}
		}
		if(aux == null)
		{
			sessao.setAttribute("erro", "Produto não cadastrado");
		}
		else
		{
			sessao.setAttribute("produto", aux);
		}
		
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response, ArrayList<Produto> lista) {
		String aux;
		Produto p = new Produto();

		aux = request.getParameter("codigo");
		p.setCodigo(Integer.parseInt(aux));

		aux = request.getParameter("valor");
		p.setValor(Double.parseDouble(aux));

		aux = request.getParameter("descricao");
		p.setDescricao(aux);

		aux = request.getParameter("fornecedor");
		p.setFornecedor(aux);

		lista.add(p);
		
	}

}
