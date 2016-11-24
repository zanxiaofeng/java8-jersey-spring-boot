DROP TABLE IF EXISTS `exam`;

CREATE TABLE `exam` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` varchar(50) DEFAULT NULL,
  `end_time` varchar(50) DEFAULT NULL,
  `template_id` int(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
