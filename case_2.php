<?php
// Check if IP number is set and not empty
require "conn.php";
if(isset($_POST['ipNumber']) && !empty($_POST['ipNumber'])) {
    // Retrieve IP number from the POST request
    $ipNumber = $_POST['ipNumber'];


    // Prepare and execute SQL query to fetch data based on IP number
    $sql = "SELECT * FROM addpatient2 WHERE id = '$ipNumber'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        // Output data as JSON
        $row = $result->fetch_assoc();
        echo json_encode($row);
    } else {
        echo "0 results";
    }
    $conn->close();
} else {
    // If ipNumber is not set or empty, return an error message
    echo "IP number not provided";
}
?>
