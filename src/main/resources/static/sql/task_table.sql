CREATE TABLE `tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `duration` float NOT NULL,
  `date` datetime NOT NULL,
  `id_user` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_user_idx` (`id_user`),
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE
);
