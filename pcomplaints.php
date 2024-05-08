<?php

// Database configuration
require("conn.php");

// Get data from the Android app
$patientId = $_POST["pid"];  // You can modify this as per your requirements
$complaintText = $_POST['complaint'];
$doctorVisitAnswer = $_POST['doctor_visit'];
$date = $_POST['date'];
$sugg="";

// Check if the patientId already exists in the table
$check_sql = "SELECT * FROM pcomplaints WHERE pid = '$patientId'";
$result = $conn->query($check_sql);

if ($result->num_rows > 0) {
    // Patient already exists, update the record
    $update_sql = "UPDATE pcomplaints SET comp = '$complaintText', `y/n` = '$doctorVisitAnswer', `date` = '$date' WHERE pid = '$patientId'";
    
    if ($conn->query($update_sql) === TRUE) {
        echo "Data updated successfully";
    } else {
        echo "Error updating record: " . $conn->error;
    }
} else {
    // Patient doesn't exist, insert new record
    $insert_sql = "INSERT INTO pcomplaints  VALUES ('$patientId', '$complaintText', '$doctorVisitAnswer', '$date','$sugg')";
    
    if ($conn->query($insert_sql) === TRUE) {
        echo "Data inserted successfully";
    } else {
        echo "Error inserting record: " . $conn->error;
    }
}

$conn->close();

?>
