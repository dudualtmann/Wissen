package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Aluno;
import control.Carrinho;
import control.Curso;
import control.Pedido;

/**
 * Servlet implementation class SvCadastroPedido
 */
@WebServlet("/SvCadastroPedido")
public class SvCadastroPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = (Aluno) request.getSession().getAttribute("objUser");
		if(!aluno.findAluno(aluno.getEmail())) {
			request.setAttribute("msg", "Erro ao localizar a conta");
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}
		// fazer um find aluno
		String price = request.getParameter("total-price");
		String metodoPagamento = request.getParameter("payment-method");
		List<Curso> listaCursos = aluno.getCarrinho().getListaCursosCarrinho();
		
		if(listaCursos != null) {
			System.out.println("entrou");
			Pedido p = new Pedido(price, metodoPagamento, aluno, listaCursos);
			if(p.cadastrar()) {
				
				
					Carrinho c = new Carrinho();
					aluno.setCarrinho(c);
					
					if(!aluno.update()) {
						request.setAttribute("msg-error", "Carrinho não atualizado.");
					}
				
					
				
				request.setAttribute("msg", "Pedido Realizado com Sucesso!");
				request.getRequestDispatcher("jspHome.jsp").forward(request, response);
			}
			
			else {
				System.out.println("deu erro: "+p.errorMsg);
				request.setAttribute("msg", p.errorMsg);
				request.getRequestDispatcher("checkout.jsp").forward(request, response);
			}
		}
		
		
		
	}

}
