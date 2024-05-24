<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add Event</title>
<style>
	body {
		font-family: 'Courier New', Courier, monospace;
		font-size: large;
	}
	input[type=text], select {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type=submit] {
	  width: 100%;
	  background-color: #4CAF50;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
	}
	
	div {
	  position: absolute;
	  left: 20vw;
	  top: 15vh;
	  width: 50%;
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
	h1 {
		position: absolute;
		left: 2vw;
	}
	a {
		position: absolute;
		top: 65vh;
		left: 2vw;
		font-weight: bolder;
	}
</style>
</head>
<body>
<h1>Add Event : </h1>
<div>
	<form method="POST" name="add_event"
		action="processNewEvent?clubName=${clubName}">
			Event name: <input name="eventName" type="text" required/> 
			<br /> <br />
			Event Description: <input name="eventDescription" type="text" required/> 
			<br /> <br /> 
			Last registration date: <input name="eventRegDue" type="datetime-local" required/> 
			<br /> <br />
		<input value="Add Event" type="submit" name="submit" />
	</form>
</div>
<a href="showClubDashboard?clubName=${clubName}">DASHBOARD</a> 
</body>
</html>