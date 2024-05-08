-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 06:32 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ortho`
--

-- --------------------------------------------------------

--
-- Table structure for table `addpatient`
--

CREATE TABLE `addpatient` (
  `name` varchar(30) NOT NULL,
  `age` varchar(7) NOT NULL,
  `ipNumber` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `admission` varchar(5) NOT NULL,
  `occupation` varchar(20) NOT NULL,
  `education` varchar(20) NOT NULL,
  `surgery` varchar(20) NOT NULL,
  `discharge` varchar(20) NOT NULL,
  `socioecStatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addpatient`
--

INSERT INTO `addpatient` (`name`, `age`, `ipNumber`, `address`, `contact`, `admission`, `occupation`, `education`, `surgery`, `discharge`, `socioecStatus`) VALUES
('chandra', '22', '1234', '1/a/123', '1234567890', '234d', 'jkngd ', 'cse', 'vn wgfbd', 'dfbnif', 'qgnyrga'),
('reddy', '22', '1209834576', '12/23/a', '0987654321', '22', 'ifjnv', 'cse', '08', '20', '23ffdb'),
('reddy', '22', '1209834576', '12/23/a', '0987654321', '22', 'ifjnv', 'cse', '08', '20', '23ffdb'),
('', '', '', '', '', '', '', '', '', '', ''),
('yfx', '223', '1234567890', 'kjge', 'jjef', 'rije', '14', 'jhukh', 'kj', 'uhi', 'uhui'),
('reddy', 'male', '0123456789', 'jc', 'jfilr', 'jc', 'wckw', 'hdke', 'ijei', 'jcd', 'ijgt'),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('qw', 'fr', 'gg', 'dfc', 'gf', 'f', 'f', 't', 'gg', 'ty', 'ty'),
('qw', 'fr', 'gg', 'dfc', 'gf', 'f', 'f', 't', 'gg', 'ty', 'ty'),
('gfdbb', 'wret', '123456', 'etgfj', 'rsty', 'gfh', 'gg', 'yu', 'wfd', 'gfh', 'fghgf'),
('gfdbb', 'wret', '123456', 'etgfj', 'rsty', 'gfh', 'gg', 'yu', 'wfd', 'gfh', 'fghgf'),
('', '', '', '', '', '', '', '', '', '', ''),
('reddy', 'male', 'penchala', 'dfd', 'str', 'rdf', 'erf', 'erfg', 'ed', 'ef', 'df'),
('patient', 'male', '111111', 'wereg', 'gj', '04/03', 'wer', 'fg', 'rg', 'asdf', 'ewrt'),
('ganesh', 'male', 'gan1234', 'sdf', '15256', '05/03', 'fv', 'sfg', 'jfnd', '20/03/2024', 'dfg'),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('vundela', '23', '0987654321', 'puj', '1234567890', '25/03', 'stu', 'Be.T', '27/03/2024', '29/03/2024', 'nill'),
('mohan', '22', 'sse1234', '124/ksd', '9934562345', '08/04', 'jkjns', 'jkqkq', '10/04/2024', '15/04/2024', 'kjd'),
('mohan', '22', 'sse1234', '124/ksd', '9934562345', '08/04', 'jkjns', 'jkqkq', '10/04/2024', '15/04/2024', 'kjd'),
('chandra', '20', 'smc12345', 'rajbjfhjehf', '546738297', '30-06', 'famrer', 'rwuhuowjhjof', '6-04-2003', '9-08-2003', 'jgiejfirj'),
('chandra', '20', 'smc12345', 'rajbjfhjehf', '546738297', '30-06', 'famrer', 'rwuhuowjhjof', '6-04-2003', '9-08-2003', 'jgiejfirj'),
('leela', '21', 'simats', 'qsrr', '3698521470', '12/04', 'kjfh', 'be', '15/04/2020', '16/04/2020', 'fgjh'),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', ''),
('vreddy', '20', 'reddy123', 'kjrhw', '234568', '23/25', 'wdfwgihf', 'sjhf', '24/12/2024', '12/13/2024', 'wer');

-- --------------------------------------------------------

--
-- Table structure for table `addpatient2`
--

CREATE TABLE `addpatient2` (
  `id` varchar(100) NOT NULL,
  `1a` varchar(100) NOT NULL,
  `1b` varchar(100) NOT NULL,
  `1c` varchar(100) NOT NULL,
  `1d` varchar(100) NOT NULL,
  `1e` varchar(100) NOT NULL,
  `2a` varchar(100) NOT NULL,
  `2b` varchar(100) NOT NULL,
  `2c` varchar(100) NOT NULL,
  `2d` varchar(100) NOT NULL,
  `2e` varchar(100) NOT NULL,
  `3a` varchar(100) NOT NULL,
  `3b` varchar(100) NOT NULL,
  `3c` varchar(100) NOT NULL,
  `3d` varchar(100) NOT NULL,
  `3e` varchar(100) NOT NULL,
  `3f` varchar(100) NOT NULL,
  `3g` varchar(100) NOT NULL,
  `3h` varchar(100) NOT NULL,
  `3i` varchar(100) NOT NULL,
  `3j` varchar(100) NOT NULL,
  `3k` varchar(100) NOT NULL,
  `3l` varchar(100) NOT NULL,
  `4a` varchar(100) NOT NULL,
  `4b` varchar(100) NOT NULL,
  `4c` varchar(100) NOT NULL,
  `5a` varchar(100) NOT NULL,
  `5b` varchar(100) NOT NULL,
  `5c` varchar(100) NOT NULL,
  `5d` varchar(100) NOT NULL,
  `a` varchar(100) NOT NULL,
  `b` varchar(100) NOT NULL,
  `c` varchar(100) NOT NULL,
  `d` varchar(100) NOT NULL,
  `e` varchar(100) NOT NULL,
  `f` varchar(100) NOT NULL,
  `g` varchar(100) NOT NULL,
  `h` varchar(100) NOT NULL,
  `i` varchar(100) NOT NULL,
  `j` varchar(100) NOT NULL,
  `other` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addpatient2`
--

INSERT INTO `addpatient2` (`id`, `1a`, `1b`, `1c`, `1d`, `1e`, `2a`, `2b`, `2c`, `2d`, `2e`, `3a`, `3b`, `3c`, `3d`, `3e`, `3f`, `3g`, `3h`, `3i`, `3j`, `3k`, `3l`, `4a`, `4b`, `4c`, `5a`, `5b`, `5c`, `5d`, `a`, `b`, `c`, `d`, `e`, `f`, `g`, `h`, `i`, `j`, `other`) VALUES
('1234', 'Road traffic accident', 'Pedestrian struck injury', '', '', '', '', '', 'c.  Deformity', '', '', '', 'Hypertension', 'Coronary heart disease', '', '', '', 'Tuberculosis', '', '', '', '', '', 'Steroids', '', '', '', ' Previous surgeries or hospitalisations', '', '', '', 'Mixed', '', '', '', 'Altered', '', 'Alcohol', '', '', 'hellonnbn'),
('1234', 'Road traffic accident', 'Pedestrian struck injury', '', '', '', '', '', 'c.  Deformity', '', '', '', 'Hypertension', 'Coronary heart disease', '', '', '', 'Tuberculosis', '', '', '', '', '', 'Steroids', '', '', '', ' Previous surgeries or hospitalisations', '', '', '', 'Mixed', '', '', '', 'Altered', '', 'Alcohol', '', '', 'hellonnbn'),
('1234', 'Road traffic accident', 'Pedestrian struck injury', '', '', '', '', '', 'c.  Deformity', '', '', '', 'Hypertension', 'Coronary heart disease', '', '', '', 'Tuberculosis', '', '', '', '', '', 'Steroids', '', '', '', ' Previous surgeries or hospitalisations', '', '', '', 'Mixed', '', '', '', 'Altered', '', 'Alcohol', '', '', 'hellonnbn'),
('0123456789', 'Road traffic accident', '', '', '', '', '', 'b.  Swelling – site / extent', '', '', '', '', '', 'Coronary heart disease', '', '', '', '', '', '', '', '', '', '', '', '', 'Any similar injuries', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('0123456789', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Married', '', 'Regular', '', '', '', '', '', ''),
('0123456789', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('0123456789', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('penchala', 'Road traffic accident', '', '', '', 'slip and fall', '', '', '', '', '', '', 'Hypertension', '', '', '', '', '', '', 'Bronchial asthma', '', '', '', '', '', 'Immunosuppressants', '', '', '', '', '', '', 'Married', '', '', 'Altered', '', 'Alcohol', '', '', 'werfgd'),
('111111', '', '', '', '', '', '', 'b.  Swelling – site / extent', '', '', '', '', '', '', '', '', '', 'Tuberculosis', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Mixed', '', '', '', '', '', 'Alcohol', '', '', 'ert'),
('gan1234', 'Road traffic accident', '', '', '', 'slip and fall', '', '', '', '', '', 'Diabetes mellitus', '', '', '', '', 'Dyslipidaemia', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Vegetarian', '', '', 'Single', '', '', '', 'Alcohol', '', '', 'tug3454'),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('0987654321', 'Road traffic accident', '', 'Fall from height', '', 'slip and fall', '', 'b.  Swelling – site / extent', '', '', 'e.  Other associated injuries – head injury / limb injuries / spine injuries ', '', '', 'Coronary heart disease', '', '', '', 'Tuberculosis', '', '', 'Neoplastic disorders', '', 'Chronic Obstructive lung diseases', '', 'Disease modifying anti-rheumatoid drugs ', '', '', ' Previous surgeries or hospitalisations', '', '', 'Vegetarian', '', '', 'Single', '', 'Altered', '', 'Alcohol', '', 'Drug Addictions', 'hello'),
('sse1234', '', 'Pedestrian struck injury', '', '', 'slip and fall', '', 'b.  Swelling – site / extent', '', '', '', '', '', 'Coronary heart disease', '', '', '', '', 'Hepatic disorder', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Regular', 'Altered', '', '', '', '', ''),
('simats', 'Road traffic accident', '', '', 'work place injury', '', '', '', 'c.  Deformity', '', '', '', '', '', 'Renal disorder', '', '', '', '', '', '', '', '', '', 'Disease modifying anti-rheumatoid drugs ', '', '', '', 'Any major illnesses', '', '', '', '', 'Single', '', '', '', '', 'Tobacco', '', 'sdsgs'),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('reddy123', '', '', '', 'work place injury', '', 'a.  Pain – site / duration', '', '', '', '', '', 'Hypertension', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Single', '', '', '', 'Alcohol', '', '', 'hfiuh');

-- --------------------------------------------------------

--
-- Table structure for table `addpatient3`
--

CREATE TABLE `addpatient3` (
  `ipNumber` varchar(10) NOT NULL,
  `appearance` varchar(100) NOT NULL,
  `pallor` varchar(100) NOT NULL,
  `cyanosis` varchar(100) NOT NULL,
  `treatment` varchar(100) NOT NULL,
  `family` varchar(100) NOT NULL,
  `built` varchar(100) NOT NULL,
  `icterus` varchar(100) NOT NULL,
  `clubbing` varchar(100) NOT NULL,
  `pulse` varchar(100) NOT NULL,
  `bp` varchar(10) NOT NULL,
  `pedal` varchar(100) NOT NULL,
  `lymphadeno` varchar(100) NOT NULL,
  `respiratory` varchar(100) NOT NULL,
  `temperature` varchar(100) NOT NULL,
  `card` varchar(100) NOT NULL,
  `respirat` varchar(100) NOT NULL,
  `abdomen` varchar(100) NOT NULL,
  `central` varchar(100) NOT NULL,
  `right1` varchar(100) NOT NULL,
  `left1` varchar(100) NOT NULL,
  `soft` varchar(100) NOT NULL,
  `discharge` varchar(100) NOT NULL,
  `neurova` varchar(100) NOT NULL,
  `other` varchar(100) NOT NULL,
  `fracture` varchar(100) NOT NULL,
  `open` varchar(100) NOT NULL,
  `non` varchar(100) NOT NULL,
  `fina` varchar(100) NOT NULL,
  `initial` varchar(100) NOT NULL,
  `planned` varchar(100) NOT NULL,
  `post` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `addpatient3`
--

INSERT INTO `addpatient3` (`ipNumber`, `appearance`, `pallor`, `cyanosis`, `treatment`, `family`, `built`, `icterus`, `clubbing`, `pulse`, `bp`, `pedal`, `lymphadeno`, `respiratory`, `temperature`, `card`, `respirat`, `abdomen`, `central`, `right1`, `left1`, `soft`, `discharge`, `neurova`, `other`, `fracture`, `open`, `non`, `fina`, `initial`, `planned`, `post`) VALUES
('123', 'yes', 'wef', 'xf', 'hjkjgnbv', 'hv', 'jhtgfsv', 'yktfg', 'v', 'svzc', 'tht', 'rtf', 'no', 'htr', 'fvc', 'fdr', 'lkd', 'll', ';,slv', 'fewgf', 'erf', 't', 'g', 'rg', 'ryeg', 'etytg', 'ertgerg', 'rtrg', 'ey', 'kdfmdj', ' xdj', 'c djn'),
('1234', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('1234', '123', 'rg', 'vfg', 'y', 'u', 'tu', 't', 'u', 'yu', 'tu', 'tu', 't', 'u', 'uiy', 'tuu', 'tuyi', 'uu', 'tu', 't', 'ryr', 'ry', 'ry', 'ry', 'ry', 'ryi', 'tut', 'tytu', 'rytu', 'tuy', 'tut', ''),
('1234', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '1234', '123412', '1234', '123', '123', '123', '123', '123'),
('0123456789', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('penchala', 'qewr', 'efg', 'gh', 'h', 'hj', 'yu', 'uyj', '56y', 'swdf', 'dfg', 'fgb', 'dfgb', 'defg', 'gth', 'yth', 'yhg', 'gh', 'rgf', 'ujh', 'jyg', 'yhgb', 'hgb', 'f', 'rf', 'df', 'tg', 'rgf', 'yhg', 'yhg', 'ytrfg', 'jhg'),
('111111', '5y', 'fg', '6y', 'u', '5t', '7y', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('gan1234', 'uuy', 'n', '', '', 'nbbj', '', 'h', '', 'jhk', '120', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('0987654321', 'cxv', 'hvh', 'mnbhb', 'jhv', 'hj', 'kjh', 'kjbh', 'kj', 'lh', '120', 'kj', 'kjh', 'dgjhg', 'hgdfja', 'hj', 'hjg', 'hdf', 'jkhm', 'efd', 'hjfd', 'adf', 'ydg', 'dg', 'dgud', 'iudh', 'sgygd', 'hdgjs', 'hdg', 'dg', 'ud', 'uhd'),
('sse1234', 'gsva', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('simats', 'dfs', '', '', 'df', 'fg', '', 'ghg', '', 'f', 'gg', '', 'df', '', '', 'rt', '', '', '', '', '', 'tyu', 'jhy', '', '', '', 'te', 'hgj', '', '', '', 'jyu'),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('reddy123', 'iwehjide', 'djfhbdkj', 'jehfek', 'hjgjhb', 'hvjmvbku', 'nmvmng', 'hgmb', 'nmn', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `dlogin`
--

CREATE TABLE `dlogin` (
  `did` varchar(15) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dlogin`
--

INSERT INTO `dlogin` (`did`, `password`) VALUES
('redd', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `sno` bigint(20) NOT NULL,
  `id` varchar(30) NOT NULL,
  `img` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`sno`, `id`, `img`) VALUES
(1, 'default_value', 'uploads/image_default_value.jpg'),
(2, 'default_value', 'uploads/image_default_value.jpg'),
(3, '111111', 'profile/ysr.jpg'),
(4, 'simats', 'uploads/image_simats.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `doc_post_day`
--

CREATE TABLE `doc_post_day` (
  `id` varchar(20) NOT NULL,
  `text` varchar(500) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doc_post_day`
--

INSERT INTO `doc_post_day` (`id`, `text`, `date`) VALUES
('1234', 'dsfghj', '2024-02-29'),
('penchala', '12we', '2024-03-04'),
('111111', 'dgfb', '2024-03-04'),
('gan1234', 'ertdythb', '2024-03-05');

-- --------------------------------------------------------

--
-- Table structure for table `doc_reviews`
--

CREATE TABLE `doc_reviews` (
  `id` varchar(20) NOT NULL,
  `date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doc_reviews`
--

INSERT INTO `doc_reviews` (`id`, `date`) VALUES
('1234', '2023-12-14'),
('1234', '2023-12-15'),
('1235', '2023-12-17'),
('1235', '2023-12-17'),
('1235', '2023-12-14'),
('1234', '2023-12-14'),
('1234', '2023-12-15'),
('1235', '2023-12-17'),
('1235', '2023-12-17'),
('1235', '2023-12-14'),
('your_patient_id', '2024-01-10'),
('your_patient_id', '2024-01-10'),
('your_patient_id', '2024-01-10'),
('1234', '2024-02-29'),
('1234', '2024-02-29'),
('1234', '2024-02-10'),
('1234', '2024-02-10'),
('1234', '2024-01-05'),
('1234', '2024-01-05'),
('1234', '2024-01-01'),
('1234', '2024-01-01'),
('1234', '2024-01-26'),
('1234', '2024-01-26'),
('1234', '2024-03-15'),
('1234', '2024-03-15'),
('1234', '2024-02-01'),
('1234', '2024-02-01'),
('1234', '2024-02-01'),
('1234', '2024-02-19'),
('1234', '2024-02-19'),
('1234', '2024-02-14'),
('1234', '2024-02-14'),
('penchala', '2024-02-26'),
('penchala', '2024-02-26'),
('penchala', '2024-02-20'),
('penchala', '2024-02-20'),
('1234', '2024-02-27'),
('1234', '2024-02-27'),
('111111', '2024-03-04'),
('111111', '2024-03-04'),
('1234', '2024-03-05'),
('1234', '2024-03-05'),
('1234', '2024-03-16'),
('1234', '2024-03-16'),
('0987654321', '2024-03-25'),
('111111', '2024-03-30'),
('111111', '2024-03-30'),
('penchala', '2024-03-30'),
('sse1234', '2024-04-08'),
('sse1234', '2024-04-08'),
('sse1234', '2024-04-10'),
('sse1234', '2024-04-10'),
('reddy123', '2024-05-04'),
('reddy123', '2024-05-04');

-- --------------------------------------------------------

--
-- Table structure for table `doc_scoresheet`
--

CREATE TABLE `doc_scoresheet` (
  `patient_id` varchar(30) NOT NULL,
  `date` varchar(10) NOT NULL,
  `pod` varchar(30) NOT NULL,
  `fun_score` varchar(2) NOT NULL,
  `fun_text` varchar(500) NOT NULL,
  `rad_score` varchar(2) NOT NULL,
  `rad_text` varchar(500) NOT NULL,
  `x_ray` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doc_scoresheet`
--

INSERT INTO `doc_scoresheet` (`patient_id`, `date`, `pod`, `fun_score`, `fun_text`, `rad_score`, `rad_text`, `x_ray`) VALUES
('penchala', '8', '8', '4.', 'hgfcv', '5.', 'lkjhg', 'kjhmnb'),
('111111', '2024-03-04', 'er', '4.', 'Fair', '5.', 'hi', 'hello'),
('gan1234', '2024-03-25', 'onetow', '0', 'Good', '3.', 'where', 'how'),
('1234', '2024-03-30', 'null', '0', 'Fair', '0', 'null', 'null'),
('sse1234', '2024-04-08', '10/04/2024', '0', 'null', '4.', 'good', 'know'),
('simats', '2024-04-12', 'null', '0', 'Good', '0', 'null', 'null'),
('reddy123', '2024-05-06', 'null', '0', 'Good', '0', 'null', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `doc_search`
--

CREATE TABLE `doc_search` (
  `Id` varchar(30) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `phone` bigint(11) NOT NULL,
  `profile` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doc_search`
--

INSERT INTO `doc_search` (`Id`, `Name`, `Gender`, `phone`, `profile`) VALUES
('1', 'ysr', 'male', 9899979796, 'profile/ysr.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `doc_surgery`
--

CREATE TABLE `doc_surgery` (
  `patient_id` varchar(20) NOT NULL,
  `diagnosis` varchar(100) NOT NULL,
  `pn` varchar(50) NOT NULL,
  `io` varchar(20) NOT NULL,
  `surgery_date` varchar(10) NOT NULL,
  `surgery_time` varchar(10) NOT NULL,
  `blood_loss` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doc_surgery`
--

INSERT INTO `doc_surgery` (`patient_id`, `diagnosis`, `pn`, `io`, `surgery_date`, `surgery_time`, `blood_loss`) VALUES
('', '', '', '', '', '', ''),
('', '', '', '', '', '', ''),
('123', 'krjfik54jg', 'rkijfij', 'hfurh', 'uhfeufh', 'hfeih', 'ijfr'),
('penchala', '34t', 'dsf', 'dfg', '25/02/2024', '12:00', '20'),
('penchala', 'ui', 'lk', 'nj', 'bhvg', 'vg', 'xd'),
('1234', 'uyru', 'tut', 'tyu', 'tyu', 'tyu', 'tuy'),
('1234', 'piu', 'io', 'yt', 're', 'tr', 'ty'),
('1234', 'tyu', 'fghj', 'nk k', '541', 'iuy5', 'oiuhj'),
('1234', 'nbbvv', 'operation', 'in', '29', '10', '0.5'),
('1234', 'qwert', 'asdfg', 'zxcvb', '1/03/2023', '12:30', '20ml'),
('1234', '12', '3e', 'we', '45', '67', 'w4'),
('1234', '12', 'hh', 'nnm', 'kjh', 'nn', 'mn'),
('1234', '23', 'gh', 'b b', 'hhb', 'nnn', 'bh'),
('penchala', '123', '123', '123', '123', '123', '123'),
('penchala', 'er', 'we', 'rt', '12', 'df', 'we'),
('111111', 'we', 'fd', 'tg', 'trg', 't', 'ty'),
('gan1234', 'jb', 'gu', 'tf', 'hjjk', 'ghjhghj', 'k'),
('1234', '', '', '', '', '', ''),
('1234', 'ortho', 'vundela', 'today', '25/03/2024', '2:00pm', '10grams'),
('penchala', 'cv', 'dg', 'et', 'gh', '34', 'fg'),
('sse1234', 'sd', 'we', 'qe', 'gf', 'hhhbb', '25gm');

-- --------------------------------------------------------

--
-- Table structure for table `dprofile`
--

CREATE TABLE `dprofile` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `working` varchar(50) NOT NULL,
  `age` varchar(3) NOT NULL,
  `did` varchar(20) NOT NULL,
  `phno` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `qulaification` varchar(50) NOT NULL,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dprofile`
--

INSERT INTO `dprofile` (`id`, `name`, `working`, `age`, `did`, `phno`, `email`, `qulaification`, `img`) VALUES
(1, 'ram charan', 'chennai', '40', 'redd', '9873430842', 'ram12@gmail.com', 'Ms', 'doctor_profile/6635f41706141.jpg'),
(2, '', '', '', '', '', '', '', ''),
(3, '', '', 'red', '', '', '', '', ''),
(4, '', '', 'red', '', '', '', '', ''),
(5, '', '', 'red', '', '', '', '', ''),
(6, '', '', 'red', '', '', '', '', ''),
(7, '', '', 'red', '', '', '', '', ''),
(8, '', '', 'red', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `medicine_timing`
--

CREATE TABLE `medicine_timing` (
  `id` varchar(30) NOT NULL,
  `Medicine_name` varchar(50) NOT NULL,
  `Dose` varchar(10) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Date` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicine_timing`
--

INSERT INTO `medicine_timing` (`id`, `Medicine_name`, `Dose`, `Type`, `Date`) VALUES
('reddy123', 'dolo', '50mg', 'night', '2024-05-04'),
('reddy123', '', '', '', '2024-05-04');

-- --------------------------------------------------------

--
-- Table structure for table `pcomplaints`
--

CREATE TABLE `pcomplaints` (
  `pid` varchar(30) NOT NULL,
  `comp` varchar(400) NOT NULL,
  `y/n` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `sugg` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pcomplaints`
--

INSERT INTO `pcomplaints` (`pid`, `comp`, `y/n`, `date`, `sugg`) VALUES
('111111', 'hello ', 'Yes', '2024-04-23', 'wwodQsd'),
('', '', '', '0000-00-00', 'wecc'),
('0987654321', 'i have some problem,please help me.', 'Yes', '2024-03-25', 'come to hospital.'),
('smc123', 'hjnrfjrbg', 'yes', '0000-00-00', 'wecc'),
('simats', 'leela', 'Yes', '2024-04-12', 'wecc'),
('reddy123', 'Good morning sir,\nToday i am doing exercise on that time paining.', 'No', '2024-05-06', 'wecc');

-- --------------------------------------------------------

--
-- Table structure for table `pilizarov`
--

CREATE TABLE `pilizarov` (
  `dist` varchar(30) NOT NULL,
  `dp` varchar(30) NOT NULL,
  `dt` varchar(20) NOT NULL,
  `comp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pilizarov`
--

INSERT INTO `pilizarov` (`dist`, `dp`, `dt`, `comp`) VALUES
('6pm', 'Done', 'Not Done', '6pm'),
('6pm', 'Done', 'Not Done', '6pm'),
('12am', 'Not Done', 'Not Done', '12am'),
('6am', 'Not Done', 'Not Done', '6pm'),
('6am', 'Not Done', 'Not Done', '12am'),
('6am', 'Not Done', 'Not Done', '12am'),
('6am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am'),
('6pm', 'Not Done', 'Not Done', '6pm'),
('6pm', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Done', '6pm'),
('12am', 'Not Done', 'Not Done', '12am'),
('12am', 'Not Done', 'Not Done', '12am');

-- --------------------------------------------------------

--
-- Table structure for table `plogin`
--

CREATE TABLE `plogin` (
  `pid` varchar(40) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(255) DEFAULT 'one',
  `phno` varchar(20) DEFAULT 'one',
  `qualification` varchar(100) DEFAULT 'one',
  `image` varchar(255) DEFAULT 'one',
  `name` varchar(255) DEFAULT 'one',
  `age` varchar(255) DEFAULT '20'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plogin`
--

INSERT INTO `plogin` (`pid`, `password`, `email`, `phno`, `qualification`, `image`, `name`, `age`) VALUES
('smc123', '1234', 'hareram12@gmail.com', '6304324313', 'B Tech', 'patient_profile/660ac6b039530.jpg', 'Ram Charan', '24'),
('0123456789', '6789', 'one', 'one', 'one', 'one', 'one', '20'),
('gg', 'gg', 'one', 'one', 'one', 'one', 'one', '20'),
('gg', 'gg', 'one', 'one', 'one', 'one', 'one', '20'),
('123456', '3456', 'one', 'one', 'one', 'one', 'one', '20'),
('123456', '3456', 'one', 'one', 'one', 'one', 'one', '20'),
('penchala', 'hala', 'one', 'one', 'one', 'one', 'one', '20'),
('111111', '1111', 'ntr@gmail.com', '8654979523', 'M Tech', 'patient_profile/660e60e88ee3f.jpg', 'Ramarao', '24'),
('gan1234', '1234', 'one', 'one', 'one', 'one', 'one', '20'),
('0987654321', '4321', 'onemanshow@gmail.com', '6303672890', 'BE', 'patient_profile/660b7423bfb52.jpg', 'lokesh', '21'),
('smc12345', '2345', '', '', '', '', '', ''),
('simats', 'mats', 'leela@gmail.com', '8431647678', 'BE.TEch', 'patient_profile/66195156068b7.jpg', 'leela', '23'),
('', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', ''),
('', '', '', '', '', '', '', ''),
('reddy123', 'y123', 'reddy', '9875645123', 'uguyguh', 'patient_profile/6635f5247809a.jpg', 'reddy123', '23');

-- --------------------------------------------------------

--
-- Table structure for table `ppprofile`
--

CREATE TABLE `ppprofile` (
  `pid` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(10) NOT NULL,
  `phno` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `qualification` varchar(30) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ppprofile`
--

INSERT INTO `ppprofile` (`pid`, `name`, `age`, `phno`, `email`, `qualification`, `image`) VALUES
('smc123', 'John Doe', 30, '1234567890', 'john@example.com', 'MD', 'patient_profile/6609b1c134b17.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `pprofile`
--

CREATE TABLE `pprofile` (
  `id` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(10) NOT NULL,
  `phno` int(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `qualification` varchar(30) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pprofile`
--

INSERT INTO `pprofile` (`id`, `name`, `age`, `phno`, `email`, `qualification`, `image`) VALUES
('smc123', 'ads', 0, 0, 'e', 'e', 'patient_profile/660a4f790384a.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `dprofile`
--
ALTER TABLE `dprofile`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `sno` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `dprofile`
--
ALTER TABLE `dprofile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
