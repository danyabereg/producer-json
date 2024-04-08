CREATE TABLE profile
(
    id    BIGSERIAL PRIMARY KEY,
    phone VARCHAR(32),
    city  VARCHAR(32),
    sex   VARCHAR(8)
);

CREATE TABLE hobby
(
    hobby_name VARCHAR(32) NOT NULL,
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile (id) ON UPDATE CASCADE

);

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(32),
    last_name  VARCHAR(32),
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile (id) ON UPDATE CASCADE
);