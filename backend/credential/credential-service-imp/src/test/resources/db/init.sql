CREATE TABLE `credential` (
  `id`        BIGINT(20) AUTO_INCREMENT,
  `username`  VARCHAR(255)            NOT NULL,
  `password`  VARCHAR(255)            NOT NULL,
  `confirmed` BOOLEAN DEFAULT FALSE   NOT NULL,
  `user_id`   BIGINT(20)              NOT NULL,
  PRIMARY KEY (`id`)
);
