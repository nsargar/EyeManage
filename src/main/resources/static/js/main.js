$('#resultTable').on('click', '.clickable-row', function(event) {
	  if($(this).hasClass("info"))
	        $(this).removeClass('info');
	    else
	        $(this).addClass('info').siblings().removeClass('info');
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