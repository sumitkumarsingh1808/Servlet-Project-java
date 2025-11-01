-- ==========================================================
-- Database Script for Product CRUD Operations
-- Database: productDB
-- Author: Sumit Kumar Singh
-- Description: Creates 'productDB' database with Product table
--              and inserts sample data for CRUD testing.
-- ==========================================================

--  Create Database
CREATE DATABASE IF NOT EXISTS productDB;
USE productDB;

--  Create Product Table
CREATE TABLE IF NOT EXISTS Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Quantity INT NOT NULL,
    Category VARCHAR(50) DEFAULT 'General'
);

-- Insert Sample Products
INSERT INTO Product (ProductName, Price, Quantity, Category) VALUES
('Laptop', 55000.00, 10, 'Electronics'),
('Mouse', 750.00, 50, 'Accessories'),
('Keyboard', 1500.00, 30, 'Accessories'),
('Monitor', 12000.00, 20, 'Electronics'),
('Headphones', 2500.00, 25, 'Audio'),
('Webcam', 3200.00, 15, 'Electronics'),
('USB Cable', 200.00, 100, 'Accessories'),
('External Hard Drive', 6500.00, 12, 'Storage');

-- Test Queries (Optional)
-- SELECT * FROM Product;
-- UPDATE Product SET Quantity = 40 WHERE ProductID = 2;
-- DELETE FROM Product WHERE ProductID = 6;
-- INSERT INTO Product (ProductName, Price, Quantity, Category)
-- VALUES ('Smartphone', 30000.00, 8, 'Electronics');
