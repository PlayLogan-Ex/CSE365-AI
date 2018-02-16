<?php

  if($_SERVER["REQUEST_METHOD"]=="POST"){
    require 'connect.php';

    postComment();
    //postAnswer();
    //postQuestion();
    //createUser();
  }

  // 4
  function postComment() {
    global $connect;

    # Handle: POST method
    // mendatory: catch posting data
    $aID = $_POST["answerIDKey"];
    $commentHolder = $_POST["commentHolderKey"];

    // optional
    $commentTextKey = $_POST["commentTextKey"];

    if ($connect) {
      // comment(commentID, commentHolder, commentText, likeCount, dislikeCount, userImage)
      $query = "INSERT INTO comment (commentHolder, commentText) VALUES ('$commentHolder', '$commentTextKey')";
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



  // 3
  function postAnswer() {
    global $connect;

    # Handle: POST method
    // answer(answerID, answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime, userImage)

    // mendatory: catch posting data
    $qID = $_POST["questionIDKey"];
    $answerHolder = $_POST["answerHolderKey"];

    // optional
    $answerTextKey = $_POST["answerTextKey"];

    if ($connect) {
      // answer(answerID, answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime, userImage)
      $query = "INSERT INTO answer(answerText, answerHolder) VALUES ('$answerTextKey', '$answerHolder')";
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



// 2
function postQuestion() {
  global $connect;

  # Handle: POST method
  // question(questionID, questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment)

  // mendatory
  // Note: Only registered users can post question.
  // FOREIGN KEY (questionHolder) REFERENCES user(email)
  $questionHolderKey = $_POST["questionHolderKey"];
  $questionTextKey = $_POST["questionTextKey"];

  if ($connect) {
    // question(questionID, questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment)
    $query = "INSERT INTO question(questionText, questionHolder) VALUES ('$questionTextKey', '$questionHolderKey')";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

    if ($result) {
      echo "Data inserted\n";
    }
  }
}

// 1
function createUser() {
  global $connect;

  # Handle: POST method
  // user(email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)

  // mendatory
  $email = $_POST["emailKey"];

  $firstName = $_POST[""];
  $lastName = $_POST[""];
  $password = $_POST[""];
  $address = $_POST[""];
  $profession = $_POST[""];
  $contactNo = $_POST[""];
  $researchArea = $_POST[""];
  $hobby = $_POST[""];

  if ($connect) {

    // user(email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)
    $query = "INSERT INTO user(email) VALUES ('$email')";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));

    if ($result) {
      echo "Data inserted\n";
    }
  }
}


?>
