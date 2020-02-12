insert into zone values (1,"North");

insert into propertytype values(1,"land");
insert into propertytype values(2,"car");

insert into residentialstatus values(1,"own");
insert into residentialstatus values(2,"rented");

insert into taxcost values("land","own","North",20);
insert into taxcost values("car","rented","North",20);
insert into taxcost values("land","rented","North",20);
insert into taxcost values("car","own","North",20);
