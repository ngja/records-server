CREATE TABLE country
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(255)   NOT NULL,
    english_name VARCHAR(255)   NOT NULL,
    alpha_2      CHAR(2) UNIQUE NOT NULL,
    alpha_3      CHAR(3) UNIQUE NOT NULL,
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);