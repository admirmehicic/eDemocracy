create database korisnici;

create database baza;

use baza;

create table korisnici(
IDkorisnika int not null  AUTO_INCREMENT,
jmbg varchar(13) not null,
datumRodenja varchar(20),
ime varchar(20),
prezime varchar(20),
adresa varchar (30),
brojTelefona varchar(15),
emailAdresa varchar(50),
lozinka varchar(20),
kanton varchar(20),
grad varchar(20),
PRIMARY KEY(IDkorisnika)
);

create table uposlenici(
IDuposlenika int not null  AUTO_INCREMENT,
jmbg varchar(13) not null,
datumRodenja varchar(20),
ime varchar(20),
prezime varchar(20),
adresa varchar (30),
brojTelefona varchar(15),
emailAdresa varchar(50),
osnovica int,
lozinka varchar(20),
kanton varchar(20),
grad varchar(20),
PRIMARY KEY(IDuposlenika)
);

create table zdravstveniKarton(
serijskiBroj integer,
JMBGkorisnika varchar(13),
IDzahtjeva int
);

drop table uposlenici;

create table digitalnoPotpisivanje(
IDpotpisa int not null auto_increment,
tip int,
filename varchar(50),
kod int,
primary key(IDpotpisa)
);

create table zahtjevi(
idzahtjeva int not null auto_increment,
vrsta int, 
svrha varchar(50),
kod int,
primary key (idzahtjeva)
);

create table dokument(
serijskiBroj int not null,
JMBGkorisnika varchar(13),
IDzahtjeva int,
vrstaZahtjeva int,
primary key (serijskibroj)
);

create table uposlenik(

JMBG varchar(13),
datumRodenja date,
ime varchar(20),
prezime varchar(20),
spol char(1),
adresa varchar(30),
brojtelefona varchar(15),
email varchar(30),
datumZaposlenja date,
osnovicaPlate numeric(8,2)
);

create table WebAdministrator(
id int auto_increment,
titula varchar(20),
jmbgUposlenik varchar(13),
primary key(id)
);

create table izbori(
id int not null primary key,
datumOtvaranjaIzbora date,
datumZatvaranjaIzbora date,
regija int
);

create table uposlenikAdministrativni(
jmbg varchar(13) primary key,
titula varchar(30),
opisRadnogMjesta varchar (100),
staz int
);

create table glas(
glasID int auto_increment,
korisnikJMBG varchar(13),
datumGlasanja date,
primary key (glasID)
)




drop table dokument;

drop table uposlenik;


drop table digitalnoPotpisivanje;

drop table zahtjevi;

insert into korisnici values ("12345678924", '2002-11-11', "admir", "prezime", "m", "zenica", "9484", "email", "pass");

drop table korisnici;