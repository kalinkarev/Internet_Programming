var page = 0;
var perPage = 10;

function getCarList() {
	$.ajax({
		url: "http://localhost:8080/rst2/api/cars",
		type: "GET",
		data:{page: page, perPage: perPage},
		dataType: "json",
		success: function(data) {
			var cars = data.data;
			if (page == 0) {
				console.log(data);
				var th = $('<tr id = "headers">');
				th.append('<th>Name</th>');
				th.append('<th>Model</th>');
				th.append('<th>Year of Production</th>');
				th.append('<th>Color</th>');
				th.append('<th>Fuel</th>');
				th.append('</tr>');
				$('#usersTable').append(th);
			}
			$.each(cars, function(index) {
				var tr = $('<tr>');
				tr.append('<td>' + cars[index].name + '</td>');
				tr.append('<td>' + cars[index].model + '</td>');
				tr.append('<td>' + cars[index].year_producted + '</td>');
				tr.append('<td>' + cars[index].color + '</td>');
				tr.append('<td>' + cars[index].fuel + '</td>');
				tr.append('</tr>');
				$('#usersTable').append(tr);
			})
		}
	});
}

function check_scroll_enabled() {
	if ($("body").height() < $(window).height()) {
		page++;
		getCarList();
	}
}

$(window).scrool(function(){
	if ($(window).scrollTop() >= $(document).height() - $(window).height()) {
		page++;
		getCarList();
	}
});

$(document).ready(function() {
	getCarList();
	perPage = 3;
});