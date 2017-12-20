CREATE TABLE `category_type` (
  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255)        DEFAULT NULL,
  `balance_type` VARCHAR(255)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

ALTER TABLE category
  ADD COLUMN category_type_id BIGINT;
ALTER TABLE category
  ADD FOREIGN KEY (category_type_id) REFERENCES category_type (id);
ALTER TABLE category
  DROP COLUMN category_type;

INSERT INTO category_type (name, balance_type) VALUES ('', 'INCOME');
INSERT INTO category_type (name, balance_type) VALUES ('', 'OUTCOME');

ALTER TABLE account
  ADD currency VARCHAR(255) NULL;

ALTER TABLE account
  CHANGE initial_balance balance DECIMAL(10, 2);
ALTER TABLE transaction
  MODIFY value DECIMAL(10, 2);
ALTER TABLE transfer
  MODIFY value DECIMAL(10, 2);

ALTER TABLE account
  DROP FOREIGN KEY FK7m8ru44m93ukyb61dfxw0apf6;
ALTER TABLE account
  ADD CONSTRAINT FK7m8ru44m93ukyb61dfxw0apf6
FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE;

ALTER TABLE category
  DROP FOREIGN KEY FKpfk8djhv5natgshmxiav6xkpu;
ALTER TABLE category
  ADD CONSTRAINT FKpfk8djhv5natgshmxiav6xkpu
FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE;
ALTER TABLE category
  DROP FOREIGN KEY category_ibfk_1;
ALTER TABLE category
  ADD CONSTRAINT category_ibfk_1
FOREIGN KEY (category_type_id) REFERENCES category_type (id)
  ON DELETE CASCADE;

ALTER TABLE transaction
  DROP FOREIGN KEY FK6g20fcr3bhr6bihgy24rq1r1b;
ALTER TABLE transaction
  ADD CONSTRAINT FK6g20fcr3bhr6bihgy24rq1r1b
FOREIGN KEY (account_id) REFERENCES account (id)
  ON DELETE CASCADE;
ALTER TABLE transaction
  DROP FOREIGN KEY FKgik7ruym8r1n4xngrclc6kiih;
ALTER TABLE transaction
  ADD CONSTRAINT FKgik7ruym8r1n4xngrclc6kiih
FOREIGN KEY (category_id) REFERENCES category (id)
  ON DELETE CASCADE;
ALTER TABLE transaction
  DROP FOREIGN KEY FKsg7jp0aj6qipr50856wf6vbw1;
ALTER TABLE transaction
  ADD CONSTRAINT FKsg7jp0aj6qipr50856wf6vbw1
FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE;

ALTER TABLE transfer
  DROP FOREIGN KEY FKfbrtpigqywdcc6e64ichki73j;
ALTER TABLE transfer
  ADD CONSTRAINT FKfbrtpigqywdcc6e64ichki73j
FOREIGN KEY (from_account_id) REFERENCES account (id)
  ON DELETE CASCADE;
ALTER TABLE transfer
  DROP FOREIGN KEY FKrppn0djf9uip7gj308swxq54j;
ALTER TABLE transfer
  ADD CONSTRAINT FKrppn0djf9uip7gj308swxq54j
FOREIGN KEY (to_account_id) REFERENCES account (id)
  ON DELETE CASCADE;
ALTER TABLE transfer
  DROP FOREIGN KEY FKddbjk8kle2s7siw04lua30sjl;
ALTER TABLE transfer
  ADD CONSTRAINT FKddbjk8kle2s7siw04lua30sjl
FOREIGN KEY (user_id) REFERENCES user (id)
  ON DELETE CASCADE;

ALTER TABLE transfer
  ADD exchange_rate DECIMAL(10, 2) DEFAULT 1 NULL;
