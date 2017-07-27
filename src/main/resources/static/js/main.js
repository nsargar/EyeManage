
//Add rows dynamically
$("#addDrugBtn").click(function () {
	$("#drugTable").each(function () {
		var size	=	$('#drugTable tr').length;
		var newRow = jQuery('<tr>' + 
				'<td><select name="drugType" class="form-control" id="drugType_' + (size) + '">' +
				'<option value="">Select</option>' +
				'<option value="Tablet">Tablet</option>' +
				'<option value="Drop">Drops</option>' +
				'</select></td>' +
				'<td><input type="text" class="form-control" name="drugName" id="drugName_' + (size) + '"/></td>' +
				'<td><input type="text" class="form-control" name="quantity" id="quantity_' + (size) + '"/></td>' +
				'<td><input type="text" class="form-control" name="frequency" id="frequency_' + (size) + '"/></td>' +
				'<td colspan="2"><input type="text" class="form-control" name="duration" id="duration_' + (size) + '"/></td>' + 
				'<td colspan="2"><select name="durationType" class="form-control" id="durationType_' + (size) + '">' +
				'<option value="">Select</option>' +
				'<option value="days">Days</option>' +
				'<option value="weeks">Weeks</option>' +
				'<option value="months">Months</option>' +
				'</select></td>' +
		'</tr>');
		jQuery("#drugTable").append(newRow);
	});
});

$("#visitSearchDrop").on('change', function(event) {
	if ( $("#visitSearchDrop").val() == "date" ){
		$("#nameTextDiv").hide();
		$("#dateFromDiv").show();
		$("#dateToDiv").show();
	}
	else{
		$("#nameTextDiv").show();
		$("#dateFromDiv").hide();
		$("#dateToDiv").hide();
	}
});