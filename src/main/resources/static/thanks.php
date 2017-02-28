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
							thanks
						</div>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="index.html">Home</a></li>
								<li><a href="form.php">Find Partners</a></li>
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
		
		<?php
			$errorMessage = "";
			
			$UserID = $_GET['userID'];
			$PartnerID = $_GET['partnerID'];
			$PartnerRating = $_GET['partnerRating'];
			
			if(empty($errorMessage)){
				//echo $PartnerRating;
				$fs = fopen("data/ratings.csv","a");
				fwrite($fs, $UserID . ", " . $PartnerID . ", " . 
							$PartnerRating . "\n");
				fclose($fs);
			}
			
			//header("Location: thanks.php?userID=&partnerID=&partnerRating=");
			exit;
		?>

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