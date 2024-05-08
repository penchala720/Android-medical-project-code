<?php
// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    // Retrieve data from the POST request
    $key = $_POST['key']; // Assuming 'key' is the data you're sending

    // Process the data as needed
    // ...

    // Send a response back to the Android app (optional)
    $response = array('message' => 'Data received successfully');
    echo json_encode($response);
} else {
    // Handle non-POST requests
    echo "Invalid request method";
}
?>
