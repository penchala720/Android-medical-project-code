<?php
require("conn.php");

// Check if the required parameters are set
if (isset($_POST['id']) ) {

  

    // Prepare the SQL statement to insert data into your table
    $sql = "INSERT INTO  addpatient2
            VALUES ('".$_POST['id']."', '".$_POST['c1']."', '".$_POST['c2']."', '".$_POST['c3']."', '".$_POST['c4']."', 
                    '".$_POST['c5']."', '".$_POST['c6']."', '".$_POST['c7']."', '".$_POST['c8']."', 
                    '".$_POST['c9']."', '".$_POST['c10']."','".$_POST['c11']."', '".$_POST['c12']."', '".$_POST['c13']."', '".$_POST['c14']."', '".$_POST['c15']."', 
                    '".$_POST['c16']."', '".$_POST['c17']."', '".$_POST['c18']."', '".$_POST['c19']."', 
                    '".$_POST['c20']."', '".$_POST['c21']."','".$_POST['c22']."', '".$_POST['c23']."', '".$_POST['c24']."', '".$_POST['c25']."', '".$_POST['c26']."', 
                    '".$_POST['c27']."', '".$_POST['c28']."', '".$_POST['c29']."', '".$_POST['c30']."', 
                    '".$_POST['c31']."', '".$_POST['c32']."' ,   '".$_POST['c33']."' ,  '".$_POST['c34']."' ,  '".$_POST['c35']."' ,  '".$_POST['c36']."' , 
                    '".$_POST['c37']."' ,  '".$_POST['c38']."' ,   '".$_POST['c39']."' ,   '".$_POST['text']."'                                         
                    
                    )  ";

    // Execute the SQL statement
    if ($conn->query($sql) === TRUE) {
        // Data inserted successfully
        $response = array("success" => true, "message" => "Data stored successfully");
        echo json_encode($response);
    } else {
        // Error occurred during insertion
        $response = array("success" => false, "message" => "Error: " . $conn->error);
        echo json_encode($response);
    }

    // Close the database connection
    $conn->close();

} else {
    // Required parameters are not set
    $response = array("success" => false, "message" => "Required parameters are missing");
    echo json_encode($response);
}
?>
