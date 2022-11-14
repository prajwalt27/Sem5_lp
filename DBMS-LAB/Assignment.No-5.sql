
CREATE table result(roll int, name varchar(100), class varchar(100));

INSERT INTO result VALUES(1,"prajwal","") ,(2,"raj",""),(3,"abhi","");

CREATE TABLE stud_marks(name varchar(100), marks int);

INSERT INTO stud_marks VALUES("prajwal",1500),("raj",900),("abhi",850);

CREATE PROCEDURE prograde(in rno int ,out grade varchar(100))
BEGIN
   DECLARE m int;
  
   SELECT marks INTO m FROM stud_marks WHERE name=(SELECT name FROM result WHERE  roll=rno);
   
   IF(m>=990 and m<=1500) THEN
     SELECT "Distinction" INTO grade;
     UPDATE result SET class="Distinction" WHERE roll= rno;
  
   ELSEIF(m>=900 and m<=989) THEN
     SELECT "First calss" INTO grade;  
     UPDATE result SET class="First class" WHERE roll=rno;
  
   ELSEIF(m>=825 and m<=899) THEN
      SELECT "Higher Second class" INTO grade;
      UPDATE result SET class="Higher second class" WHERE roll=rno;

  ELSE
       SELECT "--" INTO grade;
       UPDATE result SET class="--" WHERE roll=rno;
  
  END IF;
END;
      

CREATE FUNCTION FUNC_GRADE(rno INT)
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
   DECLARE grade VARCHAR(100);
   CALL PRO_GRADE(rno,grade);
   RETURN grade;
END;

CALL func_grade(1);
 
CALL func_grade(1);

CALL func_grade(1);


select * from result;
+------+---------+---------------------+
| roll | name    | class               |
+------+---------+---------------------+
|    1 | prajwal | Distinction         |
|    2 | raj     | First class         |
|    3 | abhi    | Higher second class |
+------+---------+---------------------+

 
