<?php

  if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connect.php';
    postAnswer();
  }

  function postAnswer() {
    global $connect;

    // Handle: POST method
    // answer(answerID, answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime, userImage)

    // mendatory: catch posting data
    $qID = $_POST['questionIDKey'];
    $answerHolder = $_POST["answerHolderKey"];
    $answerText = $_POST["answerTextKey"];

    // checkpost
    // if (!$qID || !$answerHolder || !$answerText) {
    //   header("HTTP/1.1 404 Invalid Protocol!");
    //   $response = "Invalid Protocol!";
    //   echo json_encode($response);
    //   die();
    // }

    // optional
    $totalLike = $_POST["totalLikeKey"];
    // $totalLike = 2;
    $totalDislike = $_POST["totalDislikeKey"];
    // $totalDislike = 3;
    $totalComment = $_POST["totalCommentKey"];
    // $totalComment = 4;
    $answerTime = $_POST["answerTime"];
    // $answerTime = "";

    if ($connect) {
      // answer(answerID, answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime, userImage)
      $query = "INSERT INTO answer(answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime)
        VALUES ('$answerText', '$totalLike', '$totalDislike', '$totalComment', '$answerHolder', '$answerTime')";
      $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
      if ($result) {
        echo "Data inserted: answer\n";

        // get last inserted row id from answer table
        $aID = mysqli_insert_id($connect);

        $query = "INSERT INTO mapqa(qID, aID) VALUES ('$qID', '$aID')";
        $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
        if ($result) {
          echo "Data inserted: mapqa\n";
        }
      }
    }
  }

?>
