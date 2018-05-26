create table shoppingorder(
id number(8) primary key ,
user_id number(8) references shoppinguser(id),
address_id number(8) references vipaddress(id),
pro_id     number(8) references pro(id),
paymentMethod  number(2) default 0,
ordertime     Date,
procount      number(8),
status         number(2) ,
ordernumber    number(32)
)

create sequence shoppingorder_seq
increment by 1
start with 0
minvalue 0
