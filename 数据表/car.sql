
       
       select * from shoppingcar
       
       create table shoppingcar(
       id number(8) primary key,
       user_id number(8) references shoppinguser(id),
       pro_id  number(8) references pro(id),
       goodscount number(8)
       )
       create sequence shoppingcar
       increment by 1
       start with 0
       minvalue 0 
       
       
