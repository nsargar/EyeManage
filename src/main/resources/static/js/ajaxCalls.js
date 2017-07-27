// Delete Patient AJAX Starts

function deleteBtn(patientId){
	ajaxDelPost(patientId);
}

function ajaxDelPost(patientId){
	var url	=	window.location;
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
            console.log("ERROR: ", e);
        }
    });
}

function deleteRow(patientId){
	$("#tr"+patientId).hide();
} 

//Delete Patient AJAX Ends


//Edit Patient AJAX Starts

function editBtn(patientId,firstName, lastName, gender, email, mobile, phoneNumber){
	ajaxEditPost(patientId,firstName,lastName,gender,email,mobile,phoneNumber);
}

function ajaxEditPost(patientId,firstName,lastName,gender,email,mobile,phoneNumber){
	var url	=	window.location;
	var formData ={
			patientId	:	patientId,
			firstName	:	firstName,
			lastName	:	lastName,
			gender		:	gender,
			email		:	email,
			mobile		:	mobile,
			phoneNumber	:	phoneNumber
	}
	
	$.ajax({
	    type : "POST",
        contentType : "application/json",
        url : url + "/patientEdit",
        data :JSON.stringify(formData),
        dataType : 'json',
        success : function(result) {
            if(result.status == "Done"){
            
            	$("#msg").html("<strong>" + "Patient Details Edited Successfully!</strong>");
            }else{
            	
            	$("#msg").html("<strong>" + "Something Went wrong</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}

//Edit Patient AJAX Ends


//Add Visit AJAX Starts

//$("#addVisitBtn").on('click', function(event) {
/*function addVisitDetails1(){
	var url	=	window.location;
	var drugData	=	[];
	var size	=	$('#drugTable tr').length;
	for ( var i = 1 ; i < size ; i++ ){
		drugData.push({
		drugType		:	document.getElementById('drugType_'+i).value,
		drugName		:	document.getElementById('drugName_'+i).value,
		quantity		:	document.getElementById('quantity_'+i).value,
		frequency		:	document.getElementById('frequency_'+i).value,
		duration		:	document.getElementById('duration_'+i).value,
		durationType	:	document.getElementById('durationType_'+i).value
		});
	}
	
	var visitData	=	{	
			sphDistRight 			: $('#sphDistRight').val(),
			cylRight 				: $('#cylRight').val(),
			axisRight 				: $('#axisRight').val(),
			vaRight 				: $('#vaRight').val(),
			sphDistLeft 			: $('#sphDistLeft').val(),
			cylLeft 				: $('#cylLeft').val(),
			axisLeft 				: $('#axisLeft').val(),
			vaLeft 					: $('#vaLeft').val(),
			sphNearRight 			: $('#sphNearRight').val(),
			sphNearLeft 			: $('#sphNearLeft').val(),
			remarks 				: $('#remarks').val(),
			anteriorSeg 			: $('#anteriorSeg').val(),
			posteriorSeg 			: $('#posteriorSeg').val(),
			iop 					: $('#iop').val(),
			keraK1 					: $('#keraK1').val(),
			keraK2 					: $('#keraK2').val(),
			axialLength 			: $('#axialLength').val(),
			iolPower 				: $('#iolPower').val(),
			surgicalPlan 			: $('#surgicalPlan').val(),
			admissionDate 			: $('#admissionDate').val(),
			surgeryDate 			: $('#surgeryDate').val(),
			dischargeDate 			: $('#dischargeDate').val(),
			diagnosis 				: $('#diagnosis').val(),
			surgicalProc 			: $('#surgicalProc').val(),
			investigations 			: $('#investigations').val(),
			anaesthetist 			: $('#anaesthetist').val(),
			surgeon 				: $('#surgeon').val(),
			followUp 				: $('#followUp').val(),
			fees 					: $('#fees').val(),
			drugs					: drugData
	}
	
	$.ajax({
	    type : "POST",
        contentType : "application/json",
        url : url,
        data : JSON.stringify(visitData),
        dataType : 'json',
        success : function(result) {
            if( result.status == "Done"){
            	//clearForm();
            	window.location.href = result.data;
            	$("#msg").html("<strong>" + "Visit Added Successfully!</strong>");
            }else{
            	$("#msg").html("<strong>" + "Something Went wrong</strong>");
            }
            console.log("Whole Result : " + JSON.stringify(result));
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}*/
//});

/*function clearForm(){
	alert("In");
	$('#sphDistRight').val("");    
	$('#cylRight').val("");    
	$('#axisRight').val("");       
	$('#vaRight').val("");       
	$('#sphDistLeft').val("");     
	$('#cylLeft').val("");         
	$('#axisLeft').val("");        
	$('#vaLeft').val("");          
	$('#sphNearRight').val("");    
	$('#sphNearLeft').val("");     
	$('#remarks').val("");         
	$('#anteriorSeg').val("");     
	$('#posteriorSeg').val("");    
	$('#iop').val("");             
	$('#keraK1').val("");          
	$('#keraK2').val("");          
	$('#axialLength').val("");     
	$('#iolPower').val("");        
	$('#surgicalPlan').val("");    
	$('#admissionDate').val("");   
	$('#surgeryDate').val("");     
	$('#dischargeDate').val("");   
	$('#diagnosis').val("");       
	$('#surgicalProc').val("");    
	$('#investigations').val("");  
	$('#anaesthetist').val("");    
	$('#surgeon').val("");         
	$('#followUp').val("");        
	$('#fees').val("");         
}*/

//Add Visit AJAX Ends

//Print Report AJAX Starts


function printReport(visitId){
	var url	=	window.location + "/print/" + visitId;
	alert("In , id : " + visitId);
	alert(url);
	
	$.ajax({
	    type : "POST",
        contentType : "application/pdf",
        url : url,
        success : function(result) {
            alert("Result : " + result);
        	console.log(result);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}

//Print Report AJAX Ends