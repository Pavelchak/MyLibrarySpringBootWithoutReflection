USE mylibrary;

DELIMITER //
CREATE TRIGGER AfterInsertPersonBook
AFTER INSERT
ON person_book FOR EACH ROW
BEGIN
	DECLARE name_person VARCHAR(50);
    DECLARE name_book VARCHAR(90);
    SELECT CONCAT(surname, ' ', name) INTO name_person
    FROM person WHERE person_id=new.person_id;
    SELECT CONCAT(book_name, ' / ', Author) INTO name_book
    FROM book WHERE book_id=new.book_id;
	INSERT INTO logger (person, book, action,
								time_stamp, user)
	VALUES(name_person,  name_book, 'GOT', NOW(), USER() );
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterDeletePersonBook
AFTER DELETE
ON person_book FOR EACH ROW
BEGIN
	DECLARE name_person VARCHAR(50);
    DECLARE name_book VARCHAR(90);
    SELECT CONCAT(surname, ' ', name) INTO name_person
    FROM person WHERE person_id=old.person_id;
    SELECT CONCAT(book_name, ' / ', author) INTO name_book
    FROM book WHERE book_id=old.book_id;
	INSERT INTO Logger (person, book, action,
                      time_stamp, user)
	VALUES(name_person,  name_book, 'GAVEBACK', NOW(), USER() );
END //
DELIMITER ;






