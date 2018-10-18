
-- Default data for wallet table
INSERT INTO wallet (id, currency, balance) values (1,'SGD',5500.50);
INSERT INTO wallet (id, currency, balance) values (2,'SGD',0);

INSERT INTO user (id,name,wallet_id) values (1,'Shopping Societies',1);
INSERT INTO user (id,name,wallet_id) values (2,'Duleendra Shashimal',2 );
INSERT INTO user (id,name,wallet_id) values (3,'John Mark',null);
INSERT INTO user (id,name,wallet_id) values (4,'Michel Clerk',null);
INSERT INTO user (id,name,wallet_id) values (5,'Simon Silva',null);
INSERT INTO user (id,name,wallet_id) values (6,'Stanley See',null);