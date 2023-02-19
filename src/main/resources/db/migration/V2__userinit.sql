create table if  not exists users (
 id bigserial primary key,
 name varchar(255),
 password varchar(255));

 create table if  not exists roles(
 id bigserial primary key,
 name varchar(255));


 create table if not exists users_roles(
 user_id  bigserial not null,
 role_id int not null,
 primary key (user_id,role_id),
 foreign key (user_id) references users(id),
 foreign key (role_id) references roles(id)
 );


 insert into roles(name)
 values
 ('ROLE_USER'),('ROLE_ADMIN');


INSERT into users(name,password)
values
('Anton', '$2y$10$j2ySGZvi1j.xP3.SHwQzbeDBomPvsEGOaqq.8itsB.xgYCfictkPi'),
('Admin', '$2y$10$68sXwkAHQlSRuB8owysL9OL8fi53qlNsqS0m8dGnkmAA1VoGj2lnO');

insert into users_roles(user_id,role_id)
values
(1,1),
(2,2);

