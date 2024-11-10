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

CREATE TABLE person
(
    id         BIGINT PRIMARY KEY,
    surname    VARCHAR(100) NOT NULL,
    forename   VARCHAR(100) NOT NULL,
    name       VARCHAR(200) NOT NULL,
    gender     VARCHAR(10)  NOT NULL,
    birthday   TIMESTAMP    NOT NULL,
    height     INT          NULL,
    deleted    BOOLEAN   DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);