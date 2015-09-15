package PrAula17082015;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculadorateste
 */
@WebServlet("/Calculadorateste")
public class Calculadorateste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculadorateste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		double operador1 = Double.parseDouble(request.getParameter("operador1"));
		double operador2 = Double.parseDouble(request.getParameter("operador2"));
		String op = request.getParameter("operador");
		
		double resultado = 0;
		
		if(op.equals("+")){
			resultado = operador1 + operador2;
		}
		
		if(op.equals("-")){
			resultado = operador1 - operador2;
		}
		
		if(op.equals("*")){
			resultado = operador1 * operador2;
		}
		
		if(op.equals("/")){	
			resultado = operador1 / operador2;
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>CALCULADORA SIMPLES</h2>");
		out.println("Resultado: " + resultado);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
