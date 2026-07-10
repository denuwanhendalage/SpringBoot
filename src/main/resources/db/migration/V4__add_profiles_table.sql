create table profiles
(
    id             BIGINT  Primary Key,
    bio            Text,
    phone_number   varchar(15),
    date_of_birth  DATE,
    loyalty_points int UNSIGNED default 0 ,
    foreign key (id) references users(id)
);