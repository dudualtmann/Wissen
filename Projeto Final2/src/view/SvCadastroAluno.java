package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;

/**
 * Servlet implementation class SvCadastroAluno
 */
@WebServlet("/SvCadastroAluno")
public class SvCadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		
		Aluno a = new Aluno(nome, senha, email);
		
		if(a.cadastrar()) {
			request.setAttribute("msg", "Cadastro Realizado com Sucesso!");
			request.getRequestDispatcher("jspLogin.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", a.errorMsg);
			request.getRequestDispatcher("jspLogin.jsp").forward(request, response);
		}
		
	}

}
