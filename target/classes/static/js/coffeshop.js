$(function(){
    $.ajax({
        url:'http://localhost:8080/ws/products',
        type:'GET',
        success:ajaxSuccess,
        fail:ajaxFailure
    });
});

function ajaxSuccess(jsonData){
		$.each(jsonData, function (index, item) {
		    var eachrow = "<tr>"
		                + "<td>" + item.id + "</td>"
		                + "<td>" + item.productName + "</td>"
		                + "<td>" + item.description + "</td>"
		                + "<td>" + item.price + "</td>"
		                + "<td>" + item.productType + "</td>"
		                +"<td> <input type='submit' value='Delete' onclick='deleteProduct("+item.id+")'/></td>"
		                + "</tr>";
		    $('#tbody').append(eachrow);
			});
}

function ajaxFailure(Error){
    alert('Error');
}

function deleteProduct(id){
	$.ajax({
		url:'http://localhost:8080/ws/product/'+id,
		type:'DELETE',
		success:function(){
			alert('Product Deleted')
		},
		fail:function(){
			alert('Error Deleting');
		}
	});
}












