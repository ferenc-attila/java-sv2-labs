CREATE TABLE postal_codes (
    id BIGINT AUTO_INCREMENT NOT NULL,
    postal_code VARCHAR(12) NOT NULL,
    municipality VARCHAR(60) NOT NULL,
    district VARCHAR(120),
    CONSTRAINT pk_postal_codes PRIMARY KEY (id)
);

LOAD DATA INFILE 'postal_codes_hungary.csv'
INTO TABLE postal_codes
FIELDS TERMINATED BY ';'
IGNORE 1 ROWS;

CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    postal_code VARCHAR(12) NOT NULL,
    age SMALLINT NOT NULL,
    email VARCHAR(120),
    social_security_number VARCHAR(9),
    number_of_vaccination SMALLINT,
    last_vaccination DATETIME,
    CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE vaccinations (
    id BIGINT AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    vaccination_date DATETIME NOT NULL,
    status VARCHAR(10),
    note VARCHAR(255),
    vaccina_type VARCHAR(120)
    CONSTRAINT pk_vaccinations PRIMARY KEY (id),
    CONSTRAINT fk_client_vaccination FOREIGN KEY(client_id) REFERENCES clients(id)
);

CREATE TABLE vaccina_types (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    primary_series TINYINT NOT NULL,
    min_age SMALLINT,
    max_age SMALLINT,
    CONSTRAINT pk_vaccina_types PRIMARY KEY(id)
);

LOAD DATA INFILE 'vaccina_types.csv'
INTO TABLE vaccina_types
FIELDS TERMINATED BY ';'
IGNORE 1 ROWS;