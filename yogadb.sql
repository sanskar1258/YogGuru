CREATE DATABASE yogadb;

use yogadb

CREATE Table users 
(
    user_id int auto_increment PRIMARY KEY,
    name char(45) not null,
    email char(255)  unique,
    password char(255) not null,
    user_type int,
    age int,
    phone char(10),
    selected_batch VARCHAR(20) NOT NULL,
    start_date DATE NOT NULL
);

