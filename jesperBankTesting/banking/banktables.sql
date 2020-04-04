SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS bank;
drop table if exists account;
drop table if exists customer;



CREATE TABLE bank (
    id        INT PRIMARY KEY
   
  );
  
 CREATE TABLE account (
    id        INT PRIMARY KEY,
    bank int,
    customer int,
    number varchar(255),
    balance bigint,
    
    FOREIGN KEY (customer) REFERENCES customer(id),
    FOREIGN KEY (bank) REFERENCES bank(id)
   
  );
 
 CREATE TABLE customer (
    id        INT PRIMARY KEY,
    number varchar(255),
    name varchar(255),
    account int,
    bank int,
    FOREIGN KEY (bank) REFERENCES bank(id),
    FOREIGN KEY (account) REFERENCES account(id)
   
  );
  
 SET FOREIGN_KEY_CHECKS = 1;
 