<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Login</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    
    <script src="https://kit.fontawesome.com/b1b1442df1.js" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
  </head>
  <body>

    <header class="header-wissen">
        <nav class="menu-topo-wissen row">
        <div class="wis-menu col-sm-2">
            <a class="logo-wissen-a" href="index.html" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a>
        </div>

        <nav class="menu-itens col-sm-6">
            <span class="nav-item"><a href="index.html">Home</a></span>
            <span class="nav-item"><a href="cadastroinstrutor.html">Virar Instrutor</a></span>
        </nav>

        <div class="login-box col-sm-4 pr-5">
            <a class="btn-cadastrar" href="login.html" role="button" >Cadastre-se</a>
            <a href="login.html"><i class="fas fa-user link-login-wissen login-svg" style="color: #1F4F66; font-size: 30px;"></i></a>
        </div>
    </nav>
    <!-- Mobile -->
    <nav class="nav-mobile">

        <div class="wis-menu">
            <a class="logo-wissen-a" href="index.html" title="Wissen - A Plataforma do Conhecimento">
                <img class="logo-wissen" src="images/labelwissen.png" alt="WISSEN">
            </a>
        </div>

        <div class="burger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>

        <ul class="nav-links">
            <li class="nav-li1"><a href="index.html">Home</a></li>
            <li><a href="cadastroinstrutor.html">Virar Instrutor</a></li>
            <li><a class="btn-cadastrar" href="login.html" role="button" >Cadastre-se</a></li>
            <li><a href="login.html"><i class="fas fa-user link-login-wissen login-svg" style="color: #1F4F66; font-size: 30px;"></i></a></li>
        </ul>
    </nav>
    </header>

    <main class="container-fluid">

        <section class="row align-items-center justify-content-center">

        <div class="image col-md-6">
            <span class="image-span">
                <img src="images/undraw_researching_22gp.svg" alt="" class="door">
            </span>
            <span class="image-span">
                <img src="images/wissen full.png" alt="">
            </span>
            
            
        </div>

        <div class="right col-md-6">

            <div class="form">
            <!--Login Form-->
            
            <form action="SvLogin" method="post" class="login-form">
                <img src="images/undraw_profile_pic_ic5t (1).svg" alt="" class="avatar">
                <h2>Bem-Vindo</h2>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-envelope"></i>
                    </div>
                    <div>
                        <h5>Email</h5>
                        <input class="input email" type="email" name="username">
                    </div>
                </div>

                <div class="input-div two">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div>
                        <h5>Senha</h5>
                        <input class="input password" type="password" name="senha">
                    </div>
                </div>

                <a href="#" class="a">Esqueceu a Senha?</a>
                <p style="margin-top: 3%"><%= request.getAttribute("msg") %></p>
                <input type="submit" class="btn-wissen" value="Login">

                <div class="options">
                    <p>Sem Cadastro? <a href="#" onclick="signup()">Criar uma Conta</a></p>
                </div>

            </form>
            <!--Sign up Form-->
            <form action="SvCadastroAluno" method="post" class="signup-form">
                <img src="images/undraw_profile_pic_ic5t (1).svg" alt="" class="avatar">
                <h2>Cadastro</h2>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-user"></i>
                    </div>
                    <div>
                        <h5>Nome e Sobrenome</h5>
                        <input class="input name" type="text" name="username">
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-envelope"></i>
                    </div>
                    <div>
                        <h5>Email</h5>
                        <input class="input validate-email" type="email" name="email">
                    </div>
                </div>

                <div class="input-div two">
                    <div class="i">
                        <i class="fas fa-lock"></i>
                    </div>
                    <div>
                        <h5>Senha</h5>
                        <input class="input password" type="password" name="senha">
                    </div>
                </div>
                
                <input type="submit" class="btn-wissen" value="Cadastrar">

                <div class="options">
                    <p>Já tem Conta? <a href="#" onclick="login()">Fazer Login</a></p>
                </div>

            </form>
            </div>
        </div>
    </section>
    </main>


      
    <!-- Optional JavaScript -->
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/login.js"></script>
    <script src="js/nav.js"></script>
 
  </body>
</html>