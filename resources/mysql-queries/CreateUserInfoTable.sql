CREATE TABLE `user_info`
(
    `user_id`        bigint(20)  NOT NULL AUTO_INCREMENT,
    `user_name`      varchar(50) NOT NULL,
    `gender`         tinyint(1)           DEFAULT NULL,
    `date_of_birth`  date                 DEFAULT NULL,
    `contact_number` varchar(15)          DEFAULT NULL,
    `email`          varchar(50) NOT NULL,
    `created_at`     datetime             DEFAULT NULL,
    `updated_at`     timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `user_name` (`user_name`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `contact_number` (`contact_number`),
    KEY `user_id` (`user_id`, `user_name`, `email`, `contact_number`),
    CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user_credentials` (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;