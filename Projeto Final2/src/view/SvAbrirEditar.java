package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Curso;

/**
 * Servlet implementation class SvAbrirEditar
 */
@WebServlet("/SvAbrirEditar")
public class SvAbrirEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCurso = request.getParameter("id-curso");
		
		Curso c = new Curso();
		
		if(c.find(idCurso)) {
			request.getSession().setAttribute("objCurso", c);
			request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", c.errorMsg);
			request.getSession().setAttribute("objCurso", null);
			request.getRequestDispatcher("homeinstrutor.jsp").forward(request, response);
		}
	}

}
