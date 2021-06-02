// home.js
var carrinho = 0;
$(document).on('click', '.buy-btn', function() {
    let id = $(this).parent().find("input").val();
    
    $.ajax({url:"SvAddCarrinho", data: {idCurso:id},type: "post", success: function(responseText) {   
        if(responseText == "ok"){
            // Curso adicionado no carrinho com sucesso
            carrinho += 1;
            $('.cart-number').text(carrinho).show();
        } else{
            // Erro ao adicionar curso no carrinho
            alert('erro: '+responseText);
        }
                   
    }});
});

$(document).ready(function(){
	if($('.cart-number').text() != "")
		$('.cart-number').show();
})
