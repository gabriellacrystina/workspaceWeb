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
 * Servlet implementation class RelatorioVendasRegiao
 */
@WebServlet("/RelatorioVendasRegiao")
public class RelatorioVendasRegiao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioVendasRegiao() {
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
		
		ArrayList<Venda> listaVendas;
		ArrayList<Venda> relatorio = null;
		
		listaVendas = (ArrayList<Venda>)sessao.getAttribute("listaVendas");
		relatorio = new ArrayList<Venda>();
		
		if(listaVendas == null){
			listaVendas = new ArrayList<Venda>();
			sessao.setAttribute("listaVendas", listaVendas);
		}

		Venda venda;
		String regiao = request.getParameter("regiao");
		
		//int i, qtde = 0;
		//double valTotal = 0;
		
		for(int i=0; i < listaVendas.size(); i++){
			venda = listaVendas.get(i);
			if(venda.getRegiao().equals(Regiao.valueOf(regiao))){
				//valTotal += venda.getValorVenda();
				//qtde++;
				relatorio.add(venda);
			}
		}
		sessao.setAttribute("relatorio", relatorio);
		//request.setAttribute("quantidade", qtde);
		//request.setAttribute("valorTotal", valTotal);
		
		request.getRequestDispatcher("RelatorioVendasRegiao.jsp").forward(request, response);	
	}
}

