create table if not exists persistent_logins (
    username varchar(100) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);