-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2015 �?12 �?17 �?15:11
-- 服务器版本: 5.6.11
-- PHP 版本: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `lims`
--
CREATE DATABASE IF NOT EXISTS `lims` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `lims`;

-- --------------------------------------------------------

--
-- 表的结构 `content_article`
--

CREATE TABLE IF NOT EXISTS `content_article` (
  `ArticleID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `SubTitle` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Author` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `Source` varchar(200) DEFAULT NULL,
  `Inputor` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Editor` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `Hits` int(11) NOT NULL DEFAULT '0',
  `UpdateTime` datetime NOT NULL,
  `CreateTime` datetime NOT NULL,
  `Content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `Url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `Priority` int(11) DEFAULT '0',
  `NodeID` int(11) DEFAULT '0',
  PRIMARY KEY (`ArticleID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `content_article`
--

INSERT INTO `content_article` (`ArticleID`, `Title`, `SubTitle`, `Author`, `Source`, `Inputor`, `Editor`, `Hits`, `UpdateTime`, `CreateTime`, `Content`, `Url`, `Priority`, `NodeID`) VALUES
(1, '我是标题1', '我是副标题1', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦', 'dengzhr.com', 0, 0),
(2, '我是标题2', '我是副标题2', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', 'dengzhr.com', 0, 0),
(3, '我是标题3', '我是副标题3', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈哈哈哈啦啦啦哈哈哈哈哈', 'dengzhr.com', 0, 0),
(4, '我是标题4', '我是副标题4', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '44444444444444', 'dengzhr.com', 0, 0),
(5, '我是标题5', '我是副标题5', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '5555555555555555555555', 'dengzhr.com', 0, 0),
(6, '我是标题6', '我是副标题6', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '66666666666666666666666666666', 'dengzhr.com', 0, 0),
(7, '我是标题7', '我是副标题7', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '7777777777777777777777777', 'dengzhr.com', 0, 0),
(8, '我是标题8', '我是副标题8', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '8888888888888', 'dengzhr.com', 0, 0),
(9, '我是标题9', '我是副标题9', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '9999999999999999999999', 'dengzhr.com', 0, 0),
(10, '我是标题10', '我是副标题10', '邓智容', NULL, NULL, NULL, 0, '2015-12-11 00:00:00', '2015-12-08 00:00:00', '101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010', 'dengzhr.com', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `content_node`
--

CREATE TABLE IF NOT EXISTS `content_node` (
  `NodeID` int(11) NOT NULL AUTO_INCREMENT,
  `NodeName` varchar(200) NOT NULL,
  `NodeDepth` int(11) DEFAULT '0',
  `ParentID` int(11) DEFAULT '0',
  PRIMARY KEY (`NodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `devicecategory`
--

CREATE TABLE IF NOT EXISTS `devicecategory` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(255) NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `device_info`
--

CREATE TABLE IF NOT EXISTS `device_info` (
  `DeviceID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_bin NOT NULL,
  `NameEn` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Model` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Department` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `Describe` text COLLATE utf8_bin NOT NULL,
  `Status` int(11) DEFAULT NULL,
  `DevicesFunction` text COLLATE utf8_bin,
  `Provider` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `ProviderAddress` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `DeviceCount` int(11) DEFAULT NULL,
  `PriceInner` decimal(10,0) DEFAULT NULL,
  `PriceOuter` decimal(10,0) DEFAULT NULL,
  `PersonInCharge` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `PersonInChargePhone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `PersonInChargeAddress` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `UsedBeginTime` datetime DEFAULT NULL,
  `UsedEndTime` datetime DEFAULT NULL,
  `MaxApplyTime` int(11) DEFAULT NULL,
  `MaxPreApplyDate` int(11) DEFAULT NULL,
  `Remark` text COLLATE utf8_bin,
  `Url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `DeviceNodeID` int(11) DEFAULT '0',
  `DevicePicUrl` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DeviceID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `device_info`
--

INSERT INTO `device_info` (`DeviceID`, `Name`, `NameEn`, `Model`, `Department`, `Address`, `Describe`, `Status`, `DevicesFunction`, `Provider`, `ProviderAddress`, `DeviceCount`, `PriceInner`, `PriceOuter`, `PersonInCharge`, `PersonInChargePhone`, `PersonInChargeAddress`, `UsedBeginTime`, `UsedEndTime`, `MaxApplyTime`, `MaxPreApplyDate`, `Remark`, `Url`, `DeviceNodeID`, `DevicePicUrl`) VALUES
(1, '激光显微拉曼光谱仪', 'Laser Micro-Raman Spectrometer ', 'Renishaw inVia', '', '', '激光显微拉曼光谱仪激光显微拉曼光谱仪激光显微拉曼光谱仪激光显微拉曼光谱仪激光显微拉曼光谱仪激光显微拉曼光谱仪激光显微拉曼光谱仪', 0, '激光显微拉曼光谱仪的功能', 'dengzhirong', '1', 0, '200', '300', '', '', '', '2015-12-01 00:00:00', '2016-10-20 00:00:00', 4, 3, '哈哈，我是备注激光显微拉曼光谱仪', 'dengzhr.com', 1, 'http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png'),
(2, 'X-射线光电子能谱仪', 'x-ray', '', '', '', 'X-射线光电子能谱仪X-射线光电子能谱仪X-射线光电子能谱仪X-射线光电子能谱仪', 0, 'X-射线光电子能谱仪的功能', 'xiaohei', '', 1, '100', '200', '', '', '', '2015-12-24 00:00:00', '2015-12-22 00:00:00', 3, 1, '哈哈，我是备注  X-ray', 'ce.sysu.edu.cn', 1, 'http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png'),
(3, '冷场发射扫描电镜', 'lengchang', '', '', '', '冷场发射扫描电镜冷场发射扫描电镜冷场发射扫描电镜冷场发射扫描电镜冷场发射扫描电镜', 0, '冷场发射扫描电镜的功能', 'xiaohei', '', 1, '100', '200', '', '', '', '2015-12-24 00:00:00', '2015-12-22 00:00:00', 3, 1, '哈哈，我是备注  冷场发射扫描电镜', 'ce.sysu.edu.cn/hope', 2, 'http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png');

-- --------------------------------------------------------

--
-- 表的结构 `device_node`
--

CREATE TABLE IF NOT EXISTS `device_node` (
  `NodeID` int(11) NOT NULL AUTO_INCREMENT,
  `NodeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未定义',
  PRIMARY KEY (`NodeID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `device_node`
--

INSERT INTO `device_node` (`NodeID`, `NodeName`) VALUES
(1, '中山大学测试中心-表面与结构分析平台\r\n'),
(2, '中山大学测试中心-材料微区分析平台'),
(3, '生命科学学院-医药分子生物学实验室'),
(4, '生命科学学院-生科院实验中心'),
(5, '化学与化学工程学院-化学学院中心实验室'),
(6, '化学与化学工程学院-高分子化学与物理国家重点学科实验室');

-- --------------------------------------------------------

--
-- 表的结构 `device_reserve`
--

CREATE TABLE IF NOT EXISTS `device_reserve` (
  `ReservationID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `UserType` int(11) NOT NULL,
  `BeginTime` datetime NOT NULL,
  `EndTime` datetime NOT NULL,
  `Project` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `DeviceID` int(11) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Remark` text COLLATE utf8_bin,
  `LastUpdateTime` timestamp NULL DEFAULT NULL,
  `CreateReserveTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Duration` int(11) DEFAULT NULL,
  `IsCompleted` tinyint(1) DEFAULT '0',
  `UserPhoneNumber` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ReservationID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `device_reserve`
--

INSERT INTO `device_reserve` (`ReservationID`, `UserID`, `UserType`, `BeginTime`, `EndTime`, `Project`, `DeviceID`, `Price`, `Remark`, `LastUpdateTime`, `CreateReserveTime`, `Duration`, `IsCompleted`, `UserPhoneNumber`) VALUES
(5, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目1', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 1, '13929584731'),
(6, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目2', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 0, '13929584731'),
(7, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目3', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 0, '13929584731'),
(8, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目4', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 0, '13929584731'),
(9, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目5', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 1, '13929584731'),
(10, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目5', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 0, '13929584731'),
(11, 1, 0, '2015-12-12 12:00:00', '2015-12-12 13:00:00', '测试项目6', 1, '50', '我是备注', NULL, '0000-00-00 00:00:00', 1, 0, '13929584731');

-- --------------------------------------------------------

--
-- 表的结构 `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `MessageID` int(11) NOT NULL AUTO_INCREMENT,
  `SendID` int(11) NOT NULL,
  `ReceiverID` int(11) NOT NULL,
  `Title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `IsChecked` tinyint(1) DEFAULT '0',
  `MessageDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `IsRead` tinyint(1) DEFAULT '0',
  `IsHideToReceiver` tinyint(1) DEFAULT '0',
  `IsHideToSend` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`MessageID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `message`
--

INSERT INTO `message` (`MessageID`, `SendID`, `ReceiverID`, `Title`, `Content`, `IsChecked`, `MessageDate`, `IsRead`, `IsHideToReceiver`, `IsHideToSend`) VALUES
(3, 1, 2, 'Hello, xiaohei你好，我是邓子', '我是消息正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(11, 1, 2, '消息1', '我是消息1正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(12, 1, 2, '消息2', '我是消息2正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(13, 1, 2, '消息3', '我是消息3正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(14, 1, 2, '消息4', '我是消息4正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(15, 1, 2, '消息5', '我是消息5正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(16, 1, 2, '消息6', '我是消息6正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(17, 1, 2, '消息7', '我是消息7正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(18, 1, 2, '消息8', '我是消息8正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(19, 1, 2, '消息9', '我是消息9正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(20, 1, 2, '', '', 0, '2015-12-15 15:21:01', 0, 0, 0),
(21, 1, 2, '消息9', '我是消息9正文', 0, '2015-12-15 15:21:01', 0, 0, 0),
(22, 1, 2, '消息9', '我是消息9正文', 0, '2015-12-15 15:23:05', 0, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `PamentID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `PayTime` datetime NOT NULL,
  `DeviceID` int(11) NOT NULL,
  `CurrentMoney` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`PamentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `RealName` text COLLATE utf8_bin NOT NULL,
  `StudentID` int(11) NOT NULL,
  `NickName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Email` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `PhoneNumber` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `UserImageUrl` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `DepartmentID` int(11) NOT NULL,
  `UserType` int(11) DEFAULT NULL,
  `QQNumber` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `IsInSchool` tinyint(1) NOT NULL,
  `IsEnable` tinyint(1) NOT NULL,
  `RegisterTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LastLoginTime` datetime DEFAULT NULL,
  `IsPhoneLogin` int(11) DEFAULT '0',
  `RoleID` int(11) DEFAULT NULL,
  `ErrorTimes` int(11) DEFAULT '0',
  `LastErrorTime` datetime DEFAULT NULL,
  `Remark` text CHARACTER SET latin1,
  `Job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `userinfo`
--

INSERT INTO `userinfo` (`UserID`, `Name`, `RealName`, `StudentID`, `NickName`, `Password`, `Email`, `PhoneNumber`, `UserImageUrl`, `DepartmentID`, `UserType`, `QQNumber`, `IsInSchool`, `IsEnable`, `RegisterTime`, `LastLoginTime`, `IsPhoneLogin`, `RoleID`, `ErrorTimes`, `LastErrorTime`, `Remark`, `Job`) VALUES
(1, 'dengzhirong', '邓智容', 12322033, '小凳子', '202cb962ac59075b964b07152d234b70', '804999766@qq.com', '13929584731', 'http://www.dengzhr.com/wp-content/themes/dengzhr/images/logo.png', 0, 0, '804999766', 1, 1, '2015-12-15 08:52:49', '2015-12-15 00:08:00', 0, 0, 0, '2015-12-04 00:00:00', NULL, NULL),
(2, 'xiaohei', '小黑', 12322032, '小黑', '*hope8848', '804999766@qq.com', '13929584731', 'http://www.dengzhr.com/wp-content/themes/dengzhr/images/logo.png', 0, 0, '804999766', 1, 1, '2015-12-15 08:52:56', '2015-12-15 00:08:00', 0, 0, 0, '2015-12-04 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `website_configure`
--

CREATE TABLE IF NOT EXISTS `website_configure` (
  `SysID` int(11) NOT NULL AUTO_INCREMENT,
  `SiteName` varchar(200) DEFAULT 'LIMS',
  `SiteTitle` varchar(200) DEFAULT 'LIMS',
  `Logo` varchar(255) DEFAULT NULL,
  `KeyWord` varchar(255) DEFAULT NULL,
  `Description` varchar(1024) DEFAULT NULL,
  `Copyright` varchar(255) DEFAULT NULL,
  `SiteMaster` varchar(200) DEFAULT NULL,
  `MaterEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SysID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
