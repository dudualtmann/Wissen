//aulas.js

$(document).on('click', ".video",function(){
	var link = $(this).attr("id");
	
	$('#video-src').attr('src', link);
	document.getElementById("video-player").load();
});