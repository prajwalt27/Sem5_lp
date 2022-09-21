create procedure proc()
begin
declare a,b int;
declare c1 cursor for select rollno from oldemp;
declare continue handler for NOT FOUND SET b=1;

OPEN c1;
REPEAT
FETCH c1 into a;
UNTIL b=1;
END REPEAT;
CLOSE c1;
END;

delimiter //
create procedure merge()
   begin
     DECLARE empid int;
     DECLARE n varchar(50);
     DECLARE s int;
     DECLARE cit varchar(50);
     
     DECLARE exit_loop boolean;
     DECLARE c1 cursor for select id from oldemp;
     DECLARE continue handler for NOT FOUND set exit_loop=TRUE;
         open c1;
           myloop:LOOP 
              fetch c1 into empid;
              if not exists(select id from newemp where id=empid) then
              select name into n from oldemp where id=empid;
              select sal into s from oldemp where id=empid;
              select city into cit from oldemp where id=empid;
              
              insert into newemp values(empid,n,s,cit);
              

              end if;
              if exit_loop then 
          close c1;
          leave myloop;
              end if;
       end loop myloop;
end;
