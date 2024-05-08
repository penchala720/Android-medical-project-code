<?php
// Check if IP number is set and not empty
require "conn.php";

if(isset($_POST['ipNumber']) && !empty($_POST['ipNumber'])) {
    // Retrieve IP number from the POST request
    $ipNumber = $_POST['ipNumber'];
    $sql = "SELECT * FROM addpatient WHERE ipNumber = '$ipNumber'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        // Output data of each row
        $response = array();
        while($row = $result->fetch_assoc()) {
            // Append each row to the response array
            $response[] = $row;
        }
        // Send the response as JSON
        echo json_encode($response);
    } else {
        // If no results found, return an error message
        echo json_encode(array("error" => "No results found"));
    }
    $conn->close();
} else {
    // If ipNumber is not set or empty, return an error message
    echo json_encode(array("error" => "IP number not provided"));
}
?>
