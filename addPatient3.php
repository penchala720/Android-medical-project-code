<?php
require("conn.php");
// Check if the required parameters are set
if(isset($_POST["id"]) && isset($_POST['appearance']) && isset($_POST['pallor']) && isset($_POST['cyanosis']) && isset($_POST['treatment']) && isset($_POST['family']) && isset($_POST['built']) && isset($_POST['icterus']) && isset($_POST['clubbing']) && isset($_POST['pulse']) && isset($_POST['bp']) && isset($_POST['pedal']) && isset($_POST['lymphadeno']) && isset($_POST['respiratory']) && isset($_POST['temperature']) && isset($_POST['card']) && isset($_POST['respirat']) && isset($_POST['abdomen']) && isset($_POST['central']) && isset($_POST['right1']) && isset($_POST['left1']) && isset($_POST['soft']) && isset($_POST['discharge']) && isset($_POST['neurova']) && isset($_POST['other']) && isset($_POST['fracture']) && isset($_POST['open']) && isset($_POST['non']) && isset($_POST['fina']) && isset($_POST['initial']) && isset($_POST['planned']) && isset($_POST['post'])) {

    // Assign received data to variables
    $id = $_POST["id"];
    $appearance = $_POST['appearance'];
    $pallor = $_POST['pallor'];
    $cyanosis = $_POST['cyanosis'];
    $treatment = $_POST['treatment'];
    $family = $_POST['family'];
    $built = $_POST['built'];
    $icterus = $_POST['icterus'];
    $clubbing = $_POST['clubbing'];
    $pulse = $_POST['pulse'];
    $bp = $_POST['bp'];
    $pedal = $_POST['pedal'];
    $lymphadeno = $_POST['lymphadeno'];
    $respiratory = $_POST['respiratory'];
    $temperature = $_POST['temperature'];
    $card = $_POST['card'];
    $respirat = $_POST['respirat'];
    $abdomen = $_POST['abdomen'];
    $central = $_POST['central'];
    $right = $_POST['right1'];
    $left = $_POST['left1'];
    $soft = $_POST['soft'];
    $discharge = $_POST['discharge'];
    $neurova = $_POST['neurova'];
    $other = $_POST['other'];
    $fracture = $_POST['fracture'];
    $open = $_POST['open'];
    $non = $_POST['non'];
    $fina = $_POST['fina'];
    $initial = $_POST['initial'];
    $planned = $_POST['planned'];
    $post = $_POST['post'];

    // Database connection parameters


    // Insert data into the database
    $sql = "INSERT INTO addpatient3 
            VALUES ('$id','$appearance', '$pallor', '$cyanosis', '$treatment', '$family', '$built', '$icterus', '$clubbing', '$pulse', '$bp', '$pedal', '$lymphadeno', '$respiratory', '$temperature', '$card', '$respirat', '$abdomen', '$central', '$right', '$left', '$soft', '$discharge', '$neurova', '$other', '$fracture', '$open', '$non', '$fina', '$initial', '$planned', '$post')";

    if ($conn->query($sql) === TRUE) {
        $response = array("status" => "success", "message" => "Data inserted successfully");
        echo json_encode($response);
    } else {
        $response = array("status" => "error", "message" => "Error: " . $conn->error);
        echo json_encode($response);
    }

    // Close connection
    $conn->close();

} else {
    $response = array("status" => "error", "message" => "Required parameters are missing");
    echo json_encode($response);
}
?>
