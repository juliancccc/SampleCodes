DROP PROCEDURE IF EXISTS GetStudentName;
DELIMITER $$
CREATE PROCEDURE GetStudentName(IN student_id int, OUT student_name VARCHAR(16))
BEGIN
	DECLARE ename VARCHAR(16);
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
END $$
DELIMITER ;