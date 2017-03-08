//run recommendations program

    //print Basic Recommender table
    $.get('data/BRrecommendations.csv', function(data) {
      var html = '<table class="table table-bordered">';
      var rows = data.split("\n");
        html += "<tr>";
        html += "<td>Name</td>";
        html += "<td>Major</td>";
        html += "<td>On Campus</td>";
        html += "<td>Off Campus</td>";
        html += "<td>Monday</td>";
        html += "<td>Tuesday</td>";
        html += "<td>Wednesday</td>";
        html += "<td>Thursday</td>";
        html += "<td>Friday</td>";
        html += "<td>Similarity</td>";
        html += "</tr>";
      rows.forEach(function getvalues(ourrow) {
        html += "<tr>";
        var columns = ourrow.split(",");
        html += "<td>" + columns[0] + "</td>";
        html += "<td>" + columns[1] + "</td>";
        html += "<td>" + columns[8] + "</td>";
        html += "<td>" + columns[9] + "</td>";
        html += "<td>" + columns[10] + "</td>";
        html += "<td>" + columns[11] + "</td>";
        html += "<td>" + columns[12] + "</td>";
        html += "<td>" + columns[13] + "</td>";
        html += "<td>" + columns[14] + "</td>";
        html += "<td>" + columns[15] + "</td>";
        html += "<td><button id='popup' onclick='div_show()' class='otherButton'>Contact</button></td>";
        html += "</tr>";
      })
      html += "</table>";
      $('#myTable').append(html);
    });

  //print CF table
    $.get('data/CFrecommendations.csv', function(data) {
      var html = '<table class="table table-bordered">';
      var rows = data.split("\n");
        html += "<tr>";
        html += "<td>Name</td>";
        html += "<td>Major</td>";
        html += "<td>On Campus</td>";
        html += "<td>Off Campus</td>";
        html += "<td>Monday</td>";
        html += "<td>Tuesday</td>";
        html += "<td>Wednesday</td>";
        html += "<td>Thursday</td>";
        html += "<td>Friday</td>";
        html += "<td>Rating</td>";
        html += "</tr>";
      rows.forEach(function getvalues(ourrow) {
        html += "<tr>";
        var columns = ourrow.split(",");
        html += "<td>" + columns[0] + "</td>";
        html += "<td>" + columns[1] + "</td>";
        html += "<td>" + columns[8] + "</td>";
        html += "<td>" + columns[9] + "</td>";
        html += "<td>" + columns[10] + "</td>";
        html += "<td>" + columns[11] + "</td>";
        html += "<td>" + columns[12] + "</td>";
        html += "<td>" + columns[13] + "</td>";
        html += "<td>" + columns[14] + "</td>";
        html += "<td>" + columns[16] + "</td>";
        html += "<td><button id='myBtn'>Rate</button></td>";
        html += "</tr>";
      })
      html += "</table>";
      $('#myCFTable').append(html);
    });

    $(document).ready(function(){
    //  Check Radio-box
        $(".rating input:radio").attr("checked", false);
        $('.rating input').click(function () {
            $(".rating ").removeClass('checked');
            $(this).parent().addClass('checked');
        });

        $('input:radio').change(
        function(){
            var partnerRating = this.value;
        });

      var a = document.getElementsByClassName('otherButton');
      for (var i = 0; i<a.length;i++) {
        a[i].addEventListener('click',function(){
         var b = this.parentNode.parentNode.cells[0].textContent;
        alert(b);
        });
      }

      var ratingInfo = userId + "," + partnerId + "," + partnerRating;

        $('#rate').click(function click(){
          $.ajax(
        {
          type : "POST",
          url  : "/addRating/" + ratingInfo,
          data : {
          },
          success : function(result) {
            window.location = "/index.html"
          },
          error: function (jqXHR, exception) {
            alert("Failed to add ratings. Please check the inputs. " + jqXHR.textStatus);
          }
        });

        return false;
      });
    });