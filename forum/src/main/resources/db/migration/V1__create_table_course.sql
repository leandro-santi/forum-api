create table courses
(
    id bigint not null auto_increment,
    name varchar(50) not null,
    category varchar(50) not null,
    primary key (id)
);

insert into courses
values (1, 'Kotlin', 'Programming');
insert into courses
values (2, 'Java', 'Embedded');
