-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 03, 2021 at 03:40 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `canteen`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `addadmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addadmin` (IN `name` VARCHAR(100), IN `username` VARCHAR(100), IN `pass` VARCHAR(255), IN `addre` VARCHAR(20), IN `email` VARCHAR(100), IN `tel` VARCHAR(20), IN `id` VARCHAR(50))  BEGIN


INSERT INTO user(user_reg, user_full_name, user_name, user_password, user_email, user_addres, user_state, user_otp, user_email_state, user_tel)VALUE(id, name, username, pass, email, addre, "Admin", "000000", "No", tel);

END$$

DROP PROCEDURE IF EXISTS `addfeed`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addfeed` (IN `uid` INT(50), IN `title` VARCHAR(200), IN `note` VARCHAR(800))  BEGIN
INSERT INTO feedback(feedback_user_id, feedback_date, feedback_title, feedback_note, feedback_state)VALUE(uid, curdate(), title, note, "Not");
END$$

DROP PROCEDURE IF EXISTS `additemnnew`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `additemnnew` (IN `name` VARCHAR(100), IN `cata` VARCHAR(100), IN `price` INT(100), IN `qunti` INT(100), IN `img` VARCHAR(255))  BEGIN
INSERT INTO item(item_name, item_price, item_quntity, item_up_date, item_state, item_catagory, item_img)VALUE(name, price, qunti, curdate(), "Yes", cata, img);
END$$

DROP PROCEDURE IF EXISTS `addnewnoty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addnewnoty` (IN `userid` INT(100), IN `sendid` INT(100), IN `title` VARCHAR(150), IN `note` VARCHAR(600))  BEGIN


INSERT INTO notify(notify_user_id, notify_send_user_id, notify_tital, notify_note, notify_state, notify_date)VALUE(userid, sendid, title, note, "Not", curdate());

END$$

DROP PROCEDURE IF EXISTS `billdata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `billdata` (IN `userid` INT(50))  BEGIN
SELECT * FROM bill WHERE neworder_user_id=userid ORDER BY neworder_id DESC;
END$$

DROP PROCEDURE IF EXISTS `billpendingdata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `billpendingdata` (IN `userid` INT(50))  BEGIN
SELECT * FROM bill WHERE neworder_user_id=userid AND neworder_state="pending" OR neworder_state="shipd" ORDER BY neworder_id DESC;
END$$

DROP PROCEDURE IF EXISTS `countfeed`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `countfeed` ()  BEGIN
SELECT COUNT(feedback_id) FROM feedback WHERE feedback_state="Not";
END$$

DROP PROCEDURE IF EXISTS `countnoty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `countnoty` (IN `id` INT(50))  BEGIN
SELECT COUNT(notify_id) FROM notify WHERE (notify_user_id=id OR notify_user_id=0) AND notify_state="Not";
END$$

DROP PROCEDURE IF EXISTS `deleteitem`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteitem` (IN `id` INT(50))  BEGIN
UPDATE item SET item_state="No", item_up_date=curdate() WHERE item_id=id;
END$$

DROP PROCEDURE IF EXISTS `deletreg`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletreg` (IN `id` VARCHAR(50))  BEGIN
DELETE FROM reglist WHERE `reglist_rg_id`=id;
END$$

DROP PROCEDURE IF EXISTS `getalluserdata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getalluserdata` ()  BEGIN
SELECT * FROM user WHERE user_state!="Admin";
END$$

DROP PROCEDURE IF EXISTS `getdeliver`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getdeliver` ()  BEGIN
SELECT * FROM deliver WHERE deliver_qun_today=(SELECT MIN(deliver_qun_today) FROM deliver) LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `getdeliverupin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getdeliverupin` (IN `word` VARCHAR(50), IN `id` INT(50), IN `name` VARCHAR(50), IN `tel` VARCHAR(50))  BEGIN

IF word="All"  THEN

	SELECT * FROM deliver;
 
ELSE

	IF word="Up"  THEN

        UPDATE deliver SET deliver_name=name, deliver_tel=tel WHERE deliver_id=id;

    ELSE

        IF word="In"  THEN

            INSERT INTO deliver(deliver_qun_today, deliver_qun_month, deliver_name, deliver_tel) VALUE(0, 0, name, tel);

       


        END IF;

    END IF;
END IF;

END$$

DROP PROCEDURE IF EXISTS `getfeedlist`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getfeedlist` ()  BEGIN

SELECT * FROM feedbacklist;

END$$

DROP PROCEDURE IF EXISTS `gethomemaim`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gethomemaim` (IN `type` VARCHAR(50))  BEGIN
SELECT * FROM item WHERE item_catagory=type;
END$$

DROP PROCEDURE IF EXISTS `getitemdaly`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getitemdaly` (IN `word` VARCHAR(50))  BEGIN

IF word="day" THEN

	SELECT * FROM dalyitem WHERE DAY(curdate())=DAY(neworder_date) ;
 
ELSE
	IF word="mon" THEN

    	SELECT `item_id`,`item_name`, `item_price`,`item_catagory`,SUM(`sold qun`), SUM(`total`) FROM dalyitem WHERE MONTH(curdate())=MONTH(neworder_date) GROUP BY item_id; 

    ELSE
        
    	IF word="monc" THEN

        	SELECT SUM(total) FROM dalyitem WHERE MONTH(curdate())=MONTH(neworder_date); 

        ELSE

            IF word="dayc" THEN

        		SELECT SUM(total) FROM dalyitem WHERE DAY(curdate())=DAY(neworder_date) ; 

            ELSE

                SELECT * FROM dalyitem;

            END IF;

        END IF;
        
    END IF;

END IF;

END$$

DROP PROCEDURE IF EXISTS `getitemdetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getitemdetails` (IN `idset` INT(50))  BEGIN
SELECT * FROM item WHERE item_id=idset;
END$$

DROP PROCEDURE IF EXISTS `getitemlistorder`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getitemlistorder` ()  BEGIN
SELECT * FROM item WHERE item_state="Yes" ORDER BY item_quntity ASC;
END$$

DROP PROCEDURE IF EXISTS `getoerdernew`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getoerdernew` (IN `id` INT(50), IN `word` VARCHAR(50))  BEGIN

IF id=0  THEN

	SELECT * FROM bill WHERE neworder_state=word ;
 
ELSE

	UPDATE neworder SET neworder_state="shipd" WHERE neworder_id=id;

END IF;

END$$

DROP PROCEDURE IF EXISTS `getordercount`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getordercount` ()  BEGIN
SELECT COUNT(neworder_id) FROM neworder WHERE neworder_state="pending";
END$$

DROP PROCEDURE IF EXISTS `getotpemail`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getotpemail` (IN `id` INT(50))  BEGIN
SELECT * FROM user WHERE user_id=id;
END$$

DROP PROCEDURE IF EXISTS `getregin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getregin` (IN `word` VARCHAR(50), IN `id` VARCHAR(50), IN `name` VARCHAR(50), IN `address` VARCHAR(50), IN `state` VARCHAR(50))  BEGIN

IF word="All"  THEN

	SELECT * FROM reglist;
 
ELSE
	
    INSERT INTO reglist(reglist_rg_id, reglist_name, reglist_address, reglist_state)VALUE(id, name, address, state);
	
END IF;

END$$

DROP PROCEDURE IF EXISTS `getsearchdtails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getsearchdtails` (IN `seaword` VARCHAR(50))  BEGIN
SELECT * FROM item WHERE (item_name LIKE CONCAT('%',seaword,'%') OR item_catagory LIKE CONCAT('%',seaword,'%')) AND item_quntity!=0;
END$$

DROP PROCEDURE IF EXISTS `getusedata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getusedata` (IN `id` INT(50))  BEGIN
SELECT * FROM user WHERE user_id=id;
END$$

DROP PROCEDURE IF EXISTS `lastbilldata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lastbilldata` (IN `userid` INT(50))  BEGIN
SELECT * FROM bill WHERE neworder_user_id=userid ORDER BY neworder_id DESC LIMIT 1;
END$$

DROP PROCEDURE IF EXISTS `logmaintain`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `logmaintain` (IN `word` VARCHAR(50), IN `id` INT(50))  BEGIN

IF word="log"  THEN

	INSERT INTO log(log_user_id, log_time, Log_out_time) VALUE(id, NOW(), null);
ELSE

     UPDATE log SET Log_out_time=NOW() WHERE log_user_id=id;
  
END IF;

END$$

DROP PROCEDURE IF EXISTS `notydetails`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `notydetails` (IN `id` INT(50))  BEGIN
SELECT * FROM notify WHERE notify_user_id=id OR notify_user_id=0 ORDER BY notify_id DESC;
END$$

DROP PROCEDURE IF EXISTS `selectbilldata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectbilldata` (IN `odrid` VARCHAR(50))  BEGIN
SELECT * FROM bill WHERE neworder_id=odrid ;
END$$

DROP PROCEDURE IF EXISTS `summorbill`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `summorbill` (IN `id` INT(50))  NO SQL
SELECT * FROM bill WHERE neworder_user_id=id AND neworder_state!="pending" AND neworder_state!="shipd" ORDER BY neworder_id DESC$$

DROP PROCEDURE IF EXISTS `updateorderstate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateorderstate` (IN `id` VARCHAR(50), IN `newstate` VARCHAR(50))  BEGIN
UPDATE neworder SET neworder_state=newstate WHERE neworder_id=id;
END$$

DROP PROCEDURE IF EXISTS `updateud1`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateud1` (IN `id` INT(50), IN `un` VARCHAR(100), IN `tn` VARCHAR(100))  BEGIN
UPDATE user SET user_name=un, user_tel=tn WHERE user_id=id;
END$$

DROP PROCEDURE IF EXISTS `upfeedstate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upfeedstate` (IN `id` VARCHAR(50))  BEGIN
UPDATE feedback SET feedback_state="See" WHERE feedback_id=id;
END$$

DROP PROCEDURE IF EXISTS `upitemdata`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upitemdata` (IN `id` INT(50), IN `name` VARCHAR(100), IN `cata` VARCHAR(100), IN `price` INT(50))  BEGIN
UPDATE item SET item_name=name, item_catagory=cata, item_price=price WHERE item_id=id;
END$$

DROP PROCEDURE IF EXISTS `upitemimg`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upitemimg` (IN `id` INT(50), IN `img` VARCHAR(500))  BEGIN
UPDATE item SET item_img=img WHERE item_id=id;
END$$

DROP PROCEDURE IF EXISTS `upitemqun`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upitemqun` (IN `newqun` INT(50), IN `itemid` INT(50))  BEGIN
UPDATE item SET item_quntity=newqun WHERE item_id=itemid;
END$$

DROP PROCEDURE IF EXISTS `upitemqunadmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upitemqunadmin` (IN `id` INT(50), IN `qun` INT(100))  BEGIN
UPDATE item SET item_quntity=qun, item_up_date=curdate() WHERE item_id=id;
END$$

DROP PROCEDURE IF EXISTS `upnotystate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upnotystate` (IN `id` VARCHAR(50))  BEGIN
UPDATE notify SET notify_state="See" WHERE notify_id=id;
END$$

DROP PROCEDURE IF EXISTS `upotp`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upotp` (IN `id` INT(50), IN `otp` VARCHAR(100))  BEGIN
UPDATE user SET user_otp=otp WHERE user_id=id;
END$$

--
-- Functions
--
DROP FUNCTION IF EXISTS `user_set`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `user_set` (`name` VARCHAR(50), `id` INT(50)) RETURNS VARCHAR(250) CHARSET latin1 BEGIN
DECLARE pass VARCHAR(200)DEFAULT"";
SELECT `user_password` INTO pass FROM user WHERE `user_name`=name;
RETURN pass;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `bill`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
`neworder_id` int(200)
,`neworder_quntity` int(200)
,`neworder_new_addres` varchar(250)
,`neworder_date` varchar(200)
,`neworder_time` varchar(50)
,`neworder_state` varchar(50)
,`neworder_item_id` int(200)
,`item_name` varchar(100)
,`item_price` int(200)
,`item_catagory` varchar(50)
,`neworder_user_id` int(200)
,`user_full_name` varchar(250)
,`user_reg` varchar(100)
,`user_email` varchar(255)
,`neworder_delver_id` int(200)
,`deliver_name` varchar(250)
,`deliver_tel` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `dalyitem`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `dalyitem`;
CREATE TABLE IF NOT EXISTS `dalyitem` (
`item_id` int(200)
,`item_name` varchar(100)
,`item_price` int(200)
,`item_catagory` varchar(50)
,`neworder_date` varchar(200)
,`sold qun` decimal(65,0)
,`total` decimal(65,0)
);

-- --------------------------------------------------------

--
-- Table structure for table `deliver`
--

DROP TABLE IF EXISTS `deliver`;
CREATE TABLE IF NOT EXISTS `deliver` (
  `deliver_id` int(200) NOT NULL AUTO_INCREMENT,
  `deliver_qun_today` int(200) NOT NULL,
  `deliver_qun_month` int(200) NOT NULL,
  `deliver_name` varchar(250) NOT NULL,
  `deliver_tel` varchar(50) NOT NULL,
  PRIMARY KEY (`deliver_id`),
  KEY `dqt` (`deliver_qun_today`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliver`
--

INSERT INTO `deliver` (`deliver_id`, `deliver_qun_today`, `deliver_qun_month`, `deliver_name`, `deliver_tel`) VALUES
(1, 13, 69, 'Pawan sandeeda', '077-2658956'),
(2, 9, 32, 'Ishan chathuranga', '014-5623985'),
(3, 10, 68, 'chamika lakmali', '077-0000005');

--
-- Triggers `deliver`
--
DROP TRIGGER IF EXISTS `creatework`;
DELIMITER $$
CREATE TRIGGER `creatework` AFTER INSERT ON `deliver` FOR EACH ROW BEGIN
DECLARE dliverid integer;
SET dliverid := NEW.deliver_id;


INSERT INTO deliverwork (deliverwork_deliver_id, deliverwork_start_date, deliverwork_start_time, deliverwork_state)
VALUES(dliverid, curdate(), curtime(), "Active");

END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `delever_log_delete`;
DELIMITER $$
CREATE TRIGGER `delever_log_delete` BEFORE DELETE ON `deliver` FOR EACH ROW INSERT INTO deliver_log(deliver_id,deliver_qun_today,deliver_qun_month,deliver_name,deliver_tel,deliver_log_state,deliver_log_time)
VALUE(OLD.deliver_id,OLD.deliver_qun_today,OLD.deliver_qun_month,OLD.deliver_name,OLD.deliver_tel,'Delete',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `delever_log_insert`;
DELIMITER $$
CREATE TRIGGER `delever_log_insert` AFTER INSERT ON `deliver` FOR EACH ROW INSERT INTO deliver_log(deliver_id,deliver_qun_today,deliver_qun_month,deliver_name,deliver_tel,deliver_log_state,deliver_log_time)
VALUE(NEW.deliver_id,NEW.deliver_qun_today,NEW.deliver_qun_month,NEW.deliver_name,NEW.deliver_tel,'Insert',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `delever_log_update`;
DELIMITER $$
CREATE TRIGGER `delever_log_update` BEFORE UPDATE ON `deliver` FOR EACH ROW INSERT INTO deliver_log(deliver_id,deliver_qun_today,deliver_qun_month,deliver_name,deliver_tel,deliver_log_state,deliver_log_time)
VALUE(OLD.deliver_id,OLD.deliver_qun_today,OLD.deliver_qun_month,OLD.deliver_name,OLD.deliver_tel,'Update',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `dliworupdate`;
DELIMITER $$
CREATE TRIGGER `dliworupdate` AFTER DELETE ON `deliver` FOR EACH ROW BEGIN
DECLARE dliverid integer;
SET dliverid := old.deliver_id;

UPDATE deliverwork SET deliverwork_state="Leave" WHERE deliverwork_deliver_id=dliverid;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `deliverwork`
--

DROP TABLE IF EXISTS `deliverwork`;
CREATE TABLE IF NOT EXISTS `deliverwork` (
  `deliverwork_id` int(50) NOT NULL AUTO_INCREMENT,
  `deliverwork_deliver_id` int(50) NOT NULL,
  `deliverwork_start_date` date NOT NULL,
  `deliverwork_start_time` time NOT NULL,
  `deliverwork_state` varchar(50) NOT NULL,
  PRIMARY KEY (`deliverwork_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliverwork`
--

INSERT INTO `deliverwork` (`deliverwork_id`, `deliverwork_deliver_id`, `deliverwork_start_date`, `deliverwork_start_time`, `deliverwork_state`) VALUES
(1, 4, '2021-06-07', '12:28:13', 'Active'),
(2, 5, '2021-06-08', '11:51:26', 'Leave'),
(3, 6, '2021-06-22', '13:03:13', 'Leave');

-- --------------------------------------------------------

--
-- Table structure for table `deliver_log`
--

DROP TABLE IF EXISTS `deliver_log`;
CREATE TABLE IF NOT EXISTS `deliver_log` (
  `deliver_log_id` int(200) NOT NULL AUTO_INCREMENT,
  `deliver_id` int(200) NOT NULL,
  `deliver_qun_today` int(200) NOT NULL,
  `deliver_qun_month` int(200) NOT NULL,
  `deliver_name` varchar(250) NOT NULL,
  `deliver_tel` varchar(50) NOT NULL,
  `deliver_log_state` varchar(50) NOT NULL,
  `deliver_log_time` datetime NOT NULL,
  PRIMARY KEY (`deliver_log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliver_log`
--

INSERT INTO `deliver_log` (`deliver_log_id`, `deliver_id`, `deliver_qun_today`, `deliver_qun_month`, `deliver_name`, `deliver_tel`, `deliver_log_state`, `deliver_log_time`) VALUES
(7, 5, 50, 20, 'gjhgjjyhj', '077-2658956', 'up', '2021-02-16 16:16:10');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE IF NOT EXISTS `feedback` (
  `feedback_id` int(50) NOT NULL AUTO_INCREMENT,
  `feedback_user_id` int(50) NOT NULL,
  `feedback_date` date NOT NULL,
  `feedback_title` varchar(200) NOT NULL,
  `feedback_note` varchar(800) NOT NULL,
  `feedback_state` varchar(50) NOT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `feedback_user_id`, `feedback_date`, `feedback_title`, `feedback_note`, `feedback_state`) VALUES
(1, 21, '2021-06-16', 'ffff', 'fzfgf', 'See'),
(2, 21, '2021-06-16', 'kkkll.', 'k.k.l/.cl', 'See'),
(3, 21, '2021-06-16', 'iyo[o', 'ho\'ol\'b', 'See'),
(4, 21, '2021-06-17', 'bnhgjnh', 'gnjhgjnhg', 'See');

-- --------------------------------------------------------

--
-- Stand-in structure for view `feedbacklist`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `feedbacklist`;
CREATE TABLE IF NOT EXISTS `feedbacklist` (
`feedback_id` int(50)
,`feedback_user_id` int(50)
,`feedback_date` date
,`feedback_title` varchar(200)
,`feedback_note` varchar(800)
,`feedback_state` varchar(50)
,`user_id` int(200)
,`user_reg` varchar(100)
,`user_full_name` varchar(250)
,`user_email` varchar(255)
,`user_tel` varchar(200)
,`user_addres` varchar(200)
);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int(200) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) NOT NULL,
  `item_price` int(200) NOT NULL,
  `item_quntity` int(200) NOT NULL,
  `item_up_date` date NOT NULL,
  `item_state` varchar(50) NOT NULL,
  `item_catagory` varchar(50) NOT NULL,
  `item_img` varchar(255) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `itn` (`item_name`),
  KEY `itc` (`item_catagory`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `item_name`, `item_price`, `item_quntity`, `item_up_date`, `item_state`, `item_catagory`, `item_img`) VALUES
(1, 'Rice & Curry', 100, 50, '2021-06-04', 'Yes', 'Breakfast', '/userimg/braf01.png'),
(2, 'Fid rice', 150, 58, '2021-06-04', 'Yes', 'Lunch', '/userimg/lunc01.png'),
(3, 'Rice & Curry', 120, 150, '2021-06-04', 'Yes', 'Dinner', '/userimg/lunc01.png'),
(4, 'Fish Bun', 30, 15, '2021-06-13', 'Yes', 'Bun', '/userimg/fbun01.png'),
(5, 'Presty', 40, 50, '2021-06-13', 'Yes', 'Bun', '/userimg/pastf01.png'),
(6, 'Sunlight', 58, 150, '2021-06-13', 'Yes', 'Sop', '/userimg/sunlig.png'),
(7, 'Milk Pack', 50, 50, '2021-06-20', 'Yes', 'Kothmale', '/userimg/mpack.png'),
(8, 'Fruit Jus', 30, 20, '2021-06-13', 'Yes', 'Drink', '/userimg/juse01.png'),
(9, 'Milk Coffee', 25, 150, '2021-06-13', 'Yes', 'Drink', '/userimg/milkcoff.png'),
(10, 'Sanwich', 60, 150, '2021-06-14', 'Yes', 'Breakfast other.', '/userimg/sanwich01.png'),
(11, 'Milo', 70, 10, '2021-06-20', 'Yes', 'Drink', '/userimg/1106_20_2021_12_48.png'),
(12, 'Vanilla Milk', 30, 150, '2021-06-14', 'Yes', 'Drink', '/userimg/vanimil01.png'),
(13, 'String Hoper', 20, 50, '2021-06-14', 'Yes', 'Breakfast other.', '/userimg/stho01.png'),
(14, 'Yogurt', 25, 50, '2021-06-14', 'Yes', 'Kothmale', '/userimg/yorgate01.png'),
(15, 'Tea', 15, 150, '2021-06-14', 'Yes', 'Drink', '/userimg/tea01.png');

--
-- Triggers `item`
--
DROP TRIGGER IF EXISTS `log_delete`;
DELIMITER $$
CREATE TRIGGER `log_delete` BEFORE DELETE ON `item` FOR EACH ROW INSERT INTO item_log(item_id, item_name, item_price, item_quntity, item_up_date, item_state, item_catagory, item_img, item_log_state,item_log_time)VALUES(OLD.item_id,OLD.item_name,OLD.item_price,OLD.item_quntity,OLD.item_up_date,OLD.item_state, OLD.item_catagory,OLD.item_img,'Delete',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `log_insert`;
DELIMITER $$
CREATE TRIGGER `log_insert` AFTER INSERT ON `item` FOR EACH ROW INSERT INTO item_log(item_id, item_name, item_price, item_quntity, item_up_date, item_state, item_catagory, item_img, item_log_state,item_log_time)VALUES(NEW.item_id,NEW.item_name,NEW.item_price,NEW.item_quntity,NEW.item_up_date,NEW.item_state, NEW.item_catagory,NEW.item_img,'Insert',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `log_update`;
DELIMITER $$
CREATE TRIGGER `log_update` BEFORE UPDATE ON `item` FOR EACH ROW INSERT INTO item_log(item_id, item_name, item_price, item_quntity, item_up_date, item_state, item_catagory, item_img, item_log_state,item_log_time)VALUES(OLD.item_id,OLD.item_name,OLD.item_price,OLD.item_quntity,OLD.item_up_date,OLD.item_state, OLD.item_catagory,OLD.item_img,'Update',NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `item_log`
--

DROP TABLE IF EXISTS `item_log`;
CREATE TABLE IF NOT EXISTS `item_log` (
  `item_log_id` int(200) NOT NULL AUTO_INCREMENT,
  `item_id` int(200) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `item_price` int(200) NOT NULL,
  `item_quntity` int(200) NOT NULL,
  `item_up_date` date NOT NULL,
  `item_state` varchar(50) NOT NULL,
  `item_catagory` varchar(50) NOT NULL,
  `item_img` varchar(255) NOT NULL,
  `item_log_state` varchar(50) NOT NULL,
  `item_log_time` datetime NOT NULL,
  PRIMARY KEY (`item_log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `log_id` int(100) NOT NULL AUTO_INCREMENT,
  `log_user_id` int(100) NOT NULL,
  `log_time` datetime NOT NULL,
  `Log_out_time` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`log_id`, `log_user_id`, `log_time`, `Log_out_time`) VALUES
(3, 21, '2021-07-03 14:33:59', '2021-07-03 14:34:07');

-- --------------------------------------------------------

--
-- Table structure for table `neworder`
--

DROP TABLE IF EXISTS `neworder`;
CREATE TABLE IF NOT EXISTS `neworder` (
  `neworder_id` int(200) NOT NULL AUTO_INCREMENT,
  `neworder_item_id` int(200) NOT NULL,
  `neworder_quntity` int(200) NOT NULL,
  `neworder_date` varchar(200) NOT NULL,
  `neworder_time` varchar(50) NOT NULL,
  `neworder_user_id` int(200) NOT NULL,
  `neworder_new_addres` varchar(250) NOT NULL,
  `neworder_state` varchar(50) NOT NULL,
  `neworder_delver_id` int(200) NOT NULL,
  PRIMARY KEY (`neworder_id`),
  KEY `no` (`neworder_user_id`),
  KEY `iid` (`neworder_item_id`),
  KEY `di` (`neworder_delver_id`),
  KEY `nd` (`neworder_date`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `neworder`
--

INSERT INTO `neworder` (`neworder_id`, `neworder_item_id`, `neworder_quntity`, `neworder_date`, `neworder_time`, `neworder_user_id`, `neworder_new_addres`, `neworder_state`, `neworder_delver_id`) VALUES
(23, 4, 5, '2021-06-13', '09 49 PM', 21, 'Room 08', 'shipd', 1),
(8, 2, 8, '2021-06-07', '11 28 AM', 21, 'Room 08', 'Report', 3),
(7, 2, 3, '2021-06-18', '11 28 AM', 21, 'Room 08', 'shipd', 2),
(6, 1, 2, '2021-06-07', '10 35 AM', 21, 'Room 08', 'Report', 2),
(9, 2, 3, '2021-06-07', '11 30 AM', 21, 'Room 09', 'Reseve', 1),
(10, 2, 3, '2021-06-08', '01 37 PM', 18, 'Room 10', 'Report', 1),
(11, 1, 1, '2021-07-09', '10 54 AM', 21, 'Room 08', 'pending', 1),
(12, 2, 1, '2021-06-09', '11 02 AM', 18, 'Room 09', 'pending', 2),
(13, 2, 2, '2021-06-09', '11 14 AM', 18, 'Room 09', 'pending', 3),
(14, 3, 4, '2021-06-09', '07 04 PM', 21, 'Room 08', 'pending', 1),
(15, 3, 2, '2021-06-09', '07 14 PM', 21, 'Room 08', 'pending', 2),
(16, 3, 5, '2021-06-09', '07 16 PM', 21, 'Room 08', 'pending', 3),
(17, 3, 2, '2021-06-09', '07 29 PM', 21, 'Room 08', 'pending', 2),
(18, 3, 2, '2021-06-09', '07 32 PM', 21, 'Room 08', 'Report', 1),
(19, 3, 2, '2021-06-09', '07 35 PM', 21, 'Room 08', 'Reseve', 2),
(20, 3, 1, '2021-06-09', '07 37 PM', 21, 'Room 08', 'Reseve', 1),
(21, 3, 2, '2021-06-09', '07 44 PM', 18, 'Room 09', 'pending', 2),
(22, 3, 1, '2021-06-09', '07 47 PM', 22, 'Room 10', 'pending', 3),
(24, 2, 2, '2021-06-18', '04 47 PM', 21, 'Room 08', 'pending', 3);

--
-- Triggers `neworder`
--
DROP TRIGGER IF EXISTS `neworder_log_delete`;
DELIMITER $$
CREATE TRIGGER `neworder_log_delete` BEFORE DELETE ON `neworder` FOR EACH ROW INSERT INTO neworder_log(neworder_id,neworder_item_id,neworder_quntity,neworder_date,neworder_time,neworder_user_id,neworder_new_addres,neworder_state,neworder_delver_id,neworder_log_state,neworder_log_time)
VALUE(OLD.neworder_id,OLD.neworder_item_id,OLD.neworder_quntity,OLD.neworder_date,OLD.neworder_time,OLD.neworder_user_id,OLD.neworder_new_addres,OLD.neworder_state,OLD.neworder_delver_id,'Delete',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `neworder_log_insert`;
DELIMITER $$
CREATE TRIGGER `neworder_log_insert` AFTER INSERT ON `neworder` FOR EACH ROW INSERT INTO neworder_log(neworder_id,neworder_item_id,neworder_quntity,neworder_date,neworder_time,neworder_user_id,neworder_new_addres,neworder_state,neworder_delver_id,neworder_log_state,neworder_log_time)
VALUE(NEW.neworder_id,NEW.neworder_item_id,NEW.neworder_quntity,NEW.neworder_date,NEW.neworder_time,NEW.neworder_user_id,NEW.neworder_new_addres,NEW.neworder_state,NEW.neworder_delver_id,'Update',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `neworder_log_update`;
DELIMITER $$
CREATE TRIGGER `neworder_log_update` BEFORE UPDATE ON `neworder` FOR EACH ROW INSERT INTO neworder_log(neworder_id,neworder_item_id,neworder_quntity,neworder_date,neworder_time,neworder_user_id,neworder_new_addres,neworder_state,neworder_delver_id,neworder_log_state,neworder_log_time)
VALUE(OLD.neworder_id,OLD.neworder_item_id,OLD.neworder_quntity,OLD.neworder_date,OLD.neworder_time,OLD.neworder_user_id,OLD.neworder_new_addres,OLD.neworder_state,OLD.neworder_delver_id,'Update',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `updatedeliver`;
DELIMITER $$
CREATE TRIGGER `updatedeliver` AFTER INSERT ON `neworder` FOR EACH ROW BEGIN
DECLARE dliverid integer;
DECLARE quntity integer;
DECLARE todayqun integer;
DECLARE monthqun integer;
DECLARE toltodqun integer;
DECLARE tolmonqun integer;
SET dliverid := NEW.neworder_delver_id;
SET quntity := NEW.neworder_quntity;
SET todayqun := (SELECT deliver_qun_today FROM deliver WHERE deliver_id=dliverid);
SET monthqun := (SELECT deliver_qun_month FROM deliver WHERE deliver_id=dliverid);

SET toltodqun := (todayqun + quntity);
SET tolmonqun := (monthqun + quntity);

UPDATE deliver SET deliver_qun_today=toltodqun, deliver_qun_month=tolmonqun WHERE deliver_id=dliverid;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `neworder_log`
--

DROP TABLE IF EXISTS `neworder_log`;
CREATE TABLE IF NOT EXISTS `neworder_log` (
  `neworder_log_id` int(200) NOT NULL AUTO_INCREMENT,
  `neworder_id` int(200) NOT NULL,
  `neworder_item_id` int(200) NOT NULL,
  `neworder_quntity` int(200) NOT NULL,
  `neworder_date` varchar(200) NOT NULL,
  `neworder_time` varchar(50) NOT NULL,
  `neworder_user_id` int(200) NOT NULL,
  `neworder_new_addres` varchar(250) NOT NULL,
  `neworder_state` varchar(50) NOT NULL,
  `neworder_delver_id` int(200) NOT NULL,
  `neworder_log_state` varchar(50) NOT NULL,
  `neworder_log_time` datetime NOT NULL,
  PRIMARY KEY (`neworder_log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `neworder_log`
--

INSERT INTO `neworder_log` (`neworder_log_id`, `neworder_id`, `neworder_item_id`, `neworder_quntity`, `neworder_date`, `neworder_time`, `neworder_user_id`, `neworder_new_addres`, `neworder_state`, `neworder_delver_id`, `neworder_log_state`, `neworder_log_time`) VALUES
(25, 9, 2, 3, '2021-06-07', '11 30 AM', 21, 'Room 08', 'Reseve', 1, 'Update', '2021-07-03 16:06:45');

-- --------------------------------------------------------

--
-- Table structure for table `notify`
--

DROP TABLE IF EXISTS `notify`;
CREATE TABLE IF NOT EXISTS `notify` (
  `notify_id` int(50) NOT NULL AUTO_INCREMENT,
  `notify_user_id` int(50) NOT NULL,
  `notify_send_user_id` int(50) NOT NULL,
  `notify_tital` varchar(200) NOT NULL,
  `notify_note` varchar(500) NOT NULL,
  `notify_state` varchar(20) NOT NULL,
  `notify_date` date NOT NULL,
  PRIMARY KEY (`notify_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notify`
--

INSERT INTO `notify` (`notify_id`, `notify_user_id`, `notify_send_user_id`, `notify_tital`, `notify_note`, `notify_state`, `notify_date`) VALUES
(20, 0, 0, 'hjhj', 'hjh', 'See', '2021-06-24'),
(19, 0, 0, 'hjh', 'jhjh', 'Not', '2021-06-24'),
(18, 22, 0, 'jghjg', 'hgjhgj', 'Not', '2021-06-24'),
(17, 0, 0, 'ggh', 'ghtgh', 'See', '2021-06-24'),
(16, 21, 0, 'k;\\\'', 'kl;\\;\'\\\'', 'Not', '2021-06-24');

-- --------------------------------------------------------

--
-- Table structure for table `reglist`
--

DROP TABLE IF EXISTS `reglist`;
CREATE TABLE IF NOT EXISTS `reglist` (
  `reglist_rg_id` varchar(50) NOT NULL,
  `reglist_name` varchar(200) NOT NULL,
  `reglist_address` varchar(250) NOT NULL,
  `reglist_state` varchar(200) NOT NULL,
  PRIMARY KEY (`reglist_rg_id`),
  KEY `rgid` (`reglist_rg_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reglist`
--

INSERT INTO `reglist` (`reglist_rg_id`, `reglist_name`, `reglist_address`, `reglist_state`) VALUES
('TG/2017/262', 'G I U S Chamika', 'Room 08', 'Student'),
('TG/2017/266', 'Withakshana wikkramasekara', 'Room 09', 'Sudent'),
('TG/2017/242', 'K.d.h.h.Waidyarathna', 'Room 10', 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `summorder`
--

DROP TABLE IF EXISTS `summorder`;
CREATE TABLE IF NOT EXISTS `summorder` (
  `summorder_id` int(200) NOT NULL AUTO_INCREMENT,
  `neworder_id` int(200) NOT NULL,
  `neworder_item_id` int(200) NOT NULL,
  `neworder_quntity` int(200) NOT NULL,
  `neworder_date` date NOT NULL,
  `neworder_time` decimal(10,0) NOT NULL,
  `neworder_user_id` int(200) NOT NULL,
  `neworder_new_addres` varchar(250) NOT NULL,
  `neworder_state` varchar(50) NOT NULL,
  `summorder_deliver_id` int(11) NOT NULL,
  `summorder_sub_date` date NOT NULL,
  `summorder_sub_time` int(11) NOT NULL,
  PRIMARY KEY (`summorder_id`),
  KEY `iid` (`neworder_item_id`),
  KEY `nd` (`neworder_date`),
  KEY `ui` (`neworder_user_id`),
  KEY `di` (`summorder_deliver_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(200) NOT NULL AUTO_INCREMENT,
  `user_reg` varchar(100) NOT NULL,
  `user_full_name` varchar(250) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_addres` varchar(200) NOT NULL,
  `user_state` varchar(50) NOT NULL,
  `user_otp` varchar(200) NOT NULL,
  `user_email_state` varchar(522) NOT NULL,
  `user_tel` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_reg`, `user_full_name`, `user_name`, `user_password`, `user_email`, `user_addres`, `user_state`, `user_otp`, `user_email_state`, `user_tel`) VALUES
(23, 'ad/001', 'sahan chamika', 'sahan', '58c76b2c9dbc3981fa6fe15213d8adca', 'sahanCgam@gmail.com', 'no', 'Admin', '123654', 'no', '077-0000000'),
(21, 'TG/2017/262', 'G I U S Chamika', 'Chamika', 'f0ff662649f17657cad7c0cc05b010e4', 'sahanchamikagunawikkrama@gmail.com', 'Room 08', 'Student', '868904', 'Yes', '077-0609541'),
(22, 'TG/2017/242', 'K.d.h.h.Waidyarathna', 'Heshan', '5dfc4f99ff98413d8043e2196646613f', 'hhansajith8@gmail.com', 'Room 10', 'Student', '054711', 'Yes', '077-1234567'),
(18, 'TG/2017/266', 'Withakshana wikkramasekara', 'Withakshana', '6c4cd2bdeedadf73b7b5be0c874e0370', 'Vithakshana97@gmail.com', 'Room 09', 'Sudent', '070572', 'Yes', '077-9637894');

--
-- Triggers `user`
--
DROP TRIGGER IF EXISTS `log_user_delete`;
DELIMITER $$
CREATE TRIGGER `log_user_delete` BEFORE DELETE ON `user` FOR EACH ROW INSERT INTO user_log(user_id,user_reg,user_full_name,user_name,user_password,user_email,user_addres,user_state,user_otp,user_email_state,user_tel,user_log_sate,user_log_time)
VALUE(OLD.user_id,OLD.user_reg,OLD.user_full_name,OLD.user_name,OLD.user_password,OLD.user_email,OLD.user_addres,OLD.user_state,OLD.user_otp,OLD.user_email_state,OLD.user_tel,'Delete',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `log_user_insert`;
DELIMITER $$
CREATE TRIGGER `log_user_insert` AFTER INSERT ON `user` FOR EACH ROW INSERT INTO user_log(user_id,user_reg,user_full_name,user_name,user_password,user_email,user_addres,user_state,user_otp,user_email_state,user_tel,user_log_sate,user_log_time)
VALUE(NEW.user_id,NEW.user_reg,NEW.user_full_name,NEW.user_name,NEW.user_password,NEW.user_email,NEW.user_addres,NEW.user_state,NEW.user_otp,NEW.user_email_state,NEW.user_tel,'Update',NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `log_user_update`;
DELIMITER $$
CREATE TRIGGER `log_user_update` BEFORE UPDATE ON `user` FOR EACH ROW INSERT INTO user_log(user_id,user_reg,user_full_name,user_name,user_password,user_email,user_addres,user_state,user_otp,user_email_state,user_tel,user_log_sate,user_log_time)
VALUE(OLD.user_id,OLD.user_reg,OLD.user_full_name,OLD.user_name,OLD.user_password,OLD.user_email,OLD.user_addres,OLD.user_state,OLD.user_otp,OLD.user_email_state,OLD.user_tel,'Update',NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE IF NOT EXISTS `user_log` (
  `user_log_id` int(200) NOT NULL AUTO_INCREMENT,
  `user_id` int(200) NOT NULL,
  `user_reg` varchar(100) NOT NULL,
  `user_full_name` varchar(250) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_addres` varchar(200) NOT NULL,
  `user_state` varchar(50) NOT NULL,
  `user_otp` varchar(200) NOT NULL,
  `user_email_state` varchar(522) NOT NULL,
  `user_tel` varchar(200) NOT NULL,
  `user_log_sate` varchar(50) NOT NULL,
  `user_log_time` datetime NOT NULL,
  PRIMARY KEY (`user_log_id`),
  KEY `un` (`user_name`),
  KEY `pw` (`user_password`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure for view `bill`
--
DROP TABLE IF EXISTS `bill`;

DROP VIEW IF EXISTS `bill`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bill`  AS  select `neworder`.`neworder_id` AS `neworder_id`,`neworder`.`neworder_quntity` AS `neworder_quntity`,`neworder`.`neworder_new_addres` AS `neworder_new_addres`,`neworder`.`neworder_date` AS `neworder_date`,`neworder`.`neworder_time` AS `neworder_time`,`neworder`.`neworder_state` AS `neworder_state`,`neworder`.`neworder_item_id` AS `neworder_item_id`,`item`.`item_name` AS `item_name`,`item`.`item_price` AS `item_price`,`item`.`item_catagory` AS `item_catagory`,`neworder`.`neworder_user_id` AS `neworder_user_id`,`user`.`user_full_name` AS `user_full_name`,`user`.`user_reg` AS `user_reg`,`user`.`user_email` AS `user_email`,`neworder`.`neworder_delver_id` AS `neworder_delver_id`,`deliver`.`deliver_name` AS `deliver_name`,`deliver`.`deliver_tel` AS `deliver_tel` from (((`neworder` join `item`) join `user`) join `deliver`) where ((`neworder`.`neworder_item_id` = `item`.`item_id`) and (`neworder`.`neworder_user_id` = `user`.`user_id`) and (`neworder`.`neworder_delver_id` = `deliver`.`deliver_id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `dalyitem`
--
DROP TABLE IF EXISTS `dalyitem`;

DROP VIEW IF EXISTS `dalyitem`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dalyitem`  AS  select `item`.`item_id` AS `item_id`,`item`.`item_name` AS `item_name`,`item`.`item_price` AS `item_price`,`item`.`item_catagory` AS `item_catagory`,`neworder`.`neworder_date` AS `neworder_date`,sum(`neworder`.`neworder_quntity`) AS `sold qun`,(`item`.`item_price` * sum(`neworder`.`neworder_quntity`)) AS `total` from (`item` join `neworder`) where (`item`.`item_id` = `neworder`.`neworder_item_id`) group by `neworder`.`neworder_item_id`,`neworder`.`neworder_date` ;

-- --------------------------------------------------------

--
-- Structure for view `feedbacklist`
--
DROP TABLE IF EXISTS `feedbacklist`;

DROP VIEW IF EXISTS `feedbacklist`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `feedbacklist`  AS  select `feedback`.`feedback_id` AS `feedback_id`,`feedback`.`feedback_user_id` AS `feedback_user_id`,`feedback`.`feedback_date` AS `feedback_date`,`feedback`.`feedback_title` AS `feedback_title`,`feedback`.`feedback_note` AS `feedback_note`,`feedback`.`feedback_state` AS `feedback_state`,`user`.`user_id` AS `user_id`,`user`.`user_reg` AS `user_reg`,`user`.`user_full_name` AS `user_full_name`,`user`.`user_email` AS `user_email`,`user`.`user_tel` AS `user_tel`,`user`.`user_addres` AS `user_addres` from (`feedback` join `user`) where (`feedback`.`feedback_user_id` = `user`.`user_id`) ;

DELIMITER $$
--
-- Events
--
DROP EVENT `daydelqunup`$$
CREATE DEFINER=`root`@`localhost` EVENT `daydelqunup` ON SCHEDULE EVERY 1 DAY STARTS '2021-06-07 23:59:59' ENDS '2023-03-07 23:59:59' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE deliver SET deliver_qun_today= 0 WHERE 1$$

DROP EVENT `delevermonth`$$
CREATE DEFINER=`root`@`localhost` EVENT `delevermonth` ON SCHEDULE EVERY 1 MONTH STARTS '2021-07-01 14:38:02' ENDS '2023-03-07 23:59:59' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE deliver SET deliver_qun_month= 0 WHERE 1$$

DROP EVENT `drop_deliver_log`$$
CREATE DEFINER=`root`@`localhost` EVENT `drop_deliver_log` ON SCHEDULE EVERY 1 WEEK STARTS '2021-07-01 16:19:02' ENDS '2025-07-01 16:19:02' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM deliver_log WHERE deliver_log_time < NOW() - INTERVAL 3 MONTH$$

DROP EVENT `drop_item_log`$$
CREATE DEFINER=`root`@`localhost` EVENT `drop_item_log` ON SCHEDULE EVERY 1 WEEK STARTS '2021-07-01 16:23:21' ENDS '2025-07-01 16:23:21' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM item_log WHERE item_log_time < NOW() - INTERVAL 3 MONTH$$

DROP EVENT `drop_neworder_log`$$
CREATE DEFINER=`root`@`localhost` EVENT `drop_neworder_log` ON SCHEDULE EVERY 1 WEEK STARTS '2021-07-01 16:25:07' ENDS '2025-07-01 16:25:07' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM neworder_log WHERE neworder_log_time < NOW() - INTERVAL 3 MONTH$$

DROP EVENT `drop_user_log`$$
CREATE DEFINER=`root`@`localhost` EVENT `drop_user_log` ON SCHEDULE EVERY 1 WEEK STARTS '2021-07-01 16:26:24' ENDS '2025-07-01 16:26:24' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM user_log WHERE user_log_time < NOW() - INTERVAL 3 MONTH$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
