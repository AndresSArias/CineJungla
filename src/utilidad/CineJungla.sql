DROP SCHEMA IF EXISTS cinejungla CASCADE;

DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS salas CASCADE;
DROP TABLE IF EXISTS multiplex CASCADE;

DROP TYPE IF EXISTS multiplex_type CASCADE;
DROP TYPE IF EXISTS cargo_type CASCADE;

CREATE TYPE multiplex_type AS ENUM ('Titán','Unicentro','Plaza Central','Gran Estación','Embajador','Américas');
CREATE TYPE cargo_type AS ENUM ('Director','Cajero','Cofiteria','Encargado','Aseador');

CREATE TABLE Multiplex(
	Nombre multiplex_type primary key,
	NumeroDeSalas integer not null
);
CREATE TABLE Usuario(
	Cedula bigint not null primary key,
	Codigo serial,
	Nombre text not null,
	Celular bigint not null,
	FechaInicioContrato date not null,
	Cargo cargo_type not null,
	Salario integer not null,
	Multiplex multiplex_type not null,
	foreign key (Multiplex) references Multiplex(Nombre)
);

CREATE TABLE Cliente(
	Nombre text not null,
	Cedula bigint not null primary key,
	Puntos integer,
	CalificacionCineJungla integer,
	CalificacionPelicula integer
);

CREATE TABLE Salas(
	Multiplex multiplex_type not null,
	NumeroDeSala integer,
	ArregloSillasGeneral integer[40],
	ArregloSillasPreferencial integer[20],
	foreign key (Multiplex) references Multiplex(Nombre),
	primary key (Multiplex, NumeroDeSala)
);