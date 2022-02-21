CREATE TABLE activities (
id BIGINT AUTO_INCREMENT,
start_time TIMESTAMP,
description VARCHAR(255),
activity_type VARCHAR(32),
CONSTRAINT pk_activities PRIMARY KEY (id)
);