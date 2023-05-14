insert into dictionary values ('a49ad1ad-8deb-48e4-bfc9-bd4c82a35d59', null, 'Тип живописи', 'EXH_TYPE');
insert into dictionary values ('9ae21a22-3766-40fe-a4b5-8e65b8e32f55', 'a49ad1ad-8deb-48e4-bfc9-bd4c82a35d59', 'Картина', 'EXH_TYPE_PICTURE');
insert into dictionary values ('1a46cebe-e9c5-4d7c-ac57-0985413869e2', 'a49ad1ad-8deb-48e4-bfc9-bd4c82a35d59', 'Фреска', 'EXH_TYPE_FRESCO');
insert into dictionary values ('4bc49883-5c6b-4181-8d92-d8961fa942e1', 'a49ad1ad-8deb-48e4-bfc9-bd4c82a35d59', 'Фотография', 'EXH_TYPE_PHOTO');

insert into dictionary values ('e94d3338-df0d-4050-a6be-d6f861af55a8', null, 'Тип вложения', 'EXH_ATTACH_TYPE');
insert into dictionary values ('e86eebd9-ea44-4449-b519-7c792f740664', 'e94d3338-df0d-4050-a6be-d6f861af55a8', 'Документ', 'EXH_ATTACH_TYPE_DOCUMENT');
insert into dictionary values ('8e155792-0f76-497c-8bfc-98560f001b0f', 'e94d3338-df0d-4050-a6be-d6f861af55a8', 'Отчет', 'EXH_ATTACH_TYPE_REPORT');

insert into dictionary values ('43e6339c-7266-40a4-aacc-668f13b3f927', null, 'Тип мероприятия', 'EVENT_TYPE');
insert into dictionary values ('fffaf5fe-4885-4cce-8361-98602c5ac965', '43e6339c-7266-40a4-aacc-668f13b3f927', 'Персональная выставка', 'EVENT_TYPE_PERSONAL');
insert into dictionary values ('092949a7-24e4-4dba-9ac3-91b33bdbdd09', '43e6339c-7266-40a4-aacc-668f13b3f927', 'Регулярная выставка', 'EVENT_TYPE_REGULAR');

insert into dictionary values ('b2bf46dc-1c2d-478e-9cd0-34df5caedb0c', null, 'Тип роли', 'ROLE_TYPE');
insert into dictionary values ('3302b0a3-4b45-4503-9bdc-e6e0e1755b25', 'b2bf46dc-1c2d-478e-9cd0-34df5caedb0c', 'Администратор', 'ROLE_TYPE_ADMIN');

insert into dictionary values ('25c17414-86ad-49ee-af18-47c30a79787c', null, 'Тип места', 'PLACE_TYPE');
insert into dictionary values ('78585f52-a925-4a33-9dd4-3c520229da43', '25c17414-86ad-49ee-af18-47c30a79787c', 'Хранение', 'PLACE_TYPE_STORAGE');
insert into dictionary values ('f2145928-eeac-4347-bd3c-2e2dabbf0608', '25c17414-86ad-49ee-af18-47c30a79787c', 'Выставка', 'PLACE_TYPE_EXHIBITION');
insert into dictionary values ('d7cdc140-6320-4a42-ad62-0be978e55b0c', '25c17414-86ad-49ee-af18-47c30a79787c', 'Реставрация', 'PLACE_TYPE_RESTORATION');

insert into dictionary values ('fee27cff-0f8e-4ca9-8836-827268aea6ef', null, 'Тип условия хранения', 'STORAGE_CONDITION_TYPE');
insert into dictionary values ('9fab0f15-2309-4eea-bdf1-7041aa40f26e', 'fee27cff-0f8e-4ca9-8836-827268aea6ef', 'Специальное хранение', 'STORAGE_CONDITION_TYPE_SPECIAL');
insert into dictionary values ('18fa6745-9860-4870-afe9-269f1c304186', 'fee27cff-0f8e-4ca9-8836-827268aea6ef', 'Обычное хранение', 'STORAGE_CONDITION_TYPE_REGULAR');