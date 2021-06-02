/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.99
 * Generated at: 2021-01-30 06:17:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.Aluno;
import java.util.List;
import control.Curso;
import control.Carrinho;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
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
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>Wissen | Meus Cursos</title>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"ISO-8859-1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Big+Shoulders+Inline+Display:wght@600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/b1b1442df1.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <!-- CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/mycourses.css\">\r\n");
      out.write("    \r\n");
      out.write("    ");
Aluno a = (Aluno) session.getAttribute("objUser"); 
      out.write("\r\n");
      out.write("    ");

    Carrinho car = a.getCarrinho();
    
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <header class=\"header-wissen\">\r\n");
      out.write("    <form class=\"header-wissen\" method=\"post\">\r\n");
      out.write("        <nav class=\"menu-topo-wissen row\">\r\n");
      out.write("        <div class=\"wis-menu col-sm-2\">\r\n");
      out.write("            <a class=\"logo-wissen-a\" href=\"jspHome.jsp\" title=\"Wissen - A Plataforma do Conhecimento\">\r\n");
      out.write("                <img class=\"logo-wissen\" src=\"images/labelwissen.png\" alt=\"WISSEN\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\r\n");
      out.write("        <nav class=\"menu-itens col-sm-6\">\r\n");
      out.write("        \t\r\n");
      out.write("            <span class=\"span-search\">\r\n");
      out.write("                <input type=\"text\" placeholder=\"Pesquisar por um curso\" name=\"search\">\r\n");
      out.write("                <button type=\"submit\" formaction=\"SvSearch\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("            </span>\r\n");
      out.write("            \r\n");
      out.write("        </nav>\r\n");
      out.write("\t\r\n");
      out.write("        <div class=\"login-box col-sm-4 pr-5\">\r\n");
      out.write("        ");
 if(car.getListaCursosCarrinho() != null) { 
      out.write("\r\n");
      out.write("        <a class=\"btn-cart\" href=\"SvCheckout\" role=\"button\" ><i class=\"fas fa-shopping-cart\"></i></a><span class=\"cart-number\">");
      out.print(a.getCarrinho().getListaCursosCarrinho().size() );
      out.write("</span>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            <a class=\"btn-cart\" href=\"SvCheckout\" role=\"button\" ><i class=\"fas fa-shopping-cart\"></i></a><span class=\"cart-number\"></span>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            <a class=\"btn-heart\" href=\"SvLogout\" role=\"button\" ><i class=\"fas fa-sign-out-alt\"></i></a>\r\n");
      out.write("            <a class=\"btn-cursos\" href=\"meuscursos.jsp\" role=\"button\" >Meus Cursos</a>\r\n");
      out.write("            <a href=\"profile.jsp\"><i class=\"fas fa-user link-login-wissen login-svg\" ></i></a>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <!-- Mobile -->\r\n");
      out.write("    <nav class=\"nav-mobile\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <span class=\"span-search\">\r\n");
      out.write("            <input type=\"text\" placeholder=\"Pesquisar por um curso\">\r\n");
      out.write("            <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("        </span>\r\n");
      out.write("            \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <div class=\"burger\">\r\n");
      out.write("            <div class=\"line1\"></div>\r\n");
      out.write("            <div class=\"line2\"></div>\r\n");
      out.write("            <div class=\"line3\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav-links\">\r\n");
      out.write("            <li class=\"nav-li1\">");
 if(car.getListaCursosCarrinho() != null) { 
      out.write("\r\n");
      out.write("        <a class=\"btn-cart\" href=\"SvCheckout\" role=\"button\" ><i class=\"fas fa-shopping-cart\"></i></a><span class=\"cart-number\">");
      out.print(a.getCarrinho().getListaCursosCarrinho().size() );
      out.write("</span>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            <a class=\"btn-cart\" href=\"SvCheckout\" role=\"button\" ><i class=\"fas fa-shopping-cart\"></i></a><span class=\"cart-number\"></span>\r\n");
      out.write("            ");
 } 
      out.write("</li>\r\n");
      out.write("            <li><a href=\"profile.jsp\"><i class=\"fas fa-user link-login-wissen login-svg\"></i></a></li>\r\n");
      out.write("            <li ><a class=\"btn-cursos\" href=\"meuscursos.jsp\" role=\"button\" >Meus Cursos</a></li>\r\n");
      out.write("            <li ><a class=\"btn-heart\" href=\"SvLogout\" role=\"button\" ><i class=\"fas fa-sign-out-alt\"></i></a></li>\r\n");
      out.write("            \r\n");
      out.write("            <li><a class=\"logo-wissen-a\" href=\"jspHome.jsp\" title=\"Wissen - A Plataforma do Conhecimento\">\r\n");
      out.write("                <img class=\"logo-wissen\" src=\"images/labelwissen.png\" alt=\"WISSEN\">\r\n");
      out.write("            </a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("    </form>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!--End of Header -->\r\n");
      out.write("\r\n");
      out.write("    <main class=\"container-fluid\">\r\n");
      out.write("        <section class=\"main-section\">\r\n");
      out.write("            <h2 class=\"h2-title\">Resultados</h2>\r\n");
      out.write("            \r\n");
      out.write("            <input type=\"hidden\" id=\"id-curso\" name=\"id-curso\" value=\"\">\r\n");
      out.write("            <div class=\"courses-row\">\r\n");
      out.write("                ");
 List<Curso> lista = (List<Curso>) request.getAttribute("listaCursos");
                if(lista == null){
                	String errorMsg = (String) request.getAttribute("errorMsg");
                    if(errorMsg != null && !errorMsg.isEmpty()){ 
      out.write("\r\n");
      out.write("                    \t<div class=\"alert alert-danger mt-4\" role=\"alert\">\r\n");
      out.write("  \t\t\t\t\t\t\t");
      out.print( errorMsg );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("                    ");

                    }
                    
                } else {
                for(int i = 0; i < lista.size(); i++) { 
      out.write("\r\n");
      out.write("                <div class=\"flex-div\">\r\n");
      out.write("                <div class=\"card\" style=\"width: 16rem; height: 370px;\">\r\n");
      out.write("                    <img class=\"card-img-top\" src=\"images/");
      out.print( lista.get(i).getPhoto() );
      out.write("\" alt=\"Imagem de capa do card\" style=\"height: 150px;\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                      <h5 class=\"card-title\" style=\"font-size: 16px;\">");
      out.print( lista.get(i).getTitle() );
      out.write("</h5>\r\n");
      out.write("                      <p class=\"card-text\" style=\"font-size: 12px;\">Por: ");
      out.print( lista.get(i).getNameInstrutor() );
      out.write("</p>\r\n");
      out.write("                      <button href=\"#\" class=\"buy-btn\">Adicionar Carrinho</button>\r\n");
      out.write("                      <input type=\"hidden\" class=\"id_curso\" value=\"");
      out.print(lista.get(i).getId());
      out.write("\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
 } } 
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("        </section>\r\n");
      out.write("    </main>\r\n");
      out.write("      \r\n");
      out.write("    <!-- Optional JavaScript -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\">\r\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <!-- Meus JS -->\r\n");
      out.write("    <script src=\"js/nav.js\"></script>\r\n");
      out.write("    <script src=\"js/home.js\"></script>\r\n");
      out.write("  </body>\r\n");
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
