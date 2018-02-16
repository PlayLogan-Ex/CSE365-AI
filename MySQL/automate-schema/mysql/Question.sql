-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2017 at 03:51 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

--
-- Database: `iot`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE question (
  questionID int(11) NOT NULL,
  questionText varchar(100) NOT NULL,
  tag varchar(20) NOT NULL,
  questionHolder varchar(50) NOT NULL,
  time date NOT NULL,
  totalLike int(11) NOT NULL,
  totalDislike int(11) NOT NULL,
  totalComment int(11) NOT NULL
);

--
-- Indexes for table `question`
--
ALTER TABLE question
  ADD PRIMARY KEY (questionID);

ALTER TABLE question ADD FULLTEXT KEY question_index (questionText, tag, questionHolder);

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE question
  MODIFY questionID int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- Constraints for table `question`
--
ALTER TABLE question
  ADD CONSTRAINT FK1_questionHolder FOREIGN KEY (questionHolder) REFERENCES user (email);
