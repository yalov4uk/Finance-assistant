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

ALTER TABLE account ADD currency VARCHAR(255) NULL;

ALTER TABLE account CHANGE initial_balance balance DECIMAL(10,2);
ALTER TABLE transaction MODIFY value DECIMAL(10,2);
ALTER TABLE transfer MODIFY value DECIMAL(10,2);
