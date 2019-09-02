CREATE TABLE `user_credentials`
(
    `user_name` varchar(50)  NOT NULL,
    `passwd`    varchar(255) NOT NULL,
    PRIMARY KEY (`user_name`),
    UNIQUE KEY `user_name` (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;