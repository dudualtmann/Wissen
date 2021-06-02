package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Curso;
import control.Modulo;

/**
 * Servlet implementation class SvCriarModulo
 */
@WebServlet("/SvCriarModulo")
public class SvCriarModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("nome-modulo");
		String idCurso = request.getParameter("id_curso");
		
		Curso c = new Curso();
		
		if(c.find(idCurso)) {
			Modulo m = new Modulo(title,c);
			if(m.cadastrar()) {
				// Cadastro efetuado com sucesso
				request.setAttribute("msg", "Módulo criado com sucesso!");
				request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
			} else {
				// Erro ao cadastrar Módulo
				request.setAttribute("errorMsg", m.errorMsg);
				request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
			}
		} else {
			// Erro ao localizar Curso
			request.setAttribute("errorMsg", c.errorMsg);
			request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
		}
		
		
	}

}
