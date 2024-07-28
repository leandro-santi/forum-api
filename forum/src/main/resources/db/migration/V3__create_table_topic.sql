create table topics
(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(300) not null,
    date datetime not null,
    course_id bigint not null,
    user_id bigint not null,
    status varchar(20) not null,
    primary key (id),
    foreign key (course_id) references courses(id),
    foreign key (user_id) references users(id)
);