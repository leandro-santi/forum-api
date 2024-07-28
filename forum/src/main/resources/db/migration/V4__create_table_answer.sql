create table answers
(
    id bigint not null auto_increment,
    message varchar(300) not null,
    date datetime not null,
    user_id bigint not null,
    topic_id bigint not null,
    solution int not null default 1,
    primary key (id),
    foreign key (user_id) references users(id),
    foreign key (topic_id) references topics(id)
);