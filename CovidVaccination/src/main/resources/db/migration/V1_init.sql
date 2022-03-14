CREATE TABLE postal_codes (
id BIGINT AUTO_INCREMENT,
postal_code VARCHAR(12),
municipality VARCHAR(60),
district VARCHAR(120),
CONSTRAINT pk_postal_codes PRIMARY KEY (id)
);

LOAD DATA INFILE 'postal_codes_hungary.csv'
INTO TABLE postal_codes
FIELDS TERMINATED BY ';'
IGNORE 1 ROWS;

CREATE TABLE clients (
id BIGINT AUTO_INCREMENT,
name VARCHAR(120),
postal_code VARCHAR(12),
age SMALLINT,
email VARCHAR(120),
social_security_number VARCHAR(9),
CONSTRAINT pk_clients PRIMARY KEY (id)
);