package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelo.Vendedor;

/**
 * Servlet implementation class ManutencaoVendedor
 */
@WebServlet("/ManutencaoVendedor")
public class ManutencaoVendedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManutencaoVendedor() {
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
		
		Vendedor vendedor = new Vendedor();
		ArrayList<Vendedor> listaVendedor;
		
		//pega a lista da sessao!!
		listaVendedor = (ArrayList<Vendedor>)sessao.getAttribute("listaVendedor");
		
		if(listaVendedor == null){
			//Lista ainda n�o existe!!
			//Aqui ela sera instanciada e colocada na sessao.
			listaVendedor = new ArrayList<Vendedor>();
			sessao.setAttribute("listaVendedor", listaVendedor);
		}
		
		//getParameter: pq estou pegando uma String vinda do request
		String btn = request.getParameter("btnSubmit");
		String auxiliar;
		int codigo = 0;
		
		if(btn.equals("salvar")){
			
			//Gerar c�digo autom�tico - O arrayList j� soma 1 posicao assim que adiciona um item
			//Por isso n�o eh necessario nenhum tratamento especifico.
			codigo = listaVendedor.size() + 1;
			vendedor.setCodigo(codigo);
			
			auxiliar = request.getParameter("nome");
			vendedor.setNome(auxiliar);
			
			//adiciona o objeto vendedor na lista.
			listaVendedor.add(vendedor);
		}
	
		if(btn.equals("pesquisar")){
			String erro = null;
			int i,cod = 0;
			Vendedor vend = null;
			
			//recebo o RA como parametro de busca.
			cod =(Integer.parseInt(request.getParameter("codigo")));
			
			for(i = 0; i < listaVendedor.size(); i++){
				Vendedor v = (Vendedor) listaVendedor.get(i);
				if(cod == v.getCodigo()){
					vend = v;
				}
			}
				if(vend == null)
					erro = ("VENDEDOR N�O ENCONTRADO!!");
				
			//Se houver erro, ent�o set a string de erro ou ent�o "".
			sessao.setAttribute("erro", erro);
			//Se o vendedor foi encontrado set 
			sessao.setAttribute("vendedor", vend);
		}
		
		if(btn.equals("alterar")){
			
			vendedor = (Vendedor) sessao.getAttribute("vendedor");
			
			auxiliar = request.getParameter("nome");
			vendedor.setNome(auxiliar);
			
			sessao.setAttribute("alterar", vendedor);
		}
	
		if(btn.equals("excluir")){
			
			vendedor = (Vendedor) sessao.getAttribute("vendedor");
			
			listaVendedor.remove(vendedor);
		}
		
		//requisi��o atual � transferida para a p�gina JSP ManutencaoVendedor.
		request.getRequestDispatcher("ManutencaoVendedor.jsp").forward(request, response);	
	}
}
