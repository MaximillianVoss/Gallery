insert into users values ('6edfbc36-f1f3-4a74-a5ca-b460520403b4', 'Иван', 'Иванов', 'admin@test.ru', '$2a$10$mqgq2/vI5hfgrStkmNsY5eyiourAT5ZceJdeVQP5m9Vn1lu3MaZ0a', '3302b0a3-4b45-4503-9bdc-e6e0e1755b25');

insert into author values ('9dd8ca37-c315-4525-8648-edf1da198fdb', 'Алина Глазун');
insert into author values ('de9404a3-2996-4db7-8d46-619aa241362c', 'Евгений Гранильщиков');
insert into author values ('8d2b4bfa-24ee-49ae-83a7-98eb46432ff3', 'Алексей Дубинский');
insert into author values ('c690955c-04c8-497a-aa92-e34e82148b85', 'Евфросина');
insert into author values ('be2a36f0-2bbc-4b7d-bb0f-e8e583d54f39', 'Миша Никатин');

insert into event values ('d82bc250-07aa-47da-9ba0-93b83b59cf9e', 'Персональная выставка Алины Глазун', 'Персональная выставка современной москвоской хужожницы Алина Глазун', '2023-03-01', '2023-03-15', 'fffaf5fe-4885-4cce-8361-98602c5ac965', '/img/events/d82bc250-07aa-47da-9ba0-93b83b59cf9e/zgc1993-Fk9RSVdJ6Q8-unsplash-min.jpg');
insert into event values ('296edec8-8d29-417a-b6e8-4bc6d902642d', 'Персональная выставка Евгения Гранильщикова', 'Персональная выставка современного москвоского хужожника Евгения Гранильщикова', '2023-03-01', '2023-03-15', 'fffaf5fe-4885-4cce-8361-98602c5ac965', '/img/events/296edec8-8d29-417a-b6e8-4bc6d902642d/raychan-kJQ6cDyodAM-unsplash-min.jpg');
insert into event values ('eb628b29-0f9e-4a41-8eea-88f14aae3e70', 'Персональная выставка Алексея Дубинского', 'Персональная выставка современного москвоского хужожника Алексея Дубинского', '2023-03-01', '2023-03-15', 'fffaf5fe-4885-4cce-8361-98602c5ac965', '/img/events/eb628b29-0f9e-4a41-8eea-88f14aae3e70/dannie-jing-3GZlhROZIQg-unsplash-min.jpg');

insert into exhibit values ('d17a9d20-fcc8-49e3-9924-aba19b423209', 'Волны', 'CODE1', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2012, 160, 120, '58f53eaf-829c-4cef-8915-5bb14a77462f', 'a4edb8d9-18b0-44ca-a145-deacdacf8a1c', '/img/exhibits/d17a9d20-fcc8-49e3-9924-aba19b423209/henrik-donnestad-t2Sai-AqIpI-unsplash.jpg');
insert into exhibit values ('c537a02c-e622-4bf3-9945-903731ea5d91', 'Слеза', 'CODE2', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2020, 150, 100, 'b06abaaa-4a22-42f7-a75a-5123616c0ee9', 'a4edb8d9-18b0-44ca-a145-deacdacf8a1c', '/img/exhibits/c537a02c-e622-4bf3-9945-903731ea5d91/victor-grabarczyk-wN9DU73b8_s-unsplash-min.jpg');
insert into exhibit values ('596e6eca-b57d-4ee1-9c4f-bf378bf32490', 'Марш', 'CODE3', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2021, 160, 120, '58f53eaf-829c-4cef-8915-5bb14a77462f', 'a4edb8d9-18b0-44ca-a145-deacdacf8a1c', '/img/exhibits/596e6eca-b57d-4ee1-9c4f-bf378bf32490/adrianna-geo-1rBg5YSi00c-unsplash-min.jpg');
insert into exhibit values ('0dfec3b0-f300-4e2c-b249-9177e0efc6d0', 'Дождь', 'CODE4', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2022, 120, 60, '1d19afa9-adc3-4712-ac6c-c3eba2290de8', 'e628340a-8095-434e-8f35-659b26fac6ed', '/img/exhibits/0dfec3b0-f300-4e2c-b249-9177e0efc6d0/john-schaidler-9V3Q2W_mRLE-unsplash-min.jpg');
insert into exhibit values ('9124b0d4-d07c-4b23-93e7-ee53a8171360', 'Искусство', 'CODE5', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2015, 80, 70, '58f53eaf-829c-4cef-8915-5bb14a77462f', 'e628340a-8095-434e-8f35-659b26fac6ed', '/img/exhibits/9124b0d4-d07c-4b23-93e7-ee53a8171360/debby-hudson-MzSqFPLo8CE-unsplash.jpg');
insert into exhibit values ('0a5d5556-5de3-419f-853f-5615eebb01db', 'Удовольствие', 'CODE6', '9dd8ca37-c315-4525-8648-edf1da198fdb', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186', 2019, 70, 70, '769e0745-ce0c-4be5-9533-8757c4363c3b', 'e628340a-8095-434e-8f35-659b26fac6ed', '/img/exhibits/0a5d5556-5de3-419f-853f-5615eebb01db/rhondak-native-florida-folk-artist-_Yc7OtfFn-0-unsplash-min.jpg');

insert into exhibit values ('ea5da651-f243-4815-bd65-3cf6ddd5e2d2', 'Взгляд', 'CODE10', 'de9404a3-2996-4db7-8d46-619aa241362c', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2019, 20, 20, '1328ab25-0ca9-43ce-bd65-913ed2f5f3dc', 'c9d862c4-a39a-4ec9-8b12-eee9c3b35abf', '/img/exhibits/ea5da651-f243-4815-bd65-3cf6ddd5e2d2/gabriela-gomez-3NXyodgX254-unsplash-min.jpg');
insert into exhibit values ('126444e1-34be-48df-a69a-74230a64d0a6', 'Увлечение', 'CODE11', 'de9404a3-2996-4db7-8d46-619aa241362c', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2022, 165, 115, '769e0745-ce0c-4be5-9533-8757c4363c3b', 'c9d862c4-a39a-4ec9-8b12-eee9c3b35abf', '/img/exhibits/126444e1-34be-48df-a69a-74230a64d0a6/jene-stephaniuk-wsVOc34cQ_Q-unsplash-min.jpg');
insert into exhibit values ('7b282345-9868-4788-9ca7-f0c5431d84b9', 'Облака', 'CODE12', 'de9404a3-2996-4db7-8d46-619aa241362c', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2022, 70, 50, '1328ab25-0ca9-43ce-bd65-913ed2f5f3dc', '3613f968-09ef-4722-b202-c76cde82bc51', '/img/exhibits/7b282345-9868-4788-9ca7-f0c5431d84b9/orfeas-green-G5A5ZNjS2tE-unsplash-min.jpg');
insert into exhibit values ('24920bd7-468c-4c56-8e7b-808a819bf1ce', 'Преступление', 'CODE13', 'de9404a3-2996-4db7-8d46-619aa241362c', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2019, 80, 70, '1d19afa9-adc3-4712-ac6c-c3eba2290de8', '3613f968-09ef-4722-b202-c76cde82bc51', '/img/exhibits/24920bd7-468c-4c56-8e7b-808a819bf1ce/steve-johnson-3Sf_G9m0gcQ-unsplash-min (1).jpg');

insert into exhibit values ('1f0bc7e1-0e28-4aff-b8d1-6e9a3d6c5e55', 'Два мира', 'CODE7', '8d2b4bfa-24ee-49ae-83a7-98eb46432ff3', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186', 2018, 50, 50, 'c5e5019f-0c1f-48a7-a466-1ece6ed991c3', '86e1c45d-ea55-4d84-9028-4a21e51b9387', '/img/exhibits/1f0bc7e1-0e28-4aff-b8d1-6e9a3d6c5e55/luis-alfonso-orellana-WjIB-6UxA5Q-unsplash-min.jpg');
insert into exhibit values ('867f5baf-cce6-4f8f-8d07-316c2dbb146e', 'Удивление', 'CODE8', '8d2b4bfa-24ee-49ae-83a7-98eb46432ff3', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186', 2022, 120, 60, 'c5e5019f-0c1f-48a7-a466-1ece6ed991c3', '86e1c45d-ea55-4d84-9028-4a21e51b9387', '/img/exhibits/867f5baf-cce6-4f8f-8d07-316c2dbb146e/markus-spiske-k0rVudBoB4c-unsplash-min.jpg');
insert into exhibit values ('2acc3efc-d903-485f-aa2a-54dfe4fe34a2', 'Однажды ночью', 'CODE9', '8d2b4bfa-24ee-49ae-83a7-98eb46432ff3', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186', 2022, 50, 50, 'b06abaaa-4a22-42f7-a75a-5123616c0ee9', '86e1c45d-ea55-4d84-9028-4a21e51b9387', '/img/exhibits/2acc3efc-d903-485f-aa2a-54dfe4fe34a2/joel-filipe-QwoNAhbmLLo-unsplash-min.jpg');

--for event 1
insert into event_exhibit values ('7ee11f59-47b1-402a-945d-0196d48154b1', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', 'd17a9d20-fcc8-49e3-9924-aba19b423209');
insert into event_exhibit values ('40bd9338-bea8-4f15-8e04-53d48bfe459f', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', 'c537a02c-e622-4bf3-9945-903731ea5d91');
insert into event_exhibit values ('009a6889-2059-4984-b8dc-a170d241978a', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '596e6eca-b57d-4ee1-9c4f-bf378bf32490');
insert into event_exhibit values ('90709dfe-0c96-4f24-b45c-9e0303e981e6', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '0dfec3b0-f300-4e2c-b249-9177e0efc6d0');
insert into event_exhibit values ('cd32f73a-76a9-4cbb-a402-912c4e14eac9', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '9124b0d4-d07c-4b23-93e7-ee53a8171360');
insert into event_exhibit values ('43f01775-1d6f-4bf3-83a2-4a07b35d73fc', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '0a5d5556-5de3-419f-853f-5615eebb01db');
--for event 2
insert into event_exhibit values ('17aeddf0-ec26-408f-b9c8-b657a7b69ee1', '296edec8-8d29-417a-b6e8-4bc6d902642d', 'ea5da651-f243-4815-bd65-3cf6ddd5e2d2');
insert into event_exhibit values ('79a59470-96c4-4281-bc03-60fe423737fc', '296edec8-8d29-417a-b6e8-4bc6d902642d', '126444e1-34be-48df-a69a-74230a64d0a6');
insert into event_exhibit values ('f4fba9d2-b74b-459e-a69b-a31d1a6e3e40', '296edec8-8d29-417a-b6e8-4bc6d902642d', '7b282345-9868-4788-9ca7-f0c5431d84b9');
insert into event_exhibit values ('274153cc-9e4b-4628-aa7b-96704bd6a319', '296edec8-8d29-417a-b6e8-4bc6d902642d', '24920bd7-468c-4c56-8e7b-808a819bf1ce');
--for event 3
insert into event_exhibit values ('bbce2bc3-2cd9-43a1-8214-a705786a2581', 'eb628b29-0f9e-4a41-8eea-88f14aae3e70', '1f0bc7e1-0e28-4aff-b8d1-6e9a3d6c5e55');
insert into event_exhibit values ('558c4ae5-e53b-4292-b251-c4b121e2df9b', 'eb628b29-0f9e-4a41-8eea-88f14aae3e70', '867f5baf-cce6-4f8f-8d07-316c2dbb146e');
insert into event_exhibit values ('c30089a3-6f70-4d2d-bd52-2974d35c183c', 'eb628b29-0f9e-4a41-8eea-88f14aae3e70', '2acc3efc-d903-485f-aa2a-54dfe4fe34a2');


insert into exhibit_place values ('291b1fc9-8f63-4366-a695-2996508112fc', 'd17a9d20-fcc8-49e3-9924-aba19b423209', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '2023-03-01');
insert into exhibit_place values ('4878c777-9767-45f4-a3f1-545a233a8f46', 'd17a9d20-fcc8-49e3-9924-aba19b423209', 'f2145928-eeac-4347-bd3c-2e2dabbf0608', 'Выставка', '2023-03-01', '2023-03-15');
insert into exhibit_place values ('aa1d348d-6133-48c6-bc04-3871b50a9936', 'd17a9d20-fcc8-49e3-9924-aba19b423209', '78585f52-a925-4a33-9dd4-3c520229da43', 'Вернули на хранение', '2023-03-15', '9999-01-01');

insert into exhibit_place values ('0ce5b270-0cd9-4a45-aa70-aabd07a2fd89', 'c537a02c-e622-4bf3-9945-903731ea5d91', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '2023-01-31');
insert into exhibit_place values ('ef744d6d-1f72-4dd5-8e22-ebcf6eca6540', 'c537a02c-e622-4bf3-9945-903731ea5d91', 'f2145928-eeac-4347-bd3c-2e2dabbf0608', 'Выставка', '2023-03-01', '2023-03-15');
insert into exhibit_place values ('937485e9-2e67-41f4-89ea-7de7650e0ab8', 'c537a02c-e622-4bf3-9945-903731ea5d91', '78585f52-a925-4a33-9dd4-3c520229da43', 'Вернули на хранение', '2023-03-15', '9999-01-01');

insert into exhibit_place values ('a9de1882-5eee-48fb-b830-0e43163944e9', '596e6eca-b57d-4ee1-9c4f-bf378bf32490', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '2023-01-31');
insert into exhibit_place values ('13ef8aff-8303-4374-af8e-d1545c9aad1f', '596e6eca-b57d-4ee1-9c4f-bf378bf32490', 'f2145928-eeac-4347-bd3c-2e2dabbf0608', 'Выставка', '2023-03-01', '2023-03-15');
insert into exhibit_place values ('2c29b2fa-8f2a-4722-b8e5-05b4f3921d74', '596e6eca-b57d-4ee1-9c4f-bf378bf32490', '78585f52-a925-4a33-9dd4-3c520229da43', 'Вернули на хранение', '2023-03-15', '9999-01-01');

insert into exhibit_place values ('efc27234-786c-40e5-952c-1d9c0a63e57f', '0dfec3b0-f300-4e2c-b249-9177e0efc6d0', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '2023-01-31');
insert into exhibit_place values ('1de34a56-90a3-4fac-b7e2-89195536bd6f', '0dfec3b0-f300-4e2c-b249-9177e0efc6d0', 'f2145928-eeac-4347-bd3c-2e2dabbf0608', 'Выставка', '2023-03-01', '2023-03-15');
insert into exhibit_place values ('eba3e5ab-5227-4d54-9e69-26f6c86b2267', '0dfec3b0-f300-4e2c-b249-9177e0efc6d0', '78585f52-a925-4a33-9dd4-3c520229da43', 'Вернули на хранение', '2023-03-15', '9999-01-01');

insert into exhibit_place values ('af5dae06-3482-4f11-95a8-d50146ac8cac', '9124b0d4-d07c-4b23-93e7-ee53a8171360', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('c53f5bba-7759-437f-ac47-6b242782d9b3', '0a5d5556-5de3-419f-853f-5615eebb01db', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('1601e913-e381-4c58-9e7b-004b5c5f124c', '1f0bc7e1-0e28-4aff-b8d1-6e9a3d6c5e55', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('138ff693-30cc-43c6-b783-207c1791f954', '867f5baf-cce6-4f8f-8d07-316c2dbb146e', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('437b35eb-4ac2-4331-b195-a8217f9ef119', '2acc3efc-d903-485f-aa2a-54dfe4fe34a2', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('fe8f39e3-cbb3-4d95-b443-c66afacd9f69', 'ea5da651-f243-4815-bd65-3cf6ddd5e2d2', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('056ce6c7-3606-4993-9b7d-9d8cff4811c4', '126444e1-34be-48df-a69a-74230a64d0a6', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('cae90e84-9b24-49a8-8a9c-e63b894e0d60', '7b282345-9868-4788-9ca7-f0c5431d84b9', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
insert into exhibit_place values ('674e2e32-5c68-4a40-bddd-e18477bf68f7', '24920bd7-468c-4c56-8e7b-808a819bf1ce', '78585f52-a925-4a33-9dd4-3c520229da43', 'Покупка', '2023-01-02', '9999-01-01');
