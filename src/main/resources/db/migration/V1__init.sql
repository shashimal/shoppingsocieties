CREATE TABLE `user` (
  `user_id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `wallet` (
  `wallet_id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `currency_code` VARCHAR (6) NOT NULL,
  `balance` DOUBLE DEFAULT NULL,
  `user_id` BIGINT(11) unsigned NOT NULL,
  PRIMARY KEY (`wallet_id`),
  CONSTRAINT `fk_wallet_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;