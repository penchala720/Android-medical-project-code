<?php
// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    // Retrieve data from the POST request
    $medicineName = $_POST['medicineName'];
    $dose = $_POST['dose'];
    $session = $_POST['session'];

    // Perform any necessary validation or processing

    // Example: Insert data into a database
    // Replace the database connection details and query with your actual information
    $servername = "your_database_server";
    $username = "your_database_username";
    $password = "your_database_password";
    $dbname = "your_database_name";

    // Create a connection
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Check the connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Prepare and execute the SQL query
    $sql = "INSERT INTO medicines (medicine_name, dose, session) VALUES ('$medicineName', '$dose', '$session')";
    if ($conn->query($sql) === TRUE) {
        echo "Data inserted successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    // Close the connection
    $conn->close();
} else {
    // Handle non-POST requests
    echo "Invalid request method";
}
?>
