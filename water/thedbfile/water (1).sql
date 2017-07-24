-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2017 at 09:23 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `water`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_tb`
--

CREATE TABLE `admin_tb` (
  `id` int(11) NOT NULL,
  `admin_user` varchar(30) NOT NULL,
  `admin_pass` varchar(30) NOT NULL,
  `time_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_log` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_tb`
--

INSERT INTO `admin_tb` (`id`, `admin_user`, `admin_pass`, `time_created`, `active_log`) VALUES
(1, 'admin', 'admin', '2017-07-20 21:17:15', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `client_tb`
--

CREATE TABLE `client_tb` (
  `client_id` int(11) NOT NULL,
  `client_fname` varchar(50) NOT NULL,
  `client_lname` varchar(50) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `client_email` varchar(70) NOT NULL,
  `client_phonenum` varchar(10) NOT NULL,
  `client_password` varchar(20) NOT NULL,
  `client_regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client_tb`
--

INSERT INTO `client_tb` (`client_id`, `client_fname`, `client_lname`, `gender`, `client_email`, `client_phonenum`, `client_password`, `client_regdate`) VALUES
(1, 'hhff', 'fhfh', ' ', 'adminis', '', '123456789', '2017-07-20 16:47:29'),
(2, '', '', ' ', '', '', '', '2017-07-20 16:50:49'),
(3, 'emmanuel', 'steiner', 'male ', 'kojo@gmail.com', '4321emma', '0270019503', '2017-07-20 17:03:43'),
(4, 'Rtyuii', 'Yuo', 'nil ', 'joy@gmail.com', '0278195093', '4675774733454', '2017-07-20 17:21:25'),
(5, 'Tyy', 'Yuo', 'nil ', 'joyuu@gmail.com', '0278195093', '4675774733454', '2017-07-20 17:26:19'),
(6, 'Tuofi', 'Gouy', 'nil ', 'hoig@gmail.com', '0272341234', 'fgdfggffg', '2017-07-20 17:33:45'),
(7, 'Resd', 'sder', 'nil ', 'gfggg', 'dgfhfhjgj', '012356', '2017-07-21 03:41:31'),
(8, 'Abe', 'Soh', 'nil ', 'hob', '858854959', '7893', '2017-07-21 03:42:51'),
(9, 'Abe', 'Soh', 'nil ', 'admin', 'admin', '7893', '2017-07-21 03:54:55'),
(10, 'Emman', 'Steiner', 'nil ', 'kojosalmin@gail.com', '', '1233445', '2017-07-21 05:09:27'),
(11, 'Er', 'fdg', 'nil ', 'gdg', '', 'gdg', '2017-07-21 05:11:48'),
(12, 'Chris', 'Abei', 'nil ', 'joppfjk', '', 'fdkfjdkjk', '2017-07-21 05:15:36'),
(13, 'Kate', 'Aba', 'nil ', 'kate@gmail.com', '', 'adminkate123', '2017-07-24 12:58:03'),
(14, 'Seth', 'Abeti', 'nil ', 'seth@gmail.com', 'seth123456', '0234567845', '2017-07-24 14:02:43'),
(15, 'Jake', 'alexander', 'nil ', 'jake@gmail.com', 'jake123456', '0234567834', '2017-07-24 14:06:26'),
(16, 'Loris', 'Zemio', 'nil ', 'loris@gmail.com', 'loris12345', '0234567893', '2017-07-24 14:10:38'),
(17, 'Loris', 'Zemio', 'nil ', 'loris2@gmail.com', 'loris2@gma', '0234567893', '2017-07-24 15:29:42'),
(18, 'Rose', 'Gabiti', 'nil ', 'rose@gmail.com', 'rose123456', '0234567823', '2017-07-24 15:31:42'),
(19, 'Apple', 'Android', 'nil ', 'apple@gmail.com', 'appleandro', '0234511845', '2017-07-24 15:48:44'),
(20, 'Lenovo', 'Computer', 'nil ', 'lenovo@gmail.com', 'lenovo1234', '0234565745', '2017-07-24 15:55:56'),
(21, 'Chris', 'Ayei', 'nil ', 'chris@gmail.com', 'chris12345', '0234564534', '2017-07-24 16:00:13'),
(22, 'Chris', 'Ayei', 'nil ', 'christwo@gmail.com', 'chris09876', '0234523534', '2017-07-24 16:05:11'),
(23, 'Chris', 'Ayei', 'nil ', 'christwothree@gmail.com', 'three12345', '0230023534', '2017-07-24 16:16:57'),
(24, 'Max', 'Thon', 'nil ', 'max@gmail.com', 'max1234567', '0257675884', '2017-07-24 16:18:09'),
(25, 'Maxlon', 'Thonre', 'nil ', 'maxthon@gmail.com', 'maxthon@gm', '0258675884', '2017-07-24 16:20:19'),
(26, 'Chrome', 'Explorer', 'nil ', 'chrome@gmail.com', 'chrome1234', '0255739275', '2017-07-24 16:24:00'),
(27, 'Grace', 'Period', 'nil ', 'grace@gmail.com', 'grace@gmai', '0235752864', '2017-07-24 16:26:15'),
(28, 'hewelt', 'packard', 'nil ', 'hew@gmail.com', '12345ghjkl', '0234789079', '2017-07-24 16:34:37'),
(29, 'hewelttey', 'packard', 'nil ', 'hewpack@gmail.com', '123456789g', '0238789079', '2017-07-24 18:03:59'),
(30, 'Tris', 'Alba', 'nil ', 'tris@gmail.com', 'tris123456', '0239583867', '2017-07-24 18:06:59'),
(31, 'Blue', 'Pink', 'nil ', 'blue@gmail.com', 'bluepink12', '0233417803', '2017-07-24 18:21:52'),
(32, 'Green', 'Grass', 'nil ', 'green@gmail.com', 'green12345', '0233419503', '2017-07-24 18:23:43'),
(33, 'Greenf', 'Grassg', 'nil ', 'greenjui@gmail.com', 'greatethat', '0233408503', '2017-07-24 18:25:15');

-- --------------------------------------------------------

--
-- Table structure for table `complain`
--

CREATE TABLE `complain` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `subject` varchar(30) NOT NULL,
  `message` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complain`
--

INSERT INTO `complain` (`id`, `name`, `email`, `subject`, `message`) VALUES
(67, 'prince', 'prince23@ymail.com', 'No Bill', 'there has no water bill to my house since last four mount, which is june');

-- --------------------------------------------------------

--
-- Table structure for table `fromphonecomp`
--

CREATE TABLE `fromphonecomp` (
  `compid` int(11) NOT NULL,
  `ownerid` varchar(70) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `imageid` varchar(100) NOT NULL,
  `location_address` varchar(100) NOT NULL,
  `location_city` varchar(50) NOT NULL,
  `location_street` varchar(50) NOT NULL,
  `location_colat` varchar(70) NOT NULL,
  `location_colon` varchar(70) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fromphonecomp`
--

INSERT INTO `fromphonecomp` (`compid`, `ownerid`, `detail`, `imageid`, `location_address`, `location_city`, `location_street`, `location_colat`, `location_colon`, `time`) VALUES
(1, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 15:59:38'),
(2, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 16:00:52'),
(3, '', '', 'nimg', '', '', '', '', '', '2017-07-17 16:03:05'),
(4, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 16:03:34'),
(5, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 16:17:21'),
(6, '', '', 'nimg', 'data ', ' data', 'data ', 'data ', 'data ', '2017-07-17 16:50:02'),
(7, '', '', 'nimg', 'data ', ' data', 'data ', 'data ', 'data ', '2017-07-17 16:50:09'),
(8, '', '', 'nimg', 'data ', ' data', 'data ', 'data ', 'data ', '2017-07-17 16:50:48'),
(9, '', '', 'nimg', 'data ', ' data', 'data ', 'data ', 'data ', '2017-07-17 16:52:03'),
(10, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 16:57:51'),
(11, '', '', ' 596ced0ec5bc39.44821368', '', ' ', ' ', ' ', ' ', '2017-07-17 16:59:58'),
(12, '', '', ' 596ced665cc2f6.61817987', '', ' ', ' ', ' ', ' ', '2017-07-17 17:01:26'),
(13, '', '', ' 596cedf2e83916.77073530', '', ' ', ' ', ' ', ' ', '2017-07-17 17:03:46'),
(14, '', '', ' 596ceec249e7e4.38601506', '', ' ', ' ', ' ', ' ', '2017-07-17 17:07:14'),
(15, '', '', ' 596ceefc654d40.46930781', '', ' ', ' ', ' ', ' ', '2017-07-17 17:08:12'),
(16, '', '', ' 596ceffbb4c465.81124287', '', ' ', ' ', ' ', ' ', '2017-07-17 17:12:27'),
(17, '', '', ' 596cf266288175.44124605', '', ' ', ' ', ' ', ' ', '2017-07-17 17:22:46'),
(18, '', '', ' 596cf26664d810.51324818', '', ' ', ' ', ' ', ' ', '2017-07-17 17:22:46'),
(19, '', '', ' 596cf26ddfdbf9.68953118', '', ' ', ' ', ' ', ' ', '2017-07-17 17:22:53'),
(20, '', '', ' 596cf373c7b204.00943192', '', ' ', ' ', ' ', ' ', '2017-07-17 17:27:15'),
(21, '', '', ' 596cf39eb702f5.84115995', '', ' ', ' ', ' ', ' ', '2017-07-17 17:27:58'),
(22, '', '', ' 596cf39ee0aa79.27218142', '', ' ', ' ', ' ', ' ', '2017-07-17 17:27:58'),
(23, 'jet', '', ' 596cf4c1a61491.11527478', '', ' ', ' ', ' ', ' ', '2017-07-17 17:32:49'),
(24, 'jet', '', ' 596cf4f400e499.90933241', '', ' ', ' ', ' ', ' ', '2017-07-17 17:33:40'),
(25, 'jet', 'ffggg', ' 596cf7702839b8.11404257', '', ' ', ' ', ' ', ' ', '2017-07-17 17:44:16'),
(26, 'jet', 'edfff', ' 596d04f06ed343.87714620', '', ' ', ' ', ' ', ' ', '2017-07-17 18:41:52'),
(27, 'jet', 'the mouse', ' 596d0af548d6d7.91533505', '', ' ', ' ', ' ', ' ', '2017-07-17 19:07:33'),
(28, 'jet', 'the mouse', ' 596d0b21b969c0.10722061', '', ' ', ' ', ' ', ' ', '2017-07-17 19:08:17'),
(29, '', '', ' 596d1659a742d9.39456938', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 19:56:09'),
(30, '', '', ' 596d168c95e542.68238111', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 19:57:00'),
(31, 'jet', 'firt', ' 596d1991c676a6.18324508', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:09:53'),
(32, 'jet', 'fre', ' 596d1a252b0c18.32594819', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:12:21'),
(33, 'jet', 'fre', ' 596d1a8d70b7b6.95897875', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:14:05'),
(34, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 20:19:48'),
(35, 'jet', 'fre', ' 596d1cc67cbd70.59607607', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:23:34'),
(36, 'jet', 'dry', ' 596d1d13bd58b1.22136972', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:24:51'),
(37, 'jet', 'dry', ' 596d1d25dcc222.85260546', 'Mountain View, 	 1604 Amphitheatre Parkway', 'Mountain View', '1604 Amphitheatre Parkway', '37.421998333333335', '-122.08499833333332', '2017-07-17 20:25:09'),
(38, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 23:29:27'),
(39, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 23:30:15'),
(40, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-17 23:32:24'),
(41, '', '', 'nimg', '', ' ', ' ', ' ', ' ', '2017-07-19 15:23:39'),
(42, '', 'ghhfgg', ' 596f7d6d0dec37.03689163', 'no', 'no', 'no', 'no', 'no', '2017-07-19 15:40:29'),
(43, '', 'ghhfgg', ' 596f7d794a2126.83082039', 'no', 'no', 'no', 'no', 'no', '2017-07-19 15:40:41'),
(44, '', 'ghhfgg', ' 596f7df2cf4713.86053943', 'no', 'no', 'no', 'no', 'no', '2017-07-19 15:42:42'),
(45, '', 'fggg', ' 596f7efeb051e1.44366611', 'no', 'no', 'no', 'no', 'no', '2017-07-19 15:47:10'),
(46, '', 'fggg', ' 596f7f05065b96.19507101', 'no', 'no', 'no', 'no', 'no', '2017-07-19 15:47:17'),
(47, '', 'dfgg', ' 596f7faa9604a1.84095414', '', 'a', 'a', 'a', 'a', '2017-07-19 15:50:02'),
(48, '', '', ' 596f801e9a0d24.50415518', '', 'a', 'a', 'a', 'a', '2017-07-19 15:51:58'),
(49, '', '', '', '', '', '', '', '', '2017-07-21 13:24:05'),
(50, '', '', '', 'no', 'no', 'no', 'no', 'no', '2017-07-21 13:26:56'),
(51, '', '', '', 'no', 'no', 'no', 'no', 'no', '2017-07-21 13:27:39'),
(52, '', '', '', 'no', 'no', 'no', 'no', 'no', '2017-07-21 13:29:18'),
(53, '', '', '', 'no', 'no', 'no', 'no', 'no', '2017-07-21 13:36:52'),
(54, '', '', '', 'no', 'no', 'no', 'no', 'no', '2017-07-21 13:36:53');

-- --------------------------------------------------------

--
-- Table structure for table `itempay`
--

CREATE TABLE `itempay` (
  `ID` int(11) NOT NULL,
  `STNAME` varchar(255) NOT NULL,
  `ITEM` varchar(255) NOT NULL,
  `AMOUNT` float NOT NULL,
  `DATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itempay`
--

INSERT INTO `itempay` (`ID`, `STNAME`, `ITEM`, `AMOUNT`, `DATE`) VALUES
(3, 'jackson hreb', 'sugar', 2500, '2013-07-23'),
(5, 'herbert samz', 'slasher,\r\noil', 2500, '2013-07-24'),
(11, 'herbert samz', 'dfdsfdsfs', 323, '2013-07-24'),
(12, 'jackson hreb', 'bullete', 500, '2013-08-14');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `passw` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `passw`, `email`) VALUES
(1, 'wanzima', 'wanzima19', 'wanzima19@yahoo.com'),
(2, 'adminis', '123456789', 'admin@water,com');

-- --------------------------------------------------------

--
-- Table structure for table `login_client`
--

CREATE TABLE `login_client` (
  `client_id` int(11) NOT NULL,
  `login_client_email` varchar(70) NOT NULL,
  `login_client_phon` varchar(10) NOT NULL,
  `login_client_pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_client`
--

INSERT INTO `login_client` (`client_id`, `login_client_email`, `login_client_phon`, `login_client_pass`) VALUES
(0, '', '', ''),
(5, '04847938958', 'brank', 'craft'),
(7, 'gfggg', '012356', 'dgfhfhjgj'),
(8, 'hob', '7893', '858854959'),
(9, 'admin', '7893', 'admin'),
(10, 'kojosalmin@gail.com', '1233445', ''),
(11, 'gdg', 'gdg', ''),
(12, 'joppfjk', 'fdkfjdkjk', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_tb`
--
ALTER TABLE `admin_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client_tb`
--
ALTER TABLE `client_tb`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `complain`
--
ALTER TABLE `complain`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fromphonecomp`
--
ALTER TABLE `fromphonecomp`
  ADD PRIMARY KEY (`compid`);

--
-- Indexes for table `itempay`
--
ALTER TABLE `itempay`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_client`
--
ALTER TABLE `login_client`
  ADD PRIMARY KEY (`client_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_tb`
--
ALTER TABLE `admin_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `client_tb`
--
ALTER TABLE `client_tb`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `complain`
--
ALTER TABLE `complain`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `fromphonecomp`
--
ALTER TABLE `fromphonecomp`
  MODIFY `compid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT for table `itempay`
--
ALTER TABLE `itempay`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
