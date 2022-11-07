CREATE TABLE `months` (
  `idmonths` int NOT NULL,
  `month` varchar(45) NOT NULL,
  PRIMARY KEY (`idmonths`),
  UNIQUE KEY `month_UNIQUE` (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

