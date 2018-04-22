INSERT INTO wspolnota (id, nazwa, ulica, numer) VALUES (1, 'Szóstka', 'Bajana', 12);
INSERT INTO wspolnota (id, nazwa, ulica, numer) VALUES (2, 'Piast', 'Bystrzycka', 45);
INSERT INTO wspolnota (id, nazwa, ulica, numer) VALUES (3, 'Energetyk', 'Kolista', 20);

INSERT INTO mieszkanie (id, number, powierzchnia, wspolnota_id) VALUES (1, 15, 50, 1);
INSERT INTO mieszkanie (id, number, powierzchnia, wspolnota_id) VALUES (2, 20, 70, 1);
INSERT INTO mieszkanie (id, number, powierzchnia, wspolnota_id) VALUES (3, 4, 115, 1);

INSERT INTO mieszkaniec (id, imie, nazwisko, mieszkanie_id, plec) VALUES (1, 'Aleksandra', 'Sikora', 1, 'KOBIETA');
INSERT INTO mieszkaniec (id, imie, nazwisko, mieszkanie_id, plec) VALUES (2, 'Malgorzata', 'Duda', 1, 'KOBIETA');
INSERT INTO mieszkaniec (id, imie, nazwisko, mieszkanie_id, plec) VALUES (3, 'Alicja', 'Olkowska', 1, 'KOBIETA');