<?php
// Your database connection parameters
require("conn.php");

// SQL query to fetch patient information
$sql = "SELECT distinct ipNumber, name, age, contact FROM addpatient";

$result = $conn->query($sql);

if ($result) {
    $data = array();
    while ($row = $result->fetch_assoc()) {
        // Fetch profile information from plogin table
        $profile_sql = "SELECT image FROM plogin WHERE pid = '" . $row['ipNumber'] . "'";
        $profile_result = $conn->query($profile_sql);
        
        if ($profile_result) {
            $profile_row = $profile_result->fetch_assoc();
            if ($profile_row) {
                $row['profile_image'] = $profile_row['image']; // Assuming 'image' is the correct column name
            } else {
                $row['profile_image'] = "No profile image found"; // Or handle as per your requirement
            }
        } else {
            $row['profile_image'] = "Error fetching profile image"; // Or handle as per your requirement
        }
        
        $data[] = $row;
    }
    
    echo json_encode($data); // Return JSON response
} else {
    echo "Error executing query: " . $conn->error;
}

$conn->close();
?>