CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;
 
-- Staff Table
CREATE TABLE staff (
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('Admin', 'Staff') NOT NULL
);
 
-- Patients Table
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender ENUM('Male', 'Female', 'Other'),
    phone VARCHAR(15),
    address VARCHAR(255)
);
-- Doctors Table
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100),
    phone VARCHAR(15)
);
 
-- drop table appointments,billing; 

CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    reason VARCHAR(255)
);
 
-- Billing Table
CREATE TABLE billing (
    billing_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    appointment_id INT,
    total_amount DECIMAL(10,2),
    discharge_date DATE,
    summary TEXT
);
 
INSERT INTO staff (username, password, role) VALUES ('admin', 'admin123', 'Admin');
select * from patients;
use hospital_db;
 
select * from staff;
select * from billing;