CREATE TABLE postal_codes (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    postal_code VARCHAR(12) NOT NULL,
    municipality VARCHAR(60) NOT NULL,
    district VARCHAR(120)
);

CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    postal_code VARCHAR(12) NOT NULL,
    age SMALLINT NOT NULL,
    email VARCHAR(120),
    social_security_number VARCHAR(9),
    number_of_vaccination SMALLINT,
    last_vaccination DATETIME
);

CREATE TABLE vaccinations (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    client_id BIGINT NOT NULL,
    vaccination_date DATETIME NOT NULL,
    status VARCHAR(10),
    note VARCHAR(255),
    vaccina_type VARCHAR(120),
    CONSTRAINT fk_client_vaccination
    FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE vaccina_types (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    primary_series TINYINT NOT NULL,
    min_age SMALLINT,
    max_age SMALLINT
);