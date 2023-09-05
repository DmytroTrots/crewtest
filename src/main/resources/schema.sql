CREATE DATABASE  IF NOT EXISTS `botscrewtest`;

DROP TABLE IF EXISTS `department_has_lector`;
DROP TABLE IF EXISTS `lectors`;
DROP TABLE IF EXISTS `degree`;
DROP TABLE IF EXISTS `department`;

CREATE TABLE `degree` (
       `degree_id` int NOT NULL AUTO_INCREMENT,
       `degree_name` varchar(125) NOT NULL,
       PRIMARY KEY (`degree_id`),
       UNIQUE KEY `UK_bhbcxx2jqgfuwmsx2jtx6kf8o` (`degree_name`)
);

CREATE TABLE `lectors` (
       `degree_id` int NOT NULL,
       `lector_id` int NOT NULL AUTO_INCREMENT,
       `salary` decimal(38,2) NOT NULL,
       `name` varchar(125) NOT NULL,
       `surname` varchar(125) NOT NULL,
       PRIMARY KEY (`lector_id`),
       UNIQUE KEY `UK_a1sw33i35mm9s32oiemf4xhmd` (`surname`),
       KEY `FK5kowct63esj9dpvrqenl9ifuy` (`degree_id`),
       CONSTRAINT `FK5kowct63esj9dpvrqenl9ifuy` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`degree_id`)
);

CREATE TABLE `department` (
       `department_id` int NOT NULL AUTO_INCREMENT,
       `department_name` varchar(125) NOT NULL,
       `head_of_department_name` varchar(125) NOT NULL,
       PRIMARY KEY (`department_id`),
       UNIQUE KEY `UK_f5np34wnxt905fwmrs6133l28` (`department_name`),
       UNIQUE KEY `UK_h2mhxkj36f6hj9hrlpaqt4yl0` (`head_of_department_name`)
);

CREATE TABLE `department_has_lector` (
       `department_id` int NOT NULL,
       `lector_id` int NOT NULL,
       PRIMARY KEY (`department_id`,`lector_id`),
       KEY `FKstvgrpreu2ua9saoael2v7xfn` (`lector_id`),
       CONSTRAINT `FK5nth34w1qvvgvwln7qfojpige` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
       CONSTRAINT `FKstvgrpreu2ua9saoael2v7xfn` FOREIGN KEY (`lector_id`) REFERENCES `lectors` (`lector_id`)
);