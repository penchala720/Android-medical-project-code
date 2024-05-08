<?php

require("conn.php");
// Get the POST data from Android app
$distractionValue = $_POST['distraction'];
$dressingPinTrackValue = $_POST['dressing_pin_track'];
$dressingApparatusCleaningValue = $_POST['dressing_apparatus_cleaning'];
$compressionValue = $_POST['compression'];

// Insert data into the table
$sql = "INSERT INTO pilizarov 
        VALUES ('$distractionValue', '$dressingPinTrackValue', '$dressingApparatusCleaningValue', '$compressionValue')";

if (mysqli_query($conn, $sql)) {
    echo "Data inserted successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($connection);
}

// Close the database connection
mysqli_close($conn);

?>
