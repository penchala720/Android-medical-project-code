<?php
require("conn.php");
// Check if it's a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    // Get the raw POST data
    $json_data = file_get_contents("php://input");
    
    // Decode the JSON data
    $data = json_decode($json_data, true);
    
    // Extract data
    $id = $data['id'];
    $selectedOption = $data['selectedOption'];
    
    // Process the data (you can perform any desired actions here)
    
    // Respond with a message
    $response = array('status' => 'success', 'message' => 'Data received successfully');
    echo json_encode($response);
    
} else {
    // Respond with an error message for non-POST requests
    $response = array('status' => 'error', 'message' => 'Invalid request method');
    echo json_encode($response);
}
?>
