function addUser() {

	var userId = $('#id').val();
	var userName = $('#name').val();
	var userMajor = $('#major').val();
	var userEmail = $('#email').val();
	var userClass = $('#class').val();
	var userPartNum = $('#numPartner').val();
	var userLocation1 = $('#location1').val();
	var userLocation2 = $('#location2').val();
	var userMonTime = $('#MonTime option:selected').val();
    var userTueTime = $('#TueTime option:selected').val();
    var userWedTime = $('#WedTime option:selected').val();
    var userThuTime = $('#ThuTime option:selected').val();
    var userFriTime = $('#FriTime option:selected').val();

    var info = userName+","+userMajor+","+userEmail+","+userClass+","+userPartNum+","+
                userLocation1+","+userLocation2+","+userMonTime +","+userTueTime+","+
                userWedTime+","+userThuTime+","+userFriTime;

	if (userId) {
		$.ajax(
				{
					type : "POST",
					url  : "/addUser/" + userId,
					data : {
						"info" : info
					},
					success : function(result) {
						window.location = "/recommendations.html"
					},
					error: function (jqXHR, exception) {
						alert("Failed to add the user. Please check the inputs." + jqXHR.textStatus);
					}
				});
	} else {
		alert("Invalid User Id");
	}
}