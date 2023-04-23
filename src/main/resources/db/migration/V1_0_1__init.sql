create table users
(
    id           bigserial primary key,
    email        varchar                  not null,
    keycloak_id  varchar                  not null,
    created_date timestamp with time zone not null default now()
);