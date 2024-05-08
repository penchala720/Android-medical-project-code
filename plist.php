<?php
// Database connection parameters
require("conn.php");

// Query to retrieve patient data
$sql = "SELECT pid,comp,date FROM pcomplaints";
$result = $conn->query($sql);

// Check if there are results
if ($result->num_rows > 0) {
    // Output data of each row
    $output = array();
    while($row = $result->fetch_assoc()) {
        $output[] = $row;
    }
    echo json_encode($output); // Return JSON representation of the data
} else {
    echo "0 results";
}
$conn->close();
?>
