#mysql
CREATE TABLE `person` (
   `p_id` int(11) NOT NULL AUTO_INCREMENT,
   `p_name` varchar(50) DEFAULT NULL,
   `p_age` varchar(50) DEFAULT NULL,
   `p_hobby` varchar(50) DEFAULT NULL,
   `p_birthday` date DEFAULT NULL,
   `p_wage` double DEFAULT NULL,
   `p_company` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`p_id`)
 ) ENGINE=MyISAM AUTO_INCREMENT=205 DEFAULT CHARSET=utf8