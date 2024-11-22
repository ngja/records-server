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

CREATE TABLE artist
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    debut_date   TIMESTAMP    NOT NULL,
    status       VARCHAR(255) NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_artist PRIMARY KEY (id)
);

CREATE TABLE member
(
    id           BIGINT       NOT NULL,
    artist_id    BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN      NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_member PRIMARY KEY (id)
);

CREATE TABLE album
(
    id           BIGINT       NOT NULL,
    artist_id    BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    release_date TIMESTAMP    NOT NULL,
    tags         VARCHAR(255),
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN      NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_album PRIMARY KEY (id)
);

CREATE TABLE mv
(
    id         BIGINT       NOT NULL,
    artist_id  BIGINT,
    song_id    BIGINT,
    url        VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted    BOOLEAN      NOT NULL,
    CONSTRAINT pk_mv PRIMARY KEY (id)
);

CREATE TABLE concert
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    type         VARCHAR(255) NOT NULL,
    start_date   TIMESTAMP    NOT NULL,
    end_date     TIMESTAMP    NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN      NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_concert PRIMARY KEY (id)
);

CREATE TABLE concert_artist
(
    id         BIGINT  NOT NULL,
    artist_id  BIGINT,
    concert_id BIGINT,
    deleted    BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_concert_artist PRIMARY KEY (id)
);

CREATE TABLE song
(
    id           BIGINT       NOT NULL,
    album_id     BIGINT,
    title        VARCHAR(255) NOT NULL,
    lyrics       VARCHAR(255) NOT NULL,
    composition  VARCHAR(255) NOT NULL,
    arrangement  VARCHAR(255) NOT NULL,
    release_date TIMESTAMP    NOT NULL,
    deleted      BOOLEAN      NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_song PRIMARY KEY (id)
);