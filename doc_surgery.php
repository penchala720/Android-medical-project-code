<?php
require("conn.php");

// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Get the JSON data from the request body
    $json_data = file_get_contents('php://input');

    // Decode the JSON data
    $data = json_decode($json_data, true);

    // Retrieve data from the decoded JSON
    $patient_id = $_POST['patient_id']; // Corrected variable name
    $diagnosis = $_POST['diagnosis'];
    $pn = $_POST['pn']; // Corrected variable name
    $io = $_POST['io']; // Corrected variable name
    $surgery_date = $_POST['surgery_date']; // Corrected variable name
    $surgery_time = $_POST['surgery_time']; // Corrected variable name
    $blood_loss = $_POST['blood_loss'];

    // TODO: Add your logic to save the data to the database or perform other operations
    // For now, let's just print the received data

    // Ensure to use proper variable names in your SQL query
    $sql = "INSERT INTO doc_surgery 
            VALUES ('$patient_id', '$diagnosis', '$pn', '$io', '$surgery_date', '$surgery_time', '$blood_loss')";

    // Execute the SQL query
    $result = mysqli_query($conn, $sql);

    if ($result) {
        // If the query was successful, send a success response
        $response = array("status" => "success", "message" => "Data received and inserted successfully");
        echo json_encode($response);
    } else {
        // If there was an error in the query, send an error response
        $response = array("status" => "error", "message" => "Error inserting data into the database");
        echo json_encode($response);
    }
} else {
    // If the request method is not POST, return an error response
    $response = array("status" => "error", "message" => "Invalid request method");
    echo json_encode($response);
}
?>
