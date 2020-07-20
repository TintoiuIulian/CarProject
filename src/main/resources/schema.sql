DROP TABLE t_cars IF EXISTS;
create table t_cars
(
	id integer auto_increment,
	doors integer,
	platenumber varchar(50),
	brand varchar(50),
	rentingprice varchar(50),
	primary key(id)
);

DROP TABLE t_garage IF EXISTS;
create table t_garage
(
	id integer auto_increment,
	doors integer,
	platenumber varchar(50),
	brand varchar(50),
	rentingprice varchar(50),
	primary key(id)
);

