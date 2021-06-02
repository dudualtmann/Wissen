package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;

/**
 * Servlet implementation class SvCheckEmail
 */
@WebServlet("/SvCheckEmail")
public class SvCheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String text = "invalid";
		
		Aluno a = new Aluno();
		
		if(a.findAluno(email)) {
			
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("ISO-8859-1"); 
		    response.getWriter().write(text);
		}else {
			text = "valid";
			response.setContentType("text/plain");  
			response.setCharacterEncoding("ISO-8859-1"); 
			response.getWriter().write(text);
		}
		
		
	}

}
