CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empId` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(6) NOT NULL,
  `role` varchar(1) NOT NULL DEFAULT '0' COMMENT '0:employee,1:admin',
  `position` varchar(45) NOT NULL,
  `teamName` varchar(45) NOT NULL,
  `basicSalary` varchar(45) NOT NULL DEFAULT '150000',
  PRIMARY KEY (`id`,`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;