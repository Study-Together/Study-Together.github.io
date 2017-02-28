<?php
	$errorMessage = "";
	
	$userID = $_GET['userID'];
	$userName = $_GET['userName'];
	$class = $_GET['class'];

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
						<p>Please confirm the information if correct  </p>
							<div class="container.\31" style="background-color: rgba(255, 255, 255, 0.5); border-radius: 20px; text-align: left; padding-left: 10px;">
							
														
							Name <?php echo $userName; ?>
							<br>
							ID <?php echo $userID; ?>
							<br>
							class <?php echo $class; ?>
							<br>
							</div>
							
							<footer>
								<a href="#" class="button circled scrolly">Confirm</a>
							</footer>
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