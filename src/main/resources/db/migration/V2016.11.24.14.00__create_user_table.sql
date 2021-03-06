CREATE TABLE `USER` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `time_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `USER` ADD `phone` VARCHAR(11)  NULL  DEFAULT NULL  AFTER `time_created`;
ALTER TABLE `USER` ADD `school` VARCHAR(20)  NULL  DEFAULT NULL  AFTER `phone`;
ALTER TABLE `USER` ADD `grade` VARCHAR(10)  NULL  DEFAULT NULL  AFTER `school`;
ALTER TABLE `USER` ADD `realname` VARCHAR(10)  NULL  DEFAULT NULL  AFTER `grade`;
ALTER TABLE `USER` ADD `sex` INT(1)  NULL  DEFAULT NULL  AFTER `realname`;
ALTER TABLE `USER` ADD `age` INT(3)  NULL  DEFAULT NULL  AFTER `sex`;





