$(function() {
	$.ajax({
		url : 'http://localhost:8080/ws/persons/',
		type : 'GET',
		success : ajaxSuccess,
		fail : ajaxFailure
	});
});
function ajaxSuccess(jsonData) {
	$.each(jsonData,function(index, person) {
		console.log(person);
						var eachrow = "<tr>"+ "<td>"+ person.id+ "</td>"
								+ "<td>"+ person.firstName+ "</td>"
								+ "<td>"+ person.lastName+ "</td>"
								+ "<td>"+ person.email+ "</td>"
								+ "<td>"+ person.phone
								+ "</td>"+ "<td> <input type='submit' value='Disable' onclick='disableUser("+ person.id + ")' /></td>" 
								+ "</td>"+ "<td> <input type='submit' value='Delete' onclick='deleteUser("+ person.id + ")'/></td>" + "</tr>";
						$('#tbody').append(eachrow);
					});
}

function ajaxFailure(Error) {
	alert('Error');
}

function deleteUser(id) {
	$.ajax({
		url : 'http://localhost:8080/ws/person/' + id,
		type : 'DELETE',
		success : function() {
			alert('User Deleted')
		},
		fail : function() {
			alert('Error Deleting');
		}
	});
}

function disableUser(id) {
	$.ajax({
		url : 'http://localhost:8080/ws/person/' + id,
		type : 'PUT',
		success : function() {
			alert('User Disabled')
		},
		fail : function() {
			alert('Error Disabling');
		}
	});
}





















