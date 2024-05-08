<?php
require("conn.php");

// Check if the ID is provided in the POST request
if(isset($_POST["id"])) {
    // Define the id for which you want to retrieve data
    $id = $_POST["id"];

    // Perform the query to retrieve data with a specific id from the table
    $query = "SELECT `Medicine_name`, `Dose`, `Type` FROM `medicine_timing` WHERE `id` = ? ORDER BY `date`";
    $stmt = mysqli_prepare($conn, $query);

    // Bind the parameter
    mysqli_stmt_bind_param($stmt, "i", $id);

    // Execute the statement
    mysqli_stmt_execute($stmt);

    // Get the result
    $result = mysqli_stmt_get_result($stmt);

    // Fetch the data and store it in an array
    $data = array();
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }

    // Free the result set
    mysqli_free_result($result);

    // Close the statement
    mysqli_stmt_close($stmt);

    // Close the database connection
    mysqli_close($conn);

    // Set the appropriate content type for JSON response
    header('Content-Type: application/json');

    // Check if any data was found
    if(!empty($data)) {
        // Convert the array to JSON and echo the response
        echo json_encode($data);
    } else {
        // No data found for the provided ID
        echo json_encode(array("error" => "No data found for the provided ID"));
    }
} else {
    // ID is not provided in the POST request
    echo json_encode(array("error" => "ID not provided"));
}
?>
