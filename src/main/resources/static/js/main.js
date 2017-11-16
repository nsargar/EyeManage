//Delete Rows Dynamically
function removeRow(rowId){
	$('#'+rowId).remove();
}

//Add Rows Dynamically
	$("#addDrugBtn").click(function () {
		$("#drugTable").each(function () {
			var size	=	$('#drugTable tr').length;
			var newRow = jQuery('<tr id="' + (size) + '">' + 
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
					'<td colspan="2"><input type="button" class="btn btn-danger" name="removeBtn_' + (size) + '" id="removeBtn_' + (size) + '"' + 
					'onclick="removeRow('+ (size) +')" value="Remove"/></td>' + 
			'</tr>');
			jQuery("#drugTable").append(newRow);
		});
	});

	
//Toggle Search Filter Text/Date in Visit Search
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


/*
 * Function to show/hide text box on change of the following Drop Downs:
 * 1. Vision Without Glass
 * 2. Vision With Glass
 * 3. Lens
 * 4. Cornea
 * 5. Pupil
 * 6. Iris
 * 7. Anterior Chamber
 */
function toggleTextBox( listRightId, listLeftId, rowId, cellRightId, cellLeftId ){
	alert("In");
	if ( $("#" + listRightId ).val() == "other" || $("#" + listLeftId ).val() == "other" ){
		// Show Row
		alert("Show");
		if ( $("#" + listRightId ).val() == "other" && $("#" + listLeftId ).val() == "other" ){
			// Show both cells
			$("#" + cellRightId ).removeClass("hidden");
			$("#" + cellLeftId ).removeClass("col-sm-offset-3");
			$("#" + cellLeftId ).removeClass("hidden");
		}
		else if( $("#" + listRightId ).val() == "other" ){
			// Show right cell and hide left cell
			$("#" + cellRightId ).removeClass("hidden");
			$("#" + cellLeftId ).removeClass("col-sm-offset-3");
			$("#" + cellLeftId ).addClass("hidden");
		}
		else if( $("#" + listLeftId ).val() == "other" ){
			// Show left cell and hide right cell
			$("#" + cellRightId ).addClass("hidden");
			$("#" + cellLeftId ).addClass("col-sm-offset-3");
			$("#" + cellLeftId ).removeClass("hidden");
		}
		$("#" + rowId ).removeClass("hidden");
	}
	else{
		// Hide Row
		alert("Hide");
		$("#" + rowId ).addClass("hidden");
	}
	
	
}

// Toggle Text Box for Vision Without Glass Right
$("#visionWithoutGlassRight").on('change', function(event) {
	toggleTextBox( 'visionWithoutGlassRight', 'visionWithoutGlassLeft', 'visionWithoutGlassRow', 
			'visionWithoutGlassRightCell', 'visionWithoutGlassLeftCell');
});

//Toggle Text Box for Vision Without Glass Left
$("#visionWithoutGlassLeft").on('change', function(event) {
	toggleTextBox( 'visionWithoutGlassRight', 'visionWithoutGlassLeft', 'visionWithoutGlassRow', 
			'visionWithoutGlassRightCell', 'visionWithoutGlassLeftCell');
});
