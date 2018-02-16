<?php

  if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connect.php';
    createUser();
  }


  function createUser() {
    global $connect;

    // Handle: POST method
    // user(email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)

    // mendatory
    $email = $_POST["emailKey"];
    if (!$email) {
      header("HTTP/1.1 404 Email required!");

      $response = "Email required!";
      echo json_encode($response);

      die();
    }

    $firstName = $_POST["firstNameKey"];
    $lastName = $_POST["lastNameKey"];
    $password = $_POST["passwordKey"];
    $address = $_POST["addressKey"];
    $profession = $_POST["professionKey"];
    $contactNo = $_POST["contactNoKey"];
    $researchArea = $_POST["researchAreaKey"];
    $hobby = $_POST["hobby"];

    // check db connection for operation
    if ($connect) {

      // user(email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)
      $query = "INSERT INTO user (email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)
        VALUES ('$email', '$firstName', '$lastName', '$password', '$address', '$profession', '$contactNo', '$researchArea', '$hobby')";
      $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

      if ($result) {
        echo "Data inserted: user\n";
      }
    }
  }

?>
