USE mysql;

create SCHEMA IF NOT EXISTS `course_platform`
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_hungarian_ci;

create user 'course'@'%'
identified by 'course';

grant all privileges
on course_platform.*
TO 'course'@'%'
with grant OPTION;

FLUSH PRIVILEGES;