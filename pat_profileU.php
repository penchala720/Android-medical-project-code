<?php
require("conn.php");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $json_data = file_get_contents("php://input");
    $data = json_decode($json_data, true);

    if ($data !== null) {

        $field1 = $data['field1'];
     
        $field3 = $data['field3'];
        $field5 = $data['field5'];
        $field6 = $data['field6'];
        $field7 = $data['field7'];
        $patient_id=$data['P_id'];
        $profile_image = $data['profile'];

        $q1 = "SELECT image FROM pprofile WHERE id='$patient_id'";
        $result1 = mysqli_query($conn, $q1);
        $oldImagePath = '';
        if ($row = mysqli_fetch_assoc($result1)) {
            $oldImagePath = $row['image'];
        }
        
        $imagePath = 'patient_profile/' . uniqid() . '.jpg';

        if (file_put_contents($imagePath, base64_decode($profile_image))) {
            if (!empty($oldImagePath) && file_exists($oldImagePath)) {
                unlink($oldImagePath);
            }
            $sql = "UPDATE plogin SET name ='$field1', age = '$field3', phno = '$field5', email = '$field6', qualification = '$field7', image='$imagePath' WHERE pid='$patient_id'";
            $stmt = mysqli_query($conn, $sql);
            
            echo json_encode(array("status"=> "success","message"=> "Data updated successfully"));
        } else {
            $response = array('message' => 'Failed to save profile image');
            echo json_encode($response);
        }
    } else {
        $response = array('message' => 'Invalid JSON data');
        echo json_encode($response);
    }
} else {
    $response = array('message' => 'Invalid request method');
    echo json_encode($response);
}
?>