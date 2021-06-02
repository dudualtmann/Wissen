// login.js

// Tratamento de Exce��o

$(document).on('blur','.password',function(){
    // Tratamento de Senha

    let parent = $(this).parent().parent();
    let text = $(this).val();
    if(text.length < 8 && this.value != ""){
        
        parent.addClass('invalid');
        parent.removeClass('focus');
    } else{
        parent.removeClass('invalid');
        
}
})

$(document).on('blur','.name',function(){
    // Tratamento de Nome e Sobrenome
    
    let parent = $(this).parent().parent();
    let text = $(this).val();
    nomeSobrenome = /\b[A-Za-z�-�][A-Za-z�-�]+,?\s[A-Za-z�-�][A-Za-z�-�]{2,19}\b/gi;
    
    if(!(nomeSobrenome.test(text))){
        
        parent.addClass('invalid');
        parent.removeClass('focus');
    } else{
        parent.removeClass('invalid');
        
}
})

$(document).on('blur','.email',function(){
    // Tratamento de Email
    
    let parent = $(this).parent().parent();
    let text = $(this).val();
    email = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/gi;
    
    if(!(email.test(text))){
       
        parent.addClass('invalid');
        parent.removeClass('focus');
    } else{
        
        parent.removeClass('invalid');
        
}
})

$(document).on('blur','.validate-email',function(){
    	// Ajax Vendo se Email ja foi utilizado
// Tratamento de Email
    
    let parent = $(this).parent().parent();
    let text = $(this).val();
    email = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/gi;
    
    if(!(email.test(text))){
       
        parent.addClass('invalid');
        parent.removeClass('focus');
    } else{
        
        parent.removeClass('invalid');
        
}
		
    	$.ajax({url:"SvCheckEmail", data: {email:$(this).val()},type: "post", success: function(responseText) {   
    		
    		console.log(responseText);
    		if(responseText=="invalid"){
    			parent.addClass('invalid');
    	        parent.removeClass('focus');
    		} else{
    			parent.removeClass('invalid');
    		}
                       
        }});
    })

// Fun��es da P�gina

function signup(){
    const formLogin = $('.login-form');
    const formSignup = $('.signup-form');
    
    formLogin.hide();
    formSignup.show();
}

function login(){
    const formLogin = $('.login-form');
    const formSignup = $('.signup-form');
    
    formSignup.hide();
    formLogin.show();
}

const inputs = document.querySelectorAll('.input');

function focusFunc(){
    // Adiciona a Classe 'focus' no input se estiver em foco
    let parent = this.parentNode.parentNode;
    parent.classList.add('focus');
    parent.classList.remove('invalid');
}

function blurFunc(){
    // remove a Classe 'focus' no input se n�o estiver mais em foco e n�o tiver nada preenchido
    let parent = this.parentNode.parentNode;
    if(this.value == ""){
        parent.classList.remove('focus');
    }
    
    }
    

// Adiciona esses eventos para todos os inputs
inputs.forEach(input => {
    // Ao entrar em foco
    input.addEventListener('focus', focusFunc);
    // Ao perder o foco
    input.addEventListener('blur', blurFunc);
})