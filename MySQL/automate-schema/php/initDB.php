<?php

  require 'connect.php';

  if ($connect) {
    # init db tables

    ## Table: 01
    # user
    $query = "CREATE TABLE user (
      email varchar(50) NOT NULL,
      firstName varchar(20) NOT NULL,
      lastName varchar(20) NOT NULL,
      password varchar(40) NOT NULL,
      address varchar(50) NOT NULL,
      profession varchar(20) NOT NULL,
      contactNo int(11) NOT NULL,
      researchArea varchar(100) NOT NULL,
      hobby varchar(50) NOT NULL
    );";
    echo "\n1. user(email, firstName, lastName, password, address, profession, contactNo, researchArea, hobby)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE user
      ADD PRIMARY KEY (email);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- PRIMARY KEY (email)\n";
    }


    ## Table: 02
    # question
    $query = "CREATE TABLE question (
      questionID int(11) NOT NULL,
      questionText varchar(100) NOT NULL,
      tag varchar(20) NOT NULL,
      questionHolder varchar(50) NOT NULL,
      time date NOT NULL,
      totalLike int(11) NOT NULL,
      totalDislike int(11) NOT NULL,
      totalComment int(11) NOT NULL
    );";
    echo "2. question(questionID, questionText, tag, questionHolder, time, totalLike, totalDislike, totalComment)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE question
      ADD PRIMARY KEY (questionID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- PRIMARY KEY (questionID)\n";
    }

    $query = "ALTER TABLE question
      MODIFY questionID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 3. modified -- questionID AUTO_INCREMENT, AUTO_INCREMENT=1\n";
    }

    $query = "ALTER TABLE question
      ADD CONSTRAINT FK1_questionHolder FOREIGN KEY (questionHolder) REFERENCES user (email);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 4. modified -- FOREIGN KEY (questionHolder) REFERENCES user(email)\n";
    }

    $query = "ALTER TABLE question ADD FULLTEXT KEY question_index (questionText, tag, questionHolder);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 5. modified -- FULLTEXT KEY question_index (questionText, tag, questionHolder)\n";
    }




    ## Table: 03
    # answer
    $query = "CREATE TABLE answer (
      answerID int(11) NOT NULL,
      answerText varchar(255) NOT NULL,
      totalLike int(11) DEFAULT NULL,
      totalDislike int(11) DEFAULT NULL,
      totalComment int(11) DEFAULT NULL,
      answerHolder varchar(50) DEFAULT NULL,
      answerTime date DEFAULT NULL,
      userImage varchar(50) DEFAULT NULL
    );";
    echo "3. answer(answerID, answerText, totalLike, totalDislike, totalComment, answerHolder, answerTime, userImage)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE answer
      ADD PRIMARY KEY (answerID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- PRIMARY KEY (answerID)\n";
    }

    $query = "ALTER TABLE answer
      MODIFY answerID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 3. modified -- answerID AUTO_INCREMENT, AUTO_INCREMENT=1\n";
    }

    $query = "ALTER TABLE answer
      ADD CONSTRAINT FK1_answerHolder FOREIGN KEY(answerHolder) REFERENCES user(email);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 4. modified -- FOREIGN KEY(answerHolder) REFERENCES user(email)\n";
    }



    ## Table: 04
    # comment
    $query = "CREATE TABLE comment (
      commentID int(11) NOT NULL,
      commentHolder varchar(50) DEFAULT NULL,
      commentText varchar(255) NOT NULL,
      likeCount int(11) DEFAULT NULL,
      dislikeCount int(11) DEFAULT NULL,
      userImage varchar(50) DEFAULT NULL
    );";
    echo "4. comment(commentID, commentHolder, commentText, likeCount, dislikeCount, userImage)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE comment
      ADD PRIMARY KEY (commentID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- PRIMARY KEY (commentID)\n";
    }

    $query = "ALTER TABLE comment
      MODIFY commentID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 3. modified -- commentID AUTO_INCREMENT, AUTO_INCREMENT=1\n";
    }

    $query = "ALTER TABLE comment
      ADD CONSTRAINT FK1_commentHolder FOREIGN KEY(commentHolder) REFERENCES user(email);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 4. modified -- FOREIGN KEY(commentHolder) REFERENCES user(email)\n";
    }


    ## Table: 04
    # mapqa
    $query = "CREATE TABLE mapqa (
      qID int(11) NOT NULL,
      aID int(11) NOT NULL
    );";
    echo "5. mapqa(qID, aID)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE mapqa
      ADD CONSTRAINT FK1_qID_MapQA FOREIGN KEY (qID) REFERENCES question (questionID),
      ADD CONSTRAINT FK2_aID_MapQA FOREIGN KEY (aID) REFERENCES answer (answerID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- FOREIGN KEY (qID) REFERENCES question (questionID), FOREIGN KEY (aID) REFERENCES answer (answerID)\n";
    }

    $query = "ALTER TABLE mapqa
      ADD PRIMARY KEY (qID, aID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 3. modified -- PRIMARY KEY (qID, aID)\n";
    }


    ## Table: 05
    # mapac
    $query = "CREATE TABLE mapac (
      aID int(11) NOT NULL,
      cID int(11) NOT NULL
    );";
    echo "6. mapac(aID, cID)\n";

    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 1. created\n";
    }

    # Constraints
    $query = "ALTER TABLE mapac
      ADD CONSTRAINT FK1_aID_MapAC FOREIGN KEY (aID) REFERENCES answer (answerID),
      ADD CONSTRAINT FK2_cID_MapAC FOREIGN KEY (cID) REFERENCES comment (commentID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 2. modified -- FOREIGN KEY (aID) REFERENCES answer (answerID), FOREIGN KEY (cID) REFERENCES comment (commentID)\n";
    }

    $query = "ALTER TABLE mapac
      ADD PRIMARY KEY (aID, cID);";
    $result = mysqli_query($connect, $query) or die (mysqli_error($connect));
    if ($result) {
      echo " 3. modified -- PRIMARY KEY (aID, cID)\n";
    }

    mysqli_close($connect);
  }


?>
