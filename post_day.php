<?php

// Database configuration
require("conn.php");

// Get data from the Android app
$patientId = $_POST["pid"];  // You can modify this as per your requirements
$complaintText = $_POST['complaint'];
$currentDate = date('Y-m-d H:i:s'); // Get the current date and time in MySQL format

// Check if the patientId already exists in the table
$check_sql = "SELECT * FROM doc_post_day WHERE id = '$patientId'";
$result = $conn->query($check_sql);

if ($result->num_rows > 0) {
    // Patient already exists, update the complaint and current date
    $update_sql = "UPDATE doc_post_day SET text = '$complaintText', date = '$currentDate' WHERE id = '$patientId'";
    
    if ($conn->query($update_sql) === TRUE) {
        echo "Data updated successfully";
    } else {
        echo "Error updating record: " . $conn->error;
    }
} else {
    // Patient doesn't exist, insert new record
    $insert_sql = "INSERT INTO doc_post_day  VALUES ('$patientId', '$complaintText', '$currentDate')";
    
    if ($conn->query($insert_sql) === TRUE) {
        echo "New record inserted successfully";
    } else {
        echo "Error inserting record: " . $conn->error;
    }
}

$conn->close();

?>
