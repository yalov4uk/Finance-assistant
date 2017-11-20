CREATE TABLE `account` (
  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `icon`            VARCHAR(255)        DEFAULT NULL,
  `initial_balance` BIGINT(20)          DEFAULT NULL,
  `initial_date`    DATETIME            DEFAULT NULL,
  `name`            VARCHAR(255)        DEFAULT NULL,
  `user_id`         BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `category` (
  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_type` INT(11)             DEFAULT NULL,
  `icon`          VARCHAR(255)        DEFAULT NULL,
  `name`          VARCHAR(255)        DEFAULT NULL,
  `user_id`       BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpfk8djhv5natgshmxiav6xkpu` (`user_id`),
  CONSTRAINT `FKpfk8djhv5natgshmxiav6xkpu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `transaction` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date`        DATETIME            DEFAULT NULL,
  `note`        VARCHAR(255)        DEFAULT NULL,
  `value`       INT(11)             DEFAULT NULL,
  `account_id`  BIGINT(20)          DEFAULT NULL,
  `category_id` BIGINT(20)          DEFAULT NULL,
  `user_id`     BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`),
  KEY `FKgik7ruym8r1n4xngrclc6kiih` (`category_id`),
  KEY `FKsg7jp0aj6qipr50856wf6vbw1` (`user_id`),
  CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKgik7ruym8r1n4xngrclc6kiih` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKsg7jp0aj6qipr50856wf6vbw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `transfer` (
  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date`            DATETIME            DEFAULT NULL,
  `note`            VARCHAR(255)        DEFAULT NULL,
  `value`           INT(11)             DEFAULT NULL,
  `from_account_id` BIGINT(20)          DEFAULT NULL,
  `to_account_id`   BIGINT(20)          DEFAULT NULL,
  `user_id`         BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbrtpigqywdcc6e64ichki73j` (`from_account_id`),
  KEY `FKrppn0djf9uip7gj308swxq54j` (`to_account_id`),
  KEY `FKddbjk8kle2s7siw04lua30sjl` (`user_id`),
  CONSTRAINT `FKddbjk8kle2s7siw04lua30sjl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKfbrtpigqywdcc6e64ichki73j` FOREIGN KEY (`from_account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKrppn0djf9uip7gj308swxq54j` FOREIGN KEY (`to_account_id`) REFERENCES `account` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user` (
  `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `email`    VARCHAR(255) NOT NULL,
  `name`     VARCHAR(255)          DEFAULT NULL,
  `password` VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
