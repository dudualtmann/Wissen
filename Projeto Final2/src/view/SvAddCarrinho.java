package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;
import control.Carrinho;
import control.Curso;

/**
 * Servlet implementation class SvAddCarrinho
 */
@WebServlet("/SvAddCarrinho")
public class SvAddCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("idCurso");
		String text = "no";
		Aluno a = (Aluno) request.getSession().getAttribute("objUser");
		Curso cs = new Curso();
		if(!cs.find(id)) {
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("ISO-8859-1"); 
		    response.getWriter().write(cs.errorMsg);
		}
		
		if(a.getCarrinho() == null) {
			Carrinho c = new Carrinho();
			List<Curso> lista = new ArrayList<Curso>();
			c.setListaCursosCarrinho(lista);
			c.getListaCursosCarrinho().add(cs);
			a.setCarrinho(c);
			if(a.update()) {
				text = "ok";
			} else {
				text = a.errorMsg;
			}
			
		} else {
			a.getCarrinho().getListaCursosCarrinho().add(cs);
			
			if(a.update()) {
				text = "ok";
			} else {
				text = a.errorMsg;
			}
			
		}
		
		
		response.setContentType("text/plain");  
	    response.setCharacterEncoding("ISO-8859-1"); 
	    response.getWriter().write(text);
	}

}
