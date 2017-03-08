function addUser() {

	var userName = $('#name').val();
	var userMajor = $('#major').val();
	var userSchool = $('#school').val();
	var userEmail = $('#email').val();
	var userPhone = $('#phone').val();
	var userLanguage = $('#language').val();
	var userClass = $('#class').val();
	var userPartNum = $('#numPartner').val();
	var userLocation1 = $('#location1').val();
	var userLocation2 = $('#location2').val();
	var userMonTime = $('#MonTime option:selected').val();
    var userTueTime = $('#TueTime option:selected').val();
    var userWedTime = $('#WedTime option:selected').val();
    var userThuTime = $('#ThuTime option:selected').val();
    var userFriTime = $('#FriTime option:selected').val();

    var userInfo = userName+","+userMajor+","+userSchool+","+userEmail+","+userPhone+","+","+
                   userLanguage+","+userClass+","+userPartNum+","+ userLocation1+","+userLocation2+","+
                   userMonTime +","+ userTueTime+","+ userWedTime+","+userThuTime+","+userFriTime+",0";

    var myUrl = "/addUser/" + userInfo;
    //alert(myUrl);

	if (userName) {
		$.ajax(
				{
					type : "POST",
					url  : myUrl,
					data : {
					},
					success : function(result) {
						window.location = "/recommendations.html"
					},
					error: function (jqXHR, exception) {
					    window.location.href = "/recommendations.html"
						//alert("Failed to add the user. Please check the inputs. " + jqXHR.textStatus);
					}
				});
	} else {
		alert("Invalid User Id");
	}
};