<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">

<head>
    <title>Wissen | Perfil</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Inline+Display:wght@600&display=swap"
        rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/profile.css">
    <script src="https://kit.fontawesome.com/b1b1442df1.js" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <%@page import="control.Aluno, control.Carrinho"%>
        <% Aluno a = (Aluno) session.getAttribute("objUser"); %>
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

    <!-- End of Header -->

    <main class="container">
       
        <div class="profile-card">
            <form action="SvUpdateAluno" method="POST" class="profile-form">
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
                
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-3 group-foto">
                        <label class="custom-file">
                            <input type="file" name="foto-perfil" placeholder="" class="custom-file-input"
                                aria-describedby="fileHelpId">
                            <span class="custom-file-control"><img <%if(a.getFotoPerfil()!=null){%>src="images/<%=a.getFotoPerfil()%>"<% } else { %>src="images/undraw_profile_pic_ic5t (1).svg"<% } %>  alt=""
                                    class="img-perfil"></span>
                        </label>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="">Nome Completo</label>
                        <input type="text" name="nome" class="form-control" placeholder="" aria-describedby="helpId" <%if(a.getNome()!=null){%>value="<%=a.getNome()%>"<% } %>>
                    </div>
                </div>

                <div class="row align-items-center justify-content-center">
                    <div class="form-group col-md-6">
                      <label for="">E-Mail</label>
                      <input type="text" name="email" class="form-control" placeholder="" aria-describedby="helpId" <%if(a.getEmail()!=null){%>value="<%=a.getEmail()%>"<% } %>>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="">Senha</label>
                        <input type="password" name="password" class="form-control" placeholder="" aria-describedby="helpId" <%if(a.getSenha()!=null){%>value="<%=a.getSenha()%>"<% } %>>
                      </div>
                </div>

                <div class="row align-items-center justify-content-center">
                    <div class="form-group col-md-6">
                      <label for="">CPF</label>
                      <input type="text" name="cpf" class="form-control" placeholder="" aria-describedby="helpId" <%if(a.getCpf()!=null){%>value="<%=a.getCpf()%>"<% } %>>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="">Data de Nascimento</label>
                        <input type="date" name="date" class="form-control" placeholder="" aria-describedby="helpId" value="<%=a.getDataFormatado()%>">
                      </div>
                </div>

                <div class="row align-items-center justify-content-center">
                    <div class="form-group col-md-6">
                        <label for="">Nacionalidade</label>
                        <select class="form-control" name="nationality">
                          <option value="Brasil" <%if(a.getNacionalidade()!= null && a.getNacionalidade().equals("Brasil")){%>selected<% } %>>Brasil</option>
                          <option value="Estados Unidos" <%if(a.getNacionalidade()!= null && a.getNacionalidade().equals("Estados Unidos")){%>selected<% } %>>United States</option>
                          <option value="Alemanha" <%if(a.getNacionalidade()!= null && a.getNacionalidade().equals("Alemanha")){%>selected<% } %>>Deutschland</option>
                        </select>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="">Sexo</label>
                        <select class="form-control" name="gender">
                            <option value="Masculino" <%if(a.getSexo()!=null && a.getSexo().equals("Masculino")){%>selected<% } %>>Masculino</option>
                            <option value="Feminino" <%if(a.getSexo()!=null && a.getSexo().equals("Feminino")){%>selected<% } %>>Feminino</option>
                            <option value="Outro" <%if(a.getSexo()!=null && a.getSexo().equals("Outro")){%>selected<% } %>>Outro</option>
                          </select>
                    </div>
                    
                </div>

                <div class="row justify-content-end">
                    <div class="form-group col-md-3">
                        <input id="btn-red" class="btn btn-danger" formaction="SvDesativarConta" type="submit" value="Desativar Conta">
                    </div>
                    <div class="form-group col-md-3">
                        <input id="btn-save" class="btn btn-dark" type="submit" value="Salvar Alterações">
                    </div>
                </div>

            </form>
        </div>
    </main>

    <!-- Optional JavaScript -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="js/nav.js"></script>