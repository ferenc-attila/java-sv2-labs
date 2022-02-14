CREATE TABLE activities (
id BIGINT AUTO_INCREMENT,
start_time TIMESTAMP,
activity_desc VARCHAR(255),
activity_type VARCHAR(32),
PRIMARY KEY pk_activities(id)
);