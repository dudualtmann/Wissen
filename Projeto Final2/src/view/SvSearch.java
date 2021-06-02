package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Curso;

/**
 * Servlet implementation class SvSearch
 */
@WebServlet("/SvSearch")
public class SvSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("search");
		Curso c = new Curso();
		
		List<Curso> lista = c.searchCursos(nome);
		if(lista==null)
			request.setAttribute("errorMsg", c.errorMsg);
		request.setAttribute("listaCursos", lista);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
	}

}
