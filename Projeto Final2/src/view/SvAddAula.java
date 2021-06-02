package view;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aula;
import control.Curso;
import control.Modulo;

/**
 * Servlet implementation class SvAddAula
 */
@WebServlet("/SvAddAula")
public class SvAddAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idModulo = request.getParameter("modulo-aula");
		String nomeAula = request.getParameter("nome-aula");
		File videoAula = new File(request.getParameter("video-aula"));
		File materialAula = new File(request.getParameter("material-aula"));
		String idCurso = request.getParameter("id_curso");
		
		Curso c = new Curso();
		
		if(c.find(idCurso)) {
			// Curso Localizado com Sucesso
			
			Modulo m = new Modulo();
			if(m.findModulo(idModulo)) {
				// Modulo Localizado com Sucesso
				
				Aula a = new Aula(m, videoAula, nomeAula, materialAula);
				if(a.cadastrar()) {
					// Aula Cadastrada com sucesso
					request.setAttribute("msg", "Aula Cadastrada com Sucesso!");
					request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
				} else {
					// Erro ao Cadastrar Aula
					request.setAttribute("msg", a.errorMsg);
					request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
				}
			} else {
				// Erro ao localizar Módulo
				request.setAttribute("msg", m.errorMsg);
				request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
			}
			
		} else {
			// Erro ao localizar o curso
			request.setAttribute("msg", c.errorMsg);
			request.getRequestDispatcher("editarcurso.jsp").forward(request, response);
		}
		
	}

}
