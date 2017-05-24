$(function() {
	$('#submitForm').submit(savePerson);
});

function savePerson() {
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