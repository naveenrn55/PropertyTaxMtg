insert into Zone values (1,"North");

insert into PropertyType values(1,"land");
insert into PropertyType values(2,"car");

insert into ResidentialStatus values(1,"own");
insert into ResidentialStatus values(2,"rented");

insert into TaxCost values("land","own","North",20);
insert into TaxCost values("car","rented","North",20);
insert into TaxCost values("land","rented","North",20);
insert into TaxCost values("car","own","North",20);
