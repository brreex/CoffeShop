$(function() {
	var id = $('#userId').val();
	alert(id);
	$.ajax({
		url : 'http://localhost:8080/ws/person/'+id,
		type : 'GET',
		success : ajaxSuccess,
		fail : ajaxFailure
	});

	$('#submitForm').submit(saveProfile);
});

function ajaxSuccess(jsonData) {
	console.log(jsonData);
	var formdata =  "<div class='form-group'> <label for='firstName'>First Name:</label> <input type='text' value="+jsonData.firstName+" class='form-control' id='firstName' name='firstName'> </div>" +
					"<div class='form-group'> <label for='lastName'>Last Name:</label> <input type='text' value="+jsonData.lastName+" class='form-control' id='lastName' name='lastName'> </div>" +
					"<div class='form-group'> <label for='email'>Email:</label> <input type='text' value="+jsonData.email+" class='form-control' id='email' name='email'> </div>" +
					"<div class='form-group'> <label for='phone'>Phone:</label> <input type='text' value ="+jsonData.phone+" class='form-control' id='phone' name='phone'> </div>" +
					"<button type='submit' class='btn btn-default' onclick='saveProfile()'>Save</button>";
	$('#submitForm').append(formdata);
}

function ajaxFailure(Error) {
	alert('Error');
}

function saveProfile() {
	var form = this;
	var formData = {}
	$.each(form, function(i, v) {
		var input = $(v);
		formData[input.attr("name")] = input.val();
	});

	$.ajax({
		type : form.attr('method'),
		url : form.attr('action'),
		dataType : 'json',
		data : JSON.stringify(formData),
		success : function() {
			alert('Saved');
		},
		fail : function(error) {
			alert('Error');
		}
	});
}