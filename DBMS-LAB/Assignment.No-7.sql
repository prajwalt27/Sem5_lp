 /*
 Name: Prajwal Toundakar
 Divi.: TE1
 Roll No.: 31184
 Batch: N1
 */

/*Topic - Triggers  */

CREATE TABLE Library_Table(id int, title varchar(100), total_copies int);
CREATE TABLE Library_Audit(id int ,title varchar(100),total_copies int,mod_date date, status varchar(100));
 
 
 INSERT INTO Library_Table VALUES(10,"Ikigai",3),(11,"Wings of fire",2),(12,"Atomic Habits",4),(13,"Ego is enemy",1),(14,"Attitude is everything",2),(15,"The monk way", 4),(16,"Lincoln",2);

 SELECT * FROM Library_Table;
+------+------------------------+--------------+
| id   | title                  | total_copies |
+------+------------------------+--------------+
|   10 | Ikigai                 |            3 |
|   11 | Wings of fire          |            2 |
|   12 | Atomic Habits          |            4 |
|   13 | Ego is enemy           |            1 |
|   14 | Attitude is everything |            2 |
|   15 | The monk way           |            4 |
|   16 | Lincoln                |            2 |
+------+------------------------+--------------+

delimiter //

/*for update */
CREATE TRIGGER up_trigg
AFTER UPDATE ON Library_Table
FOR EACH ROW
BEGIN
INSERT INTO Library_Audit SET id=OLD.id , title=OLD.title, total_copies=OLD.total_copies, mod_date=CURDATE(),status ="UPDATE";
END;
//

/*for delete*/
CREATE TRIGGER del_trigg
AFTER DELETE ON Library_Table
FOR EACH ROW
BEGIN
INSERT INTO Library_Audit SET id=OLD.id , title=OLD.title, total_copies=OLD.total_copies, mod_date=CURDATE(),status ="DELETE";
END;
//

UPDATE Library_Table SET total_copies=4 WHERE id=13;
DELETE FROM Library_Table WHERE id=15;


SELECT * FROM Library_Audit;
+------+--------------+--------------+------------+--------+
| id   | title        | total_copies | mod_date   | status |
+------+--------------+--------------+------------+--------+
|   13 | Ego is enemy |            1 | 2022-09-27 | UPDATE |
|   15 | The monk way |            4 | 2022-09-27 | DELETE |
+------+--------------+--------------+------------+--------+

SELECT * FROM Library_Table;
+------+------------------------+--------------+
| id   | title                  | total_copies |
+------+------------------------+--------------+
|   10 | Ikigai                 |            3 |
|   11 | Wings of fire          |            2 |
|   12 | Atomic Habits          |            4 |
|   13 | Ego is enemy           |            4 |
|   14 | Attitude is everything |            2 |
|   16 | Lincoln                |            2 |
+------+------------------------+--------------+









