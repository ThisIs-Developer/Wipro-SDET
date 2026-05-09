CREATE DATABASE traffic_db;

USE traffic_db;

CREATE TABLE police(
    police_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE violations(
    violation_id INT PRIMARY KEY AUTO_INCREMENT,
    owner_name VARCHAR(100),
    vehicle_number VARCHAR(30),
    reason VARCHAR(100),
    fine_amount DOUBLE,
    violation_date DATE
);

INSERT INTO police(username,password)
VALUES('admin','admin123');

CREATE TABLE submitted_bills(
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    violation_id INT,
    owner_name VARCHAR(100),
    vehicle_number VARCHAR(30),
    fine_amount DOUBLE,
    submit_date DATE
);