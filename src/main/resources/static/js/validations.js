function addVisitDetails(){
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
			sphDistLeft 			: $('#sphDistLeft').val(),
			cylDistRight 			: $('#cylDistRight').val(),
			axisDistRight 			: $('#axisDistRight').val(),
			vaDistRight 			: $('#vaDistRight').val(),
			cylDistLeft 			: $('#cylDistLeft').val(),
			axisDistLeft 			: $('#axisDistLeft').val(),
			vaDistLeft 				: $('#vaDistLeft').val(),
			sphNearRight 			: $('#sphNearRight').val(),
			sphNearLeft 			: $('#sphNearLeft').val(),
			cylNearRight 			: $('#cylNearRight').val(),
			axisNearRight 			: $('#axisNearRight').val(),
			vaNearRight 			: $('#vaNearRight').val(),
			cylNearLeft 			: $('#cylNearLeft').val(),
			axisNearLeft 			: $('#axisNearLeft').val(),
			vaNearLeft 				: $('#vaNearLeft').val(),
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
}

function clearForm(){
	alert("Clear");
	$('#addVisit sphDistRight').val("");   
	$('#addVisit sphDistLeft').val("");    
	$('#addVisit cylDistRight').val("");    
	$('#addVisit cylDistLeft').val("");
	$('#addVisit axisDistRight').val("");       
	$('#addVisit axisDistLeft').val("");
	$('#addVisit vaDistRight').val("");       
	$('#addVisit vaDistLeft').val("");          
	$('#addVisit sphNearRight').val("");    
	$('#addVisit sphNearLeft').val(""); 
	$('#addVisit cylNearRight').val("");    
	$('#addVisit cylNearLeft').val("");
	$('#addVisit axisNearRight').val("");       
	$('#addVisit axisNearLeft').val("");
	$('#addVisit vaNearRight').val("");       
	$('#addVisit vaNearLeft').val("");
	$('#addVisit remarks').val("");         
	$('#addVisit anteriorSeg').val("");     
	$('#addVisit posteriorSeg').val("");    
	$('#addVisit iop').val("");             
	$('#addVisit keraK1').val("");          
	$('#addVisit keraK2').val("");          
	$('#addVisit axialLength').val("");     
	$('#addVisit iolPower').val("");        
	$('#addVisit surgicalPlan').val("");    
	$('#addVisit admissionDate').val("");   
	$('#addVisit surgeryDate').val("");     
	$('#addVisit dischargeDate').val("");   
	$('#addVisit diagnosis').val("");       
	$('#addVisit surgicalProc').val("");    
	$('#addVisit investigations').val("");  
	$('#addVisit anaesthetist').val("");    
	$('#addVisit surgeon').val("");         
	$('#addVisit followUp').val("");        
	alert("End Clear");
}

$(document).ready(function() { 

	$("#regForm").validate({
		rules:{
			name:"required",
			answer:"required",
			userName:"required",
			role:"required",
			secQuest:"required",
			password: {
				required: true,
				minlength: 5
			},
			cnfPassword: {
				required: true,
				equalTo: "#password"
			}
		},
		messages:{
			name:{
				required: "Please enter your name"
			},
			answer:{
				required: "Please enter an answer"
			},
			userName:{
				required: "Please enter a username"
			},
			password:{
				required: "Please enter a password",
				minlength: "Your password must be at least 5 characters long"
			},
			cpassword:{
				required: "Please enter a password",
				equalTo: "Please enter the same password as above"
			}
		}
	});

	jQuery.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-z]+$/i.test(value);
	}, "Letters only please"); 

	$("#addVisit").validate({
		rules:{
			axisDistRight:{
				range: [1, 180],
				digits: true
			},
			axisDistLeft:{
				range: [1, 180],
				digits: true
			},
			axisNearRight:{
				range: [1, 180],
				digits: true
			},
			axisNearLeft:{
				range: [1, 180],
				digits: true
			},
			iop:{
				digits: true,
				rangelength: [1, 3]
			},
			keraK1:{
				number: true,
				rangelength: [1, 6]
			},
			keraK2:{
				number: true,
				rangelength: [1, 6]
			},
			axialLength:{
				number: true,
				rangelength: [1, 6]
			},
			iolPower:{
				number: true,
				rangelength: [1, 6]
			},
			followUp:{
				number: true,
				rangelength:[1,3]
			}
		},
		messages:{
			axisDistRight:{
				range: "Please enter a value between 1 to 180"
			},
			axisDistLeft:{
				range: "Please enter a value between 1 to 180"
			},
			axisNearRight:{
				range: "Please enter a value between 1 to 180"
			},
			axisNearLeft:{
				range: "Please enter a value between 1 to 180"
			}
		},
		submitHandler: function () {
			addVisitDetails();
		}
	});

	$("#patientForm").validate({
		rules:{
			firstName:{
				required: true,
				lettersonly: true
			},
			lastName:{
				required: true,
				lettersonly: true
			},
			email:{
				email:true
			},
			gender:"required"
		}
	});

});	