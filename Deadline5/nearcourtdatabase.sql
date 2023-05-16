-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 16 Μάη 2023 στις 19:43:00
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
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `email`, `username`) VALUES
(1, 'kapa@gmail.com', 'malakas'),
(2, 'kapa2@gmail.com', 'malakas2');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
