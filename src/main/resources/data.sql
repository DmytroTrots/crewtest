INSERT INTO `botscrewtest`.`degree` (`degree_name`) VALUES ('assistant');
INSERT INTO `botscrewtest`.`degree` (`degree_name`) VALUES ('associate professor');
INSERT INTO `botscrewtest`.`degree` (`degree_name`) VALUES ('professor');

INSERT INTO `botscrewtest`.`department` (`department_name`, `head_of_department_name`) VALUES ('DepartmentOne', 'HeadOne');
INSERT INTO `botscrewtest`.`department` (`department_name`, `head_of_department_name`) VALUES ('DepartmentTwo', 'HeadTwo');
INSERT INTO `botscrewtest`.`department` (`department_name`, `head_of_department_name`) VALUES ('DepartmentThree', 'HeadThree');
INSERT INTO `botscrewtest`.`department` (`department_name`, `head_of_department_name`) VALUES ('DepartmentFour', 'HeadFour');

INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('1', '12344', 'LectorOne', 'One');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('2', '32677', 'LectorTwo', 'Two');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('3', '3246', 'LectorThree', 'Three');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('1', '12456', 'LectorFour', 'Four');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('2', '65346', 'LectorFive', 'Five');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('3', '12345', 'LectorSix', 'Six');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('1', '12742', 'LectorSeven', 'Seven');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('2', '16234', 'LectorEight', 'Eight');
INSERT INTO `botscrewtest`.`lectors` (`degree_id`, `salary`, `name`, `surname`) VALUES ('3', '51246', 'LectorNine', 'Nine');

INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '1');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '2');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '3');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '4');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '5');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('1', '6');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('2', '7');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('2', '8');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('2', '9');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('2', '1');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('2', '2');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('3', '3');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('3', '4');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('3', '5');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('3', '6');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('3', '7');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('4', '8');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('4', '9');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('4', '1');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('4', '2');
INSERT INTO `botscrewtest`.`department_has_lector` (`department_id`, `lector_id`) VALUES ('4', '3');