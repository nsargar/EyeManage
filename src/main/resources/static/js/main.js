
//Add rows dynamically
	$("#addDrugBtn").click(function () {
		$("#drugTable").each(function () {
			var size	=	$('#drugTable tr').length;
			var newRow = jQuery('<tr id="rowId_' + (size) + '">' + 
					'<td><select required name="drugType_' + (size) + '" class="required form-control" id="drugType_' + (size) + '">' +
					'<option value="">Select</option>' +
					'<option value="Tablet">Tablet</option>' +
					'<option value="Drop">Drops</option>' +
					'</select></td>' +
					'<td><input type="text" required="true" class="required form-control" name="drugName_' + (size) + '" id="drugName_' + (size) + '"/></td>' +
					'<td><input type="text" required="true" class="required form-control" name="quantity_' + (size) + '" id="quantity_' + (size) + '"/></td>' +
					'<td><input type="text" required="true" class="required form-control" name="frequency_' + (size) + '" id="frequency_' + (size) + '"/></td>' +
					'<td colspan="2"><input required="true" type="text" class="required form-control" name="duration_' + (size) + '" id="duration_' + (size) + '"/></td>' + 
					'<td colspan="2"><select required name="durationType_' + (size) + '" class="required form-control" id="durationType_' + (size) + '">' +
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