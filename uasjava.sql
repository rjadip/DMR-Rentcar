-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2016 at 03:27 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uasjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `datamobil`
--

CREATE TABLE `datamobil` (
  `plat_no` varchar(10) NOT NULL,
  `merek_mobil` varchar(10) NOT NULL,
  `tipe_mobil` varchar(10) NOT NULL,
  `wrn_mobil` varchar(10) NOT NULL,
  `thn_mobil` int(10) NOT NULL,
  `k_mobil` varchar(10) NOT NULL,
  `h_sewa` int(10) NOT NULL,
  `b_denda` int(10) NOT NULL,
  `s_mobil` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datamobil`
--

INSERT INTO `datamobil` (`plat_no`, `merek_mobil`, `tipe_mobil`, `wrn_mobil`, `thn_mobil`, `k_mobil`, `h_sewa`, `b_denda`, `s_mobil`) VALUES
('B 1203 ZUS', 'TOYOTA', 'YARIS', 'MERAH', 2013, 'Baru', 500000, 100000, 0),
('B 1234 DEZ', 'HONDA', 'JAZZ', 'MERAH', 2015, 'Baru', 500000, 100000, 0),
('B 1234 XEB', 'HONDA', 'JAZZ', 'MERAH', 2015, 'Baru', 500000, 100000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_kembali` varchar(12) NOT NULL,
  `id_pinjam` varchar(12) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `terlambat` int(11) NOT NULL,
  `denda` int(11) NOT NULL,
  `ttl_pembayaran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tblcustomer`
--

CREATE TABLE `tblcustomer` (
  `Kode` varchar(11) NOT NULL,
  `NmDepan` varchar(20) NOT NULL,
  `NmBlkg` varchar(20) NOT NULL,
  `JnsID` varchar(10) NOT NULL,
  `NoId` varchar(30) NOT NULL,
  `JnsKlmin` varchar(10) NOT NULL,
  `TmptLhr` varchar(20) NOT NULL,
  `TgLhr` date NOT NULL,
  `Almt` varchar(50) NOT NULL,
  `Tlp` varchar(15) NOT NULL,
  `Hp` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Sts` varchar(10) NOT NULL,
  `Kosong` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datamobil`
--
ALTER TABLE `datamobil`
  ADD PRIMARY KEY (`plat_no`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_kembali`);

--
-- Indexes for table `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD PRIMARY KEY (`Kode`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
