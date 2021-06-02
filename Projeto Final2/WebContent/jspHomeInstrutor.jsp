<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Home Instrutor</title>
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
    <%@page import = "control.Curso, control.Instrutor, java.util.List" %>
    <% Instrutor instrutor = (Instrutor) session.getAttribute("objUser");
    %>
  </head>
  <body>

    <header class="header-wissen">
        <nav class="menu-topo-wissen row">
        <div class="wis-menu col-sm-2">
            <a class="logo-wissen-a" href="jspHomeInstrutor.jsp" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a>
        </div>

        <nav class="menu-itens col-sm-6">
            <span class="nav-item"><a href="#novo-curso">Criar Curso</a></span>
            <span class="nav-item"><a href="#gerenciar-curso">Gerenciar Cursos</a></span>
        </nav>

        <div class="login-box col-sm-4 pr-5">
            <a class="btn-heart" href="SvLogout" role="button" ><i class="fas fa-sign-out-alt"></i></a>
            <a href="#"><i class="fas fa-user link-login-wissen login-svg" ></i></a>
        </div>
    </nav>
    <!-- Mobile -->
    <nav class="nav-mobile">

        
        <span class="wis-menu">
            <a class="logo-wissen-a" href="home.html" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a>
        </span>
            
        

        <div class="burger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>

        <ul class="nav-links">
            <li class="nav-li1"><a href="#novo-curso">Criar Curso</a></li>
            <li ><a href="#gerenciar-curso">Gerenciar Cursos</a></li>
            <li ><a class="btn-heart" href="SvLogout" role="button" ><i class="fas fa-sign-out-alt"></i> Logout</a></li>
            <li><a href="#"><i class="fas fa-user link-login-wissen login-svg"></i> Perfil</a></li>
            <li><a class="logo-wissen-a" href="home.html" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a></li>
        </ul>
    </nav>
    </header>

    <main class="container-fluid">

        <div class="main-col">

            <div class="row-image">
                <img src="images/logowissen.png" alt="Wissen">
            </div>
            <% String msg = (String) request.getAttribute("msg");
                    if(msg != null && !msg.isEmpty()){ %>
                    	<div class="alert alert-success mt-4" role="alert">
  							<%= msg %>
						</div>
                    <%}
                    %>
                    
                    <% String errorMsg = (String) request.getAttribute("errorMsg");
                    if(errorMsg != null && !errorMsg.isEmpty()){ %>
                    	<div class="alert alert-danger mt-4" role="alert">
  							<%= errorMsg %>
						</div>
                    <%}
                    %>

            <div class="row-banner" style="margin-top: 5%;" id="novo-curso">
                <p class="banner-p">Criar Novo Curso</p>
            </div>

            <!--Linha de Criar Cursos -->
            <div class="row-create row-one">
                <form action="SvCadastroCurso" method="POST" class="form-curso">
                    <div class="form-group">
                      <label for="">Nome do Curso</label>
                      <input type="text" name="nome-curso" id="" class="form-control" placeholder="" aria-describedby="helpId">
                      <small id="helpId" class="text-muted">Tenha certeza de que o título seja chamativo. (25-50 caracteres)</small>
                    </div>

                    <div class="form-row">

                        <div class="form-group col-md-6">
                          <label for="">Nome Aparente do Instrutor</label>
                          <input type="text" name="instrutor-curso" id="" class="form-control" placeholder="" aria-describedby="helpId">
                          <small id="helpId" class="text-muted">Nome do instrutor que será visível no curso (Ex: Bruno Correa)</small>
                        </div>

                        <div class="form-group col-md-6">
                          <label for="">Preço (Em Reais)</label>
                          <input type="number" name="preco-curso" id="" class="form-control" placeholder="" aria-describedby="helpId">
                          <small id="helpId" class="text-muted">Obs: Divisão - 70% do Instrutor e 30% da Plataforma | Para curso gratuito colocar 0.00</small>
                        </div>

                    </div>

                    <div class="form-row">

                        <div class="form-group col-md-6">
                          <label for="">Descrição do Curso</label>
                          <textarea class="form-control" name="descricao-curso" id="" rows="3"></textarea>
                          <small id="helpId" class="text-muted">Breve descrição que irá aparecer como subtítulo na página do curso</small>
                        </div>

                        <div class="form-group col-md-6">
                          <label for="">Requisitos</label>
                          <textarea class="form-control" name="requisitos-curso" id="" rows="3"></textarea>
                          <small id="helpId" class="text-muted">Requisitos ou conhecimentos prévios necessários para fazer o curso </small>
                        </div>

                    </div>

                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label for="">Idioma do Curso</label>
                            <input type="text" name="idioma-curso" id="" class="form-control" placeholder="" aria-describedby="helpId">
                        </div>

                        <div class="form-group col-md-6">
                            <label for="">Para Quem é Este Curso</label>
                            <textarea class="form-control" name="publico-curso" id="" rows="1"></textarea>
                            <small id="helpId" class="text-muted">Público para o qual seu curso é destinado </small>
                        </div>

                    </div>

                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label>Foto de Capa</label>
                          <div class="custom-file">
                              <input type="file" class="custom-file-input foto-capa" name="foto-curso" id="customFile">
                              <label class="custom-file-label">Escolher Arquivo</label>
                              <small id="helpId" class="text-muted">Escolha uma foto que atraia público para o curso</small>
                          </div>
                        </div>

                        <div class="form-group col-md-6">
                          <label for="">Gênero</label>
                          <select class="form-control" name="genero-curso" id="">
                            <option>Programação</option>
                            <option>Tecnologia</option>
                            <option>Marketing</option>
                            <option>Música</option>
                            <option>Esporte</option>
                            <option>Jogos</option>
                            <option>Economia</option>
                            <option>Design</option>
                          </select>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-12">
                          <button type="submit" class="create-btn"  >Criar Curso</button>
                        </div>
                        
                    </div>
                </form>
    
            </div>

            <!-- Banner Entre Rows de Cursos -->

            <div class="row-banner" id="gerenciar-curso">
                <p class="banner-p">Gerenciar Cursos</p>
            </div>

            <!-- Linha de Meus Cursos -->

            <div class="row-courses">
                <h2 class="font-weight-light" style="font-size: 25px; margin-left: 5%;">Meus Cursos</h2>
                <hr>
                
                <form method = "post" action= "SvAbrirEditar" id="form-cursos">
                <input type="hidden" name="id-curso" id="id-curso" value="">
                
    <div class="row mx-auto my-auto justify-content-center">
        <div id="recipeCarousel" class="carousel slide w-100" data-ride="carousel">
            <div class="carousel-inner w-100" role="listbox" style="margin-left: 5%;">
            <% List<Curso> listaCursos = instrutor.getListaCursos();
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
                              <p class="price">R$<%= listaCursos.get(i).getPrice() %></p>
                              <a href="#" class="buy-btn">Editar</a>
                              <input type="hidden" class="id_curso" value="<%= listaCursos.get(i).getId()%>">
                            </div>
                          </div>
                    </div>
                </div>
            	<% 
            	} 
            } else { %>
            	<div class="carousel-item active">
                    <div class="col-sm-4">
                        <div class="card" style="width: 16rem; height: 370px;">
                            <div class="card-body">
                              <h5 class="card-title" style="font-size: 16px;">Você ainda não tem Cursos</h5>
                              <p class="card-text" style="font-size: 12px;">Crie um curso e volte aqui para editá-lo!</p>
                            </div>
                          </div>
                    </div>
                </div>
           <% }%>
                
                
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
    
    </form>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/nav.js"></script>
    <script src="js/homeinstrutor.js"></script>
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