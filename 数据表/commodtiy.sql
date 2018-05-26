screate table goods(
id number(8) primary key,
goods_number  number(16),
name      varchar2(24) ,
describe  varchar2(128),
price     varchar2(8),
stock     varchar2(8),
color     varchar2(8),
memory    varchar2(8),
postage   varchar2(4) default '0'
)

create table viporder(
id           number(8) primary key,
user_id      number(8) ,
address_id   number(8),
status       number(1),
ordertime    Date,
paymentMethod number(1)
)
create sequence viporder_seq
increment by 1
start with 1
minvalue 0

alter table viporder add constraint fk_viporder foreign key
(user_id)references shoppinguser(id)
alter table viporder add constraint fk_viporder_address foreign key
(address_id) references vipaddress(id)

select o.* ,rowid from viporder o ;
select * from vipaddress;

create table pro(
id number(8) primary key,
title  varchar2(64),
pictruePath varchar2(128),
classify   number(1),
price      varchar2(8),
stock      varchar2(8),
introduce  varchar2(256)
)

create sequence pro_seq
increment by 1
start with 0
minvalue  0

select p.* ,rowid from pro p;

insert into pro(id,title,pictruepath,classify,price,stock,introduce)
values(pro_seq.nextval,'123456',null,1,'11100','1000','这是一台非常nice的iphone10')

select * from shoppinguser
