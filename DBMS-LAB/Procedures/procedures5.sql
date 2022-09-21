delimiter //

CREATE PROCEDURE procGrade(IN roll INT)
	BEGIN
		DECLARE student varchar(20);
		DECLARE marks INT;
		DECLARE EXIT HANDLER FOR SQLEXCEPTION SELECT 'Entry Not Found' AS EXCEPTION;
		IF NOT EXISTS(SELECT * FROM studMarks WHERE rollNum=roll) THEN 
			SIGNAL SQLSTATE '45000';
			END IF;
		
		select sName INTO student FROM studMarks where roll=rollNum;
		select totalMarks INTO marks FROM studMarks where roll=rollNum;
		
		
		
		IF marks>=990 AND marks<=1500 THEN
			INSERT INTO result VALUES(roll,student,marks,"Distinction");
			
		ELSEIF marks >=900 AND marks<=989 THEN
			INSERT INTO result VALUES(roll,student,marks,"First Class");
		
		ELSEIF marks>=825 AND marks<=899 THEN 
			INSERT INTO result VALUES(roll,student,marks,"Higher Second Class");
			
		ELSE 
			INSERT INTO result VALUES(roll,student,marks,NULL);
		END IF;
		
		SELECT * FROM result;
		
	END
//


delimiter //
CREATE PROCEDURE loopGrade()
	BEGIN	
		DECLARE x INT;
		SET x=1;
		
		abrakadabra:
			LOOP
				IF x>10 THEN
					LEAVE abrakadabra;
				END IF;
				CALL procGrade(x);
				SET x=x+1;
				
			END LOOP;
			SELECT * FROM result;
	END
//

CREATE FUNCTION funGrade(marks INT)
RETURNS VARCHAR(20)
DETERMINISTIC

	BEGIN
		DECLARE Grade varchar(20);
		IF marks >= 990 AND marks <= 1500 THEN
			SET Grade = 'Distinction';
			
		ELSEIF marks >= 900 AND marks <= 989 THEN
			SET Grade = 'First Class';
			
		ELSEIF marks >= 825 AND marks <= 899 THEN
			SET Grade = 'Higher Second Class';
			
		ELSE
			SET Grade = NULL;
			
		END IF;
		
			
		RETURN Grade;
	END
// 


delimiter //
CREATE PROCEDURE procGrade2()
	BEGIN
	DECLARE strng varchar(20);
	DECLARE studName varchar(20);
	DECLARE marks INT;
	DECLARE x INT;
	SET x=1;
	
	
		
	forLoop:
		LOOP
			IF x>10 THEN 
				LEAVE forLoop;
			END IF;
			
			select sName INTO studName FROM studMarks where rollNum=x;
			select totalMarks INTO marks FROM studMarks where rollNum=x;
			SET strng=funGrade(marks);
			INSERT INTO result VALUES(x,studName,marks,strng);
			SET x=x+1;
		END LOOP;
		select * from result;
	END;
//
