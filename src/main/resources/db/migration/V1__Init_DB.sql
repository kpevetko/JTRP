create table orders
(
	id serial,
	orderdate date,
	ordertime time with time zone,
	ordercomplete boolean,
	clientname varchar,
	clientphone varchar,
	deliveryfail boolean
);

alter table orders owner to postgres;