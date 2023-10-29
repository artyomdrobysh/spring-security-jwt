CREATE TABLE public.user (
    id serial not null,
    username varchar(10) not null,
    password_hash varchar(512) not null,
    enabled boolean not null default true,
    primary key(id),
    constraint unq_username_enabled unique (username, enabled)
);

CREATE TYPE role AS ENUM('ADMIN', 'USER');

CREATE TABLE public.user_role (
    id serial not null,
    role role not null,
    user_id integer not null,
    primary key(id),
    constraint fk_user foreign key (user_id)
        references public.user (id) on update cascade on delete cascade
);
