-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 06, 2019 at 04:55 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paymentbillingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE `accountant` (
  `num_accountant_id` int(5) NOT NULL,
  `vch_accountant_name` varchar(30) DEFAULT NULL,
  `num_accountant_salary` int(8) DEFAULT NULL,
  `num_accountant_phone` bigint(10) DEFAULT NULL,
  `vch_accountant_email` varchar(50) DEFAULT NULL,
  `chr_accountant_active_status` char(1) DEFAULT 'Y',
  `num_accountant_branch_id` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`num_accountant_id`, `vch_accountant_name`, `num_accountant_salary`, `num_accountant_phone`, `vch_accountant_email`, `chr_accountant_active_status`, `num_accountant_branch_id`) VALUES
(101, 'sabari', 10000, 1234567890, 'sabari@gmail.com', 'Y', 1),
(102, 'Prema', 20000, 1534698722, 'prema@gmail.com', 'Y', 2);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `num_branch_id` int(5) NOT NULL,
  `vch_branch_name` varchar(30) DEFAULT NULL,
  `vch_branch_address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`num_branch_id`, `vch_branch_name`, `vch_branch_address`) VALUES
(1, 'bangalore', '123, xyz street, banglore'),
(2, 'gurugram', '123, abc, gurugram');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `num_department_id` int(5) NOT NULL,
  `vch_department_name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`num_department_id`, `vch_department_name`) VALUES
(1, 'IT'),
(2, 'CSE');

-- --------------------------------------------------------

--
-- Table structure for table `fee_status`
--

CREATE TABLE `fee_status` (
  `num_fee_id` int(5) NOT NULL,
  `num_total_fee` int(8) DEFAULT NULL,
  `num_paid_fee` int(8) DEFAULT NULL,
  `num_student_register_number` int(5) NOT NULL,
  `chr_fee_status` char(1) DEFAULT 'Y'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fee_status`
--

INSERT INTO `fee_status` (`num_fee_id`, `num_total_fee`, `num_paid_fee`, `num_student_register_number`, `chr_fee_status`) VALUES
(1, 70000, 60000, 711707, 'Y'),
(2, 70000, 30000, 711702, 'Y'),
(3, 70000, 50000, 711705, 'Y'),
(4, 70000, 60000, 711704, 'Y'),
(5, 70000, 20000, 711706, 'Y'),
(6, 50000, 25000, 711703, 'Y'),
(7, 50000, 40000, 711701, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `num_login_id` int(5) NOT NULL,
  `num_accountant_id` int(5) DEFAULT NULL,
  `vch_accountant_password` varchar(30) DEFAULT NULL,
  `num_administrator_id` int(5) DEFAULT NULL,
  `vch_administrator_password` varchar(30) DEFAULT NULL,
  `chr_active_status` char(1) DEFAULT 'Y'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`num_login_id`, `num_accountant_id`, `vch_accountant_password`, `num_administrator_id`, `vch_administrator_password`, `chr_active_status`) VALUES
(1, 101, 'sabari', NULL, NULL, 'Y'),
(2, NULL, NULL, 1, 'admin', 'Y'),
(4, 102, 'prema', NULL, NULL, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `num_student_register_number` int(10) NOT NULL,
  `vch_student_name` varchar(30) DEFAULT NULL,
  `num_student_department_id` int(5) NOT NULL,
  `num_student_branch_id` int(5) DEFAULT NULL,
  `vch_student_email` varchar(50) DEFAULT NULL,
  `num_student_phone` bigint(10) DEFAULT NULL,
  `num_student_parent_phone` int(10) DEFAULT NULL,
  `num_modified_by_accountant` int(5) NOT NULL,
  `dtt_creation_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`num_student_register_number`, `vch_student_name`, `num_student_department_id`, `num_student_branch_id`, `vch_student_email`, `num_student_phone`, `num_student_parent_phone`, `num_modified_by_accountant`, `dtt_creation_date`) VALUES
(711701, 'Yashmi', 2, 1, 'yash@gmail.com', 1234567890, 1346798520, 101, '2019-08-05 09:47:19'),
(711702, 'Himanshu', 1, 1, 'him@gmail.com', 2111554487, 1564879210, 101, '2019-08-06 10:29:21'),
(711703, 'Susmitha', 2, 2, 'susmi@gmail.com', 1236549870, 1574693021, 102, '2019-08-06 10:29:21'),
(711704, 'Jasmine', 1, 1, 'jas@gmail.com', 1546327890, 1324657980, 101, '2019-08-06 10:30:58'),
(711705, 'Jagdish', 1, 1, 'jaggu@gmail.com', 1234560987, 1237894056, 102, '2019-08-06 10:30:58'),
(711706, 'Kajal', 1, 2, 'kajal@gmail.com', 1234852000, 2110556633, 101, '2019-08-06 10:32:50'),
(711707, 'Hari Hara', 2, 1, 'harry@gmail.com', 1020304050, 2030504612, 102, '2019-08-06 10:32:50'),
(711708, 'Nihal', 1, NULL, 'nihal@gmail.com', 1234569520, 1543243210, 101, '2019-08-06 14:42:12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountant`
--
ALTER TABLE `accountant`
  ADD PRIMARY KEY (`num_accountant_id`),
  ADD KEY `num_accountant_branch_id` (`num_accountant_branch_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`num_branch_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`num_department_id`);

--
-- Indexes for table `fee_status`
--
ALTER TABLE `fee_status`
  ADD PRIMARY KEY (`num_fee_id`),
  ADD KEY `num_student_register_number` (`num_student_register_number`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`num_login_id`),
  ADD KEY `num_accountant_id` (`num_accountant_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`num_student_register_number`),
  ADD KEY `num_student_department_id` (`num_student_department_id`),
  ADD KEY `num_student_branch_id` (`num_student_branch_id`),
  ADD KEY `num_modified_by_accountant` (`num_modified_by_accountant`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fee_status`
--
ALTER TABLE `fee_status`
  MODIFY `num_fee_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `num_login_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accountant`
--
ALTER TABLE `accountant`
  ADD CONSTRAINT `accountant_ibfk_1` FOREIGN KEY (`num_accountant_branch_id`) REFERENCES `branch` (`num_branch_id`);

--
-- Constraints for table `fee_status`
--
ALTER TABLE `fee_status`
  ADD CONSTRAINT `fee_status_ibfk_1` FOREIGN KEY (`num_student_register_number`) REFERENCES `student` (`num_student_register_number`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`num_accountant_id`) REFERENCES `accountant` (`num_accountant_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`num_student_department_id`) REFERENCES `department` (`num_department_id`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`num_student_branch_id`) REFERENCES `branch` (`num_branch_id`),
  ADD CONSTRAINT `student_ibfk_3` FOREIGN KEY (`num_modified_by_accountant`) REFERENCES `accountant` (`num_accountant_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
