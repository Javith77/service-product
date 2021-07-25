DROP TABLE IF EXISTS tbl_products;
DROP TABLE IF EXISTS tbl_categories;
CREATE TABLE tbl_categories (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);


CREATE TABLE tbl_products (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  stock DOUBLE,
  price DOUBLE,
  status VARCHAR(250) NOT NULL,
  created_at TIMESTAMP,
  fk_category_id BIGINT
);