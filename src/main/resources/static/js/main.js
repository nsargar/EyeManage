$('#resultTable').on('click', '.clickable-row', function(event) {
	if($(this).hasClass("info"))
		$(this).removeClass('info');
	else
		$(this).addClass('info').siblings().removeClass('info');
});

$('#resultTable .btn-info').on('click',function(event) {
	event.stopPropagation();
});

//On change of Search Filter Drop Down 
/*$('#searchDrop').change(function(){
    alert("The text has been changed.");
    $("#searchValue").attr("th:field","*{patientId}");
    alert($("#searchValue").attr("th:field"));
});*/


//Add rows dynamically
$("#addDrugBtn").click(function () {
	$("#drugTable").each(function () {
		var size	=	$('#drugTable tr').length;
		var newRow = jQuery('<tr>' + 
				'<td><select name="drugType" class="form-control" id="drugType_' + (size) + '">' +
				'<option value="">Select</option>' +
				'<option value="1">Tablet</option>' +
				'<option value="2">Drops</option>' +
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

$("#show").click(function () {
	var arr	=	[];
	var size	=	$('#drugTable tr').length;
	//alert("Size : " + size);
	for ( var i = 1 ; i < size ; i++ ){
		//alert("Iteration No : " + (i));
		arr.push({
			drugType		:	document.getElementById('drugType_'+i).value,
			drugName		:	document.getElementById('drugName_'+i).value,
			quantity		:	document.getElementById('quantity_'+i).value,
			frequency		:	document.getElementById('frequency_'+i).value,
			duration		:	document.getElementById('duration_'+i).value,
			durationType	:	document.getElementById('durationType_'+i).value
		});
	}
	alert(JSON.stringify(arr));
});