--
-- Table structure for table `comment`
--
CREATE TABLE comment (
  commentID int(11) NOT NULL,
  commentHolder varchar(50) DEFAULT NULL,
  commentText varchar(255) NOT NULL,
  likeCount int(11) DEFAULT NULL,
  dislikeCount int(11) DEFAULT NULL,
  userImage varchar(50) DEFAULT NULL
);

--
-- Indexes for table `comment`
--
ALTER TABLE comment
  ADD PRIMARY KEY (commentID);

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE comment
  MODIFY commentID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Constraints for table `comment`
--
ALTER TABLE comment
  ADD CONSTRAINT FK1_commentHolder FOREIGN KEY(commentHolder) REFERENCES user(email);
