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
							<form action="form.php" method="post" style="width: 100%">
								
								<div class="innerleft">
								    <input type="text" name="name" placeholder="Name" value="<?=$varName;?>"/>
								    <input type="text" name="major" placeholder="Major" value="<?=$varMajor;?>"/>
								    <input type="text" name="school" placeholder="School" value="<?=$varSchool;?>"/>
								    <input type="text" name="email" placeholder="Email" value="<?=$varEmail;?>"/>
								    <input type="text" name="phone" placeholder="Phone Number" value="<?=$varPhone;?>"/>
								    <input type="text" name="language" placeholder="Language" value="<?=$varLang;?>"/>
								</div>
								
								<div class="innerright">
								    <input type="text" name="class" placeholder="Desired Class" value="<?=$varClass;?>"/>
								    <input type="text" name="numPartner" placeholder="Max Partners" value="<?=$varNumPartn;?>"/>
								    <input type="text" name="location" placeholder="On/Off Campus" value="<?=$varLocation;?>"/>
								</div>
								<hr>
							    <input type="submit" name="formSubmit" value="Submit" />
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