create table if not exists sys_user
(
  name varchar(32) not null
    primary key,
  password varchar(32),
  password_md5 varchar(64),
  password_sha varchar(64)
);

