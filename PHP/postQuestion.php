<?php

	if($_SERVER["REQUEST_METHOD"]=="POST"){
		require 'connect.php';
		createUser();
	}

	function createUser() {
		global $connect;

		// catch posting data, from android, by using key
		$questionTextKey = $_POST["questionTextKey"];
		$tagKey = $_POST["tagKey"];
		$typeKey = $_POST["typeKey"];

		// mysql query to save data into database
		$query = "INSERT INTO data_source(part, topic, book) VALUES ('$questionTextKey', '$tagKey', '$typeKey');";

		mysqli_query($connect, $query) or die (mysqli_error($connect));
		mysqli_close($connect);
	}

?>
