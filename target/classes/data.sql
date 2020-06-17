DROP TABLE IF EXISTS restaurants;
CREATE TABLE restaurants (
    id SERIAL primary key,
    name varchar(250) not null);
Insert into restaurants (id, name) values(1,'first lviv coronovirusarnia');