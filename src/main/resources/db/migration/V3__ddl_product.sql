CREATE TABLE `product` (
  `id` BIGINT(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (60) NOT NULL,
  `unit_price` DOUBLE(10,2) DEFAULT 0,
  `units_in_stock` INT(11) unsigned DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `country` (
  `country_code` VARCHAR(6) NOT NULL,
  `name` VARCHAR (100) NOT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `currency` (
  `currency_code` VARCHAR(6) NOT NULL,
  `name` VARCHAR (100) NOT NULL,
  `country_code` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`currency_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `sale` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(11) NOT NULL,
  `price` DOUBLE(10,2) NULL DEFAULT 0,
  `total_items` INT(11) NULL DEFAULT 0,
  `items_left` INT(11) NULL DEFAULT 0,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

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


INSERT INTO country (country_code, name) VALUES ('SG','Singapore');
INSERT INTO country (country_code, name) VALUES ('USA','USA');
INSERT INTO country (country_code, name) VALUES ('LK','Sri Lanka');


INSERT INTO currency (currency_code, name, country_code) VALUES ('SGD','Singapore Dolars','SG');
INSERT INTO currency (currency_code, name, country_code) VALUES ('USD','US Dolars','USA');
INSERT INTO currency (currency_code, name, country_code) VALUES ('LKR','Sri Lankan Rupee','LK');


INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (1,'iPhone 7+',950.00,10);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (2,'iPad',750.00,20);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (3,'Samsung TV ',1250.00,15);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (4,'Apple Watch',990.00,6);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (5,'Mack Book Pro',3800.00,3);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (6,'iPad Mini',450.00,2);

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (1,1,950.00,5,5,'2018-10-19 00:00:00','2018-10-20 00:00:00');
INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (2,2,750.00,10,10,'2018-10-19 00:00:00','2018-10-19 10:00:00');
INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (3,3,1250.00,5,5,'2018-10-19 00:00:00','2018-10-21 00:00:00');
INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (4,4,990.00,3,3,'2018-10-19 00:00:00','2018-10-22 00:00:00');


INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (1,1,'SG','SGD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (2,1,'USA','USD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (3,1,'LK','LKR');

INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (4,2,'SG','SGD');

INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (5,3,'SG','SGD');

INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (6,4,'SG','SGD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (7,4,'LK','LKR');





