CREATE SCHEMA IF NOT EXISTS `airport`;
USE airport;
CREATE TABLE IF NOT EXISTS `cities` (
    `city_id` INT(10) AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`city_id`)
);
CREATE TABLE IF NOT EXISTS `terminals` (
    `terminal_id` INT(10) AUTO_INCREMENT,
    `terminal` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`terminal_id`)
);
CREATE TABLE IF NOT EXISTS `statuses` (
    `status_id` INT(10) AUTO_INCREMENT,
    `status` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`status_id`)
);
CREATE TABLE IF NOT EXISTS `gates` (
    `gate_id` INT(10) AUTO_INCREMENT,
    `number` INT(10) NOT NULL,
    PRIMARY KEY (`gate_id`)
);
CREATE TABLE IF NOT EXISTS `flights` (
    `flight_id` INT(10) AUTO_INCREMENT,
    `type` VARCHAR(15) NOT NULL,
    `dates` DATETIME NOT NULL,
    `number` VARCHAR(5) NOT NULL,
    `city` INT(10) NOT NULL,
    `terminal` INT(10),
    `status` INT(10),
    `gate` INT(10),
    PRIMARY KEY (`flight_id`),
    FOREIGN KEY (`city`)
        REFERENCES `cities` (`city_id`),
    FOREIGN KEY (`terminal`)
        REFERENCES `terminals` (`terminal_id`),
    FOREIGN KEY (`status`)
        REFERENCES `statuses` (`status_id`),
    FOREIGN KEY (`gate`)
        REFERENCES `gates` (`gate_id`),
    INDEX (`number`),
    INDEX (`city`)
);
CREATE TABLE IF NOT EXISTS `classFlight` (
    `class_id` INT(10) AUTO_INCREMENT,
    `class_name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`class_id`)
);
CREATE TABLE IF NOT EXISTS `prices` (
    `prices_id` INT(10) AUTO_INCREMENT,
    `flight` INT(10) NOT NULL,
    `class` INT(10) NOT NULL,
    `price` DECIMAL,
    PRIMARY KEY (`prices_id`),
    FOREIGN KEY (`flight`)
        REFERENCES `flights` (`flight_id`),
    FOREIGN KEY (`class`)
        REFERENCES `classFlight` (`class_id`),
    INDEX (`price`)
);
CREATE TABLE IF NOT EXISTS `nationality` (
    `nat_id` INT(10) AUTO_INCREMENT,
    `nationality` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`nat_id`)
);
CREATE TABLE IF NOT EXISTS `passengers` (
    `pass_id` INT(10) AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `second_name` VARCHAR(50) NOT NULL,
    `nationality` INT(10) NOT NULL,
    `passport` VARCHAR(10) NOT NULL,
    `birthday` DATE NOT NULL,
    `gender` VARCHAR(25) NOT NULL,
    PRIMARY KEY (`pass_id`),
    FOREIGN KEY (`nationality`)
        REFERENCES `nationality` (`nat_id`),
    INDEX (`first_name`),
    INDEX (`second_name`),
    INDEX (`passport`)
);
CREATE TABLE IF NOT EXISTS `user` (
    `user_id` INT(10) AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `staff` TINYINT(1) DEFAULT 0,
    PRIMARY KEY (`user_id`),
    INDEX (`name`),
    INDEX (`password`)
);
CREATE TABLE IF NOT EXISTS `tickets` (
    `ticket_id` INT(10) AUTO_INCREMENT,
    `passengerclass_iddatesnumberstatusflight_idbirthday` INT(10) NOT NULL,
    `flight` INT(10) NOT NULL,
    `class` INT(10),
    PRIMARY KEY (`ticket_id`),
    FOREIGN KEY (`passenger`)
        REFERENCES `passengers` (`pass_id`),
    FOREIGN KEY (`flight`)
        REFERENCES `flights` (`flight_id`),
    FOREIGN KEY (`class`)
        REFERENCES `classFlight` (`class_id`)
);