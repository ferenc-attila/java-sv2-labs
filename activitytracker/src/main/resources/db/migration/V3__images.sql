CREATE table images (
id BIGINT AUTO_INCREMENT,
activity_id BIGINT,
filename VARCHAR(255),
content BLOB,
CONSTRAINT pk_images PRIMARY KEY (id)
);