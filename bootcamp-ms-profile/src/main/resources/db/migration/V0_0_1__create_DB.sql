create table users (
    id varchar primary key,
    name varchar,
    email varchar,
    gender varchar,
    status varchar
);

--
-- create table roles (
--     uuid varchar primary key,
--     creationdate timestamp not null,
--     lastupdate timestamp,
--
--     name varchar not null,
--     description varchar
-- );
--
-- create table users_roles (
--     user_id varchar,
--     role_id varchar,
--
--     constraint users_role_pk
--         primary key (user_id, role_id),
--     constraint fk_users
--         foreign key (user_id)
--              references users,
--     constraint fk_roles
--         foreign key (role_id)
--              references roles
--
-- )
