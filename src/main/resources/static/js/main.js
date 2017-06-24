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

function deleteBtn(patientId){
	alert(patientId);
	ajaxPost(patientId);
}

function ajaxPost(patientId){
	alert("In ajaxPost");
	var url	=	window.location;
	
	/*firstName	: null,
	lastName	: null,
	age	: null,
	address	: null,
	email	: null,
	gender	: null,
	mobile	: null,
	phoneNumber	: null,
	firstVisitDate	: null
	*/
	var formData ={
			patientId : patientId
	}
	
	$.ajax({
	    type : "POST",
        contentType : "application/json",
        url : url + "/patientDelete",
        data :JSON.stringify(formData),
        dataType : 'json',
        success : function(result) {
            if(result.status == "Done"){
            
            	$("#msg").html("<strong>" + "Patient Deleted Successfully!</strong>");
            	deleteRow(patientId);
            }else{
            	
            	$("#msg").html("<strong>" + "Something Went wrong</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });
}

function editBtn(patientId){
	alert(patientId);
}
function qeditBtn(patientId, firstName, lastName, gender, age, email, mobile, phone){
	alert(patientId);
	alert(firstName);
	alert(lastName);
	alert(gender);
	alert(age);
	alert(email);
	alert(mobile);
	alert(phone);
	//ajaxPost(patientId);
}


function deleteRow(patientId){
	alert("Delete Row");
	$("#"+patientId).hide();
} 

// On change of Search Filter Drop Down 
/*$('#searchDrop').change(function(){
    alert("The text has been changed.");
    $("#searchValue").attr("th:field","*{patientId}");
    alert($("#searchValue").attr("th:field"));
});*/