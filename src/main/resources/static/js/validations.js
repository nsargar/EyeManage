$(document).ready(function() { 
	
	$("#regForm").validate({
		rules:{
			name:"required",
			answer:"required",
			username:"required",
			filterByList:"required",
			password: {
				required: true,
				minlength: 5
			},
			cpassword: {
				required: true,
				equalTo: "#password"
			}
		},
		messages:{
			name:{
				required: 'Please enter your name'
			},
			answer:{
				required: 'Please enter an answer'
			},
			username:{
				required: 'Please enter a username'
			},
			password:{
				required: 'Please enter a password'
			}
		}
	});
	
});