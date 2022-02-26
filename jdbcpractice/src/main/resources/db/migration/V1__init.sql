CREATE TABLE courses (
    course_id BIGINT AUTO_INCREMENT,
    title VARCHAR(128),
    description VARCHAR(255),
    `link` VARCHAR(255),
    CONSTRAINT pk_course PRIMARY KEY (course_id)
);