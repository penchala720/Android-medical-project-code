<?php

// Assuming you have already established a connection to your database
require("conn.php");
$id = $_POST['id'];
// Perform the database query to fetch data
$query = "SELECT patient_id, diagnosis, pn, io, surgery_date, surgery_time, blood_loss FROM doc_surgery where patient_id = '$id'";
$result = mysqli_query($conn, $query);

// Check if the query was successful
if ($result) {
    // Initialize an array to store the data
    $response = array();

    // Fetch each row from the result set
    while ($row = mysqli_fetch_assoc($result)) {
        // Add each row to the response array
        $response[] = $row;
    }

    // Close the database connection
    mysqli_close($conn);

    // Convert the response array to JSON format
    $json_response = json_encode($response);

    // Set the appropriate header for JSON response
    header('Content-Type: application/json');

    // Output the JSON response
    echo $json_response;
} else {
    // If the query fails, return an error message
    echo json_encode(array('error' => 'Failed to fetch data from the database'));
}

?>
