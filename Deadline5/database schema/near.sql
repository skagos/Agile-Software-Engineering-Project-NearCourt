-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1:3306
-- Χρόνος δημιουργίας: 23 Μάη 2023 στις 17:24:50
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
-- Βάση δεδομένων: `near`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `belongs_to`
--

DROP TABLE IF EXISTS `belongs_to`;
CREATE TABLE IF NOT EXISTS `belongs_to` (
  `user_id` int NOT NULL,
  `court_id` int NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `court_id` (`court_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `belongs_to`
--

INSERT INTO `belongs_to` (`user_id`, `court_id`) VALUES
(1, 1),
(1, 1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `court`
--

DROP TABLE IF EXISTS `court`;
CREATE TABLE IF NOT EXISTS `court` (
  `court_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sport_center_id` int NOT NULL,
  `sport` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `capacity` int NOT NULL,
  PRIMARY KEY (`court_id`),
  KEY `center_court` (`sport_center_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `court`
--

INSERT INTO `court` (`court_id`, `name`, `sport_center_id`, `sport`, `capacity`) VALUES
(1, 'court 1', 2, 'Football', 10),
(2, 'court 2', 2, 'Basket', 10),
(3, 'court 3', 1, 'Football', 10),
(4, 'court 4', 1, 'Basket', 10);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sport` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `court_id` int NOT NULL,
  `players` int NOT NULL,
  `owner_id` int NOT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_owner` (`court_id`),
  KEY `group_center` (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `groups`
--

INSERT INTO `groups` (`id`, `sport`, `date`, `court_id`, `players`, `owner_id`, `time`) VALUES
(1, 'Football', '2023-05-17', 1, 2, 1, '00:00:00'),
(2, 'Basket', '2023-05-17', 3, 3, 1, '00:00:00'),
(5, 'Tennis', '2023-05-17', 1, 2, 1, '00:00:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `owner`
--

DROP TABLE IF EXISTS `owner`;
CREATE TABLE IF NOT EXISTS `owner` (
  `owner_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `owner`
--

INSERT INTO `owner` (`owner_id`, `name`, `surname`, `email`, `password`) VALUES
(1, 'Megalos', 'Paparas', 'paparas@rikos.gr', '12345678'),
(2, 'mikros', 'Paparikos', 'paparikos@rikos.gr', '12345678');

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
('sfafdasfd', 6, 2, 1),
('kalos kalos', 5, 3, 2),
('gamaei', 4, 4, 2),
('kalos kalosklkl', 6, 5, 2),
('gamaei full', 2, 6, 2),
('kalos kalosopopo', 3, 7, 2),
('gamaeighghjjg', 6, 8, 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sport_center`
--

DROP TABLE IF EXISTS `sport_center`;
CREATE TABLE IF NOT EXISTS `sport_center` (
  `center_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `owner_id` int NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`center_id`),
  KEY `owner_id` (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Άδειασμα δεδομένων του πίνακα `sport_center`
--

INSERT INTO `sport_center` (`center_id`, `name`, `owner_id`, `address`) VALUES
(1, 'Mpalitsa  center', 1, 'panachaiki 12'),
(2, 'center 2', 2, 'address 23');

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
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `phone`, `address`, `password`) VALUES
(1, 'giio', 'stergos@gmail.com', '6969696969', 'pipa2', 'stergos'),
(2, 'malakas', 'giannissk@gmail.com', '696969696969', '5353', 'giannis');

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `belongs_to`
--
ALTER TABLE `belongs_to`
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
