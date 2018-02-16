-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2017 at 11:34 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iot`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `answerID` int(11) NOT NULL,
  `answerText` varchar(255) NOT NULL,
  `totalLike` int(11) DEFAULT NULL,
  `totalDislike` int(11) DEFAULT NULL,
  `totalComment` int(11) DEFAULT NULL,
  `answerHolder` varchar(50) DEFAULT NULL,
  `answerTime` date DEFAULT NULL,
  `userImage` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`answerID`, `answerText`, `totalLike`, `totalDislike`, `totalComment`, `answerHolder`, `answerTime`, `userImage`) VALUES
(1, 'AI is important for Modern technology', 0, 0, 0, 'user1@gmail.com', '0000-00-00', NULL),
(2, 'Machine Learning is the key to success.', 0, 0, 0, 'user2@gmail.com', '0000-00-00', NULL),
(3, 'Deep learning is so much poweful', 0, 0, 0, 'user3@gmail.com', '0000-00-00', NULL),
(9, 'Answer testing is going on...', 2, 3, 4, 'user1@gmail.com', '0000-00-00', NULL),
(10, 'Updated news, and its awesome', 0, 0, 0, 'user1@gmail.com', '0000-00-00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL,
  `commentHolder` varchar(50) DEFAULT NULL,
  `commentText` varchar(255) NOT NULL,
  `likeCount` int(11) DEFAULT NULL,
  `dislikeCount` int(11) DEFAULT NULL,
  `userImage` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`commentID`, `commentHolder`, `commentText`, `likeCount`, `dislikeCount`, `userImage`) VALUES
(1, 'user4@gmail.com', 'user 4 comment', NULL, NULL, NULL),
(2, 'user5@gmail.com', 'user 5 comment', NULL, NULL, NULL),
(4, 'user6@gmail.com', 'user 6 comment', NULL, NULL, NULL),
(5, 'user6@gmail.com', 'user 7 comment', NULL, NULL, NULL),
(6, 'user5@gmail.com', 'user 8 comment', NULL, NULL, NULL),
(7, 'user4@gmail.com', 'user 9 comment', NULL, NULL, NULL),
(8, 'user3@gmail.com', 'user 10 comment', NULL, NULL, NULL),
(9, 'user2@gmail.com', 'user 11 comment', NULL, NULL, NULL),
(10, 'user1@gmail.com', 'user 12 comment', NULL, NULL, NULL),
(11, 'user1@gmail.com', 'comment 13', NULL, NULL, NULL),
(12, 'user1@gmail.com', 'comment 3', NULL, NULL, NULL),
(13, 'user1@gmail.com', 'comment for a9', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mapac`
--

CREATE TABLE `mapac` (
  `aID` int(11) NOT NULL,
  `cID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mapac`
--

INSERT INTO `mapac` (`aID`, `cID`) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(9, 13);

-- --------------------------------------------------------

--
-- Table structure for table `mapqa`
--

CREATE TABLE `mapqa` (
  `qID` int(11) NOT NULL,
  `aID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mapqa`
--

INSERT INTO `mapqa` (`qID`, `aID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 9),
(1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionID` int(11) NOT NULL,
  `questionText` varchar(100) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `questionHolder` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `totalLike` int(11) NOT NULL,
  `totalDislike` int(11) NOT NULL,
  `totalComment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `questionText`, `tag`, `questionHolder`, `time`, `totalLike`, `totalDislike`, `totalComment`) VALUES
(1, 'question 1', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(3, 'question 2', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(4, 'question 3', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(5, 'question 4', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(6, 'question 5', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(7, 'question 6', 'career', 'user1@gmail.com', '0000-00-00', 0, 0, 0),
(8, 'question 62', 'career', 'user2@gmail.com', '0000-00-00', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `address` varchar(50) NOT NULL,
  `profession` varchar(20) NOT NULL,
  `contactNo` int(11) NOT NULL,
  `researchArea` varchar(100) NOT NULL,
  `hobby` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`email`, `firstName`, `lastName`, `password`, `address`, `profession`, `contactNo`, `researchArea`, `hobby`) VALUES
('user1@gmail.com', '', '', '', '', '', 0, '', ''),
('user2@gmail.com', '', '', '', '', '', 0, '', ''),
('user3@gmail.com', '', '', '', '', '', 0, '', ''),
('user4@gmail.com', '', '', '', '', '', 0, '', ''),
('user5@gmail.com', '', '', '', '', '', 0, '', ''),
('user6@gmail.com', '', '', '', '', '', 0, '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answerID`),
  ADD KEY `FK1_answerHolder` (`answerHolder`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentID`),
  ADD KEY `FK1_commentHolder` (`commentHolder`);

--
-- Indexes for table `mapac`
--
ALTER TABLE `mapac`
  ADD PRIMARY KEY (`aID`,`cID`),
  ADD KEY `FK2_cID_MapAC` (`cID`);

--
-- Indexes for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD PRIMARY KEY (`qID`,`aID`),
  ADD KEY `FK2_aID_MapQA` (`aID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`),
  ADD KEY `FK1_questionHolder` (`questionHolder`);
ALTER TABLE `question` ADD FULLTEXT KEY `question_index` (`questionText`,`tag`,`questionHolder`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `answerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `commentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FK1_answerHolder` FOREIGN KEY (`answerHolder`) REFERENCES `user` (`email`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK1_commentHolder` FOREIGN KEY (`commentHolder`) REFERENCES `user` (`email`);

--
-- Constraints for table `mapac`
--
ALTER TABLE `mapac`
  ADD CONSTRAINT `FK1_aID_MapAC` FOREIGN KEY (`aID`) REFERENCES `answer` (`answerID`),
  ADD CONSTRAINT `FK2_cID_MapAC` FOREIGN KEY (`cID`) REFERENCES `comment` (`commentID`);

--
-- Constraints for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD CONSTRAINT `FK1_qID_MapQA` FOREIGN KEY (`qID`) REFERENCES `question` (`questionID`),
  ADD CONSTRAINT `FK2_aID_MapQA` FOREIGN KEY (`aID`) REFERENCES `answer` (`answerID`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK1_questionHolder` FOREIGN KEY (`questionHolder`) REFERENCES `user` (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
