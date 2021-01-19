drop table t_order if exists;

create table t_order (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    user varchar(255),
    stock_name varchar(255),
    price double,
    volume double,
    primary key (id)
);


