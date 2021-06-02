package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvAjax
 */
@WebServlet("/SvAjax")
public class SvAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String text1 = "teste";
		 
		 String nome = request.getParameter("nome");
		 
		 String text = nome+text1;
		 
		 

		    response.setContentType("text/plain");  
		    response.setCharacterEncoding("ISO-8859-1"); 
		    response.getWriter().write(text);       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
