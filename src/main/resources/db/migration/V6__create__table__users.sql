CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    name varchar(100) NOT NULL UNIQUE,
    email varchar(255) NOT NULL UNIQUE,
    password varchar(100) NOT NULL
);