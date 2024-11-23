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

CREATE INDEX idx_person_name ON person (name);
CREATE INDEX idx_person_birthday ON person (birthday);

CREATE TABLE artist
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    debut_date   TIMESTAMP    NOT NULL,
    status       VARCHAR(30)  NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_artist_name ON artist (name);

CREATE TABLE member
(
    id           BIGINT PRIMARY KEY,
    artist_id    BIGINT       NOT NULL,
    person_id    BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    status       VARCHAR(30)  NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_member_artist_id ON member (artist_id);
CREATE INDEX idx_member_person_id ON member (person_id);
CREATE INDEX idx_member_name ON member (name);

CREATE TABLE album
(
    id           BIGINT PRIMARY KEY,
    artist_id    BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    release_date TIMESTAMP    NOT NULL,
    tags         VARCHAR(255),
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_album_artist_id ON album (artist_id);
CREATE INDEX idx_album_release_date ON album (release_date);

CREATE TABLE mv
(
    id         BIGINT PRIMARY KEY,
    artist_id  BIGINT,
    song_id    BIGINT,
    url        VARCHAR(255) NOT NULL,
    deleted    BOOLEAN   DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_mv_artist_id ON mv (artist_id);
CREATE INDEX idx_mv_song_id ON mv (song_id);

CREATE TABLE concert
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    type         VARCHAR(255) NOT NULL,
    start_date   TIMESTAMP    NOT NULL,
    end_date     TIMESTAMP    NOT NULL,
    image_width  INTEGER      NOT NULL,
    image_height INTEGER      NOT NULL,
    image_path   VARCHAR(255),
    deleted      BOOLEAN   DEFAULT FALSE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_concert_name ON concert (name);
CREATE INDEX idx_concert_start_date ON concert (start_date);

CREATE TABLE concert_artist
(
    id         BIGINT PRIMARY KEY,
    artist_id  BIGINT,
    concert_id BIGINT,
    deleted    BOOLEAN   DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_concert_artist_artist_id ON concert_artist (artist_id);
CREATE INDEX idx_concert_artist_concert_id ON concert_artist (concert_id);

CREATE TABLE song
(
    id          BIGINT PRIMARY KEY,
    album_id    BIGINT,
    track       INT          NOT NULL,
    title       VARCHAR(255) NOT NULL,
    lyrics      VARCHAR(255) NOT NULL,
    composition VARCHAR(255) NOT NULL,
    arrangement VARCHAR(255) NOT NULL,
    deleted     BOOLEAN   DEFAULT FALSE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_song_album_id ON song (album_id);
CREATE INDEX idx_song_title ON song (title);
