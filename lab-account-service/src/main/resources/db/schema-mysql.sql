create table if not exists las_account
(
  acc_code varchar(32) not null
    primary key,
  amt double default 0 not null,
  version int not null
);

