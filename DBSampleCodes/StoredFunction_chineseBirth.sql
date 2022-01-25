DELIMITER $$
CREATE FUNCTION chineseBirth(aDate date)
RETURNS VARCHAR(16)
READS SQL DATA
BEGIN
	DECLARE cDate VARCHAR(16);
	SELECT date_format(date_sub(aDate, interval 1911 year), '%y/%m/%d') into cDate;
	RETURN cDate;
END $$
DELIMITER ;