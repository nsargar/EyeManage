$('#resultTable').on('click', '.clickable-row', function(event) {
	  if($(this).hasClass("info"))
	        $(this).removeClass('info');
	    else
	        $(this).addClass('info').siblings().removeClass('info');
	});

// To disable clickable functionality on View and Delete button press
/*$('#resultTable .btn-danger').on('click',function(event) {
	event.stopPropagation();
});

$('#resultTable .btn-info').on('click',function(event) {
	event.stopPropagation();
});*/

// On change of Search Filter Drop Down 
/*$('#searchDrop').change(function(){
    alert("The text has been changed.");
    $("#searchValue").attr("th:field","*{patientId}");
    alert($("#searchValue").attr("th:field"));
});*/