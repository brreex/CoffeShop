$(function(){
    $.ajax({
        url:'http://localhost:8080/ws/products',
        type:'GET',
        success:ajaxSuccess,
        fail:ajaxFailure
    });
});

function ajaxSuccess(jsonData){
    var ul = $('<ul>')

    for(data of jsonData){
        ul.append('<li>'+data.productName+'</li>');
        ul.append('<li>'+data.description+'</li>');
        ul.append('<li>'+data.price+'</li>');
        ul.append('<li>'+data.productType+'</li>');
    }

    ul.appendTo('#productlist')
}

function ajaxFailure(Error){
    alert('Error');
}