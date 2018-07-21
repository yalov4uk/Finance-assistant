CREATE TABLE `user` (
  `id`   BIGINT(20) NOT NULL               AUTO_INCREMENT,
  `name` VARCHAR(255)                      DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
);

CREATE TABLE `сredential` (
  `id`        BIGINT(20)              NOT NULL               AUTO_INCREMENT,
  `username`  VARCHAR(255)            NOT NULL,
  `password`  VARCHAR(255)                                   DEFAULT NULL,
  `type`      VARCHAR(255)                                   DEFAULT NULL,
  `confirmed` BOOLEAN DEFAULT FALSE   NOT NULL,
  `user_id`   BIGINT(20)              NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw3apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `account` (
  `id`           BIGINT(20)     NOT NULL            AUTO_INCREMENT,
  `icon`         VARCHAR(255)                       DEFAULT NULL,
  `balance`      DECIMAL(10, 2) NOT NULL            DEFAULT 0,
  `initial_date` DATETIME                           DEFAULT NULL,
  `name`         VARCHAR(255)                       DEFAULT NULL,
  `currency`     VARCHAR(255)   NOT NULL            DEFAULT 'USD',
  `user_id`      BIGINT(20)     NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `category` (
  `id`      BIGINT(20)   NOT NULL      AUTO_INCREMENT,
  `icon`    VARCHAR(255)               DEFAULT NULL,
  `name`    VARCHAR(255)               DEFAULT NULL,
  `type`    VARCHAR(255) NOT NULL      DEFAULT 'OUTCOME',
  `user_id` BIGINT(20)   NOT NULL,

  PRIMARY KEY (`id`),
  KEY `FKpfk8djhv5natgshmxiav6xkpu` (`user_id`),
  CONSTRAINT `FKpfk8djhv5natgshmxiav6xkpu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `transaction` (
  `id`          BIGINT(20)     NOT NULL           AUTO_INCREMENT,
  `date`        DATETIME                          DEFAULT NULL,
  `note`        VARCHAR(255)                      DEFAULT NULL,
  `value`       DECIMAL(10, 2) NOT NULL           DEFAULT 0,
  `account_id`  BIGINT(20)     NOT NULL,
  `category_id` BIGINT(20)     NOT NULL,
  `user_id`     BIGINT(20)     NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`),
  KEY `FKgik7ruym8r1n4xngrclc6kiih` (`category_id`),
  KEY `FKsg7jp0aj6qipr50856wf6vbw1` (`user_id`),
  CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `FKgik7ruym8r1n4xngrclc6kiih` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `FKsg7jp0aj6qipr50856wf6vbw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `transfer` (
  `id`              BIGINT(20)     NOT NULL           AUTO_INCREMENT,
  `date`            DATETIME                          DEFAULT NULL,
  `note`            VARCHAR(255)                      DEFAULT NULL,
  `value`           DECIMAL(10, 2) NOT NULL           DEFAULT 0,
  `exchange_rate`   DECIMAL(10, 2) NOT NULL           DEFAULT 1,
  `from_account_id` BIGINT(20)     NOT NULL,
  `to_account_id`   BIGINT(20)     NOT NULL,
  `user_id`         BIGINT(20)     NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfbrtpigqywdcc6e64ichki73j` (`from_account_id`),
  KEY `FKrppn0djf9uip7gj308swxq54j` (`to_account_id`),
  KEY `FKddbjk8kle2s7siw04lua30sjl` (`user_id`),
  CONSTRAINT `FKddbjk8kle2s7siw04lua30sjl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `FKfbrtpigqywdcc6e64ichki73j` FOREIGN KEY (`from_account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `FKrppn0djf9uip7gj308swxq54j` FOREIGN KEY (`to_account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE confirmation_code
(
  `id`      BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `code`    VARCHAR(255) NOT NULL,
  `user_id` BIGINT(20)   NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `confirmation_code_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
);