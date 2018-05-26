select t.*, t.rowid from SHOPPINGUSER t

create table shoppinguser(
ID  number(8) primary key,
USERNAME  varchar2(16) not null unique,
EMAIL     varchar2(64) not null unique,
PHONE     varchar2(11) not null unique,
PASSWORD  varchar2(64) not null ,
ROLE       varchar2(8) default 'USER', 
REALNAME    varchar2(8) ,
CITY       varchar2(32) ,
SEX         varchar2(2),
IDCARD      varchar2(18),
CATEGORY      varchar2(16),
SYNOPSIS       varchar2(512),
PICTUREPATH        varchar2(512)
)
create sequence shoppinguser_seq
increment by 1
start with 0
minvalue 0
