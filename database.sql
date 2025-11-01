-- ==========================================================
-- Database Script for Servlet-Project-Java
-- Author: Sumit Kumar Singh
-- Description: Creates 'jdbc_project' database with Employee
--              and Product tables and inserts sample data.
-- ==========================================================

-- Create Database
CREATE DATABASE IF NOT EXISTS jdbc_project;
USE jdbc_project;

-- Create Employee Table
CREATE TABLE IF NOT EXISTS Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Salary DOUBLE NOT NULL
);

-- Insert Sample Employees
INSERT INTO Employee (EmpID, Name, Salary) VALUES
(1, 'Sumit Kumar', 55000),
(2, 'Riya Sharma', 62000),
(3, 'Aman Verma', 48000),
(4, 'Priya Singh', 70000),
(5, 'Karan Patel', 50000);

-- Create Product Table
CREATE TABLE IF NOT EXISTS Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Price DOUBLE NOT NULL,
    Quantity INT NOT NULL
);

-- Insert Sample Products
INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES
(101, 'Laptop', 55000, 5),
(102, 'Mouse', 800, 25),
(103, 'Keyboard', 1500, 15),
(104, 'Monitor', 12000, 10),
(105, 'Pen Drive', 650, 30);

--  Verification Queries
-- Run these to check data after import
-- SELECT * FROM Employee;
-- SELECT * FROM Product;


