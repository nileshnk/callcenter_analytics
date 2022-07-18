-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2022 at 10:37 AM
-- Server version: 8.0.23
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kapture_crm`
--

-- --------------------------------------------------------

--
-- Table structure for table `call_center`
--

CREATE TABLE `call_center` (
  `id` int NOT NULL,
  `from_number` varchar(20) NOT NULL,
  `start_time` varchar(30) NOT NULL,
  `end_time` varchar(30) NOT NULL,
  `duration` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `call_center`
--

INSERT INTO `call_center` (`id`, `from_number`, `start_time`, `end_time`, `duration`) VALUES
(1, '9999900000', '13/01/2021 06:00:05', '13/01/2021 06:23:06', 181),
(2, '9999902010', '13/01/2021 06:12:49', '13/01/2021 06:14:44', 115),
(3, '9991323232', '13/01/2021 07:02:49', '13/01/2021 07:14:44', 715),
(4, '8484848484', '13/01/2021 08:12:49', '13/01/2021 08:14:44', 115),
(5, '9378373737', '13/01/2021 10:12:49', '13/01/2021 10:14:44', 115),
(6, '9837373737', '13/01/2021 12:12:49', '13/01/2021 12:14:44', 115),
(7, '9973737373', '13/01/2021 15:12:49', '13/01/2021 15:14:44', 115);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `call_center`
--
ALTER TABLE `call_center`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `call_center`
--
ALTER TABLE `call_center`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
