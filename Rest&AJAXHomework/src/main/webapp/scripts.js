$(document).ready(function() {
	$("#button").click(function (){
		$.get({
			url: "http://localhost:8080/rst2/api/cars",
			dataType: "json",
			success: function(data){
				console.log(data);
				$.each(data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + data[index].name + "</td>");
					tr.append("<td> " + data[index].model + "</td>");
					$("#usersTable").append(tr);
				});
			}

		});
	});
});


// this is a code from one example
var rootURL = "http://localhost:8080/rst2/index.html";

var currentCar;

findAll();

$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

$('#searchKey').keypress(function(e) {
	if (e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
	}
});

$('#btnAdd').click(function() {
	newCar();
	return false;
});

$('#btnSave').click(function() {
	
});

$('#carList a').live('click', function() {
	findById($(this).data('identity'));
});

function search(searchKey) {
	if (searchKey == '')
		findAll();
	else
		findByName(searchKey);
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json",
		success: function(data){
			console.log(data);
			$.each(data, function(index){
				var tr = $('<tr>');
				tr.append("<td> " + data[index].name + "</td>");
				$("#usersTable").append(tr);
			});
		}
	})
}