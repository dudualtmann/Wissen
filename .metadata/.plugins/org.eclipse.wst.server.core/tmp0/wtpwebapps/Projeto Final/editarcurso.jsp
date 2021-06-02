<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Curso</title>
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
    <link rel="stylesheet" href="css/course.css">
    <%@page import = "control.Curso, control.Modulo, java.util.List" %>
    <%Curso c = (Curso) session.getAttribute("objCurso"); 
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
        <div class="main-div row">
            <div class="left-space col-md-6">
                <div class="card" style="width: 16rem; height: 370px;">
                    <img class="card-img-top" src="images/<%= c.getPhoto() %>" alt="Imagem de capa do card" style="height: 150px;">
                    <div class="card-body">
                      <h5 class="card-title" style="font-size: 16px;"><%= c.getTitle() %></h5>
                      <p class="card-text" style="font-size: 12px;">Por: <%= c.getNameInstrutor() %></p>
                    <div class="rating">
                      <span class="star-text"></span>
                      <span class="fa fa-star checked"></span>
                      <span class="fa fa-star checked"></span>
                      <span class="fa fa-star checked"></span>
                      <span class="fa fa-star checked"></span>
                      <span class="fa fa-star"></span>
                    </div>
                      <p class="price">R$<%=c.getPrice() %></p>
                      <a href="#" class="buy-btn">Ver Curso</a>
                    </div>
                  </div>
            </div>
            <div class="right-space col-md-6">
                <form method="POST">
                    <input type="hidden" name="id_curso" value="<%=c.getId()%>">
                    <div class="btns">
                        <button type="button" class="btn btn-outline-primary" onclick="modulo()">Criar Módulo</button>
                        <button type="button" class="btn btn-outline-secondary btn-form" onclick="aula()">Adiconar Aula</button>
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

                    <div class="form-modulo">
                        <h3>Criar Módulo</h3>
                        <div class="form-group">
                          <label for="">Título do Módulo</label>
                          <input type="text" name="nome-modulo" class="form-control" placeholder="" aria-describedby="helpId">
                          <small id="helpId" class="text-muted">O Título deve ser objetivo</small>
                        </div>

                        <button formaction="SvCriarModulo" type="submit" class="btn btn-primary">Adicionar Módulo</button>
                    </div>

                    <div class="form-aula">
                        <h3>Adiconar Aula</h3>

                        <div class="form-group">
                        <%Modulo m = new Modulo();
                   		List<Modulo> list = m.searchModulos(c);
                        if(list != null) { %>
                          <label for="">Módulo da Aula</label>
                          <select class="form-control" name="modulo-aula">
                          <% 
                          for(int i = 0; i < list.size(); i++) { 
                          
                          %>
                            <option value="<%=list.get(i).getId()%>">Módulo <%= i + 1 %>: <%= list.get(i).getTitle() %></option>
                            <%  } %>
                          </select>
                        <% } else {%>
                        <div class="alert alert-danger" role="alert">
  							Ainda não existem módulos cadastrados no curso!
						</div>
                        <% } %>
                        </div>

                        <div class="form-group">
                            <label for="">Título da Aula</label>
                            <input type="text" name="nome-aula" class="form-control" placeholder="" aria-describedby="helpId">
                          </div>

                          <div class="form-group">
                          <label for="Vídeo Aula">Vídeo Aula</label>
                          <div class="custom-file">
                            <input type="file" class="custom-file-input" name="video-aula">
                            <label class="custom-file-label" for="customFile">Escolher Arquivo</label>
                          </div>
                        </div>

                        <div class="form-group">
                          <label for="Vídeo Aula">Material Opcional</label>
                          <div class="custom-file">
                            <input type="file" class="custom-file-input" name="material-aula">
                            <label class="custom-file-label" for="customFile">Escolher Arquivo</label>
                          </div>
                        </div>
  
                          <button formaction="SvAddAula" type="submit" class="btn btn-primary">Adicionar Aula</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- JavaScript -->
    <script src="js/nav.js"></script>
    <script src="js/course.js"></script>
  </body>
</html>