<?php
require "new.php"; 
$status='20';
$setTemp=(int)$status;
$queryTemp="select status from light where sensors='thermostat';";
$result=mysqli_query($con,$queryTemp);
if(mysqli_num_rows($result)>0){
	$ct=mysqli_fetch_assoc($result);
        $cTemp=$ct["status"];
}
echo $cTemp;
?>