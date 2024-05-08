<?php
// Assuming you have a database connection
require("conn.php");
$id = $_POST["id"];
// Check if a suggestion is submitted


// Fetch complaints from the database
$sql = "SELECT text FROM doc_post_day WHERE id = '$id'";
 // You may need to adjust the condition
$result = $conn->query($sql);




if ($result->num_rows > 0) {
    // Output data of each row
    $row = $result->fetch_assoc();
        $response = array('status' => "success",'res' => $row['text'], 'message' => 'Login successful');
        echo json_encode($response);
} else {
    $response = array('status' => 'failure', 'message' => 'Invalid request method');
    echo json_encode($response);
}

$conn->close();
?>