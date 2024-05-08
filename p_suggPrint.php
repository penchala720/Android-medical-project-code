<?php
// Assuming you have a database connection
require("conn.php");
$id = $_POST["P_id"];
// Check if a suggestion is submitted
if (isset($_POST['P_id'])) {
  
   

    // Insert the suggestion into the database
  
    $sql = "select * from pcomplaints WHERE pid = '$id' order by date desc";
$result = $conn->query($sql);

}

// Fetch complaints from the database





if ($result->num_rows > 0) {
    // Output data of each row
    $row = $result->fetch_assoc();
        $response = array('status' => "success",'res' => $row['sugg'], 'message' => 'Login successful');
        echo json_encode($response);
} else {
    $response = array('status' => 'failure', 'message' => 'Invalid request method');
    echo json_encode($response);
}

$conn->close();
?>