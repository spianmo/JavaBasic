create table User
(
    id int auto_increment,
    username varchar(20) null,
    passwd varchar(50) null,
    nickname varchar(20) null,
    openid varchar(36) null,
    sex enum('男', '女', '保密') null,
    email varchar(40) null,
    nationalid varchar(10) null,
    regtime TIMESTAMP null,
    lastlogintime TIMESTAMP null,
    constraint User_pk
        primary key (id)
);

create unique index User_username_uindex
    on User (username);

