<?php
if($_POST['formSubmit'] == "Find Study Partners")
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
	$varLocationOn = $_POST['location1'];
	$varLocationOff = $_POST['location2'];
	$varMonTime = $_POST['MonTime'];
	$varTueTime = $_POST['TueTime'];
	$varWedTime = $_POST['WedTime'];
	$varThuTime = $_POST['ThuTime'];
	$varFriTime = $_POST['FriTime'];

	if(empty($errorMessage)) 
	{
		$fs = fopen("data/mydata.csv","a");
		fwrite($fs, $varName 		. ", " . $varMajor 			. ", " . 
					$varSchool 		. ", " . $varEmail 			. ", " . 
					$varPhone 		. ", " . $varLang 			. ", " . 
					$varClass 		. ", " . $varNumPartn 		. ", " . 
					$varLocationOn 	. ", " . $varLocationOff 	. ", " .
					$varMonTime 	. ", " . $varTueTime 	. ", " .
					$varWedTime 	. ", " . $varThuTime 	. ", " .
					$varFriTime 	. "\n");
		fclose($fs);
		
		header("Location: recommendations.html");
		exit;
	}
}
?>

<html>
	<head>
		<title>Study Together</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	
	<body class="homepage">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header">
					<!-- Inner -->
					<div class="inner">
						<form action="form.php" method="post" style="width:inherit">
								
								<div class="col2">
								    <input type="text" name="name" placeholder="Name" value="<?=$varName;?>"/>
								    <input type="text" name="major" placeholder="Major" value="<?=$varMajor;?>"/>
								    <input type="text" name="school" placeholder="School" value="<?=$varSchool;?>"/>
								    <input type="text" name="email" placeholder="Email" value="<?=$varEmail;?>"/>
								    <input type="text" name="phone" placeholder="Phone Number" value="<?=$varPhone;?>"/>
								    
								</div>
								
								<div class="col1">
									<input type="text" name="language" placeholder="Language" value="<?=$varLang;?>"/>
								    <input type="text" name="class" placeholder="Desired Class" value="<?=$varClass;?>"/>
								    <input type="text" name="numPartner" placeholder="Max Partners" value="<?=$varNumPartn;?>"/>
								    Location Preference:<br>
								    <input type="checkbox" name="location1" value="On"> On Campus<br>
									<input type="checkbox" name="location2" value="Off"> Off Campus
								</div>
								<div class="footer" style="background-color: rgba(255, 255, 255, 0.5);">
									<table style="text-align: center;">
										<tbody>
										<tr>
										<td>Monday</td>
										<td>Tuesday</td>
										<td>Wednesday</td>
										<td>Thursday</td>
										<td>Friday</td>
										</tr>
										<tr>
										<td>
											<select name="MonTime">
											  <option value="morning">Morning</option>
											  <option value="afternoon">Afternoon</option>
											  <option value="evening">Evening</option>
											  <option value="none">Can't This Day</option>
											</select>
										</td>
										<td>
											<select name="TueTime">
											  <option value="morning">Morning</option>
											  <option value="afternoon">Afternoon</option>
											  <option value="evening">Evening</option>
											  <option value="none">Can't This Day</option>
											</select>
										</td>
										<td>
											<select name="WedTime">
											  <option value="morning">Morning</option>
											  <option value="afternoon">Afternoon</option>
											  <option value="evening">Evening</option>
											  <option value="none">Can't This Day</option>
											</select>
										</td>
										<td>
											<select name="ThuTime">
											  <option value="morning">Morning</option>
											  <option value="afternoon">Afternoon</option>
											  <option value="evening">Evening</option>
											  <option value="none">Can't This Day</option>
											</select>
										</td>
										<td>
											<select name="FriTime">
											  <option value="morning">Morning</option>
											  <option value="afternoon">Afternoon</option>
											  <option value="evening">Evening</option>
											  <option value="none">Can't This Day</option>
											</select>
										</td>
										</tr>
										</tbody>
										</table>
								</div>
								
								<div class="footer">
									<input type="submit" name="formSubmit" value="Find Study Partners" class="formbutton"/>
								</div>


							   
							</form>
					</div>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="index.html">Home</a></li>
								<li><a href="right-sidebar.html">Find Partners</a></li>
							</ul>
						</nav>

				</div>


			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<div class="12u">
								<!-- Copyright -->
									<div class="copyright">
										<ul class="menu">
											<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
										</ul>
									</div>

							</div>

						</div>
					</div>
				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.onvisible.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>