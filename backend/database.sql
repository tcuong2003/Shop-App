CREATE DATABASE shopapp; 
USE shopapp;

#each user has a role
CREATE TABLE roles(
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

#customer buy product => sign up => create table users
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(200) NOT NULL DEFAULT '', 
    password VARCHAR(100) NOT NULL DEFAULT '', #encrypted password
    created_at DATETIME, #check user
    updated_at DATETIME, #check user
    is_active TINYINT(1) DEFAULT 1, #soft erase //login = 1, logout = 0   
    date_of_birth DATE,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

#each user has a token when login can not password (token has time)
CREATE TABLE tokens( #extract info token 'claim' contain user, password, email
    id INT PRIMARY KEY AUTO_INCREMENT,
    token VARCHAR(255) UNIQUE NOT NULL,
    token_type VARCHAR(50) NOT NULL,
    expiration_date DATETIME,
    revoked TINYINT(1) NOT NULL,
    exprired TINYINT(1) NOT NULL,
    user_id INT, #link table user foreign key
    FOREIGN KEY (user_id) REFERENCES users (id)
);

#support login from facebook and google
CREATE TABLE socials_accounts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL,
    provider_id VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    name VARCHAR(100) NOT NULL,
    user_id INT, 
    FOREIGN KEY (user_id) REFERENCES users(id)
);

#categories for customers
CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL DEFAULT ''
);

#product for customers
CREATE TABLE products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nam VARCHAR(350) NOT NULL DEFAULT '',
    price FLOAT NOT NULL CHECK (price >= 0),
    thumbnail VARCHAR(300) DEFAULT '',
    description LONGTEXT,
    created_at DATETIME, 
    updated_at DATETIME,
    category_id INT, 
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

#Orders
CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL DEFAULT '',
    email VARCHAR(150) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(200) NOT NULL,
    note VARCHAR(100) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending, processing, shipped, delivered, cancelled'),
    total_money FLOAT CHECK(total_money>=0),
    shipping_method VARCHAR(100),
    shipping_address VARCHAR(200),
    shipping_date DATE,
    tracking_number VARCHAR(100),
    payment_method VARCHAR(100),
    active TINYINT(1),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT, 
    price FLOAT CHECK (price >= 0),
    number_of_products INT CHECK(number_of_products > 0),
    total_money FLOAT CHECK(total_money >= 0),
    color VARCHAR(20) DEFAULT '',
    order_id INT, 
    FOREIGN KEY (order_id) REFERENCES orders(id),
    product_id INT, 
    FOREIGN KEY (product_id) REFERENCES products(id)
);