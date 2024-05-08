<?php
// Include the database connection file (replace with your actual database connection code)
require("conn.php");

// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Get the JSON data from the request body
    $json_data = file_get_contents("php://input");

    $date = date("Y-m-d");
    $pod = "null";
    $fs = "null";
    $rs = "null";
    $xr = "null";
    $functionalScore = 0;
    $radiologicalScore = 0;


    // Parse the JSON data into an associative array
    $data = json_decode($json_data, true);

    // Check if the JSON data was successfully parsed
    if ($data !== null) {
        // Extract data from the JSON
        $field1 = $data['field1'];
        $field2 = $data['field2'];
        
        // Check if $id is present in doc_scoresheet
    $check_sql = "SELECT * FROM doc_scoresheet WHERE patient_id='$field2'";
    $result = $conn->query($check_sql);
    if ($result->num_rows > 0) {
        // Update the existing record
        $sql = "UPDATE doc_scoresheet SET fun_text ='$field1' where patient_id='$field2' ";
    } else {
        // Insert a new record
        $sql = "INSERT INTO doc_scoresheet (patient_id, date, pod, fun_score, fun_text, rad_score, rad_text, x_ray) 
                VALUES ('$field2', '$date', '$pod', '$functionalScore', '$field1', '$radiologicalScore', '$rs', '$xr')";
    }
        $stmt=mysqli_query($conn, $sql);
        echo json_encode(array("status"=> "success","message"=> "Data updated succesfully"));

        // Check if the update was successful
        // if (my> 0) {
        //     $response = array('message' => 'Data updated successfully');
        //     echo json_encode($response);
        // } else {
        //     $response = array('message' => 'Data not updated');
        //     echo json_encode($response);
        // }
    } else {
        $response = array('message' => 'Invalid JSON data');
        echo json_encode($response);
        
    }
} else {
    $response = array('message' => 'Invalid request method');
    echo json_encode($response);
}
?>