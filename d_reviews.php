<?php
// Assuming you have a database connection
require("conn.php");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$id = $_POST["pid"];

// Fetch dates from the database
$sql = "SELECT distinct * FROM doc_reviews where id='$id' order by date desc";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $dates = array();

    while ($row = $result->fetch_assoc()) {
        $dates[] = $row['date'];
    }

    echo json_encode($dates);
} else {
    echo "No dates found";
}

$conn->close();
?>
