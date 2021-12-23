<?php
    $dbhost = 'localhost:3306';
    $dbuser = 'julian';
    $dbpass = 'admin123';
    $dbname = 'demo';
	$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
    if ($conn->connect_error) {
        die('無法連上資料庫：' . $conn->connect_error);
    }
    $conn->set_charset("utf8");
    $sql = "SELECT id, name, score FROM Student;";
    $result = $conn->query($sql) or die('MySQL query error');
    while($row = $result->fetch_assoc()){
        echo $row['id'];echo ',';
        echo $row['name'];echo ',';
        echo $row['score']; echo '<br>';
    }
	$result->free();
	$conn->close();
?>
