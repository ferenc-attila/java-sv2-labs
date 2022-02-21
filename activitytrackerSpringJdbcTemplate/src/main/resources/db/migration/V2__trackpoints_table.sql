CREATE TABLE track_points (
id BIGINT AUTO_INCREMENT,
activity_id BIGINT,
trackpoint_time DATE,
lat DOUBLE,
lon DOUBLE,
CONSTRAINT pk_track_point PRIMARY KEY (id)
);