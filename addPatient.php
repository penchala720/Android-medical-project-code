<?php
require("conn.php");

// Check if the required parameters are set
if (isset($_POST['name']) && isset($_POST['age']) && isset($_POST['ipNumber']) && isset($_POST['address']) &&
    isset($_POST['contact']) && isset($_POST['admission']) && isset($_POST['occupation']) && isset($_POST['education']) &&
    isset($_POST['surgery']) && isset($_POST['discharge']) && isset($_POST['socioecStatus'])) {

    // Retrieve last 4 characters of the IP number as the password
    $password = substr($_POST['ipNumber'], -4);

    // Prepare the SQL statements
    $addPatientSQL = "INSERT INTO addpatient
                      VALUES ('".$_POST['name']."', '".$_POST['age']."', '".$_POST['ipNumber']."', '".$_POST['address']."', '".$_POST['contact']."', 
                              '".$_POST['admission']."', '".$_POST['occupation']."', '".$_POST['education']."', '".$_POST['surgery']."', 
                              '".$_POST['discharge']."', '".$_POST['socioecStatus']."')";

    $addPasswordSQL = "INSERT INTO plogin
                       VALUES ('".$_POST['ipNumber']."', '".$password."','','','','','','')";

    // Execute the SQL statements
    $addPatientResult = $conn->query($addPatientSQL);
    $addPasswordResult = $conn->query($addPasswordSQL);

    // Check if both queries were successful
    if ($addPatientResult && $addPasswordResult) {
        // Data inserted successfully
        $response = array("success" => true, "message" => "Data stored successfully");
        echo json_encode($response);
    } else {
        // Error occurred during insertion
        $response = array("success" => false, "message" => "Error: " . $conn->error);
        echo json_encode($response);
    }

    // Close the database connection
    $conn->close();

} else {
    // Required parameters are not set
    $response = array("success" => false, "message" => "Required parameters are missing");
    echo json_encode($response);
}
?>
