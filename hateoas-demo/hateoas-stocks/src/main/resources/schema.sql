drop table t_stocks if exists;

create table t_stocks (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    price double,
    primary key (id)
);


