package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Instrutor;

/**
 * Servlet implementation class SvCadastroInstrutor
 */
@WebServlet("/SvCadastroInstrutor")
public class SvCadastroInstrutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("username");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		
		Instrutor i = new Instrutor(nome, cpf, email, senha);
		
		if(i.cadastrar()) {
			request.setAttribute("msg", "Cadastro Realizado com Sucesso!");
			request.getRequestDispatcher("jspLogin.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", i.errorMsg);
			request.getRequestDispatcher("jspLogin.jsp").forward(request, response);
		}
	}

}
