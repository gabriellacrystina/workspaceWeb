/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2015-09-21 13:03:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Modelo.Vendedor;

public final class ManutencaoVendedor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t<title>Manutencao de Vendedor</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t\t<h1>Manutenção de Vendedor</h1>\r\n");
      out.write("\t\t");

			//Pesquisa : objeto da pesquisa ou string de erro. 
			Vendedor pesquisar = (Vendedor) session.getAttribute("vendedor");
			String erro = (String) session.getAttribute("erro");	
			
			if(erro != null){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<br><br><div>");
      out.print(erro );
      out.write("</div><br><br>\r\n");
      out.write("\t\t\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t<form action=\"ManutencaoVendedor\" method=\"post\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tCodigo: <input type=\"text\" name=\"codigo\" value=\"");
      out.print((pesquisar != null)? pesquisar.getCodigo(): "");
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\tNome: <input type=\"text\" name=\"nome\" value=\"");
      out.print((pesquisar != null)? pesquisar.getNome(): "");
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"btnSubmit\" value=\"salvar\">\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"btnSubmit\" value=\"pesquisar\">\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"btnSubmit\" value=\"alterar\">\r\n");
      out.write("\t\t\t<input type=\"submit\" name=\"btnSubmit\" value=\"excluir\"><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--Fim o formulario-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

			ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) session.getAttribute("listaVendedor");
		
			if(listaVendedor != null && listaVendedor.size() > 0){
			
      out.write("\t<!--Definindo a tabela que apresenta o resultado-->\r\n");
      out.write("\t\t\t\t<table border=\"1\" style=\"width:20%\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>CODIGO</th>\r\n");
      out.write("\t\t\t\t\t\t<th>NOME DO VENDEDOR</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t");

				for(Vendedor vendedor : listaVendedor){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><center>");
      out.print(vendedor.getCodigo() );
      out.write("</center></td>\r\n");
      out.write("\t\t\t\t\t\t<td><center>");
      out.print(vendedor.getNome() );
      out.write("</center></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
	
				}	
			}
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t<br><br><a href=\"Menu.jsp\">VOLTAR</a><br>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
