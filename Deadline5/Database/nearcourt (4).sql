-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1:3306
-- Χρόνος δημιουργίας: 03 Ιουν 2023 στις 09:43:47
-- Έκδοση διακομιστή: 8.0.31
-- Έκδοση PHP: 8.0.26

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

DROP TABLE IF EXISTS `belongs_to`;
CREATE TABLE IF NOT EXISTS `belongs_to` (
  `user_id` int NOT NULL,
  `court_id` int NOT NULL,
  `group_id` int NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `court_id` (`court_id`),
  KEY `group_id` (`group_id`),
  KEY `group_id_2` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `belongs_to`
--

INSERT INTO `belongs_to` (`user_id`, `court_id`, `group_id`) VALUES
(3, 1, 8),
(3, 1, 18),
(2, 2, 18);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `court`
--

DROP TABLE IF EXISTS `court`;
CREATE TABLE IF NOT EXISTS `court` (
  `court_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `sport_center_id` int NOT NULL,
  `sport` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `capacity` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`court_id`),
  KEY `center_court` (`sport_center_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Δομή πίνακα για τον πίνακα `friend_req`
--

DROP TABLE IF EXISTS `friend_req`;
CREATE TABLE IF NOT EXISTS `friend_req` (
  `request_id` int NOT NULL,
  `sender_id` int NOT NULL,
  `receiver_id` int NOT NULL,
  `Accept` enum('yes','no') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'no'
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

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `sport` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `date` date NOT NULL,
  `court_id` int NOT NULL,
  `joined_players` int NOT NULL,
  `owner_id` int NOT NULL,
  `group_capacity` int NOT NULL,
  `type` enum('private','public') COLLATE utf8mb4_general_ci NOT NULL,
  `time` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `group_owner` (`court_id`),
  KEY `group_center` (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `groups`
--

INSERT INTO `groups` (`group_id`, `sport`, `date`, `court_id`, `joined_players`, `owner_id`, `group_capacity`, `type`, `time`) VALUES
(1, 'Football', '2023-05-17', 1, 9, 1, 22, 'private', ''),
(2, 'Basket', '2023-05-17', 3, 10, 2, 10, 'private', ''),
(5, 'Tennis', '2023-05-17', 1, 4, 1, 4, 'private', ''),
(7, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(8, 'Football', '2023-05-31', 1, 2, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(9, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 17:00-18:00'),
(10, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(11, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(12, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 17:00-18:00'),
(13, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(14, 'Football', '2023-05-31', 1, 1, 3, 2, 'private', 'Agia Stadium 17:00-18:00'),
(15, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00'),
(16, 'Football', '2023-05-31', 1, 1, 3, 5, 'private', 'Agia Stadium 17:00-18:00'),
(17, 'Football', '2023-05-31', 1, 1, 3, 3, 'private', 'Agia Stadium 18:00-19:00'),
(18, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00'),
(19, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00'),
(20, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 17:00-18:00'),
(21, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 17:00-18:00'),
(22, 'Football', '2023-05-31', 1, 1, 3, 3, 'private', 'Agia Stadium 18:00-19:00'),
(23, 'Football', '2023-05-31', 1, 1, 3, 2, 'private', 'Agia Stadium 17:00-18:00'),
(24, 'Football', '2023-05-31', 1, 1, 3, 3, 'public', 'Agia Stadium 18:00-19:00'),
(25, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 17:00-18:00'),
(26, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00'),
(27, 'Football', '2023-05-31', 2, 1, 3, 1, 'private', 'Bahamas 18:00-19:00'),
(28, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 17:00-18:00'),
(29, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 18:00-19:00'),
(30, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 17:00-18:00'),
(31, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00'),
(32, 'Football', '2023-05-31', 1, 1, 3, 1, 'private', 'Agia Stadium 17:00-18:00'),
(33, 'Football', '2023-05-31', 1, 1, 3, 4, 'private', 'Agia Stadium 18:00-19:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `history`
--

DROP TABLE IF EXISTS `history`;
CREATE TABLE IF NOT EXISTS `history` (
  `player` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
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

DROP TABLE IF EXISTS `notifications`;
CREATE TABLE IF NOT EXISTS `notifications` (
  `notification_id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'You have a group at:',
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `notifications`
--

INSERT INTO `notifications` (`notification_id`, `date`, `text`, `user_id`, `group_id`) VALUES
(1, '0000-00-00', 'ayrio mpala', 3, 0),
(2, '2023-05-31', 'You have a group at:', 3, 0),
(3, '2023-05-31', 'You have a group at:', 3, 0),
(4, '2023-05-17', 'You have a group at:', 1, 0),
(13, '2023-05-31', 'You have a group at:', 3, 15);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `owner`
--

DROP TABLE IF EXISTS `owner`;
CREATE TABLE IF NOT EXISTS `owner` (
  `owner_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `surname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(12, 3, 20);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `rates`
--

DROP TABLE IF EXISTS `rates`;
CREATE TABLE IF NOT EXISTS `rates` (
  `rate` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `stars` int NOT NULL,
  `rate_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `rates`
--

INSERT INTO `rates` (`rate`, `stars`, `rate_id`, `user_id`) VALUES
('malakas', 5, 1, 1),
('kalosssss', 6, 2, 1),
('kalos kalos', 5, 3, 2),
('xasths', 4, 4, 2),
('kalos kalosklkl', 6, 5, 2),
('palikaros', 2, 6, 2),
('o neymar', 3, 7, 2),
('apaixtos', 6, 8, 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `res_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `court_id` int NOT NULL,
  `time` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `reservation`
--

INSERT INTO `reservation` (`res_id`, `user_id`, `court_id`, `time`) VALUES
(1, 2, 3, 'Lolen Stadium 18:00-19:00'),
(2, 3, 1, 'Agia Stadium 20:00-21:00'),
(3, 3, 2, 'Bahamas 18:00-19:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sport_center`
--

DROP TABLE IF EXISTS `sport_center`;
CREATE TABLE IF NOT EXISTS `sport_center` (
  `center_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `owner_id` int NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`center_id`),
  KEY `owner_id` (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE IF NOT EXISTS `timetable` (
  `ttid` int NOT NULL AUTO_INCREMENT,
  `court_id` int NOT NULL,
  `court_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `time` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `court_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Availability` int NOT NULL,
  `date` date DEFAULT NULL,
  `number_of_players` int NOT NULL,
  PRIMARY KEY (`ttid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `timetable`
--

INSERT INTO `timetable` (`ttid`, `court_id`, `court_name`, `time`, `court_type`, `Availability`, `date`, `number_of_players`) VALUES
(1, 1, 'Agia Stadium', 'Agia Stadium 17:00-18:00', 'Football', 1, '2023-05-31', 5),
(2, 1, 'Agia Stadium', 'Agia Stadium 18:00-19:00', 'Football', 1, '2023-05-31', 10),
(3, 1, 'Agia Stadium', 'Agia Stadium 20:00-21:00', 'Football', 1, NULL, 0),
(4, 2, 'Bahamas', 'Bahamas 16:00-17:00', 'Football', 0, NULL, 0),
(5, 2, 'Bahamas', 'Bahamas 18:00-19:00', 'Football', 0, '2023-05-31', 2),
(6, 3, 'Lolen Stadium', 'Lolen Stadium 18:00-19:00', 'Football', 0, NULL, 0),
(7, 3, 'Lolen Stadium', 'Lolen Stadium 19:00-20:00', 'Football', 0, NULL, 0),
(8, 3, 'Lolen Stadium', 'Lolen Stadium 20:00-21:00', 'Football', 0, NULL, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `phone`, `address`, `password`, `admin`) VALUES
(1, 'giio', 'stergos@gmail.com', '6969696969', 'pipa2', 'stergos', 0),
(2, 'giannis33', 'giannissk@gmail.com', '696969696969', '5353', 'giannis44', 0),
(3, 'user', '', '123456555454', 'ghvjm', '', 0),
(7, 'user2', 'user2@', NULL, NULL, '', 1),
(10, 'userr', 'sdgsgdsgdgsd', 'tegsg', 'fffsasfa', '', 0);

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
