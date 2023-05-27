-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2023 at 04:53 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nearcourt`
--

-- --------------------------------------------------------

--
-- Table structure for table `belongs_to`
--

CREATE TABLE `belongs_to` (
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `groups_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `belongs_to`
--

INSERT INTO `belongs_to` (`user_id`, `court_id`, `groups_id`) VALUES
(2, 3, 0),
(2, 1, 0),
(2, 3, 0),
(2, 1, 0),
(2, 1, 0),
(2, 1, 0),
(2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `court`
--

CREATE TABLE `court` (
  `court_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sport_center_id` int(11) NOT NULL,
  `sport` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `court`
--

INSERT INTO `court` (`court_id`, `name`, `sport_center_id`, `sport`, `capacity`, `price`) VALUES
(1, 'court 1', 2, 'Football', 10, 10),
(2, 'court 2', 2, 'Basket', 10, 20),
(3, 'court 3', 1, 'Football', 10, 30),
(4, 'court 4', 1, 'Basket', 10, 20);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL,
  `sport` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `court_id` int(11) NOT NULL,
  `joined_players` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `group_capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`group_id`, `sport`, `date`, `court_id`, `joined_players`, `owner_id`, `group_capacity`) VALUES
(1, 'Football', '2023-05-17 18:09:25', 1, 9, 1, 22),
(2, 'Basket', '2023-05-17 18:09:25', 3, 10, 1, 10),
(4, 'Basket', '2023-05-25 15:40:30', 2, 6, 2, 20),
(5, 'Tennis', '2023-05-17 18:21:36', 1, 4, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `owner_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`owner_id`, `name`, `surname`, `email`, `password`) VALUES
(1, 'Megalos', 'Paparas', 'paparas@rikos.gr', '12345678'),
(2, 'mikros', 'Paparikos', 'paparikos@rikos.gr', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rates`
--

CREATE TABLE `rates` (
  `rate` varchar(40) NOT NULL,
  `stars` int(11) NOT NULL,
  `rate_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rates`
--

INSERT INTO `rates` (`rate`, `stars`, `rate_id`, `user_id`) VALUES
('malakas', 5, 1, 1),
('sfafdasfd', 6, 2, 1),
('kalos kalos', 5, 3, 2),
('gamaei', 4, 4, 2),
('kalos kalosklkl', 6, 5, 2),
('gamaei full', 2, 6, 2),
('kalos kalosopopo', 3, 7, 2),
('gamaeighghjjg', 6, 8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sport_center`
--

CREATE TABLE `sport_center` (
  `center_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sport_center`
--

INSERT INTO `sport_center` (`center_id`, `name`, `owner_id`, `address`) VALUES
(1, 'Mpalitsa  center', 1, 'panachaiki 12'),
(2, 'center 2', 2, 'address 23');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `phone`, `address`, `password`) VALUES
(1, 'giio', 'stergos@gmail.com', '6969696969', 'pipa2', 'stergos'),
(2, 'paparas', 'giannissk@gmail.com', '696969696969', '5353', 'malakas22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `belongs_to`
--
ALTER TABLE `belongs_to`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `court_id` (`court_id`);

--
-- Indexes for table `court`
--
ALTER TABLE `court`
  ADD PRIMARY KEY (`court_id`),
  ADD KEY `center_court` (`sport_center_id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`group_id`),
  ADD KEY `group_owner` (`court_id`),
  ADD KEY `group_center` (`owner_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`owner_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `rates`
--
ALTER TABLE `rates`
  ADD PRIMARY KEY (`rate_id`);

--
-- Indexes for table `sport_center`
--
ALTER TABLE `sport_center`
  ADD PRIMARY KEY (`center_id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `court`
--
ALTER TABLE `court`
  MODIFY `court_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `owner_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rates`
--
ALTER TABLE `rates`
  MODIFY `rate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `sport_center`
--
ALTER TABLE `sport_center`
  MODIFY `center_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `belongs_to`
--
ALTER TABLE `belongs_to`
  ADD CONSTRAINT `court_has` FOREIGN KEY (`court_id`) REFERENCES `court` (`court_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_belongs` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `court`
--
ALTER TABLE `court`
  ADD CONSTRAINT `center_court` FOREIGN KEY (`sport_center_id`) REFERENCES `sport_center` (`center_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `group_center` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_owner` FOREIGN KEY (`court_id`) REFERENCES `court` (`court_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sport_center`
--
ALTER TABLE `sport_center`
  ADD CONSTRAINT `owner_center` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
