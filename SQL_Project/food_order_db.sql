create database food_order_db;
use food_order_db;

create table staff(
user_id int primary key auto_increment,
username varchar(10),
password varchar(10));

create table customers(
customer_id int primary key auto_increment,
name varchar(10),
phone varchar(10),
address varchar(50));

create table menu(
item_id int primary key auto_increment,
item_name varchar(10),
price double);

create table orders(
order_id int primary key auto_increment,
customer_id int,
item_id int,
quantity int,
order_date date);

INSERT INTO staff (username, password) VALUES ('admin', 'admin123');

create table billing(
bill_id int primary key auto_increment,
customer_id int,
order_id int,
total_amount double,
bill_date date,
summary varchar(10));

select * from customers;
select * from users;
select * from menu;
select * from orders;
select * from billing;