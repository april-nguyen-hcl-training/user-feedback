CREATE DATABASE IF NOT EXISTS `ecommerce`;

CREATE TABLE IF NOT EXISTS `ecommerce`.`feedback` (
	`id` bigint PRIMARY KEY AUTO_INCREMENT, 
	`rating` smallint,
	`username` varchar(50), 
	`comment` varchar(250), 
	`date` timestamp default now()
);