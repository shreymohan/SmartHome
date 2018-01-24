<?php
require "new.php";
$id=1;
//var_dump($_POST);
$status=$_POST["type"];

//echo $status;
$query="UPDATE light SET status='$status' WHERE sensors='light';";
mysqli_query($con,$query);
echo "Data Inserted";

	//echo "Insertion error".mysqli_error($con);
?>