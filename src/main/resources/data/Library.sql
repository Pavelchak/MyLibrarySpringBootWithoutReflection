
CREATE SCHEMA IF NOT EXISTS mylibrary DEFAULT CHARACTER SET utf8 ;
USE mylibrary ;

CREATE TABLE IF NOT EXISTS Book (
  book_id BIGINT NOT NULL AUTO_INCREMENT,
  book_name VARCHAR(45) NOT NULL,
  author VARCHAR(45) NOT NULL,
  publisher VARCHAR(50) NULL,
  imprint_year INT NULL,
  amount INT NOT NULL,
  PRIMARY KEY (book_id)
  ) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS city (
  city_id BIGINT NOT NULL AUTO_INCREMENT,
  city VARCHAR(25) NOT NULL,
  PRIMARY KEY (city_id)
  ) ENGINE = InnoDB
AUTO_INCREMENT = 1 
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS person (
  person_id BIGINT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(25) NOT NULL,
  name VARCHAR(25) NOT NULL,
  email VARCHAR(45) NULL,
  city_id BIGINT NULL,
  street VARCHAR(30) NULL,
  apartment VARCHAR(10) NULL,
  PRIMARY KEY (person_id),
  CONSTRAINT fk_person_city1
    FOREIGN KEY (city_id)
    REFERENCES mylibrary.city (city_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS person_book (
  person_id BIGINT NOT NULL,
  book_id BIGINT NOT NULL,
  PRIMARY KEY (person_id, book_id),
  CONSTRAINT personbook_ibfk_1
    FOREIGN KEY (person_id)
    REFERENCES mylibrary.person (person_id),
  CONSTRAINT personbook_ibfk_2
    FOREIGN KEY (book_id)
    REFERENCES mylibrary.book (book_id)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS logger (
  logger_id BIGINT NOT NULL AUTO_INCREMENT,
  person VARCHAR(50) NOT NULL,
  book VARCHAR(90) NOT NULL,
  action VARCHAR(10) NOT NULL,
  time_stamp DATETIME NOT NULL,
  user VARCHAR(50) NULL,
  PRIMARY KEY (logger_id)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;









