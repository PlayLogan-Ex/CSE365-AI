<?php

  if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connect.php';
    postQuestion();
  }

  function postQuestion() {
    global $connect;
    // Handle: POST method
    // question(questionID, questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment)

    // Note: Only registered users can post question.
    // FOREIGN KEY (questionHolder) REFERENCES user(email)
    // mendatory
    $questionHolder = $_POST["questionHolderKey"];
    $questionText = $_POST["questionTextKey"];
    $tag = $_POST["tagKey"];



    if (!$questionHolder || !$questionText || !$tag) {
      header("HTTP/1.1 404 Invalid Protocol!");
      $response = "Invalid Protocol!";
      echo json_encode($response);
      die();
    }

    $time = $_POST["timeKey"];
    $totalLike = $_POST["totalLikeKey"];
    $totalDislike = $_POST["totalDislikeKey"];
    $totalComment = $_POST["totalCommentKey"];

    if ($connect) {
      // question(questionID, questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment)
      $query = "INSERT INTO question(questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment) VALUES ('$questionText', '$tag', '$questionHolder', '$time', '$totalLike', '$totalDislike', '$totalComment')";
      $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

      if ($result) {
        echo "Data inserted: question\n";
      }
    }
  }

?>
