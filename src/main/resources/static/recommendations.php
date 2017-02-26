<html>
	<head>
		<title>Study Together</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link href="testpopup/elements.css" rel="stylesheet">
		<script src="testpopup/my_js.js"></script>
		
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		//  Check Radio-box
		    $(".rating input:radio").attr("checked", false);
		    $('.rating input').click(function () {
		        $(".rating ").removeClass('checked');
		        $(this).parent().addClass('checked');
		    });
		
		    $('input:radio').change(
		    function(){
		        var userRating = this.value;
		        //alert(userRating);
		    }); 
		});
		</script>
	</head>
	<body class="homepage">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header" >

					<!-- Inner -->
						<div class="inner" >
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
								        echo "<td><button id='popup' onclick='div_show()'>Contact</button></td>" ;
								        echo "</tr>\n";
								}
								fclose($f);
								echo "\n</table>";
								?>
								
							</div>
							
							<div id="abc">
								<!-- Popup Div Starts Here -->
								<div id="popupContact">
									<!-- Contact Us Form -->
									<form action="#" id="form" method="post" name="form">
										<img id="close" src="images/close.png" onclick ="div_hide()">
										<h3>Rate Partner</h3>
										<fieldset class="rating">
										    <input type="radio" id="star5" name="rating" value="5" />
										    	<label class = "full" for="star5" title="Awesome - 5 stars"></label>
										    <input type="radio" id="star4half" name="rating" value="4 and a half" />
										    	<label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
										    <input type="radio" id="star4" name="rating" value="4" />
										    	<label class = "full" for="star4" title="Pretty good - 4 stars"></label>
										    <input type="radio" id="star3half" name="rating" value="3 and a half" />
										    	<label class="half" for="star3half" title="Meh - 3.5 stars"></label>
										    <input type="radio" id="star3" name="rating" value="3" />
										    	<label class = "full" for="star3" title="Meh - 3 stars"></label>
										    <input type="radio" id="star2half" name="rating" value="2 and a half" />
										    	<label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
										    <input type="radio" id="star2" name="rating" value="2" />
										    	<label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
										    <input type="radio" id="star1half" name="rating" value="1 and a half" />
										    	<label class="half" for="star1half" title="Meh - 1.5 stars"></label>
										    <input type="radio" id="star1" name="rating" value="1" />
										    	<label class = "full" for="star1" title="Sucks big time - 1 star"></label>
										    <input type="radio" id="starhalf" name="rating" value="half" />
										    	<label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
										</fieldset>
										
										<button id='rate' onclick='rate()'>Rate</button>
									</form>
								</div>
							<!-- Popup Div Ends Here -->
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