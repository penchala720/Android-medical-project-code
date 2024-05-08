<?php
// Check if the request method is POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get the values from the POST data
    $id = $_POST["id"];
    $date = date("Y-m-d");
    $pod = $_POST["pod"];
    $fs = "null";
    $rs = $_POST["rs"];
    $xr = $_POST["xr"];
    $functionalScore = '0';
    $radiologicalScore = $_POST["radiologicalScore"];

    // You can perform any necessary validation or sanitation here

    // Connect to your database
    require("conn.php");

    // Check if $id is present in doc_scoresheet
    $check_sql = "SELECT * FROM doc_scoresheet WHERE patient_id='$id'";
    $result = $conn->query($check_sql);
    if ($result->num_rows > 0) {
        // Update the existing record
        $sql = "UPDATE doc_scoresheet SET rad_score='$radiologicalScore', rad_text='$rs', x_ray='$xr' WHERE patient_id='$id'";
    } else {
        // Insert a new record
        $sql = "INSERT INTO doc_scoresheet (patient_id, date, pod, fun_score, fun_text, rad_score, rad_text, x_ray) 
                VALUES ('$id', '$date', '$pod', '$functionalScore', '$fs', '$radiologicalScore', '$rs', '$xr')";
    }

    if ($conn->query($sql) === TRUE) {
        // Create a JSON response
        $response = array("status" => "success", "message" => "Data inserted/updated successfully");
        echo json_encode($response);
    } else {
        // Create a JSON response for the error
        $response = array("status" => "error", "message" => "Error: " . $sql . "<br>" . $conn->error);
        echo json_encode($response);
    }

    // Close the database connection
    $conn->close();
} else {
    // Invalid request method
    $response = array("status" => "error", "message" => "Invalid request method");
    echo json_encode($response);
}
?>
