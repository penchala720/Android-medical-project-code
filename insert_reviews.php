<?php
// Assuming you have a database connection
require("conn.php");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if 'pid' and 'newDate' are set in the POST data
if(isset($_POST["pid"]) && isset($_POST["newDate"])) {
    $id = $_POST["pid"];
    $newDate = $_POST["newDate"];

    // Insert a new date into the database
    $insertSql = "INSERT INTO doc_reviews (id, date) VALUES ('$id', '$newDate')";
    if ($conn->query($insertSql) === TRUE) {
        echo "New date inserted successfully";
    } else {
        echo "Error inserting date: " . $conn->error;
    }

} else {
    echo "Invalid request, 'pid' or 'newDate' not set in POST data";
}

$conn->close();
?>
