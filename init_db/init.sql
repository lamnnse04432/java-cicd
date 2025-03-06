CREATE DATABASE testdb;
USE testdb;
CREATE TABLE employee
(
    id   bigint       PRIMARY KEY,
    name varchar(100) DEFAULT NULL,
    age  varchar(100) DEFAULT NULL
);

INSERT INTO testdb.employee
    (id, name, age)
VALUES (1, 'lam', '29');