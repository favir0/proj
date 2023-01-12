INSERT INTO t_role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO t_role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO country (id, flag_image, name) VALUES (1, 'https://en.wikipedia.org/wiki/Flag_of_Russia#/media/File:Flag_of_Russia.svg', 'RUSSIA');
INSERT INTO country (id, flag_image, name) VALUES (2, 'https://en.wikipedia.org/wiki/Flag_of_China#/media/File:Flag_of_the_Peoples_Republic_of_China.svg', 'CHINA');
INSERT INTO country (id, flag_image, name) VALUES (3, 'https://en.wikipedia.org/wiki/Hideo_Kojima#/media/File:Kojima_Death_Stranding_2018.jpg', 'JAPAN');
INSERT INTO country (id, flag_image, name) VALUES (4, 'https://en.wikipedia.org/wiki/Flag_of_Ethiopia#/media/File:Flag_of_Ethiopia.svg', 'ETHIOPIA');

INSERT INTO genre (id, description, name) VALUES (1, 'BAAAAAM', 'SHOOTER');
INSERT INTO genre (id, description, name) VALUES (2, 'In this genre you would like to THINK', 'STRATEGY');
INSERT INTO genre (id, description, name) VALUES (3, 'Boooooooooooooooooooooooooooooooooooooooooo', 'HORROR');

INSERT INTO developer (id, description, name, country_id) VALUES (1, 'Magnificent company', 'VALVE', 4);
INSERT INTO developer (id, description, name, country_id) VALUES (2, 'Brilliant company', 'Stepan Plekhov and CO', 1);
INSERT INTO developer (id, description, name, country_id) VALUES (3, 'Awesome company', 'Paradox', 2);

INSERT INTO publisher (id, description, name, country_id) VALUES (1, 'Magnificent publisher', 'VALVE_PUB', 4);
INSERT INTO publisher (id, description, name, country_id) VALUES (2, 'Brilliant publisher', 'Stepan_PUB', 1);
INSERT INTO publisher (id, description, name, country_id) VALUES (3, 'Awesome publisher', 'Paradox_PUB', 2);

INSERT INTO game (id, date, description, game_image, is_multi_player, name, price, developer_id, genre_id, publisher_id)
VALUES (1, CURRENT_DATE, 'AWESOME GAME!!!!!!!!!!!!!', 'samlpe_image.jpg', true, 'DOKA2TRADE', 200, 1, 3, 1);
INSERT INTO game (id, date, description, game_image, is_multi_player, name, price, developer_id, genre_id, publisher_id)
VALUES (2, CURRENT_DATE, 'BRILLIANT GAME!!!!!!!!!!!!!', 'sample_image2.jpg', false, 'Slime castle', 80, 2, 1, 2);
INSERT INTO game (id, date, description, game_image, is_multi_player, name, price, developer_id, genre_id, publisher_id)
VALUES (3, CURRENT_DATE, 'Magnificent GAME!!!!!!!!!!!!!', 'sample_image3.jpg', true, 'Stellaris', 499, 3, 2, 3);