DROP FUNCTION IF EXISTS GetStudentName;
DELIMITER $$
CREATE FUNCTION GetStudentName(student_id int)
RETURNS VARCHAR(16)
READS SQL DATA
BEGIN
	DECLARE ename, student_name VARCHAR(16);
	SELECT name INTO ename
	FROM Student
	WHERE id = student_id;
	IF ename = "peter" THEN
		SET student_name = "彼得";
	ELSEIF ename = "eric" THEN
		SET student_name = "瑞克";
	ELSEIF ename = "edward"	THEN
		SET student_name = "愛德華";
	END IF;
    RETURN student_name;
END $$
DELIMITER ;