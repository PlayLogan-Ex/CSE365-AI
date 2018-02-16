<?php

  if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connect.php';
    postComment();
  }

  // 4
  function postComment() {
    global $connect;

    // Handle: POST method
    // mendatory: catch posting data
    $aID = $_POST["answerIDKey"];
    $commentHolder = $_POST["commentHolderKey"];
    // optional
    $commentText = $_POST["commentTextKey"];

    // checkpost
    if (!$aID || !$commentHolder || !$commentText) {
      header("HTTP/1.1 404 Invalid Protocol!");
      $response = "Invalid Protocol!";
      echo json_encode($response);
      die();
    }

    if ($connect) {
      // comment(commentID, commentHolder, commentText, likeCount, dislikeCount, userImage)
      $query = "INSERT INTO comment (commentHolder, commentText)
        VALUES ('$commentHolder', '$commentText')";
      $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

      if ($result) {
        echo "Data inserted: comment\n";

        $cID = mysqli_insert_id($connect);
        echo "$cID\n";
        $query = "INSERT INTO mapac(aID, cID) VALUES ('$aID', '$cID')";
        $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

        if ($result) {
          echo "Data inserted: mapac\n";
        }
      }
    }
  }

?>
