

create database jdbc

use jdbc

//create user with password
create user 'sqljdbc'@'localhost' identified by 'praj@123';

grant all privileges on jdbc.* to 'sqljdbc'@'localhost';

create table Students(roll int , name varchar(100), dept varchar(100),email varchar(100));

