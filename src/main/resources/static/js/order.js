$(function() {
	$.ajax({
		url : 'http://localhost:8080/ws/products',
		type : 'GET',
		success : ajaxSuccess,
		fail : ajaxFailure
	});
});

function ajaxSuccess(jsonData) {
	$.each(jsonData,function(index, item) {
						var eachrow = "<tr>"+ "<td>"+ item.id+ "</td>"
								+ "<td>"+ item.productName+ "</td>"
								+ "<td>"+ item.description+ "</td>"
								+ "<td>"+ item.price+ "</td>"
								+ "<td>"+ item.productType
								+ "</td>"+ "<td> <input type='text' id='quantity' name='quantity' placeholder='Quantity' name='quantity' /></td>" 
								+ "</td>"+ "<td> <input type='submit' value='Order' onclick='orderProduct("+ item.id + ")'/></td>" + "</tr>";
						$('#tbody').append(eachrow);
					});
}

function ajaxFailure(Error) {
	alert('Error');
}

function orderProduct(id) {
	var quantity = $('#quantity').val();
	$.ajax({
		url : 'http://localhost:8080/ws/order/' + id+"?quantity="+quantity,
		type : 'POST',
		success : function() {
			alert('Order Placed')
		},
		fail : function() {
			alert('Error Ordering');
		}
	});
}
