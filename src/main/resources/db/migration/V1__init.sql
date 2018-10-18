CREATE TABLE `wallet` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR (6) NOT NULL,
  `balance` DOUBLE(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `wallet_id` BIGINT(11) unsigned DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY unique_user_id (wallet_id),
   CONSTRAINT `fk_user_wallet` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

