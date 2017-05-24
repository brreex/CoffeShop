$(function() {
	$.ajax({
		url : 'http://localhost:8080/ws/products',
		type : 'GET',
		success : ajaxSuccess,
		fail : ajaxFailure
	});

	$('#submitForm').submit(saveProduct);
});

function ajaxSuccess(jsonData) {
	$
			.each(
					jsonData,
					function(index, item) {
						var eachrow = "<tr>"
								+ "<td>"
								+ item.id
								+ "</td>"
								+ "<td>"
								+ item.productName
								+ "</td>"
								+ "<td>"
								+ item.description
								+ "</td>"
								+ "<td>"
								+ item.price
								+ "</td>"
								+ "<td>"
								+ item.productType
								+ "</td>"
								+ "<td> <input type='submit' value='Delete' onclick='deleteProduct("
								+ item.id + ")'/></td>" + "</tr>";
						$('#tbody').append(eachrow);
					});
}

function ajaxFailure(Error) {
	alert('Error');
}

function deleteProduct(id) {
	$.ajax({
		url : 'http://localhost:8080/ws/product/' + id,
		type : 'DELETE',
		success : function() {
			alert('Product Deleted')
		},
		fail : function() {
			alert('Error Deleting');
		}
	});
}

function saveProduct() {
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
