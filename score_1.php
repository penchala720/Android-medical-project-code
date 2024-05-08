<?php

// Assuming you have already established a connection to your database

// Perform the database query to fetch data from doc_scoresheet table
require("conn.php");
$id = $_POST["id"];
$query_scoresheet = "SELECT patient_id, date, pod, fun_score, fun_text, rad_score, rad_text FROM doc_scoresheet WHERE patient_id ='$id' ORDER BY date DESC LIMIT 1";
$result_scoresheet = mysqli_query($conn, $query_scoresheet);

// Check if the query was successful
if ($result_scoresheet) {
    // Initialize an array to store the scoresheet data
    $response = array();

    // Fetch each row from the result set
    while ($row_scoresheet = mysqli_fetch_assoc($result_scoresheet)) {
        // Add each row to the response array
        $response[] = $row_scoresheet;
    }

    // Close the scoresheet result set
    mysqli_free_result($result_scoresheet);

    // Perform another query to fetch image data from the document table
    $query_document = "SELECT img FROM document WHERE id ='$id'";
    $result_document = mysqli_query($conn, $query_document);

    // Check if the query was successful
    if ($result_document) {
        // Fetch the row from the result set
        $row_document = mysqli_fetch_assoc($result_document);

        // Add the image data to the response array
        $response['x_ray'] = $row_document['img'];

        // Close the document result set
        mysqli_free_result($result_document);
    } else {
        // If the document query fails, set x_ray to null
        $response['x_ray'] = null;
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
    // If the scoresheet query fails, return an error message
    echo json_encode(array('error' => 'Failed to fetch data from the database'));
}

?>
