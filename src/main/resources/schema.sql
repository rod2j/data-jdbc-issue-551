DROP TABLE city IF EXISTS;
CREATE TABLE city (
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	country_code VARCHAR(2) NOT NULL
);
ALTER TABLE city ADD CONSTRAINT unique_city_country UNIQUE(country_code, name);