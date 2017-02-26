<?php
if($_POST['formSubmit'] == "Submit")
{
	$errorMessage = "";
	
	$varName = $_POST['name'];
	$varMajor = $_POST['major'];
	$varSchool = $_POST['school'];
	$varEmail = $_POST['email'];
	$varPhone = $_POST['phone'];
	$varLang = $_POST['language'];
	$varClass = $_POST['class'];
	$varNumPartn = $_POST['numPartner'];
	$varLocation = $_POST['location'];

	if(empty($errorMessage)) 
	{
		$fs = fopen("data/mydata.csv","a");
		fwrite($fs, $varName . ", " . $varMajor . ", " . 
					$varSchool . ", " . $varEmail . ", " . 
					$varPhone . ", " . $varLang . ", " . 
					$varClass . ", " . $varNumPartn . ", " . 
					$varLocation . "\n");
		fclose($fs);
		
		//header("Location: thankyou.html");
		exit;
	}
}
?>

<html>
	<head>
	</head>
	<body class="homepage">
		
							<form action="form1.php" method="post">
							    <input type="text" name="name" placeholder="Name" value="<?=$varName;?>"/>
							    <input type="text" name="major" placeholder="Major" value="<?=$varMajor;?>"/>
							    <input type="text" name="school" placeholder="School" value="<?=$varSchool;?>"/>
							    <input type="text" name="email" placeholder="Email" value="<?=$varEmail;?>"/>
							    <input type="text" name="phone" placeholder="Phone Number" value="<?=$varPhone;?>"/>
							    <input type="text" name="language" placeholder="Language" value="<?=$varLang;?>"/>

							    <input type="text" name="class" placeholder="Desired Class" value="<?=$varClass;?>"/>
							    <input type="text" name="numPartner" placeholder="Max Partners" value="<?=$varNumPartn;?>"/>
							    <input type="text" name="location" placeholder="On/Off Campus" value="<?=$varLocation;?>"/>
							    <input type="submit" name="formSubmit" value="Submit" />

	</body>
</html>