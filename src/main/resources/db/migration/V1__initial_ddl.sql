-- wallet table

CREATE TABLE `wallet` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR (6) NOT NULL,
  `balance` DOUBLE(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- user table
CREATE TABLE `user` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) DEFAULT NULL,
  `wallet_id` BIGINT(11) unsigned DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY unique_user_id (wallet_id),
   CONSTRAINT `fk_user_wallet` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- product table
CREATE TABLE `product` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (60) NOT NULL,
  `unit_price` DOUBLE(10,2) DEFAULT 0,
  `units_in_stock` INT(11) unsigned DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- country table
CREATE TABLE `country` (
  `country_code` VARCHAR(6) NOT NULL,
  `name` VARCHAR (100) NOT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- currency table
CREATE TABLE `currency` (
  `currency_code` VARCHAR(6) NOT NULL,
  `name` VARCHAR (100) NOT NULL,
  `country_code` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`currency_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- user sale
CREATE TABLE `sale` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(11) NOT NULL,
  `price` DOUBLE(10,2) NULL DEFAULT 0,
  `total_items` INT(11) NULL DEFAULT 0,
  `items_left` INT(11) NULL DEFAULT 0,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

-- sale_eligible_country table
CREATE TABLE `sale_eligible_country` (
  `id` BIGINT(11) NOT NULL,
  `sale_id` BIGINT(11) NOT NULL,
  `country_code` VARCHAR(6) NOT NULL,
  `currency_code` VARCHAR(6) NULL,
  PRIMARY KEY (`id`, `sale_id`),
  CONSTRAINT `fk_sale_eligible_country_sale`
    FOREIGN KEY (`sale_id`)
    REFERENCES `sale` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);