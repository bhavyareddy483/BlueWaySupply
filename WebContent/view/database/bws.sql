-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 03:56 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bws`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` varchar(50) DEFAULT NULL,
  `product_id` varchar(50) NOT NULL,
  `quality` int(50) DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `customer_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cart_id`, `product_id`, `quality`, `Total`, `customer_id`) VALUES
(NULL, '1ltbls20', 10, 200, 'gopal@gmail.com'),
(NULL, '1ltbls20', 5, 100, 'shilpa@gmail.com'),
(NULL, '1ltbls20', 10, 200, '1'),
(NULL, '1ltbls20', 20, 400, '1'),
(NULL, '500mlbls15', 10, 150, '1'),
(NULL, '1ltbls20', 10, 200, 'Kalai@gmail.com'),
(NULL, '1ltbls20', 4, 80, 'sir@gmail.com'),
(NULL, '20litrAquasure', 10, 700, 'sandhya@gmail.com'),
(NULL, 'Blue Heavens 20 ltr', 1, 70, '1');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` varchar(50) NOT NULL,
  `custname` varchar(50) NOT NULL,
  `custaddress` varchar(100) NOT NULL,
  `custphoneno` varchar(20) NOT NULL,
  `custaltphoneno` varchar(20) NOT NULL,
  `custemail` varchar(50) NOT NULL,
  `custgender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `custname`, `custaddress`, `custphoneno`, `custaltphoneno`, `custemail`, `custgender`) VALUES
('Maria@gmail.com', 'Maria abc', 'Kothanur', '8892399063', '7204899071', 'Maria@gmail.com', 'female'),
('gopal@gmail.com', 'Gopal', 'Banaswadi', '8892399063', '7204899071', 'gopal@gmail.com', 'male'),
('shilpa@gmail.com', 'Shilpa', 'Horamavu', '9876554334', '8867564231', 'shilpa@gmail.com', 'female'),
('Kalai@gmail.com', 'Kalai', 'Veeranapalya', '8296641020', '8892399063', 'Kalai@gmail.com', 'female');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL,
  `customer_id` varchar(50) NOT NULL,
  `usermail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`login_id`, `customer_id`, `usermail`, `password`) VALUES
(28, 'ABC@gmail.com', 'ABC@gmail.com', '123456'),
(24, 'admin@gmail.com', 'admin@gmail.com', 'Admin@123'),
(26, 'gopal@gmail.com', 'gopal@gmail.com', 'gopal'),
(29, 'Kalai@gmail.com', 'Kalai@gmail.com', 'Kalai@123'),
(23, 'Maria@gmail.com', 'Maria@gmail.com', 'Mari'),
(15, 'sandhya@gmail.com', 'sandhya@gmail.com', '123'),
(27, 'shilpa@gmail.com', 'shilpa@gmail.com', 'shilpa121096');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` varchar(50) NOT NULL,
  `producttype` varchar(50) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `productprice` float NOT NULL,
  `productimage` varchar(50) NOT NULL,
  `productdescription` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `producttype`, `productname`, `productprice`, `productimage`, `productdescription`) VALUES
('1ltbls20', 'bottle', '1 LITRE WATER BOTTLES', 20, 'aquafina-1-liter-mineral-water.png', 'Aquafina goes through a five step state-of-the-art purification process to give consumers pure water'),
('20litrAquasure', 'can', 'Aquasure 20 Litre Water Can', 70, 'Aquasure_20lit water.jpg', 'Aquasure 20 Litre Water Can ? Packaged Drinking Water ? Mineral Water Can.'),
('250mlbls10', 'bottle', '250 ml WATER BOTTLE', 10, 'bisleri_250ml_mineral_water_bottle.png', '250ml Bisleri Mineral Water Bottle ? It comes in pack of 48 bottles per Carton.'),
('500mlbls15', 'bottle', '500ML WATER BOTTLES ', 15, 'bisleri_500ml_mineral_water_bottle.png', '500ml Bisleri Water Bottle ? Carton of 24 bottles.'),
('Blue Heavens 1 ltr', 'Bottle', '1 ltr Blue Heaven', 25, 'bisleri_250ml_mineral_water_bottle.png', 'Purified'),
('Blue Heavens 20 ltr', 'can', '20 ltr Blue Heaven', 70, 'packaged-drinking-water-jar-500x500.jpg', 'this is Blue way can');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD UNIQUE KEY `cart_id` (`cart_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `login_id` (`login_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `login` (`customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
