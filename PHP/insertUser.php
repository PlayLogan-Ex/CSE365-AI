<?php

	if($_SERVER["REQUEST_METHOD"]=="POST"){
		require 'connect.php';
		createUser();
	}

	function createUser() {
		global $connect;

		// catch posting data, from android, by using key
		$firstNameKey = $_POST["firstNameKey"];
		$lastNameKey = $_POST["lastNameKey"];
		$emailKey = $_POST["emailKey"];
		$passwordKey = $_POST["passwordKey"];
		$addressKey = $_POST["addressKey"];
		$professionKey = $_POST["professionKey"];
		$contactNoKey = $_POST["contactNoKey"];
		$researchAreaKey = $_POST["researchArea"];
		$hobbyKey = $_POST["hobby"];

		// mysql query to save data into database
		$query = "INSERT INTO user (firstName, lastName, email, password, address, profession, contactNo, researchArea, hobby) VALUES ('$firstNameKey', '$lastNameKey', '$emailKey', '$passwordKey', '$addressKey', '$professionKey', '$contactNoKey', '$researchAreaKey', '$hobbyKey');";

		mysqli_query($connect, $query) or die (mysqli_error($connect));
		mysqli_close($connect);
	}

?>
