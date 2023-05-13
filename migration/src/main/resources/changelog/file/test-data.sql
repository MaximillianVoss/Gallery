insert into users values ('6edfbc36-f1f3-4a74-a5ca-b460520403b4', 'Иван', 'Иванов', 'admin@test.ru', '$2a$10$mqgq2/vI5hfgrStkmNsY5eyiourAT5ZceJdeVQP5m9Vn1lu3MaZ0a', '3302b0a3-4b45-4503-9bdc-e6e0e1755b25');

insert into author values ('9dd8ca37-c315-4525-8648-edf1da198fdb', 'тестовый автор1');
insert into author values ('de9404a3-2996-4db7-8d46-619aa241362c', 'тестовый автор2');

insert into event values ('d82bc250-07aa-47da-9ba0-93b83b59cf9e', 'Персональная выставка Тестового автора', 'Тестовый автор популярный художник', '2023-03-01', '2023-03-15', 'fffaf5fe-4885-4cce-8361-98602c5ac965');

insert into exhibit values ('d17a9d20-fcc8-49e3-9924-aba19b423209', 'тестовый экспонат1', '', 'CODE1', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('c537a02c-e622-4bf3-9945-903731ea5d91', 'тестовый экспонат2', '', 'CODE2', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('596e6eca-b57d-4ee1-9c4f-bf378bf32490', 'тестовый экспонат3', '', 'CODE3', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('0dfec3b0-f300-4e2c-b249-9177e0efc6d0', 'тестовый экспонат4', '', 'CODE4', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('9124b0d4-d07c-4b23-93e7-ee53a8171360', 'тестовый экспонат5', '', 'CODE5', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('0a5d5556-5de3-419f-853f-5615eebb01db', 'тестовый экспонат6', '', 'CODE6', '9dd8ca37-c315-4525-8648-edf1da198fdb', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('1f0bc7e1-0e28-4aff-b8d1-6e9a3d6c5e55', 'тестовый экспонат7', '', 'CODE7', '9dd8ca37-c315-4525-8648-edf1da198fdb', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('867f5baf-cce6-4f8f-8d07-316c2dbb146e', 'тестовый экспонат8', '', 'CODE8', '9dd8ca37-c315-4525-8648-edf1da198fdb', '1a46cebe-e9c5-4d7c-ac57-0985413869e2', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('2acc3efc-d903-485f-aa2a-54dfe4fe34a2', 'тестовый экспонат9', '', 'CODE9', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('ea5da651-f243-4815-bd65-3cf6ddd5e2d2', 'тестовый экспонат10', '', 'CODE10', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('126444e1-34be-48df-a69a-74230a64d0a6', 'тестовый экспонат11', '', 'CODE11', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('7b282345-9868-4788-9ca7-f0c5431d84b9', 'тестовый экспонат12', '', 'CODE12', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');
insert into exhibit values ('24920bd7-468c-4c56-8e7b-808a819bf1ce', 'тестовый экспонат13', '', 'CODE13', '9dd8ca37-c315-4525-8648-edf1da198fdb', '9ae21a22-3766-40fe-a4b5-8e65b8e32f55', '18fa6745-9860-4870-afe9-269f1c304186');

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


insert into event_exhibit values ('7ee11f59-47b1-402a-945d-0196d48154b1', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', 'd17a9d20-fcc8-49e3-9924-aba19b423209');
insert into event_exhibit values ('40bd9338-bea8-4f15-8e04-53d48bfe459f', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', 'c537a02c-e622-4bf3-9945-903731ea5d91');
insert into event_exhibit values ('009a6889-2059-4984-b8dc-a170d241978a', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '596e6eca-b57d-4ee1-9c4f-bf378bf32490');
insert into event_exhibit values ('90709dfe-0c96-4f24-b45c-9e0303e981e6', 'd82bc250-07aa-47da-9ba0-93b83b59cf9e', '0dfec3b0-f300-4e2c-b249-9177e0efc6d0');
