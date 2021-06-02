<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Wissen | Checkout</title>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Big+Shoulders+Inline+Display:wght@600&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/checkout.css">
    <script src="https://kit.fontawesome.com/b1b1442df1.js" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%@page import = "control.Aluno, control.Carrinho" %>
    <% Aluno a = (Aluno) session.getAttribute("objUser"); Carrinho c = a.getCarrinho();
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
        <form action="SvCadastroPedido" method="POST">
            <input type="hidden" name="id_cursos" id="id_cursos" value="">
            <input type="hidden" name="total-price" id="total-price" value="">

        <section class="row main-section">

        <div class="col-md-8 left-col">
            <p class="p-title">Carrinho</p>
            <div class="divider">
                <div class="div-products">
                    <div class="row labels">
                        <p class="col-md-8">Produtos</p>
                        <p class="col-md-4">Valor Total</p>
                    </div>
                    <hr>
                    
                    <% double price = 0;
                    for(int i = 0; i < a.getCarrinho().getListaCursosCarrinho().size(); i++) { %>
                    <div class="courses row align-items-center">
                        <div class="col-md-8 item">
                            <img src="images/<%= a.getCarrinho().getListaCursosCarrinho().get(i).getPhoto()%>" alt="">
                            <div class="p-text"><%= a.getCarrinho().getListaCursosCarrinho().get(i).getTitle() %></div>
                        </div>
                        <div class="col-md-3">
                            <div class="p-text">R$ <span class="course-price"><%= a.getCarrinho().getListaCursosCarrinho().get(i).getPrice() %></span> </div>
                        </div>
                        <div class="col-md-1"><button class="btn-x" type="button">X</button></div>
                        <input type="hidden" class="id-curso" value="<%=a.getCarrinho().getListaCursosCarrinho().get(i).getId()%>">
                    </div>
                    <%price += a.getCarrinho().getListaCursosCarrinho().get(i).getPrice(); %>
                    <% } %>

                    <hr>
                    <div class="total">
                        <p class="total-price">Total: R$ <span id="preco-total"><%= price %></span></p>
                    </div>

                </div>
            </div>
        </div>

        <div class="col-md-4 right-col">
            <p class="p-title">Pagamento</p>
            <div class="div-checkout">
                <label class="l-text">Método de Pagamento</label>
                <div class="form-check">
                    <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="payment-method" id="paypal" value="PayPal" checked>
                    <i class="fab fa-cc-paypal"></i> PayPal
                  </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="payment-method" id="credit-card" value="Cartão de Crédito">
                    <i class="fas fa-credit-card"></i> Cartão de Crédito
                  </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="payment-method" id="boleto" value="Boleto">
                    <i class="fas fa-money-bill"></i> Boleto
                  </label>
                  
                </div>
                <div class="form-group first-input">
                    <label class="l-text">Nome no Cartão:</label>
                    <input type="text"
                      class="form-control card-info" name="name" aria-describedby="helpId" placeholder="Ex: Maria M Silva" disabled>
                </div>
                <div class="form-group">
                    <label class="l-text">Número do Cartão:</label>
                    <input type="text"
                      class="form-control card-info" name="card-number" aria-describedby="helpId" placeholder="" disabled>
                </div>

                <div class="row">
                  <div class="form-group col-md-8">
                    <label class="l-text">Data de Validade (mm/aa)</label>
                    <input type="text"
                        class="form-control card-info" name="exp-date" aria-describedby="helpId" placeholder="" disabled>
                  </div>  
                  <div class="form-group col-md-4">
                    <label class="l-text">CVV</label>
                    <input type="number"
                        class="form-control card-info" name="cvv" aria-describedby="helpId" placeholder="" disabled>
                  </div>
                </div>

                <input name="" id="" class="btn btn-primary btn-finalizar" type="submit" value="Finalizar Compra">
            </div>
        </div>

    </section>
    </form>
    </main>

    

    
      
    <!-- Optional JavaScript -->

    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    
    
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/nav.js"></script>
    <script src="js/checkout.js"></script>
    
  </body>
</html>