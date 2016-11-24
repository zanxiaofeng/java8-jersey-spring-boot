CREATE TABLE `QUIZREPOSITORY` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` varchar(512) NOT NULL,
  `modifiedtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `LOGICQUIZ` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `repository_id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` varchar(512) NOT NULL,
  `options` VARCHAR (4096) NOT NULL,
  `answer` VARCHAR (64) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (repository_id) REFERENCES QUIZREPOSITORY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `PROGRAMQUIZ` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `repository_id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` varchar(4096) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (repository_id) REFERENCES QUIZREPOSITORY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PROGRAMQUIZTESTCASE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `programquiz_id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL,
  `content` varchar(8192) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (programquiz_id) REFERENCES programquiz(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;