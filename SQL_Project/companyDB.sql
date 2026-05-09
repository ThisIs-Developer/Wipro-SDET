create database company_db;
use company_db;

create table users (
    id int primary key auto_increment,
    username varchar(50),
    password varchar(50)
);

create table employees (
    id int primary key auto_increment,
    name varchar(50),
    department varchar(50),
    salary int,
    created_date date
);

insert into users(username,password)
values
('admin','admin123'),
('john','john123');

insert into employees(name,department,salary,created_date)
values
('rahul','it',40000,curdate()),
('amit','hr',35000,curdate()-interval 2 day),
('priya','it',50000,curdate()-interval 10 day);

select *
from users
where username='admin'
and password='admin123';

select *
from employees
where created_date >= curdate()-interval 7 day;

select department,
count(*) as total
from employees
group by department;

update employees
set salary=salary+5000
where department='it';

select * from employees;