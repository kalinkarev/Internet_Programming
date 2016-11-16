package bg.elsys.ip.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car {
	String id;
	String car;
	String model;
	
	public Car() {
	
	}

	public Car(String id, String car) {
		super();
		this.id = id;
		this.car = car;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return car;
	}

	public void setName(String name) {
		this.car = name;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

}

/*
<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="scripts.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script>
		document.write(Date());
	</script>
	<button id="button">Get Users</button>
	<button id="how_users">Users</button>
	<table id="usersTable"></table>
</body>
</html>
-->
*/