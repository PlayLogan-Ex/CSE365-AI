--
-- Table structure for table `answer`
--
CREATE TABLE answer (
  answerID int(11) NOT NULL,
  answerText varchar(255) NOT NULL,
  totalLike int(11) DEFAULT NULL,
  totalDislike int(11) DEFAULT NULL,
  totalComment int(11) DEFAULT NULL,
  answerHolder varchar(50) DEFAULT NULL,
  answerTime date DEFAULT NULL,
  userImage varchar(50) DEFAULT NULL
);

--
-- Indexes for table `answer`
--
ALTER TABLE answer
  ADD PRIMARY KEY (answerID);

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE answer
  MODIFY answerID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Constraints for table `answer`
--
ALTER TABLE answer
  ADD CONSTRAINT FK1_answerHolder FOREIGN KEY(answerHolder) REFERENCES user(email);
