<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Search</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Inline+Display:wght@600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b1b1442df1.js" crossorigin="anonymous"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/mycourses.css">
    <%@page import="control.Aluno, java.util.List, control.Curso, control.Carrinho" %>
    <%Aluno a = (Aluno) session.getAttribute("objUser"); %>
    <%
    Carrinho car = a.getCarrinho();
    %>
  </head>
  <body>

    <header class="header-wissen">
    <form class="header-wissen" method="post">
        <nav class="menu-topo-wissen row">
        <div class="wis-menu col-sm-2">
            <a class="logo-wissen-a" href="jspHome.jsp" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a>
        </div>
	
        <nav class="menu-itens col-sm-6">
        	
            <span class="span-search">
                <input type="text" placeholder="Pesquisar por um curso" name="search">
                <button type="submit" formaction="SvSearch"><i class="fa fa-search"></i></button>
            </span>
            
        </nav>
	
        <div class="login-box col-sm-4 pr-5">
        <% if(car.getListaCursosCarrinho() != null) { %>
        <a class="btn-cart" href="SvCheckout" role="button" ><i class="fas fa-shopping-cart"></i></a><span class="cart-number"><%=a.getCarrinho().getListaCursosCarrinho().size() %></span>
        <% } else { %>
            <a class="btn-cart" href="SvCheckout" role="button" ><i class="fas fa-shopping-cart"></i></a><span class="cart-number"></span>
            <% } %>
            <a class="btn-heart" href="SvLogout" role="button" ><i class="fas fa-sign-out-alt"></i></a>
            <a class="btn-cursos" href="meuscursos.jsp" role="button" >Meus Cursos</a>
            <a href="profile.jsp"><i class="fas fa-user link-login-wissen login-svg" ></i></a>
            
        </div>
    </nav>
    <!-- Mobile -->
    <nav class="nav-mobile">

        
        <span class="span-search">
            <input type="text" placeholder="Pesquisar por um curso">
            <button type="submit"><i class="fa fa-search"></i></button>
        </span>
            
        

        <div class="burger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>

        <ul class="nav-links">
            <li class="nav-li1"><% if(car.getListaCursosCarrinho() != null) { %>
        <a class="btn-cart" href="SvCheckout" role="button" ><i class="fas fa-shopping-cart"></i></a><span class="cart-number"><%=a.getCarrinho().getListaCursosCarrinho().size() %></span>
        <% } else { %>
            <a class="btn-cart" href="SvCheckout" role="button" ><i class="fas fa-shopping-cart"></i></a><span class="cart-number"></span>
            <% } %></li>
            <li><a href="profile.jsp"><i class="fas fa-user link-login-wissen login-svg"></i></a></li>
            <li ><a class="btn-cursos" href="meuscursos.jsp" role="button" >Meus Cursos</a></li>
            <li ><a class="btn-heart" href="SvLogout" role="button" ><i class="fas fa-sign-out-alt"></i></a></li>
            
            <li><a class="logo-wissen-a" href="jspHome.jsp" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a></li>
        </ul>
    </nav>
    </form>
    </header>
    <!--End of Header -->

    <main class="container-fluid">
        <section class="main-section">
            <h2 class="h2-title">Resultados</h2>
            
            <input type="hidden" id="id-curso" name="id-curso" value="">
            <div class="courses-row">
                <% List<Curso> lista = (List<Curso>) request.getAttribute("listaCursos");
                if(lista == null){
                	String errorMsg = (String) request.getAttribute("errorMsg");
                    if(errorMsg != null && !errorMsg.isEmpty()){ %>
                    	<div class="alert alert-danger mt-4" role="alert">
  							<%= errorMsg %>
						</div>
                    <%
                    }
                    
                } else {
                for(int i = 0; i < lista.size(); i++) { %>
                <div class="flex-div">
                <div class="card" style="width: 16rem; height: 370px;">
                    <img class="card-img-top" src="images/<%= lista.get(i).getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                    <div class="card-body">
                      <h5 class="card-title" style="font-size: 16px;"><%= lista.get(i).getTitle() %></h5>
                      <p class="card-text" style="font-size: 12px;">Por: <%= lista.get(i).getNameInstrutor() %></p>
                      <button href="#" class="buy-btn">Adicionar Carrinho</button>
                      <input type="hidden" class="id_curso" value="<%=lista.get(i).getId()%>">
                    </div>
                  </div>
                </div>
                <% } } %>
                  
                
            </div>
        
        </section>
    </main>
      
    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- Meus JS -->
    <script src="js/nav.js"></script>
    <script src="js/home.js"></script>
  </body>
</html>