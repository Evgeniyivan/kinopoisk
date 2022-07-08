# drop table films;
create table films (
    id integer not null  auto_increment,
    filmId integer,
    name_ru varchar(255),
    name_original varchar(255),
    year long,
    rating double,
    rating_imdb double,
    primary key (id))
#     ENGINE=InnoDB DEFAULT CHARSET=utf8;