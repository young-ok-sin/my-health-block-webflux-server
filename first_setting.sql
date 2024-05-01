create database my_health_block;
CREATE USER 'test'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON . TO 'test'@'localhost';
FLUSH PRIVILEGES;