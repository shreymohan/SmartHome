<?php
require "new.php";

$query="select status from light where sensors ='thermostat';";

$result=mysqli_query($con,$query);

if(mysqli_num_rows($result)>0){
	$row=mysqli_fetch_assoc($result);
        $name=$row["status"];
        echo $name;
}

else
echo "connection failed";
?>