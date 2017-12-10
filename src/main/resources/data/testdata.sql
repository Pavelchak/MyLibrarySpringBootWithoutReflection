USE mylibrary;

INSERT INTO book (book_name, author, publisher, imprint_year, amount) VALUES
('Bible','St. mans','Svichado',2005,5),
('Kobzar','Shevchenko ','Svichado',2007,4),
('Harry Potter','J. K. Rowling','Nebo Booklab Publishing',2002,1),
('Zakhar Berkut','I. Franko','Caravela',2003,2),
('The Jungle Book','Rudyard Kipling','Nebo Booklab Publishing',2002,1),
('100 fairy tales. Volume 1','','A-BA-BA-HA-LA-MA-HA',2005,3),
('100 fairy tales. Volume 2','','A-BA-BA-HA-LA-MA-HA',2008,1),
('100 fairy tales. Volume 3','','A-BA-BA-HA-LA-MA-HA',2014,2);

INSERT INTO city (city_id,city) VALUES
(1,'Herson'),(2,'Kyiv'),(3,'Lviv'),(4,'Poltava'),(5,'Ternopil');

INSERT INTO person (surname,name,email,city_id,street,apartment) VALUES
('Veres','Zenoviy','zenoviy.veres@gmail.com',3,'Hutorivka','13/25'),
('Pavelchak','Andrii','apavelchak@gmail.com',4, 'Trartorystiv','11/14a'),
('Dzelendzyak','Ulyana','u.dzelendzyak@gmail.com',1,'Tehnichna','23'),
('Liutyk','Marta','melodika99@gmail.com',5,'S.Bandery','1/21'),
('Matsiakh','Mykola','mmatsiakh@gmail.com',2,'Dytiacha','23/5'),
('Kulbach','Polina','polina.alexia@gmail.com',4,'Vesniana','11a'),
('Mishchanyn','Viktoria','viktoria.mishchanyn@gmail.com',2,'Maidan Nezalezhnosti','3/5'),
('Vinnichenko','Vitaliy','vinnichenko.vitaliy@gmail.com',5,'S.Bandery','1/22');


