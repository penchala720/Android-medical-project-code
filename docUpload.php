<?php
// Define database connection parameters
require("conn.php");

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if image file is uploaded
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["image"]) && isset($_POST["id"])) {
    $id = $_POST['id'];
    $imageData = $_POST["image"];
    $imageData = str_replace('data:image/jpeg;base64,', '', $imageData);
    $imageData = str_replace(' ', '+', $imageData);
    $data = base64_decode($imageData);
    $imageName = "image_" . $id . ".jpg";
    $filePath = "uploads/" . $imageName;

    // Upload image
    if (file_put_contents($filePath, $data)) {
        // Insert image path into database
        $sql = "INSERT INTO document  VALUES (null,'$id', '$filePath')";

        if ($conn->query($sql) === TRUE) {
            echo "Image uploaded successfully.";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
    } else {
        echo "Sorry, there was an error uploading your file.";
    }
} else {
    echo "No image file uploaded.";
}

// Close connection
$conn->close();
?>
