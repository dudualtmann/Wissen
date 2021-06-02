package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Curso;

/**
 * Servlet implementation class SvAbrirCurso
 */
@WebServlet("/SvAbrirCurso")
public class SvAbrirCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id-curso");
		
		Curso c = new Curso();
		if(c.find(id)) {
			// Abrir P�gina de ver Curso
			request.getSession().setAttribute("objCurso", c);
			request.getRequestDispatcher("aulas.jsp").forward(request, response);
		} else {
			// Erro ao abrir o Curso
			request.setAttribute("errorMsg", c.errorMsg);
			request.getRequestDispatcher("meuscursos.jsp").forward(request, response);
		}
	}

}
