CREATE TABLE activities (
id BIGINT AUTO_INCREMENT,
start_time TIMESTAMP,
activity_desc VARCHAR(128),
activity_type VARCHAR(32),
CONSTRAINT pk_activities PRIMARY KEY (id)
);