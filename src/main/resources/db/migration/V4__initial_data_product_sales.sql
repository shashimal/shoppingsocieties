-- country data
INSERT INTO country (country_code, name) VALUES ('SG','Singapore');
INSERT INTO country (country_code, name) VALUES ('US','United States of America');
INSERT INTO country (country_code, name) VALUES ('LK','Sri Lanka');
INSERT INTO country (country_code, name) VALUES ('CN','China');
INSERT INTO country (country_code, name) VALUES ('ZA','South Africa');
INSERT INTO country (country_code, name) VALUES ('CH','Switzerland');
INSERT INTO country (country_code, name) VALUES ('VN','Viet Nam');
INSERT INTO country (country_code, name) VALUES ('ES','Spain');
INSERT INTO country (country_code, name) VALUES ('NZ','New Zealand');
INSERT INTO country (country_code, name) VALUES ('AU','Australia');

-- currency data
INSERT INTO currency (currency_code, name, country_code) VALUES ('SGD','Singapore Dollar','SG');
INSERT INTO currency (currency_code, name, country_code) VALUES ('USD','US Dollar','US');
INSERT INTO currency (currency_code, name, country_code) VALUES ('LKR','Sri Lankan Rupee','LK');
INSERT INTO currency (currency_code, name, country_code) VALUES ('NZD','New Zealand Dollar','NZ');
INSERT INTO currency (currency_code, name, country_code) VALUES ('AUD','Australia Dollar','AU');


-- product data
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (1,'iPhone 7+',950.00,10);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (2,'iPad',750.00,20);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (3,'Samsung TV ',1250.00,15);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (4,'Apple Watch',990.00,6);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (5,'Mack Book Pro',3800.00,3);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (6,'iPad Mini',450.00,2);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (7,'Rolex Watch',3250.00,2);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (8,'Hand Bag',50.00,10);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (9,'Power Bank',30.00,20);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (10,'Samsung LCD Monitor',450.00,3);
INSERT INTO product (id, name, unit_price,units_in_stock) VALUES (11,'Apple Key Board',250.00,5);


-- flash sale data
INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (1,1,950.00,5,5,'2018-10-21 00:00:00','2019-10-29 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (1,1,'SG','SGD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (2,1,'US','USD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (3,1,'LK','LKR');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (2,2,750.00,10,10,'2018-10-21 00:00:00','2019-10-29 10:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (4,2,'SG','SGD');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (3,3,1250.00,5,5,'2018-10-21 00:00:00','2018-10-21 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (5,3,'SG','SGD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (6,3,'NZ','NZD');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (4,4,990.00,3,3,'2018-10-19 00:00:00','2018-10-22 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (7,4,'LK','LKR');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (5,10,450.00,1,1,'2018-10-22 00:00:00','2018-10-25 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (8,5,'SG','SGD');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (6,7,3250.00,1,1,'2018-10-21 00:00:00','2019-10-25 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (9,6,'SG','SGD');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (10,6,'US','USD');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (7,9,30.00,10,10,'2018-10-21 00:00:00','2018-10-29 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (11,7,'SG','SGD');

INSERT INTO sale (id, product_id, price,total_items,items_left,start_time,end_time) VALUES (8,11,250.00,4,4,'2018-10-19 00:00:00','2018-10-29 00:00:00');
INSERT INTO sale_eligible_country(id,sale_id,country_code,currency_code) VALUES (12,8,'SG','SGD');








