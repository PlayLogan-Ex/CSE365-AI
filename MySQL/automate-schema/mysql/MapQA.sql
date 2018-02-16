--
-- Table structure for table `mapqa`
--
CREATE TABLE mapqa (
  qID int(11) NOT NULL,
  aID int(11) NOT NULL
);

--
-- Constraints for table `mapqa`
--
ALTER TABLE mapqa
  ADD CONSTRAINT FK1_qID_MapQA FOREIGN KEY (qID) REFERENCES question (questionID),
  ADD CONSTRAINT FK2_aID_MapQA FOREIGN KEY (aID) REFERENCES answer (answerID);

--
-- Indexes for table `mapqa`
--
ALTER TABLE mapqa
  ADD PRIMARY KEY (qID, aID);
