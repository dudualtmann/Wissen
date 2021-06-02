package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;

@WebServlet("/SvCheckout")
public class SvCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno a = (Aluno) request.getSession().getAttribute("objUser");
		
		if(a.findAluno(a.getEmail())){
			
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", a.errorMsg);
			request.getRequestDispatcher("jspHome.jsp").forward(request, response);
		}
		
		
	}

}
