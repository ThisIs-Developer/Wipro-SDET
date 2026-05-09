-- Create Database
create database mydata;
use mydata;

-- Create table
create table student(rollno int, name varchar(20), pre float, age int);
select * from student;

-- Insert Value
insert into student values
(01,"Baivab",98.4,23),
(02,"Ayan",45.2,23),
(03,"Arpan ",75.7,21),
(04,null,67.8,null);
insert into student values (05,"Baivab",55.5,21);

-- Where
select * from student where name is null;
select rollno, name from student where name is null;
select * from student where name is not null;
select * from student where pre<=90;
select * from student where pre>90;
select * from student where pre<=90 and name is null;
select * from student where pre<=90 or name is null;

-- Delete Table
drop table student;

-- Order By
select * from student order by pre desc;
select * from student order by pre asc;
select * from student order by name desc;
select * from student where pre>=90 and name="Baivab";

-- Group by
select age, count(age) from student group by age;
select pre, count(pre) from student group by pre;
select pre, sum(pre) from student group by pre;

-- Having
select age, count(age) from student group by age having count(age)>=0;

-- Limit
select * from student limit 2;

-- Like
select * from student where name like '%n';

-- In
select * from student where age in(21,22,23);

-- Between
select * from student where age between 21 AND 22;

-- Join
create table Customer (custid int, name varchar(20), pro_name varchar(20), pur_date date);
create table Orders (custid int, pro_name varchar(20), del_date date, rev_date date);

insert into Customer values
(101, "Nisha", "Laptop",'2026-5-6'),
(103, "Misha", "iphone",'2026-12-2'),
(104, "Natasha", "Hat",'2026-6-7');

insert into Orders values
(101, "Nisha", '2026-5-6','2026-5-12'),
(102, "Samiksha", '2026-12-2','2026-12-8'),
(104, "Natasha", '2026-6-7','2026-6-17');

select * from Customer;
select * from Orders;

-- Inner Join
select * from Customer inner join Orders where Customer.custid=Orders.custid;
select Customer.custid, Customer.name, Customer.pur_date, Orders.del_date, Orders.rev_date 
from Customer inner join Orders where Customer.custid = Orders.custid;

-- Left Join
select * from Customer left join Orders on Customer.custid=Orders.custid;
select Customer.custid, Customer.name, Customer.pur_date, Orders.del_date, Orders.rev_date 
from Customer left join Orders on Customer.custid = Orders.custid;

-- right Join
select * from Customer right join Orders on Customer.custid=Orders.custid;
select Customer.custid, Customer.name, Customer.pur_date, Orders.del_date, Orders.rev_date 
from Customer right join Orders on Customer.custid = Orders.custid;

-- Full join
select * from Customer
left join Orders
on Customer.custid=Orders.custid
union
select * from Customer
right join Orders
on Customer.custid=Orders.custid;

-- Update row(table data)
select * from student;
update student
set name="Neha"
where rollno=04;
 
update student
set age=22
where rollno=04;


-- Update table : Add Coloum
select * from student;
alter table student add address varchar(30);

-- Update the new coloume values (add data to new colume)
update student set address="Kolkata" where rollno=01;

-- Ddelete coloumn
alter table student drop column age;

-- Delete row
delete from student where rollno=05;
 
-- Change data type of column attribute
alter table student 
modify pre int;
 
-- Rename column attribute name
alter table student 
change name f_name  varchar(20);
 
-- Rename table 
rename table student to student_details;
rename table student_details to student;
select * from student_details;

-- Delete all data from table
truncate table student;
select * from student;

-- Delete table
drop table student;






