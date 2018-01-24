<?php
require "new.php";
$id=1;

$status=$_POST["setTemp"];

$setTemp=(int)$status;
$queryTemp="select status from light where sensors='thermostat';";
$result=mysqli_query($con,$queryTemp);
if(mysqli_num_rows($result)>0){
	$ct=mysqli_fetch_assoc($result);
        $cTemp=$ct["status"];
}
$curTemp=(int)$cTemp;

if($setTemp>$curTemp){
while($setTemp!=$curTemp){
$cT=(string)$curTemp;
$query="UPDATE light SET status='$cT' WHERE sensors='thermostat';";
mysqli_query($con,$query);
$curTemp++;
sleep(5);
  
if($setTemp==$curTemp){

$cT=(string)$curTemp;
$query="UPDATE light SET status='$cT' WHERE sensors='thermostat';";
mysqli_query($con,$query);

}
echo $curTemp;
}
}
if($setTemp<$curTemp){
while($setTemp!=$curTemp){
$cTemp=(string)$curTemp;
$query="UPDATE light SET status='$cTemp' WHERE sensors='thermostat';";
mysqli_query($con,$query);
$curTemp--;
sleep(5);
if($setTemp==$curTemp){
$cT=(string)$curTemp;
$query="UPDATE light SET status='$cTemp' WHERE sensors='thermostat';";
mysqli_query($con,$query);
}
echo $curTemp;
}
}

?>
