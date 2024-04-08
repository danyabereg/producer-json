INSERT INTO profile (phone, city, sex)
VALUES ('3453453535', 'Moscow', 'Male'),
       (null, 'Saint-Petersburg', 'Female'),
       ('7675645535', null, 'Male'),
       ('6475635835', 'Kazan', null),
       (null, null, 'Male'),
       ('3453453535', null, null),
       (null, 'Rostov-on-Don', null);

INSERT INTO hobby
VALUES ('tennis', 1),
       ('football', 2),
       ('swimming', 2),
       ('running', 4),
       ('diving', 5),
       ('basketball', 6),
       ('reading books', 7),
       ('roller skating', 1),
       ('yoga', 1),
       ('rock climbing', 2),
       ('snowboarding', 2),
       ('travelling', 5),
       ('horse riding', 5),
       ('sky jumping', 6),
       ('cooking', 6),
       ('skating', 7);

INSERT INTO users(first_name, last_name, profile_id)
VALUES ('Daniil', 'Poberezhnyy', 1),
       (null, 'Petrov', 2),
       ('Semen', null, 3),
       ('Petr', 'Ermohin', 4),
       ('Nikita', 'Sidorov', null),
       ('Yury', 'Gerasimov', 6),
       ('Svetlana', 'Osetina', null);