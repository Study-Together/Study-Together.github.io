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
							<p>The System Recommends The Following Classmates:</p>
							<div class="container.\31" style="background-color: rgba(255, 255, 255, 0.5); border-radius: 10px; text-align: left; padding-left: 10px;">
								<!-- <p><strong>Name Name</strong></p> -->
								
								<?php
									
								echo "<table>\n\n";
								$f = fopen("/Users/Nada/Desktop/W17/CS 599 Information Retrieval/Project/Study-Together.github.io/data/recommendations.csv", "r");
								while (($line = fgetcsv($f)) !== false) {
								        echo "<tr>";
								        foreach ($line as $cell) {
								            echo "<td>" . htmlspecialchars($cell) . "</td>";
								        }
								        echo "<td><input type='submit' name='contact' value='contact'></td>" ;
								        echo "</tr>\n";
								}
								fclose($f);
								echo "\n</table>";
								?>
								
							</div>
							
							
							
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