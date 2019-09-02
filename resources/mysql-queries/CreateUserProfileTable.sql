CREATE TABLE `user_profile`
(
    `user_id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `designation`  varchar(50)         DEFAULT NULL,
    `organization` varchar(50)         DEFAULT NULL,
    `about`        varchar(500)        DEFAULT NULL,
    `created_at`   datetime            DEFAULT NULL,
    `updated_at`   timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`),
    CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;