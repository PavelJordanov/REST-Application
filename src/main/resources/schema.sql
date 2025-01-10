CREATE TABLE users
(
   firstname varchar(255) not null,
   lastname varchar(255) not null,
   dob varchar(255) not null,
   username varchar(255) not null,
   pwd varchar(255) not null,
   id varchar(255) not null,
   weight float not null,
   height float not null,
   fitness_goal varchar(255) not null,
   planID varchar(255) not null,
   start_date varchar(255) not null,
   end_date varchar(255) not null,
   primary key(id)
);

CREATE TABLE plans
(
   id varchar(255) not null,
   name varchar(255) not null,
   description varchar(255) not null,
   type varchar(255) not null,
   durationInWeeks int not null,
   price int not null,
   numclients int not null,
   primary key(id)
);

CREATE TABLE subscriptions 
(
   id varchar(255) not null,
   uid varchar(255) not null,
   pid varchar(255) not null,
   start_date varchar(255) not null,
   end_date varchar(255) not null,
   price int not null,
   primary key(id),
   UNIQUE (uid, pid, start_date, end_date)
);

CREATE TABLE payments
(
   id varchar(255) not null,
   uid varchar(255) not null,
   type varchar(255) not null,
   amount int not null,
   date varchar(255) not null,
   primary key(id)
);

CREATE TABLE userbalances
(
   id varchar(255) not null,
   uid varchar(255) not null,
   balance int not null,
   primary key(id),
   UNIQUE (uid)
);

--CREATE TABLE IF NOT EXISTS product
CREATE TABLE product
(
   id varchar(255) not null,
   name varchar(255) not null,
   prodgroup varchar(255) not null,
   primary key(id)
);

