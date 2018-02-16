<?php

	if($_SERVER["REQUEST_METHOD"]=="POST"){
		include 'connection.php';
		showStudent();
	}

	function showStudent()
	{
		global $connect;

		$email = $_POST["passwordTVKey"];
		$password = $_POST["passwordTVKey"];

		$query = " Select * FROM User where email = '$email' and password = '$password';";

		$result = mysqli_query($connect, $query);
		$number_of_rows = mysqli_num_rows($result);

		$temp_array  = array();

		if($number_of_rows > 0) {
			while ($row = mysqli_fetch_assoc($result)) {
				$temp_array[] = $row;
			}
		}

		header('Content-Type: application/json');
		echo json_encode(array("UserKey"=>$temp_array));
		mysqli_close($connect);

	}

?>
