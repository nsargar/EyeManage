$('#resultTable').on('click', '.clickable-row', function(event) {
	  if($(this).hasClass("info"))
	        $(this).removeClass('info');
	    else
	        $(this).addClass('info').siblings().removeClass('info');
	});

/*$(document).ready(function(){
    $("#btnDelete").click(function(){
        alert($(this).attr("value"));
    });
});*/