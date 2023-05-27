-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 27 Μάη 2023 στις 18:15:50
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
-- Βάση δεδομένων: `nearcourtdatabase`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `belongs_to`
--

CREATE TABLE `belongs_to` (
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `groups_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `belongs_to`
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
-- Δομή πίνακα για τον πίνακα `groupp`
--

CREATE TABLE `groupp` (
  `type` enum('private','public') NOT NULL,
  `sport` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(255) DEFAULT NULL,
  `number_of_players` int(11) NOT NULL,
  `player_id` int(255) NOT NULL,
  `ready` tinyint(4) DEFAULT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `groupp`
--

INSERT INTO `groupp` (`type`, `sport`, `date`, `time`, `number_of_players`, `player_id`, `ready`, `group_id`) VALUES
('private', 'Football', '2023-05-31', 'Agia Stadium 18:00-19:00', 10, 5, NULL, 1),
('private', 'Football', '2023-05-31', 'Bahamas 18:00-19:00', 3, 5, NULL, 2),
('public', 'Football', '2023-05-31', 'Agia Stadium 18:00-19:00', 2, 5, NULL, 4),
('private', 'Football', '2023-05-31', 'Agia Stadium 17:00-18:00', 2, 5, NULL, 5),
('private', 'Football', '2023-05-31', 'Agia Stadium 17:00-18:00', 1, 5, NULL, 7),
('private', 'Football', '2023-05-31', 'Agia Stadium 18:00-19:00', 1, 5, NULL, 8),
('private', 'Football', '2023-05-31', 'Agia Stadium 17:00-18:00', 1, 5, NULL, 9),
('private', 'Football', '2023-05-31', 'Bahamas 18:00-19:00', 1, 5, NULL, 10),
('private', 'Football', '2023-05-31', 'Agia Stadium 17:00-18:00', 2, 5, NULL, 11);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `groups`
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
-- Άδειασμα δεδομένων του πίνακα `groups`
--

INSERT INTO `groups` (`group_id`, `sport`, `date`, `court_id`, `joined_players`, `owner_id`, `group_capacity`) VALUES
(1, 'Football', '2023-05-17 18:09:25', 1, 9, 1, 22),
(2, 'Basket', '2023-05-17 18:09:25', 3, 10, 1, 10),
(4, 'Basket', '2023-05-25 15:40:30', 2, 6, 2, 20),
(5, 'Tennis', '2023-05-17 18:21:36', 1, 4, 1, 4);

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
(1, 'Megalos', 'Paparas', 'paparas@rikos.gr', '12345678'),
(2, 'mikros', 'Paparikos', 'paparikos@rikos.gr', '12345678');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `rates`
--

CREATE TABLE `rates` (
  `user_id` int(10) NOT NULL,
  `rate` varchar(220) NOT NULL,
  `stars` enum('0.5','1','1.5','2','2.5','3','3.5','4','4.5','5') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `rates`
--

INSERT INTO `rates` (`user_id`, `rate`, `stars`) VALUES
(1, 'kalos malakas einai', '2'),
(2, 'megalos malakas respect', '4.5'),
(1, 'kalos', '3.5');

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
(1, 1, 'Agia Stadium', 'Agia Stadium 17:00-18:00', 'Football', 0, '2023-05-31', 5),
(2, 1, 'Agia Stadium', 'Agia Stadium 18:00-19:00', 'Football', 0, '2023-05-31', 10),
(3, 1, 'Agia Stadium', 'Agia Stadium 20:00-21:00', 'Football', 0, NULL, 0),
(4, 2, 'Bahamas', 'Bahamas 16:00-17:00', 'Football', 0, NULL, 0),
(5, 2, 'Bahamas', 'Bahamas 18:00-19:00', 'Football', 0, '2023-05-31', 2),
(6, 3, 'Lolen Stadium', 'Lolen Stadium 18:00-19:00', 'Football', 0, NULL, 0),
(7, 3, 'Lolen Stadium', 'Lolen Stadium 19:00-20:00', 'Football', 0, NULL, 0),
(8, 3, 'Lolen Stadium', 'Lolen Stadium 20:00-21:00', 'Football', 0, NULL, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `email`, `username`, `password`) VALUES
(1, 'kapa@gmail.com', 'malakas', ''),
(2, 'kapa2@gmail.com', 'malakas2', ''),
(5, 'opa@gmail.com', 'opas', 'John2001!');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `groupp`
--
ALTER TABLE `groupp`
  ADD PRIMARY KEY (`group_id`);

--
-- Ευρετήρια για πίνακα `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- Ευρετήρια για πίνακα `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`ttid`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `groupp`
--
ALTER TABLE `groupp`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT για πίνακα `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT για πίνακα `timetable`
--
ALTER TABLE `timetable`
  MODIFY `ttid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
