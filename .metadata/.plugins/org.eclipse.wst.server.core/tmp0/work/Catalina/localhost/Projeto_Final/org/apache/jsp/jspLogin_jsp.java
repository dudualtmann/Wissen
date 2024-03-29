/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.99
 * Generated at: 2020-11-21 12:14:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Wissen | Login</title>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"ISO-8859-1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/b1b1442df1.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/login.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Poppins:600&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("    \r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <header class=\"header-wissen\">\r\n");
      out.write("        <nav class=\"menu-topo-wissen row\">\r\n");
      out.write("        <div class=\"wis-menu col-sm-2\">\r\n");
      out.write("            <a class=\"logo-wissen-a\" href=\"index.html\" title=\"Wissen - A Plataforma do Conhecimento\">\r\n");
      out.write("                <img class=\"logo-wissen\" src=\"images/labelwissen.png\" alt=\"WISSEN\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"menu-itens col-sm-6\">\r\n");
      out.write("            <span class=\"nav-item\"><a href=\"index.html\">Home</a></span>\r\n");
      out.write("            <span class=\"nav-item\"><a href=\"cadastroinstrutor.html\">Virar Instrutor</a></span>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"login-box col-sm-4 pr-5\">\r\n");
      out.write("            <a class=\"btn-cadastrar\" href=\"login.html\" role=\"button\" >Cadastre-se</a>\r\n");
      out.write("            <a href=\"login.html\"><i class=\"fas fa-user link-login-wissen login-svg\" style=\"color: #1F4F66; font-size: 30px;\"></i></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <!-- Mobile -->\r\n");
      out.write("    <nav class=\"nav-mobile\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"wis-menu\">\r\n");
      out.write("            <a class=\"logo-wissen-a\" href=\"index.html\" title=\"Wissen - A Plataforma do Conhecimento\">\r\n");
      out.write("                <img class=\"logo-wissen\" src=\"images/labelwissen.png\" alt=\"WISSEN\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"burger\">\r\n");
      out.write("            <div class=\"line1\"></div>\r\n");
      out.write("            <div class=\"line2\"></div>\r\n");
      out.write("            <div class=\"line3\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav-links\">\r\n");
      out.write("            <li class=\"nav-li1\"><a href=\"index.html\">Home</a></li>\r\n");
      out.write("            <li><a href=\"cadastroinstrutor.html\">Virar Instrutor</a></li>\r\n");
      out.write("            <li><a class=\"btn-cadastrar\" href=\"login.html\" role=\"button\" >Cadastre-se</a></li>\r\n");
      out.write("            <li><a href=\"login.html\"><i class=\"fas fa-user link-login-wissen login-svg\" style=\"color: #1F4F66; font-size: 30px;\"></i></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <main class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("        <section class=\"row align-items-center justify-content-center\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"image col-md-6\">\r\n");
      out.write("            <span class=\"image-span\">\r\n");
      out.write("                <img src=\"images/undraw_researching_22gp.svg\" alt=\"\" class=\"door\">\r\n");
      out.write("            </span>\r\n");
      out.write("            <span class=\"image-span\">\r\n");
      out.write("                <img src=\"images/wissen full.png\" alt=\"\">\r\n");
      out.write("            </span>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"right col-md-6\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form\">\r\n");
      out.write("            <!--Login Form-->\r\n");
      out.write("            \r\n");
      out.write("            <form action=\"SvLogin\" method=\"post\" class=\"login-form\">\r\n");
      out.write("                <img src=\"images/undraw_profile_pic_ic5t (1).svg\" alt=\"\" class=\"avatar\">\r\n");
      out.write("                <h2>Bem-Vindo</h2>\r\n");
      out.write("                <div class=\"input-div one\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-envelope\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h5>Email</h5>\r\n");
      out.write("                        <input class=\"input email\" type=\"email\" name=\"username\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-div two\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-lock\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h5>Senha</h5>\r\n");
      out.write("                        <input class=\"input password\" type=\"password\" name=\"senha\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <a href=\"#\" class=\"a\">Esqueceu a Senha?</a>\r\n");
      out.write("                <p style=\"margin-top: 3%\">");
      out.print( request.getAttribute("msg") );
      out.write("</p>\r\n");
      out.write("                <input type=\"submit\" class=\"btn-wissen\" value=\"Login\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"options\">\r\n");
      out.write("                    <p>Sem Cadastro? <a href=\"#\" onclick=\"signup()\">Criar uma Conta</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("            <!--Sign up Form-->\r\n");
      out.write("            <form action=\"SvCadastroAluno\" method=\"post\" class=\"signup-form\">\r\n");
      out.write("                <img src=\"images/undraw_profile_pic_ic5t (1).svg\" alt=\"\" class=\"avatar\">\r\n");
      out.write("                <h2>Cadastro</h2>\r\n");
      out.write("                <div class=\"input-div one\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-user\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h5>Nome e Sobrenome</h5>\r\n");
      out.write("                        <input class=\"input name\" type=\"text\" name=\"username\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-div one\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-envelope\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h5>Email</h5>\r\n");
      out.write("                        <input class=\"input validate-email\" type=\"email\" name=\"email\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"input-div two\">\r\n");
      out.write("                    <div class=\"i\">\r\n");
      out.write("                        <i class=\"fas fa-lock\"></i>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <h5>Senha</h5>\r\n");
      out.write("                        <input class=\"input password\" type=\"password\" name=\"senha\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"submit\" class=\"btn-wissen\" value=\"Cadastrar\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"options\">\r\n");
      out.write("                    <p>Já tem Conta? <a href=\"#\" onclick=\"login()\">Fazer Login</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("    <!-- Optional JavaScript -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"js/login.js\"></script>\r\n");
      out.write("    <script src=\"js/nav.js\"></script>\r\n");
      out.write(" \r\n");
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
