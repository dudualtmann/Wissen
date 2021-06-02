package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;
import control.Instrutor;

/**
 * Servlet implementation class SvLogin
 */
@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username");
		String senha = request.getParameter("senha");

		Aluno a = new Aluno();

		if (a.login(email, senha)) {
			request.getSession().setAttribute("objUser", a);
			request.getRequestDispatcher("jspHome.jsp").forward(request, response);
		} else {
			Instrutor i = new Instrutor();
			if (i.login(email, senha)) {
				request.getSession().setAttribute("objUser", i);
				request.getRequestDispatcher("jspHomeInstrutor.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", a.errorMsg);
				request.getRequestDispatcher("jspLogin.jsp").forward(request, response);
			}
		}
	}

}
