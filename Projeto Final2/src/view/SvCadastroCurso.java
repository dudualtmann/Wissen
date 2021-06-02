package view;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Curso;
import control.Instrutor;

/**
 * Servlet implementation class SvCadastroCurso
 */
@WebServlet("/SvCadastroCurso")
public class SvCadastroCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("nome-curso");
		String nameInstrutor = request.getParameter("instrutor-curso");
		String price = request.getParameter("preco-curso");
		String description = request.getParameter("descricao-curso");
		String requirements = request.getParameter("requisitos-curso");
		String language = request.getParameter("idioma-curso");
		String targetAudience = request.getParameter("publico-curso");
		String genre = request.getParameter("genero-curso");
		File photo = new File(request.getParameter("foto-curso"));
		Instrutor instrutor = (Instrutor) request.getSession().getAttribute("objUser");
		
		Curso c = new Curso(title, nameInstrutor, price, description, requirements, language, targetAudience, genre, photo, instrutor);
		
		if(c.cadastrar()) {
			request.setAttribute("msg", "Curso criado com sucesso!");
			request.getRequestDispatcher("jspHomeInstrutor.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", c.errorMsg);
			request.getRequestDispatcher("jspHomeInstrutor.jsp").forward(request, response);
		}
	}

}
