create table rooms(

    id serial primary key,
    name varchar(50) not null,
    description varchar(200) not null,
    room_type varchar(15) not null,
    price_per_night decimal(10, 2) not null,
    is_available boolean not null

);