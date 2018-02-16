-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2017 at 02:35 PM
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
-- Table structure for table `mapqa`
--

CREATE TABLE `mapqa` (
  `qID` int(11) NOT NULL,
  `aID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD PRIMARY KEY (`qID`,`aID`),
  ADD KEY `FK2_aID_MapQA` (`aID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mapqa`
--
ALTER TABLE `mapqa`
  ADD CONSTRAINT `FK1_qID_MapQA` FOREIGN KEY (`qID`) REFERENCES `question` (`questionID`),
  ADD CONSTRAINT `FK2_aID_MapQA` FOREIGN KEY (`aID`) REFERENCES `answer` (`answerID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
