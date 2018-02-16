<?php

	if($_SERVER["REQUEST_METHOD"]=="POST"){
		include 'connect.php';
		retrieveAnswerComment();
	}

	function retrieveAnswerComment() {
		global $connect;

		$questionID = $_POST["questionIDKey"];
    $query = "select question.questionID, question.questionText, answer.answerID, answer.answerText, answer.answerHolder
      from question, mapqa, answer
      where (question.questionID = $questionID) && (mapqa.qID = question.questionID && mapqa.aID = answer.answerID)";
    $result = mysqli_query($connect, $query);

    // $number_of_rows = mysqli_num_rows($result);
    //
		// $return_arr = array();
    //
		// if($number_of_rows > 0) {
		// 	while ($row = mysqli_fetch_assoc($result)) {
    //       $return_arr[] = $row;
    //       // $row_array['questionID'] = $row['questionID'];
    //       // $row_array['answerID'] = $row['answerID'];
    //       // $row_array['commentID'] = $row['commentID'];
    //       //
    //       // array_push($return_arr,$row_array);
		// 	}
		// }
    //
    // header('Content-type: application/json');
    // echo json_encode(array("result"=>$return_arr));


    $answerListArray = array();
    $answerArray = array();
    $commentArray = array();

    while ($rowAnswer = mysqli_fetch_assoc($result)) {
        $answerArray['answerID'] = $rowAnswer['answerID'];
        $answerArray['answerText'] = $rowAnswer['answerText'];
        $answerArray['answerHolder'] = $rowAnswer['answerHolder'];
        $answerArray['comments'] = array();

        $searchKey = $rowAnswer['answerID'];
        $nestedQuery = "select answer.answerID, answer.answerText, answer.answerHolder, comment.commentID, comment.commentText, comment.commentHolder
          from answer, mapac, comment
          where answer.answerID = $searchKey && (mapac.aID = answer.answerID && mapac.cID = comment.commentID)";
        $nestedResult = mysqli_query($connect, $nestedQuery);

        while ($rowComment = mysqli_fetch_assoc($nestedResult)) {
            $commentArray['commentID']=$rowComment['commentID'];
            $commentArray['commentText']=$rowComment['commentText'];
            $commentArray['commentHolder']=$rowComment['commentHolder'];

            array_push($answerArray['comments'], $commentArray);
        }
        array_push($answerListArray, $answerArray);
    }

    // $jsonData = json_encode($answerListArray, JSON_PRETTY_PRINT);
    // echo $jsonData;

    header('Content-type: application/json');
    echo json_encode(array("answers"=>$answerListArray));

    mysqli_close($connect);
	}

?>
