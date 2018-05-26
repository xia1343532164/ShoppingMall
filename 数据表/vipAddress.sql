select * from shoppinguser
select v.*,rowid from vipaddress v

create table vipAddress(
id   number(8) primary key,
user_id  number(8) ,
zone     varchar2(64) not null,
address  varchar2(64) not null,
code     varchar2(16) not null,
addressee varchar2(16)not null,
mobilephone  varchar2(11),
telphone     varchar2(16)
);
alter table VipAddress add constraint fk_VipAddress foreign key(user_id) references shoppinguser(id)

create sequence vipAddress_seq
increment by 1
start with 0
minvalue 0

