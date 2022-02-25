CRAETE TABLE courses (
    course_id BIGINT AUTO_INCREMENT,
    title varchar(128),
    description varchar(255),
    `link` varchar(255),
    CONSTRAINT pk_course PRIMARY KEY (course_id)
);