create table guests(

    id serial primary key,
    name varchar(50) not null,
    cpf varchar(11) not null,
    checkin_date DATE not null,
    checkout_date DATE not null,
    room_id serial not null,

    constraint fk_guest_room_id
    foreign key (room_id)
    references rooms(id)

);