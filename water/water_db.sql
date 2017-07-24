-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 21, 2014 at 05:40 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `water`
--
CREATE DATABASE `water` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `water`;
-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CTNAME` varchar(255) NOT NULL,
  `SEX` char(1) NOT NULL,
  `AGE` int(2) NOT NULL,
  `DISTRICT` varchar(15) NOT NULL,
  `HOME` varchar(15) NOT NULL,
  `NUMBER` varchar(25) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CUSTOMER_ID`, `CTNAME`, `SEX`, `AGE`, `DISTRICT`, `HOME`, `NUMBER`) VALUES
(1, 'jackson hreb', 'M', 12, 'KISORO', 'jacob', 'DAY'),
(2, 'cubed tevvez', 'M', 14, 'Kisoro', 'yurself', 'Day'),
(8, 'rebecca me', 'F', 17, 'HERE', 'FATHER', 'BORDING'),
(9, 'safi', 'F', 12, 'HERE', 'FATHER', 'DAY', 'SENIOR TWO'),
(11, 'jolly', 'F', 12, 'kabale', 'jesca', 'BORDING',),

-- --------------------------------------------------------



--
-- Table structure for table `user`
--


CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `FNAME` varchar(30) NOT NULL,
  `LNAME` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `FNAME`, `LNAME`,) VALUES
(11, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'DERICK', 'DAN'),
(13, 'jackson', 'e99a18c428cb38d5f260853678922e03', 'NANI', 'LOUS'),
(14, 'secretary', '21232f297a57a5a743894a0e4a801fc3', 'Mrs', 'Erina'),
(15, 'bursar', '21232f297a57a5a743894a0e4a801fc3', 'Mr ', 'Bursar');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clubmember`
--
ALTER TABLE `clubmember`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`CLUB_ID`) REFERENCES `club` (`CLUB_ID`);
