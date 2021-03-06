INSERT INTO company_bank (bankName, BIK, address) VALUES
('Совкомбанк', 043469743, '156000, г. Кострома, просп. Текстильщиков, д. 46'),
('Тинькофф Банк', 044525974, '123060, г. Москва, 1-й Волоколамский пр-д, д. 10, стр. 1'),
('Кредит Европа Банк', 044525767, '129090, г. Москва, Олимпийский проспект, дом 14'),
('Русский Стандарт', 044525151, '105187, г. Москва, ул. Ткацкая, д. 36'),
('Банк Уралсиб', 044525787, '119048, г. Москва, ул. Ефремова, д. 8 ');


INSERT INTO company_position (name, archive) VALUES
('Прораб', TRUE),
('Бригадир на производстве', TRUE), 
('Технолог', FALSE),
('Инженер', TRUE),
('Контролер качества', FALSE),
('Мастер', TRUE),
('Механик', TRUE),
('Рабочий непищевого производства', FALSE),
('Слесарь', TRUE),
('Электрик', TRUE),
('Машинист строительной техники', FALSE),
('Автослесарь', TRUE),
('Монтажник', TRUE),
('Автоэлектрик', TRUE),
('Инженер по технике безопасности', TRUE),
('Машинист холодильных установок', FALSE);

INSERT INTO company_employee (surname, name, patronymic, sex, birthDay, position, dateOfEmployment, salary,	mobilePhone, jobPhone, bank, archive) VALUES
('Шмелева', 'Ирина',  'Георгиевна', 'женский', '1971-07-13', 5, '2009-11-17', 30000, 3154518, 4081678, 5, false),
('Мухина', 'Светлана', 'Руслановна', 'женский', '1985-02-10', 15, '2010-06-13', 35000, 3789945, 45412387, 4, false),
('Перевозкин', 'Сергей', 'Борисович', 'мужской', '1975-08-03', 9, '2015-02-10', 36000, 3245874, 4213846, 3, false),
('Сикач', 'Андрей', 'Михайлович', 'мужской', '1981-06-23', 13, '2012-01-30', 39000, 3987413, 4165465, 1, false),
('Собольников', 'Валерий', 'Васильевич', 'мужской', '1982-02-22', 6, '2010-09-27', 40000, 3435615, 4157945, 5, false),
('Соловьева', 'Ирина', 'Геннадьевна', 'женский', '1987-03-15', 3, '2011-07-29', 32000, 3255590, 4011648, 2, true);
