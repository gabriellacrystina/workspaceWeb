package PrAula17082015;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prato
 */
@WebServlet("/Prato")
public class Prato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String pratoprincipal = request.getParameter("pratoprincipal");
		String[] acompto = request.getParameterValues("acompanhamento");
		String convenio = request.getParameter("convenio");
		String obser = request.getParameter("observacoes");
		double preco = 0;
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<br><h1>Refeição escolhida:</h1>");
		
		if("massa".equals(pratoprincipal)){
			preco = 10.0;
			out.println("Prato principal:  Massa;<br>");
		}
		if("carne".equals(pratoprincipal)){
			preco = 15.0;
			out.println("Prato principal:  Carne;<br>");
		}
		if("peixe".equals(pratoprincipal)){
			preco = 13.0;
			out.println("Prato principal:  Carne;<br>");
		}
		out.println("Acompanhamento(s):");
		
		for(int i = 0; i < acompto.length; i++){
			String acompanhamento = acompto[i];
			
			if(acompanhamento.equals("salada")){
				preco = preco + 1.50;
				out.println(" Salada;");
			}	
			if(acompanhamento.equals("legumes")){
				preco = preco + 3.50;
				out.println(" Legumes;");
			}
			if(acompanhamento.equals("farofa")){
				preco = preco + 2.50;
				out.println(" Farofa;");
			}
			if(acompanhamento.equals("fritas")){
				preco = preco + 4.00;
				out.println(" Fritas.<br>");
			}
		}
		out.println("Convênio:");
		
		if(convenio.equals("placomp")){
			preco = preco - 12.00;
			out.println(" Placomp que paga 12.00 reais por dia para refeição;<br>");
			
		}
		if(convenio.equals("abutua")){
			preco = preco - 15.00;
			out.println(" Abutua que paga 15.00 reais por dia para refeição;<br>");
		}
		if(convenio.equals("google")){
			preco = preco - 17.00;
			out.println(" Google que paga 17.00 reais por dia para refeição;<br>");
		}
		if(convenio.equals("prefeitura")){
			preco = preco - 10.00;
			out.println(" Prefeitura que paga 10.00 reais por dia para refeição;<br>");
		}
		
		out.println("Observação: " + obser + "<br>");
		
		if(preco < 0){
			preco = 0;
		}
		out.println("Portanto o preco da refeição é: "+ preco);
		out.println("</body>");
		out.println("</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
