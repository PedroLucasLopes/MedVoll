create table patients(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(6) not null unique,
    public_place varchar(100) not null,
    district varchar(100) not null,
    zipcode varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    fu char(2) not null,
    city varchar(100) not null,

    primary key(id)

);