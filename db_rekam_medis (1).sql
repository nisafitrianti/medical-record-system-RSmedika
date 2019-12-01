-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2019 at 02:49 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rekam_medis`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` int(11) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `gender_dokter` char(1) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `tgl_mulai_kerja` date NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kode_poliklinik` int(11) DEFAULT NULL,
  `kode_spesialisasi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `gender_dokter`, `tgl_lahir`, `tgl_mulai_kerja`, `no_telepon`, `alamat`, `kode_poliklinik`, `kode_spesialisasi`) VALUES
(1011, 'Dr. Wisnu', 'M', '1998-10-06', '2019-11-12', '087653625123', 'jl. telekomunikasi telkom university', 3301, 2201);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama_karyawan` varchar(100) NOT NULL,
  `jns_kelamin` char(1) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `tgl_mulai_bekerja` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `jns_kelamin`, `tgl_lahir`, `tgl_mulai_bekerja`, `status`, `password`) VALUES
(1021, 'caca', 'F', '2000-08-21', '2019-11-24', 1, '4a35609636702d4fe4419b8fc23a9bf7');

-- --------------------------------------------------------

--
-- Table structure for table `medical_record`
--

CREATE TABLE `medical_record` (
  `id_medical_record` int(11) NOT NULL,
  `jenis_rekam_medis` varchar(15) NOT NULL,
  `id_pasien` int(11) NOT NULL,
  `id_dokter` int(11) NOT NULL,
  `kode_spesialisasi` int(11) NOT NULL,
  `kode_poliklinik` int(11) NOT NULL,
  `kode_penyakit` int(11) NOT NULL,
  `ruang_perawatan` varchar(20) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `tgl_keluar` date NOT NULL,
  `pemeriksaan` varchar(250) NOT NULL,
  `tindakan` varchar(250) NOT NULL,
  `pengobatan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medical_record`
--

INSERT INTO `medical_record` (`id_medical_record`, `jenis_rekam_medis`, `id_pasien`, `id_dokter`, `kode_spesialisasi`, `kode_poliklinik`, `kode_penyakit`, `ruang_perawatan`, `tgl_masuk`, `tgl_keluar`, `pemeriksaan`, `tindakan`, `pengobatan`) VALUES
(5012, 'rawat inap', 3011, 1011, 2202, 3301, 1102, 'hahahaha', '2019-11-20', '0000-00-00', ',mabsdjasb ', 'jasdajsbd', 'jksadhas'),
(5013, 'jsa', 3011, 1011, 2201, 3302, 1101, 'as', '2019-11-11', '2019-11-20', 'as', 'as', 'as'),
(5014, 'rawatinap', 3011, 1011, 2201, 3301, 1101, 'a', '0000-00-00', '0000-00-00', 'fg', 'jh', 'jjhb');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` int(11) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `umur` int(11) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `jns_kelamin` char(1) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `tgl_lahir`, `umur`, `telepon`, `jns_kelamin`, `pekerjaan`, `alamat`) VALUES
(3011, 'nisa', '2000-08-21', 18, '089656028762', 'F', 'Mahakuli', 'bandung');

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE `penyakit` (
  `kode_penyakit` int(11) NOT NULL,
  `nama_penyakit` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyakit`
--

INSERT INTO `penyakit` (`kode_penyakit`, `nama_penyakit`) VALUES
(1101, 'sakit hati'),
(1102, 'gatel jantung\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `poliklinik`
--

CREATE TABLE `poliklinik` (
  `kode_poliklinik` int(11) NOT NULL,
  `nama_poliklinik` varchar(100) NOT NULL,
  `kode_spesialisasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poliklinik`
--

INSERT INTO `poliklinik` (`kode_poliklinik`, `nama_poliklinik`, `kode_spesialisasi`) VALUES
(3301, 'poli organ dalam', 2202),
(3302, 'poli ibu dan anak', 2201);

-- --------------------------------------------------------

--
-- Table structure for table `spesialisasi`
--

CREATE TABLE `spesialisasi` (
  `kode_spesialisasi` int(11) NOT NULL,
  `nama_spesialisasi` varchar(100) NOT NULL,
  `kode_penyakit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spesialisasi`
--

INSERT INTO `spesialisasi` (`kode_spesialisasi`, `nama_spesialisasi`, `kode_penyakit`) VALUES
(2201, 'spesialis hati', 1101),
(2202, 'spesialis jantung', 1102);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`),
  ADD KEY `fk_kode_poliklinik` (`kode_poliklinik`),
  ADD KEY `fk_kode_spesialisasi_dok` (`kode_spesialisasi`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `medical_record`
--
ALTER TABLE `medical_record`
  ADD PRIMARY KEY (`id_medical_record`),
  ADD KEY `fk_id_pasien` (`id_pasien`),
  ADD KEY `fk_id_dokter` (`id_dokter`),
  ADD KEY `fk_kode_penyakit2` (`kode_penyakit`),
  ADD KEY `fk_kode_spesialisasi2` (`kode_spesialisasi`),
  ADD KEY `fk_kode_poliklinik2` (`kode_poliklinik`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indexes for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`kode_penyakit`);

--
-- Indexes for table `poliklinik`
--
ALTER TABLE `poliklinik`
  ADD PRIMARY KEY (`kode_poliklinik`),
  ADD KEY `fk_kode_spesialisasi` (`kode_spesialisasi`);

--
-- Indexes for table `spesialisasi`
--
ALTER TABLE `spesialisasi`
  ADD PRIMARY KEY (`kode_spesialisasi`),
  ADD KEY `fk_kode_penyakit` (`kode_penyakit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dokter`
--
ALTER TABLE `dokter`
  MODIFY `id_dokter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1022;

--
-- AUTO_INCREMENT for table `medical_record`
--
ALTER TABLE `medical_record`
  MODIFY `id_medical_record` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5015;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id_pasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3012;

--
-- AUTO_INCREMENT for table `penyakit`
--
ALTER TABLE `penyakit`
  MODIFY `kode_penyakit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1103;

--
-- AUTO_INCREMENT for table `poliklinik`
--
ALTER TABLE `poliklinik`
  MODIFY `kode_poliklinik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3303;

--
-- AUTO_INCREMENT for table `spesialisasi`
--
ALTER TABLE `spesialisasi`
  MODIFY `kode_spesialisasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2203;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `fk_kode_poliklinik` FOREIGN KEY (`kode_poliklinik`) REFERENCES `poliklinik` (`kode_poliklinik`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_kode_spesialisasi_dok` FOREIGN KEY (`kode_spesialisasi`) REFERENCES `spesialisasi` (`kode_spesialisasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medical_record`
--
ALTER TABLE `medical_record`
  ADD CONSTRAINT `fk_id_dokter` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_penyakit2` FOREIGN KEY (`kode_penyakit`) REFERENCES `penyakit` (`kode_penyakit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_poliklinik2` FOREIGN KEY (`kode_poliklinik`) REFERENCES `poliklinik` (`kode_poliklinik`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_spesialisasi2` FOREIGN KEY (`kode_spesialisasi`) REFERENCES `spesialisasi` (`kode_spesialisasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `poliklinik`
--
ALTER TABLE `poliklinik`
  ADD CONSTRAINT `fk_kode_spesialisasi` FOREIGN KEY (`kode_spesialisasi`) REFERENCES `spesialisasi` (`kode_spesialisasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `spesialisasi`
--
ALTER TABLE `spesialisasi`
  ADD CONSTRAINT `fk_kode_penyakit` FOREIGN KEY (`kode_penyakit`) REFERENCES `penyakit` (`kode_penyakit`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
