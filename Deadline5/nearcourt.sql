-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 04 Ιουν 2023 στις 18:03:37
-- Έκδοση διακομιστή: 10.4.27-MariaDB
-- Έκδοση PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `nearcourt`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `belongs_to`
--

CREATE TABLE `belongs_to` (
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `belongs_to`
--

INSERT INTO `belongs_to` (`user_id`, `court_id`, `group_id`) VALUES
(1, 2, 45),
(1, 2, 45),
(1, 2, 45),
(1, 1, 34),
(1, 2, 51),
(1, 3, 38),
(2, 2, 51),
(2, 4, 39),
(2, 2, 49),
(2, 4, 48),
(2, 1, 50),
(7, 3, 38),
(7, 2, 47),
(7, 4, 42),
(7, 4, 42),
(7, 4, 42),
(7, 1, 43),
(7, 4, 37),
(7, 2, 47),
(10, 2, 45),
(10, 4, 39),
(10, 4, 40),
(10, 4, 40),
(10, 4, 41),
(10, 4, 41),
(10, 2, 52),
(10, 2, 35);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `court`
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
-- Άδειασμα δεδομένων του πίνακα `court`
--

INSERT INTO `court` (`court_id`, `name`, `sport_center_id`, `sport`, `capacity`, `price`) VALUES
(1, 'court 1', 2, 'Football', 10, 10),
(2, 'court 2', 2, 'Basket', 10, 20),
(3, 'court 3', 1, 'Football', 10, 30),
(4, 'court 4', 1, 'Basket', 10, 20);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `courts_rate`
--

CREATE TABLE `courts_rate` (
  `rate_id` int(11) NOT NULL,
  `stars` int(11) NOT NULL,
  `rate` varchar(255) NOT NULL,
  `court_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `courts_rate`
--

INSERT INTO `courts_rate` (`rate_id`, `stars`, `rate`, `court_id`) VALUES
(1, 4, 'Write your rate', 1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `friend_req`
--

CREATE TABLE `friend_req` (
  `request_id` int(11) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `Accept` enum('yes','no') NOT NULL DEFAULT 'no'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `friend_req`
--

INSERT INTO `friend_req` (`request_id`, `sender_id`, `receiver_id`, `Accept`) VALUES
(1, 2, 1, 'no'),
(2, 2, 1, 'no'),
(3, 2, 1, 'no');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `groups`
--

CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL,
  `sport` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `court_id` int(11) NOT NULL,
  `joined_players` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `group_capacity` int(11) NOT NULL,
  `type` enum('private','public') NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `groups`
--

INSERT INTO `groups` (`group_id`, `sport`, `date`, `court_id`, `joined_players`, `owner_id`, `group_capacity`, `type`, `time`) VALUES
(34, 'Football', '2023-05-31', 1, 2, 2, 10, 'private', 'Agia Stadium 18:00-19:00'),
(35, 'Basket', '2023-07-01', 2, 2, 7, 1, 'private', 'Agios Alexios 19:00-20:00'),
(36, 'Basket', '2023-07-01', 4, 1, 7, 1, 'private', 'Agios Alexios 2 20:00-21:00'),
(37, 'Football', '2023-07-01', 4, 2, 7, 1, 'private', 'kaltseto 20:00-21:00'),
(38, 'Football', '2023-07-01', 3, 3, 7, 2, 'private', 'kaltseto 18:00-19:00'),
(39, 'Basket', '2023-07-01', 4, 3, 7, 2, 'private', 'Agios Alexios 2 15:00-15:00'),
(40, 'Basket', '2023-07-01', 4, 2, 1, 2, 'public', 'Agios Alexios 2 18:00-19:00'),
(41, 'Basket', '2023-07-01', 4, 2, 1, 4, 'public', 'Agios Alexios 2 16:00-17:00'),
(42, 'Football', '2023-07-01', 4, 2, 1, 4, 'public', 'kaltseto 19:00-20:00'),
(43, 'Football', '2023-07-04', 1, 2, 1, 1, 'public', 'kaltseto 15:00-15:00'),
(44, 'Basket', '2023-07-05', 4, 1, 2, 1, 'private', 'Agios Alexios 2 19:00-20:00'),
(45, 'Basket', '2023-07-01', 2, 3, 2, 1, 'private', 'Agios Alexios 16:00-17:00'),
(46, 'Basket', '2023-07-01', 2, 1, 2, 1, 'private', 'Agios Alexios 15:00-15:00'),
(47, 'Basket', '2023-07-01', 2, 3, 2, 1, 'private', 'Agios Alexios 20:00-21:00'),
(48, 'Football', '2023-07-01', 4, 2, 10, 1, 'public', 'kaltseto 16:00-17:00'),
(49, 'Football', '2023-05-31', 2, 2, 10, 1, 'private', 'Bahamas 18:00-19:00'),
(50, 'Football', '2023-05-31', 1, 2, 10, 2, 'private', 'Agia Stadium 17:00-18:00'),
(51, 'Basket', '2023-07-01', 2, 3, 10, 2, 'private', 'Agios Alexios 18:00-19:00'),
(52, 'Basket', '2023-07-01', 2, 2, 10, 2, 'private', 'Agios Alexios 17:00-18:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `history`
--

CREATE TABLE `history` (
  `player` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `history`
--

INSERT INTO `history` (`player`) VALUES
('tania'),
('giwrgis'),
('nikos'),
('thanos'),
('ilias'),
('lakis');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `notifications`
--

CREATE TABLE `notifications` (
  `notification_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `text` varchar(255) DEFAULT 'You have a group at:',
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `notifications`
--

INSERT INTO `notifications` (`notification_id`, `date`, `text`, `user_id`, `group_id`) VALUES
(1, '0000-00-00', 'ayrio mpala', 3, 0),
(2, '2023-05-31', 'You have a group at:', 3, 0),
(3, '2023-05-31', 'You have a group at:', 3, 0),
(4, '2023-05-17', 'You have a group at:', 1, 0),
(13, '2023-05-31', 'You have a group at:', 3, 15),
(18, '2023-05-31', 'You have a group at:', 2, 34),
(19, '2023-07-01', 'You have a group at:', 7, 35),
(20, '2023-07-01', 'You have a group at:', 7, 36),
(21, '2023-07-01', 'You have a group at:', 7, 37),
(22, '2023-07-01', 'You have a group at:', 7, 38),
(23, '2023-07-01', 'You have a group at:', 7, 39),
(24, '2023-07-01', 'You have a group at:', 1, 0),
(25, '2023-07-01', 'You have a group at:', 1, 0),
(26, '2023-07-01', 'You have a group at:', 1, 0),
(27, '2023-07-04', 'You have a group at:', 1, 0),
(28, '2023-07-05', 'You have a group at:', 2, 44),
(29, '2023-07-01', 'You have a group at:', 2, 45),
(30, '2023-07-01', 'You have a group at:', 2, 46),
(31, '2023-07-01', 'You have a group at:', 2, 47),
(32, '2023-07-01', 'You have a group at:', 10, 0),
(33, '2023-05-31', 'You have a group at:', 10, 49),
(34, '2023-05-31', 'You have a group at:', 10, 50),
(35, '2023-07-01', 'You have a group at:', 10, 51),
(36, '2023-07-01', 'You have a group at:', 10, 52),
(37, '2023-07-01', 'You have a group at:', 1, 45),
(38, '2023-07-01', 'You have a group at:', 1, 45),
(39, '2023-07-01', 'You have a group at:', 1, 45),
(40, '2023-05-31', 'You have a group at:', 1, 34),
(41, '2023-07-01', 'You have a group at:', 1, 51),
(42, '2023-07-01', 'You have a group at:', 1, 38),
(43, '2023-07-01', 'You have a group at:', 2, 51),
(44, '2023-07-01', 'You have a group at:', 2, 39),
(45, '2023-05-31', 'You have a group at:', 2, 49),
(46, '2023-07-01', 'You have a group at:', 2, 48),
(47, '2023-05-31', 'You have a group at:', 2, 50),
(48, '2023-07-01', 'You have a group at:', 7, 38),
(49, '2023-07-01', 'You have a group at:', 7, 47),
(50, '2023-07-01', 'You have a group at:', 7, 42),
(51, '2023-07-01', 'You have a group at:', 7, 42),
(52, '2023-07-01', 'You have a group at:', 7, 42),
(53, '2023-07-04', 'You have a group at:', 7, 43),
(54, '2023-07-01', 'You have a group at:', 7, 37),
(55, '2023-07-01', 'You have a group at:', 7, 47),
(56, '2023-07-01', 'You have a group at:', 10, 45),
(57, '2023-07-01', 'You have a group at:', 10, 39),
(58, '2023-07-01', 'You have a group at:', 10, 40),
(59, '2023-07-01', 'You have a group at:', 10, 40),
(60, '2023-07-01', 'You have a group at:', 10, 41),
(61, '2023-07-01', 'You have a group at:', 10, 41),
(62, '2023-07-01', 'You have a group at:', 10, 52),
(63, '2023-07-01', 'You have a group at:', 10, 35);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `owner`
--

CREATE TABLE `owner` (
  `owner_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `owner`
--

INSERT INTO `owner` (`owner_id`, `name`, `surname`, `email`, `password`) VALUES
(1, 'hlias', 'papas', 'rixtohlia@gmail.com', '12345678'),
(2, 'stathis', 'vretos', 'haris@yahoo.gr', '12345678');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `payment`
--

INSERT INTO `payment` (`payment_id`, `user_id`, `amount`) VALUES
(1, 1, 0.454545),
(2, 3, 2.5),
(3, 3, 0.454545),
(4, 3, 10),
(5, 3, 2.5),
(6, 3, 2.5),
(7, 3, 10),
(8, 3, 10),
(9, 3, 0.454545),
(10, 3, 0.454545),
(11, 3, 2.5),
(12, 3, 20),
(13, 1, 1),
(14, 1, 10),
(15, 1, 15),
(16, 2, 10),
(17, 2, 10),
(18, 2, 20),
(19, 2, 5),
(20, 7, 15),
(21, 7, 20),
(22, 7, 20),
(23, 7, 20),
(24, 10, 20),
(25, 10, 10),
(26, 10, 10),
(27, 10, 20);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `rates`
--

CREATE TABLE `rates` (
  `rate` varchar(40) NOT NULL,
  `stars` int(11) NOT NULL,
  `rate_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `reservation`
--

CREATE TABLE `reservation` (
  `res_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `reservation`
--

INSERT INTO `reservation` (`res_id`, `user_id`, `court_id`, `time`) VALUES
(1, 2, 3, 'Lolen Stadium 18:00-19:00'),
(2, 3, 1, 'Agia Stadium 20:00-21:00'),
(3, 3, 2, 'Bahamas 18:00-19:00'),
(4, 3, 2, 'Bahamas 18:00-19:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sport_center`
--

CREATE TABLE `sport_center` (
  `center_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `sport_center`
--

INSERT INTO `sport_center` (`center_id`, `name`, `owner_id`, `address`) VALUES
(1, 'Mpalitsa  center', 1, 'panachaiki 12'),
(2, 'center 2', 2, 'address 23');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `timetable`
--

CREATE TABLE `timetable` (
  `ttid` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `court_name` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `court_type` varchar(255) NOT NULL,
  `Availability` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `number_of_players` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `timetable`
--

INSERT INTO `timetable` (`ttid`, `court_id`, `court_name`, `time`, `court_type`, `Availability`, `date`, `number_of_players`) VALUES
(1, 1, 'Agia Stadium', 'Agia Stadium 17:00-18:00', 'Football', 1, '2023-05-31', 5),
(2, 1, 'Agia Stadium', 'Agia Stadium 18:00-19:00', 'Football', 1, '2023-05-31', 10),
(3, 1, 'Agia Stadium', 'Agia Stadium 20:00-21:00', 'Football', 0, '2023-06-21', 0),
(4, 2, 'Bahamas', 'Bahamas 16:00-17:00', 'Football', 0, '2023-06-29', 0),
(5, 2, 'Bahamas', 'Bahamas 18:00-19:00', 'Football', 1, '2023-05-31', 2),
(6, 3, 'Lolen Stadium', 'Lolen Stadium 18:00-19:00', 'Football', 0, '2023-06-28', 0),
(7, 3, 'Lolen Stadium', 'Lolen Stadium 19:00-20:00', 'Football', 0, '2023-06-29', 0),
(8, 3, 'Lolen Stadium', 'Lolen Stadium 20:00-21:00', 'Football', 0, '2023-06-29', 0),
(9, 2, 'Agios Alexios', 'Agios Alexios 17:00-18:00', 'Basket', 1, '2023-07-01', 10),
(10, 2, 'Agios Alexios', 'Agios Alexios 18:00-19:00', 'Basket', 1, '2023-07-01', 10),
(11, 2, 'Agios Alexios', 'Agios Alexios 19:00-20:00', 'Basket', 1, '2023-07-01', 10),
(12, 2, 'Agios Alexios', 'Agios Alexios 20:00-21:00', 'Basket', 1, '2023-07-01', 10),
(13, 2, 'Agios Alexios', 'Agios Alexios 16:00-17:00', 'Basket', 1, '2023-07-01', 10),
(14, 2, 'Agios Alexios', 'Agios Alexios 15:00-15:00', 'Basket', 1, '2023-07-01', 10),
(15, 4, 'Agios Alexios 2', 'Agios Alexios 2 18:00-19:00', 'Basket', 1, '2023-07-01', 10),
(16, 4, 'Agios Alexios 2', 'Agios Alexios 2 19:00-20:00', 'Basket', 1, '2023-07-01', 10),
(17, 4, 'Agios Alexios 2', 'Agios Alexios 2 20:00-21:00', 'Basket', 1, '2023-07-01', 10),
(18, 4, 'Agios Alexios 2', 'Agios Alexios 2 16:00-17:00', 'Basket', 1, '2023-07-01', 10),
(19, 4, 'Agios Alexios 2', 'Agios Alexios 2 15:00-15:00', 'Basket', 1, '2023-07-01', 10),
(20, 4, 'Agios Alexios 2', 'Agios Alexios 2 18:00-19:00', 'Basket', 1, '2023-07-02', 10),
(21, 4, 'Agios Alexios 2', 'Agios Alexios 2 19:00-20:00', 'Basket', 1, '2023-07-02', 10),
(22, 4, 'Agios Alexios 2', 'Agios Alexios 2 20:00-21:00', 'Basket', 1, '2023-07-02', 10),
(23, 4, 'Agios Alexios 2', 'Agios Alexios 2 16:00-17:00', 'Basket', 1, '2023-07-02', 10),
(24, 4, 'Agios Alexios 2', 'Agios Alexios 2 15:00-15:00', 'Basket', 1, '2023-07-02', 10),
(25, 4, 'Agios Alexios 2', 'Agios Alexios 2 18:00-19:00', 'Basket', 1, '2023-07-03', 10),
(26, 4, 'Agios Alexios 2', 'Agios Alexios 2 19:00-20:00', 'Basket', 1, '2023-07-03', 10),
(27, 4, 'Agios Alexios 2', 'Agios Alexios 2 20:00-21:00', 'Basket', 1, '2023-07-03', 10),
(28, 4, 'Agios Alexios 2', 'Agios Alexios 2 16:00-17:00', 'Basket', 1, '2023-07-03', 10),
(29, 4, 'Agios Alexios 2', 'Agios Alexios 2 15:00-15:00', 'Basket', 1, '2023-07-03', 10),
(30, 4, 'Agios Alexios 2', 'Agios Alexios 2 18:00-19:00', 'Basket', 1, '2023-07-04', 10),
(31, 4, 'Agios Alexios 2', 'Agios Alexios 2 19:00-20:00', 'Basket', 1, '2023-07-04', 10),
(32, 4, 'Agios Alexios 2', 'Agios Alexios 2 20:00-21:00', 'Basket', 1, '2023-07-04', 10),
(33, 4, 'Agios Alexios 2', 'Agios Alexios 2 16:00-17:00', 'Basket', 1, '2023-07-04', 10),
(34, 4, 'Agios Alexios 2', 'Agios Alexios 2 15:00-15:00', 'Basket', 1, '2023-07-04', 10),
(35, 4, 'Agios Alexios 2', 'Agios Alexios 2 18:00-19:00', 'Basket', 1, '2023-07-05', 10),
(36, 4, 'Agios Alexios 2', 'Agios Alexios 2 19:00-20:00', 'Basket', 1, '2023-07-05', 10),
(37, 4, 'Agios Alexios 2', 'Agios Alexios 2 20:00-21:00', 'Basket', 1, '2023-07-05', 10),
(38, 4, 'Agios Alexios 2', 'Agios Alexios 2 16:00-17:00', 'Basket', 1, '2023-07-05', 10),
(39, 4, 'Agios Alexios 2', 'Agios Alexios 2 15:00-15:00', 'Basket', 1, '2023-07-05', 10),
(40, 3, 'kaltseto', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-01', 10),
(41, 4, 'kaltseto', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-01', 10),
(42, 4, 'kaltseto', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-01', 10),
(43, 4, 'kaltseto', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-01', 10),
(44, 4, 'kaltseto', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-01', 10),
(45, 3, 'kaltseto', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-02', 10),
(46, 4, 'kaltseto', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-02', 10),
(47, 4, 'kaltseto', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-02', 10),
(48, 4, 'kaltseto', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-02', 10),
(49, 4, 'kaltseto', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-02', 10),
(50, 3, 'kaltseto', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-03', 10),
(51, 4, 'kaltseto', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-03', 10),
(52, 4, 'kaltseto', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-03', 10),
(53, 4, 'kaltseto', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-03', 10),
(54, 4, 'kaltseto', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-03', 10),
(55, 3, 'kaltseto', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-04', 10),
(56, 4, 'kaltseto', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-04', 10),
(57, 4, 'kaltseto', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-04', 10),
(58, 4, 'kaltseto', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-04', 10),
(59, 1, 'Kanistras', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-04', 10),
(60, 1, 'Kanistras', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-04', 10),
(61, 1, 'Kanistras', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-04', 10),
(62, 1, 'Kanistras', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-04', 10),
(63, 1, 'Kanistras', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-04', 10),
(64, 1, 'Kanistras', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-04', 10),
(65, 1, 'Kanistras', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-03', 10),
(66, 1, 'Kanistras', 'kaltseto 18:00-19:00', 'Football', 1, '2023-07-03', 10),
(67, 1, 'Kanistras', 'kaltseto 19:00-20:00', 'Football', 1, '2023-07-03', 10),
(68, 1, 'Kanistras', 'kaltseto 20:00-21:00', 'Football', 1, '2023-07-03', 10),
(69, 1, 'Kanistras', 'kaltseto 16:00-17:00', 'Football', 1, '2023-07-03', 10),
(70, 1, 'Kanistras', 'kaltseto 15:00-15:00', 'Football', 1, '2023-07-03', 10);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `phone`, `address`, `password`, `admin`) VALUES
(1, 'stergiou', 'stergosfamily@gmail.com', '6969696969', 'kythairwnos 20', 'stergos001', 0),
(2, 'skagkos', 'johnskagos@gmail.com', '6969696969', 'ellhnos 16', 'skagos001', 0),
(3, 'user', '', '123456555454', 'ghvjm', '', 0),
(7, 'saridakis', 'geosar@gmail.com', '6969696969', 'karolou 50', 'sari001', 0),
(10, 'panselinas', 'steliospans@gmail.com', '6969696969', 'ellhnos 48', 'panselinas001', 0),
(11, 'admin', 'admin@gmail.com', '6969696969', 'admin 23', 'admin001', 1);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `belongs_to`
--
ALTER TABLE `belongs_to`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `court_id` (`court_id`),
  ADD KEY `group_id` (`group_id`),
  ADD KEY `group_id_2` (`group_id`);

--
-- Ευρετήρια για πίνακα `court`
--
ALTER TABLE `court`
  ADD PRIMARY KEY (`court_id`),
  ADD KEY `center_court` (`sport_center_id`);

--
-- Ευρετήρια για πίνακα `courts_rate`
--
ALTER TABLE `courts_rate`
  ADD PRIMARY KEY (`rate_id`),
  ADD KEY `court_id` (`court_id`);

--
-- Ευρετήρια για πίνακα `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`group_id`),
  ADD KEY `group_owner` (`court_id`),
  ADD KEY `group_center` (`owner_id`);

--
-- Ευρετήρια για πίνακα `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`notification_id`);

--
-- Ευρετήρια για πίνακα `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`owner_id`);

--
-- Ευρετήρια για πίνακα `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- Ευρετήρια για πίνακα `rates`
--
ALTER TABLE `rates`
  ADD PRIMARY KEY (`rate_id`);

--
-- Ευρετήρια για πίνακα `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`res_id`);

--
-- Ευρετήρια για πίνακα `sport_center`
--
ALTER TABLE `sport_center`
  ADD PRIMARY KEY (`center_id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Ευρετήρια για πίνακα `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`ttid`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `court`
--
ALTER TABLE `court`
  MODIFY `court_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT για πίνακα `courts_rate`
--
ALTER TABLE `courts_rate`
  MODIFY `rate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT για πίνακα `groups`
--
ALTER TABLE `groups`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT για πίνακα `notifications`
--
ALTER TABLE `notifications`
  MODIFY `notification_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT για πίνακα `owner`
--
ALTER TABLE `owner`
  MODIFY `owner_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT για πίνακα `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT για πίνακα `rates`
--
ALTER TABLE `rates`
  MODIFY `rate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT για πίνακα `reservation`
--
ALTER TABLE `reservation`
  MODIFY `res_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT για πίνακα `sport_center`
--
ALTER TABLE `sport_center`
  MODIFY `center_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT για πίνακα `timetable`
--
ALTER TABLE `timetable`
  MODIFY `ttid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `belongs_to`
--
ALTER TABLE `belongs_to`
  ADD CONSTRAINT `belongs_groupid` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `court_has` FOREIGN KEY (`court_id`) REFERENCES `court` (`court_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_belongs` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Περιορισμοί για πίνακα `court`
--
ALTER TABLE `court`
  ADD CONSTRAINT `center_court` FOREIGN KEY (`sport_center_id`) REFERENCES `sport_center` (`center_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Περιορισμοί για πίνακα `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `group_center` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_owner` FOREIGN KEY (`court_id`) REFERENCES `court` (`court_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Περιορισμοί για πίνακα `sport_center`
--
ALTER TABLE `sport_center`
  ADD CONSTRAINT `owner_center` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
