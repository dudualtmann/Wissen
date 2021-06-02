// checkout.js

$(document).ready(function(){
    var divCursos = $(".id-curso");
    let idCursos = "";



    for(i = 0; i < divCursos.length;i++){
        if(divCursos.eq(i).val() != undefined){
            if(i >= 1)
            idCursos += "," + divCursos.eq(i).val();
            else
            idCursos = divCursos.eq(0).val();
        }
        
    }

$('#id_cursos').val(idCursos);

$('#total-price').val($('#preco-total').text());

})

var carrinho = $('.cart-number').text();

$(document).on('click', '.btn-x', function() {
    let id = $(this).parent().parent().find("input").val();
    let parentDiv = $(this).parent().parent();
    let coursePrice = $(this).parent().parent().find(".col-md-3 .p-text .course-price").text();
    $.ajax({url:"SvRemoveCarrinho", data: {idCurso:id},type: "post", success: function(responseText) {   
        if(responseText == "ok"){
            // Curso removido do carrinho com sucesso
            carrinho -= 1;
            $('.cart-number').text(carrinho).show();
            
            console.log(coursePrice + " Course-price");
            let totalPrice = $('#total-price').val();
            console.log(totalPrice + " total price");
            totalPrice -= coursePrice;
            $('#total-price').val(totalPrice);
            $('#preco-total').text(totalPrice)
            parentDiv.remove();
        } else{
            // Erro ao adicionar curso no carrinho
            alert('erro: '+responseText);
        }
                   
    }});
});

$(document).on('change', "#credit-card",function(){
	if($(this).prop("checked")){
		$('.card-info').prop("disabled",false);
	}
});

$(document).on('change', '#paypal, #boleto',function(){
	if($(this).prop("checked")){
		$('.card-info').prop("disabled",true);
	}
});




