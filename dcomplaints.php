<?php
// Assuming you have a database connection
require("conn.php");

// Check if the 'id' parameter is provided
if (!isset($_POST['id'])) {
    $response = array('status' => 'failure', 'message' => 'ID parameter is missing');
    echo json_encode($response);
    exit; // Stop further execution
}

$id = $_POST["id"];

// Check if a suggestion is submitted
if (isset($_POST['suggestion'])) {
    $suggestion = $_POST['suggestion'];

    // Use prepared statement to prevent SQL injection
    $sql = "UPDATE pcomplaints SET sugg = '$suggestion' WHERE pid = '$id'";
    $stmt = $conn->prepare($sql);
 

    if ($stmt->execute()) {
        $response = array('status' => "success", 'message' => 'Suggestion updated successfully');
        echo json_encode($response);
    } else {
        $response = array('status' => 'failure', 'message' => 'Failed to update suggestion');
        echo json_encode($response);
    }
    exit; // Stop further execution
}

// Fetch complaints from the database for the specific patient ID
$sql = "SELECT comp FROM pcomplaints WHERE pid = ? ORDER BY date DESC LIMIT 1";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id);
$stmt->execute();   
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    // Output data of each row
    $row = $result->fetch_assoc();
    $response = array('status' => "success", 'res' => $row['comp'], 'message' => 'Data retrieved successfully');
    echo json_encode($response);
} else {
    $response = array('status' => 'failure', 'message' => 'No complaints found for the given ID');
    echo json_encode($response);
}

$stmt->close();
$conn->close();

?>
