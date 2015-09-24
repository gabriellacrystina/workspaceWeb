package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Regiao;
import Modelo.Venda;
import Modelo.Vendedor;

/**
 * Servlet implementation class RelatorioVendasVendedor
 */
@WebServlet("/RelatorioVendasVendedor")
public class RelatorioVendasVendedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioVendasVendedor() {
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
		HttpSession sessao = request.getSession();
		
		ArrayList<Vendedor> listaVendedores;
		listaVendedores = (ArrayList<Vendedor>)sessao.getAttribute("listaVendedor");
		
		if(listaVendedores != null){
			int indice = Integer.parseInt(request.getParameter("vendedor"));
			Vendedor vendedor = listaVendedores.get(indice);
			
			sessao.setAttribute("v", vendedor);
		}
		
		request.getRequestDispatcher("RelatorioVendasVendedor.jsp").forward(request, response);
	}
}