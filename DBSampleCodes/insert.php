<?php
    $dbhost = 'localhost';
    $dbuser = 'julian';
    $dbpass = 'admin123';
    $dbname = 'demo';
	$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
    if ($conn->connect_error) {
        die('無法連上資料庫：' . $conn->connect_error);
    }
    $conn->set_charset("utf8");
    $sql = "INSERT INTO Student values (3, 'Wu', '1978-03-09',90.5)";
    if ($conn->query($sql)) {
		echo 'Insert OK';
	}else{	
		echo 'MySQL query error';
	}	
	$conn->close();
?>
