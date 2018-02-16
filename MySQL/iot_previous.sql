-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2017 at 06:49 AM
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
(0, 'First answer', NULL, NULL, NULL, NULL, NULL, NULL);

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
(0, 'sakib.cse14ewu@gmail.com', 'This is sakib\'s comment.', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `data_source`
--

CREATE TABLE `data_source` (
  `data_id` int(11) NOT NULL,
  `part` varchar(255) NOT NULL,
  `topic` varchar(50) NOT NULL,
  `book` varchar(50) NOT NULL,
  `review_count` int(11) NOT NULL,
  `answer1` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_source`
--

INSERT INTO `data_source` (`data_id`, `part`, `topic`, `book`, `review_count`, `answer1`) VALUES
(1, 'How do I get hired by Google as an Android applications developer?', 'google', 'general question', 27, 'Google hires a lot of Android developers. From my interview experience, problem-solving capability and CS fundamentals are more important than skills in a specific area.'),
(2, 'Why do people quit their jobs at dream companies like Facebook or Google?', 'google', 'general question', 200, '0'),
(3, 'Are web search engines AI?', 'ai', 'book', 50, 'No.\r\nAnd the reason is kind of funny: If computers can do something, we no longer call it AI.'),
(4, 'What are all the job levels in Google\'s technical career track?', 'google career', 'career', 150, 'The levels listed in Anonymous\'s prior answer are correct, but \"Based on the salary range u negotiate while joining, you will be assigned the corresponding engineering level\" is not.'),
(5, 'Do people really get recruited through Google Careers?', 'Recruitment Stories', 'Google Recruiting', 30, 'No, you don\'t need to be referred by someone inside Google to get hired.  \"Employee referral\" as a source of hire used to account for ~40% of Google\'s hires when I first joined in 2005, but I think it is closer to only ~20% today.'),
(6, 'What are all the job levels in Google\'s technical career track?', 'Google Culture', 'Working at Google', 5, 'The levels listed in Anonymous\'s prior answer are correct, but \"Based on the salary range u negotiate while joining, you will be assigned the corresponding engineering level\" is not.'),
(7, 'How to join EWU?', 'ewu', 'education', 0, ''),
(8, 'How to be a android developer?', 'android', 'dev', 0, ''),
(9, 'How can I start programming machine learning and artificial intelligence?', 'Artificial Intelligence', 'Machine Learning', 18, 'AI is amazing field to start with! If you are a total beginner, your path should look like this:\r\n\r\nLearn Python.\r\nLearn AI from a couple of basic courses.\r\nBuild your first simple AI project.\r\nPractice and grow bit by bit.'),
(10, 'What are some best practices for training machine learning models?', 'Artificial Intelligence', 'Machine Learning', 136, 'Summarize some of the best practices I have come across for training and testing ML models. Note that I am focusing my answer on ML models that are trained on user-generated data for user-facing products.\r\n\r\nMetrics, Training data, Negative sampling...etc'),
(11, 'What is the best way to start learning machine learning and deep learning without taking any online courses?', 'Deep Learning', 'Artificial Intelligence', 4, 'Let me first start off by saying that there is no single best way to learn ML, and you should find a system that works well for you. Some people prefer the structure of courses, others like reading books at their own pace...'),
(12, 'How do I learn machine learning?', 'Machine Learning', 'Research scientist at Google', 100, 'Obviously I think my Machine learning textbook is pretty good. However, I am actually in the process of writing the second edition, which will ramp up more slowly, making it more accessible to beginners.'),
(13, 'What is the difference between AI, Machine Learning, NLP, and Deep Learning?', 'NLP, ML', 'Machine learning', 17, 'AI (Artificial intelligence) is a subfield of computer science, that was created in the 1960s, and it was (is) concerned with solving tasks that are easy for humans, but hard for computers.'),
(14, 'What are the best deep or machine learning journals to follow?', 'Academic Journals', 'Deep Learning', 4, 'As a member of the steering committee of distill.pub, I hope you ll find distill.pub to be one of the best deep or machine learning journals to follow'),
(15, 'What is it like to study robotics at UPenn?', 'Robotics', 'University of Pennsylvania ', 14, 'I\'ve been a Robotics Masters student at UPenn for a year now. Here are some of my thoughts on the program and the experience in general.'),
(16, 'Does artificial Intelligence involves Robots only?', 'Robotics', 'Artificial Intelligence', 3, 'No, it has a wide range of applications!\r\n\r\nOn March 24 2017, at Tempe, Arizona a Self-driving Uber Volvo was involved in a crash with a human driven Honda CRV. Luckily, no one was injured'),
(17, 'Why is it so hard to get into robotics?', 'Robotics', 'Advice for Careers', 0, 'I wish I could post the same answer as i did to another post. But contrary to what all these old folk are saying about robotics, Arduinos are NOT robotics! Just because you know'),
(18, 'Has the International Space Station (ISS) outlived its usefulness?', 'Space Stations', 'International Space Station', 1, 'No. That is a bewildering statement. Almost on a daily basis, I am in meetings in which the flight controllers strive to find ways to free up more of the crews time so that they can support more a...more'),
(19, 'How is the interior cleanliness maintained aboard the International Space Station (ISS)?', 'Space Stations', 'NASA', 2, 'If I answer this question, please don\'t tell my wife!  You see, on board the International Space Station (ISS) we were scheduled to \"clean\" our home every Saturday morning.'),
(20, 'How is cured hay made, and is it possible to \"un-cure\" it?', 'Agriculture ', 'Farming', 75, 'We cure hay by cutting it with a mowing machine called a hay cutter (very creative I know)\r\n\r\nHeres a photo or two of that process (I do this for a living)'),
(21, 'Agriculture: What\'s it like to grow up on a farm?', 'Agriculture', 'Land', 3, 'We cure hay by cutting it with a mowing machine called a hay cutter (very creative I know)'),
(22, 'What are five problems every programmer should be able to answer?', 'problems', 'solutions', 2000, 'I don\'t know if you\'re looking for \"problems\" in the sense of \"homework problems\" or \"interview quiz problems\", but those aren\'t really helpful things to know. As Computer Scientists we do not learn to program, we learn to solve problems.'),
(23, 'Is there a problem for which it is proven that there is no optimal algorithm?', 'Problem Solving', 'Mathematical Optimization Algorithms ', 5, 'Yes, there are such problems, but all instances I\'m aware of are of purely theoretical interest with no applications in practice'),
(24, 'Basic career advice?', 'career', 'general', 0, '');

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
(0, 0),
(0, 0);

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
(0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionID` int(11) NOT NULL,
  `questionText` varchar(100) NOT NULL,
  `tag` varchar(20) DEFAULT NULL,
  `questionHolder` varchar(50) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `totalLike` int(11) DEFAULT NULL,
  `totalDislike` int(11) DEFAULT NULL,
  `totalComment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `questionText`, `tag`, `questionHolder`, `time`, `totalLike`, `totalDislike`, `totalComment`) VALUES
(0, 'What is A*', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
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

INSERT INTO `user` (`id`, `firstName`, `lastName`, `email`, `password`, `address`, `profession`, `contactNo`, `researchArea`, `hobby`) VALUES
(1, 'Sakibur', 'Rahman', 'sakib@gmail.com', '123456', 'Dhaka', 'Student', 2147483647, '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answerID`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentID`);

--
-- Indexes for table `data_source`
--
ALTER TABLE `data_source`
  ADD PRIMARY KEY (`data_id`),
  ADD KEY `data_source` (`data_id`);
ALTER TABLE `data_source` ADD FULLTEXT KEY `my_index` (`part`,`topic`,`book`);

--
-- Indexes for table `mapac`
--
ALTER TABLE `mapac`
  ADD KEY `MapACfk1aID` (`aID`),
  ADD KEY `MapACfk2cID` (`cID`);

--
-- Indexes for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD KEY `MapQAfk1qID` (`qID`),
  ADD KEY `MapQAfk2aID` (`aID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_source`
--
ALTER TABLE `data_source`
  MODIFY `data_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `mapac`
--
ALTER TABLE `mapac`
  ADD CONSTRAINT `MapACfk1aID` FOREIGN KEY (`aID`) REFERENCES `answer` (`answerID`),
  ADD CONSTRAINT `MapACfk2cID` FOREIGN KEY (`cID`) REFERENCES `comment` (`commentID`);

--
-- Constraints for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD CONSTRAINT `MapQAfk1qID` FOREIGN KEY (`qID`) REFERENCES `question` (`questionID`),
  ADD CONSTRAINT `MapQAfk2aID` FOREIGN KEY (`aID`) REFERENCES `answer` (`answerID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
