--
-- Table structure for table `mapac`
--
CREATE TABLE mapac (
  aID int(11) NOT NULL,
  cID int(11) NOT NULL
);

--
-- Constraints for table `mapac`
--
ALTER TABLE mapac
  ADD CONSTRAINT FK1_aID_MapAC FOREIGN KEY (aID) REFERENCES answer (answerID),
  ADD CONSTRAINT FK2_cID_MapAC FOREIGN KEY (cID) REFERENCES comment (commentID);

--
-- Indexes for table `mapac`
--
ALTER TABLE mapac
  ADD PRIMARY KEY (aID, cID);
