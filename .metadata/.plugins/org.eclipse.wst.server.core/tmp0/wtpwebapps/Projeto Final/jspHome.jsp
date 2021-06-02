<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Home</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Inline+Display:wght@600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/home.css">
    <script src="https://kit.fontawesome.com/b1b1442df1.js" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%@page import = "control.Aluno, control.Carrinho, control.Curso, java.util.List" %>
    <% Aluno a = (Aluno) session.getAttribute("objUser");
    Carrinho c = a.getCarrinho();
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
        <% if(c.getListaCursosCarrinho() != null) { %>
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
            <li class="nav-li1"><% if(c.getListaCursosCarrinho() != null) { %>
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

    <main class="container-fluid">

        <div class="main-col">
        
        <% String msg = (String) request.getAttribute("msg");
                    if(msg != null && !msg.isEmpty()){ %>
                    	<div class="alert alert-success mt-4" role="alert">
  							<%= msg %>
						</div>
                    <%}
                    %>

            <div class="row-image">
                <img src="images/logowissen.png" alt="Wissen">
            </div>

            <div class="row-banner" style="margin-top: 5%;">
                <p class="banner-p">Cursos Mais Populares</p>
            </div>

            <!--Linha de Populares -->
            <div class="row-courses row-one" style="margin-top: 5%;">
                
    <div class="row mx-auto my-auto justify-content-center">
        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner w-100" role="listbox" style="margin-left: 5%;">
                <% Curso cs = new Curso();
                List<Curso> listaCursos = cs.popularesCursos();
            if(listaCursos != null){
            	for(int i = 0; i < listaCursos.size(); i++) { 
            		if(i == 0) { %>
            		<div class="carousel-item active">
            	<%} else { %>
            	<div class="carousel-item">
            	<% } %>
                    <div class="col-sm-4">
                        <div class="card" style="width: 16rem; height: 370px;">
                            <img class="card-img-top" src="images/<%= listaCursos.get(i).getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                            <div class="card-body">
                              <h5 class="card-title" style="font-size: 16px;"><%= listaCursos.get(i).getTitle() %></h5>
                              <p class="card-text" style="font-size: 12px;">Por: <%= listaCursos.get(i).getNameInstrutor() %></p>
                            <div class="rating">
                              <span class="star-text">4.0</span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star"></span>
                            </div>
                            <% if(listaCursos.get(i).getPrice() == 0.00) {%>
                            <p class="price">Gr�tis</p>
                            <% } else { %>
                              <p class="price">R$<%= listaCursos.get(i).getPrice() %></p>
                              <% } %>
                              <a href="#" class="buy-btn">Adicionar Carrinho</a>
                              <input type="hidden" class="id_curso" value="<%=listaCursos.get(i).getId()%>">
                            </div>
                          </div>
                    </div>
                </div>
                <% 
            	} 
            } %>
                
                
            </div>
            <a class="carousel-control-prev w-auto" href="#recipeCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next w-auto" href="#recipeCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
            </div>

            <!-- Banner Entre Rows de Cursos -->

            <div class="row-banner">
                <p class="banner-p">Os Melhores Cursos pelos Menores Pre�os!</p>
            </div>

            <!--Linha de Melhores Avaliados -->

            <div class="row-courses">
                <h2 class="font-weight-light" style="font-size: 25px; margin-left: 5%;">Melhores Avaliados</h2>
                <hr>
    <div class="row mx-auto my-auto justify-content-center">
        <div id="recipeCarousel2" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner w-100" role="listbox" style="margin-left: 5%;">
                <% 
            if(listaCursos != null){
            	for(int i = 0; i < listaCursos.size(); i++) { 
            		if(i == 0) { %>
            		<div class="carousel-item active">
            	<%} else { %>
            	<div class="carousel-item">
            	<% } %>
                    <div class="col-sm-4">
                        <div class="card" style="width: 16rem; height: 370px;">
                            <img class="card-img-top" src="images/<%= listaCursos.get(i).getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                            <div class="card-body">
                              <h5 class="card-title" style="font-size: 16px;"><%= listaCursos.get(i).getTitle() %></h5>
                              <p class="card-text" style="font-size: 12px;">Por: <%= listaCursos.get(i).getNameInstrutor() %></p>
                            <div class="rating">
                              <span class="star-text">4.0</span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star"></span>
                            </div>
                            <% if(listaCursos.get(i).getPrice() == 0.00) {%>
                            <p class="price">Gr�tis</p>
                            <% } else { %>
                              <p class="price">R$<%= listaCursos.get(i).getPrice() %></p>
                              <% } %>
                              <a href="#" class="buy-btn">Adicionar Carrinho</a>
                              <input type="hidden" class="id_curso" value="<%=listaCursos.get(i).getId()%>">
                            </div>
                          </div>
                    </div>
                </div>
                <% 
            	} 
            } %>
                
            </div>
            <a class="carousel-control-prev w-auto" href="#recipeCarousel2" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next w-auto" href="#recipeCarousel2" role="button" data-slide="next">
                <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
            </div>

            <!-- Cursos Gratuitos -->

            <div class="row-courses">
                <h2 class="font-weight-light" style="font-size: 25px; margin-left: 5%;">Cursos Gratuitos</h2>
                <hr>
    <div class="row mx-auto my-auto justify-content-center">
        <div id="recipeCarousel2" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner w-100" role="listbox" style="margin-left: 5%;">
                <% Curso cs2 = new Curso();
                List<Curso> listaCursos2 = cs2.cursosGratis();
            if(listaCursos2 != null){
            	for(int i = 0; i < listaCursos2.size(); i++) { 
            		if(i == 0) { %>
            		<div class="carousel-item active">
            	<%} else { %>
            	<div class="carousel-item">
            	<% } %>
                    <div class="col-sm-4">
                        <div class="card" style="width: 16rem; height: 370px;">
                            <img class="card-img-top" src="images/<%= listaCursos2.get(i).getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                            <div class="card-body">
                              <h5 class="card-title" style="font-size: 16px;"><%= listaCursos2.get(i).getTitle() %></h5>
                              <p class="card-text" style="font-size: 12px;">Por: <%= listaCursos2.get(i).getNameInstrutor() %></p>
                            <div class="rating">
                              <span class="star-text">4.0</span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star"></span>
                            </div>
                            <% if(listaCursos2.get(i).getPrice() == 0.00) {%>
                            <p class="price">Gr�tis</p>
                            <% } else { %>
                              <p class="price">R$<%= listaCursos2.get(i).getPrice() %></p>
                              <% } %>
                              <a href="#" class="buy-btn">Adicionar Carrinho</a>
                              <input type="hidden" class="id_curso" value="<%=listaCursos2.get(i).getId()%>">
                            </div>
                          </div>
                    </div>
                </div>
                <% 
            	} 
            } %>
                
            </div>
            <a class="carousel-control-prev w-auto" href="#recipeCarousel3" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next w-auto" href="#recipeCarousel3" role="button" data-slide="next">
                <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
            </div>

            <!-- Banner Entre Rows de Cursos -->

            <div class="row-banner">
                <p class="banner-p">Novos Cursos</p>
            </div>

             <!-- Linha de Novos Cursos -->

             <div class="row-courses">
             
             
                
    <div class="row mx-auto my-auto justify-content-center">
        <div id="recipeCarousel4" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner w-100" role="listbox" style="margin-left: 5%;">
                <% Curso cs3 = new Curso();
                List<Curso> listaCursos3 = cs.ultimosCursos();
            if(listaCursos3 != null){
            	for(int i = 0; i < listaCursos3.size(); i++) { 
            		if(i == 0) { %>
            		<div class="carousel-item active">
            	<%} else { %>
            	<div class="carousel-item">
            	<% } %>
                    <div class="col-sm-4">
                        <div class="card" style="width: 16rem; height: 370px;">
                            <img class="card-img-top" src="images/<%= listaCursos3.get(i).getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                            <div class="card-body">
                              <h5 class="card-title" style="font-size: 16px;"><%= listaCursos3.get(i).getTitle() %></h5>
                              <p class="card-text" style="font-size: 12px;">Por: <%= listaCursos3.get(i).getNameInstrutor() %></p>
                            <div class="rating">
                              <span class="star-text">4.0</span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star checked"></span>
                              <span class="fa fa-star"></span>
                            </div>
                            <% if(listaCursos3.get(i).getPrice() == 0.00) {%>
                            <p class="price">Gr�tis</p>
                            <% } else { %>
                              <p class="price">R$<%= listaCursos3.get(i).getPrice() %></p>
                              <% } %>
                              <a href="#" class="buy-btn">Adicionar Carrinho</a>
                              <input type="hidden" class="id_curso" value="<%=listaCursos3.get(i).getId()%>">
                            </div>
                          </div>
                    </div>
                </div>
                <% 
            	} 
            } %>
                
            </div>
            <a class="carousel-control-prev w-auto" href="#recipeCarousel4" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next w-auto" href="#recipeCarousel4" role="button" data-slide="next">
                <span class="carousel-control-next-icon bg-dark border border-dark rounded-circle" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    
            </div>

            <footer class="footer-wissen p-5">
        
                <div class="row align-items-center justify-content-center">
                    <img class="svg-cursos col-sm-2" src="images/wissen full.png" alt="">
                    
                    <div class="footer-slogan col-sm-4">
                        <h1>A Plataforma do<span class="txt-destaque2"> Conhecimento</span></h1>
                    </div>
        
                    <div class="col-sm-3 copyright pt-2 ">
                        <p>&copy; Desenvolvido por Altmann Softwares</p>
                    </div>
                        
                    </div>
            </footer>


        </div>

    </main>

    

    
      
    <!-- Optional JavaScript -->

    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/nav.js"></script>
    <script src="js/home.js"></script>
    <style>
        @media (max-width: 768px) {
    .carousel-inner .carousel-item > div {
        display: none;
    }
    .carousel-inner .carousel-item > div:first-child {
        display: block;
    }
}

.carousel-inner .carousel-item.active,
.carousel-inner .carousel-item-next,
.carousel-inner .carousel-item-prev {
    display: flex;
}

/* display 3 */
@media (min-width: 768px) {
    
    .carousel-inner .carousel-item-right.active,
    .carousel-inner .carousel-item-next {
      transform: translateX(33.333%);
    }
    
    .carousel-inner .carousel-item-left.active, 
    .carousel-inner .carousel-item-prev {
      transform: translateX(-33.333%);
    }
}

.carousel-inner .carousel-item-right,
.carousel-inner .carousel-item-left{ 
  transform: translateX(0);
}


    </style>

    <script>
        $('#recipeCarousel').carousel({
  interval: 10000
})

$('#recipeCarousel2').carousel({
        interval: 10000
      })

$('.carousel .carousel-item').each(function(){
    var minPerSlide = 3;
    var next = $(this).next();
    if (!next.length) {
    next = $(this).siblings(':first');
    }
    next.children(':first-child').clone().appendTo($(this));
    
    for (var i=0;i<minPerSlide;i++) {
        next=next.next();
        if (!next.length) {
        	next = $(this).siblings(':first');
      	}
        
        next.children(':first-child').clone().appendTo($(this));
      }
});

    </script>
  </body>
</html>