-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2018 at 02:35 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `visa`
--

-- --------------------------------------------------------

--
-- Table structure for table `applyvisa`
--

CREATE TABLE `applyvisa` (
  `id` int(10) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `bday` date NOT NULL,
  `gender` varchar(50) NOT NULL,
  `mail` varchar(250) NOT NULL,
  `pnumber` int(255) NOT NULL,
  `country` varchar(50) NOT NULL,
  `vtype` int(50) NOT NULL,
  `passportid` int(100) NOT NULL,
  `iday` date NOT NULL,
  `days` int(200) NOT NULL,
  `user` varchar(50) NOT NULL,
  `verify` int(10) DEFAULT NULL,
  `payment` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `applyvisa`
--

INSERT INTO `applyvisa` (`id`, `fname`, `lname`, `sname`, `bday`, `gender`, `mail`, `pnumber`, `country`, `vtype`, `passportid`, `iday`, `days`, `user`, `verify`, `payment`) VALUES
(17, 'kalana', 'udara', 'nanayakka', '1994-05-02', 'male', 'kalana@gmail.com', 1234567899, 'United States', 1, 1111111111, '2018-05-25', 30, 'udara', 1, 1),
(18, 'sandun', 'geemal', 'weerasinghe', '1996-12-09', 'male', 'sandun123@gmail.com', 1234567899, 'Mexico', 2, 555555555, '2018-04-19', 20, 'sandun', 0, 1),
(19, 'chamindu', 'ishan', 'sandaru', '1995-09-21', 'male', 'ishan@gmail.com', 12345678, 'Swaziland', 2, 199585, '2018-04-05', 49, 'ishan', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `charges`
--

CREATE TABLE `charges` (
  `cid` int(11) NOT NULL,
  `vtype` varchar(30) DEFAULT NULL,
  `scharge` double DEFAULT NULL,
  `dcharge` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charges`
--

INSERT INTO `charges` (`cid`, `vtype`, `scharge`, `dcharge`) VALUES
(1, 'Tourist', 8000, 1000),
(2, 'Business', 12000, 1875),
(3, 'Economic', 6500, 1500);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `msg` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id`, `name`, `mail`, `msg`) VALUES
(1, 'kalana', 'kalana@gmail.com', 'hello world'),
(2, 'udara', 'udara@yahoo.com', 'hello world');

-- --------------------------------------------------------

--
-- Table structure for table `passport`
--

CREATE TABLE `passport` (
  `passportid` int(100) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `bday` date NOT NULL,
  `idate` date NOT NULL,
  `exdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passport`
--

INSERT INTO `passport` (`passportid`, `fname`, `lname`, `bday`, `idate`, `exdate`) VALUES
(199585, 'chamindu', 'ishan', '1995-09-21', '2018-04-05', '2020-06-05'),
(1111111111, 'kalana', 'udara', '1994-05-02', '2018-05-25', '2020-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(10) NOT NULL,
  `cid` int(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `vtype` int(50) NOT NULL,
  `days` int(50) NOT NULL,
  `total` double NOT NULL,
  `ivisa` date NOT NULL,
  `exvisa` date NOT NULL,
  `extvisa` int(10) DEFAULT NULL,
  `extday` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `cid`, `user`, `country`, `vtype`, `days`, `total`, `ivisa`, `exvisa`, `extvisa`, `extday`) VALUES
(17, 1, 'udara', 'United States', 1, 30, 38000, '2018-05-23', '2018-06-22', 2, 50),
(18, 2, 'sandun', 'Mexico', 2, 41, 83800, '2018-05-21', '2018-07-01', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `admin` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `admin`) VALUES
(15, 'ishan', 'ishan', '123456Kk', NULL),
(1, 'kalana', 'keudaz', '123456Kk', 1),
(9, 'pavan', 'pavan', '123456Kk', NULL),
(14, 'sandun', 'sandun', '123456Kk', NULL),
(13, 'kalana', 'udara', '123456Kk', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applyvisa`
--
ALTER TABLE `applyvisa`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `charges`
--
ALTER TABLE `charges`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`passportid`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applyvisa`
--
ALTER TABLE `applyvisa`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `charges`
--
ALTER TABLE `charges`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
