# drop table films;
create table films (
    id integer not null  auto_increment,
    filmId integer,
    filmName varchar(255),
    year int,
    rating double,
    description varchar(3000),
    primary key (id))
#     ENGINE=InnoDB DEFAULT CHARSET=utf8;