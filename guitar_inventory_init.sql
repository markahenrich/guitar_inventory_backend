DROP DATABASE IF EXISTS `guitar_inventory`;
CREATE DATABASE `guitar_inventory`;
USE `guitar_inventory`;

CREATE TABLE `manufacturer` (
	m_id INT NOT NULL,
    m_name VARCHAR(20),
    PRIMARY KEY (m_id)
);

INSERT INTO `manufacturer` VALUES (1, 'Gibson');
INSERT INTO `manufacturer` VALUES (2, 'Fender');
INSERT INTO `manufacturer` VALUES (3, 'B.C. Rich');

CREATE TABLE `guitar_model` (
	g_id INT NOT NULL AUTO_INCREMENT,
    m_id INT NOT NULL,
    model_name VARCHAR(20) NOT NULL,
    model_year INT,
    color VARCHAR(20),
    price DECIMAL(6, 2),
    PRIMARY KEY (g_id),
    FOREIGN KEY (m_id) REFERENCES `manufacturer`(m_id)
);

INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (1, 'Les Paul', 2021, 'Gold Top', 1999.99); 
INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (1, 'Flying V', 2020, 'White', 1699.99); 
INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (1, 'SG', 2000, 'Red', 1499.99); 
INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (2, 'Stratocaster', 2018, 'Black', 999.99); 
INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (2, 'Telecaster', 2020, 'Green', 1299.99); 
INSERT INTO `guitar_model` (m_id, model_name, model_year, color, price) VALUES (3, 'Mockingbird', 2015, 'Black/Gold', 999.99); 

CREATE VIEW `all_makes_and_models` AS
SELECT m_name AS 'Make', model_name AS 'Model', model_year AS 'Year', color AS 'Color', price AS 'Price' 
FROM `manufacturer` AS `m`
JOIN `guitar_model` AS `g` ON `g`.m_id = `m`.m_id;

