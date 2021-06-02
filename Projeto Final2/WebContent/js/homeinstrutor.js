// homeinstrutor.js

$(document).on('click', '.buy-btn', function() {
    let id = $(this).parent().find("input").val();
    
    $('#id-curso').val(id);
    
    document.getElementById("form-cursos").submit();
    
    
});