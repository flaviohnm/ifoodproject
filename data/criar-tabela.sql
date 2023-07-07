 CREATE TABLE IF NOT EXISTS usuarios (
	id varchar(36),
	cpf varchar(11) NOT NULL,
	username varchar(255) NOT NULL,
	fullname varchar(255) NOT NULL,
	displayname varchar(255) NOT NULL,
	email varchar(255),
	phonenumber varchar(14)
);
ALTER TABLE usuarios ADD CONSTRAINT id PRIMARY KEY (id);