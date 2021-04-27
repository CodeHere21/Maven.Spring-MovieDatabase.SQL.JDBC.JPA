show databases;
use miniMovie;
create table movie(
                      title varchar (50) not null,
                      runtime integer primary key not null,
                      genre varchar(50) not null,
                      imdb_score float not null,
                      rating varchar(50) not null
);
show tables;
select * from movie;
insert into movie
values ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
select * from movie;
insert into movie
values ('Lavalantula',83,'Horror',4.7,'TV-14');
insert into movie
values ('Starship Troopers',129,'Sci-Fi',7.2,'PG-13');
insert into movie
values ('Waltz With Bashir',90,'Documentary',8.0,'R');
insert into movie
values ('Spaceballs',96,'Comedy',7.1,'PG');
insert into movie
values ('Monsters Inc',92,'Animation',8.1,'G');
select * from movie
where genre='Sci-Fi';
select * from movie
where imdb_score > 6.5;
select * from movie
where rating = 'G' or rating ='PG' and runtime < 100;
select avg(runtime)
from movie
where imdb_score <7.5
group by genre;
update movie
set rating ='R'
where title='Starship Troopers';
select rating from movie
where genre='Horror' or genre='Documentary';
select avg(imdb_score)
from movie;
select min(imdb_score)
from movie;
select max(imdb_score)
from movie;
select count(*)
from movie
having count(*)>1;
delete from movie
where rating='R';
show databases ;
create schema person;
show databases ;
use person;
create table people(
                       id INTEGER primary key not null auto_increment,
                       first_name varchar(50) not null,
                       last_name varchar(50) not null,
                       mobile varchar(50) not null,
                       birthday varchar(50) not null
);
insert into people
values (1,'John','Smith','12345','08-07-1980');
select * from people;
insert into people
values (2,'Sheeri','Carbral','230423','02-31-1970');
insert into people
values (3,'Raj','Sharam','1865223','08-31-1980');
insert into people
values (4, 'Noelle','Durand','395-6161','07-06-1960');
select * from people;
insert into people
values (5, 'Thomas', 'Smith','395-6181','07-06-1987');
insert into people
values (6, 'Jane','Smith','393-6181','12-06-1987');
insert into people
values (7, 'Doug','Brown','466-6241','12-07-1954');
select * from people;