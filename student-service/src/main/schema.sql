CREATE TABLE IF NOT EXISTS `Student` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `index` int(6) NOT NULL,
 `firstName` varchar(200) NOT NULL,
 `lastName` varchar(200) NOT NULL,
 PRIMARY KEY (`id`)
);