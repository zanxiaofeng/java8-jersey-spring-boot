CREATE TABLE `TEMPLATE` (
  `ID` bigint(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `logic_question_repository_id` int(11) NOT NULL,
  `logic_question_hard_number` int(11) NOT NULL,
  `logic_question_middle_number` int(11) NOT NULL,
  `logic_question_easy_number` int(11) NOT NULL,
  `program_question_list` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
