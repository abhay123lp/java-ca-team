<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking details</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    
 <script>

 publicHoliDays = [
            [1, 1, 'Newyear'], [2, 10, 'chinese new year'], [2, 11, 'Chinese new year'],
            [3, 29, 'GoodFriday'], [4, 21, 'LabourDay'], [4, 24, 'vesak day'],
            [8, 8, 'Har raya pusua'], [8,9,'National Day'], [15, 10, 'hari raya Haji'],
            [11, 3, 'Deepavali'], [12, 25, 'chirstmas Day']
            ];
    $(function() {
    	   $( "#bookedfrom" ).datepicker({
               defaultDate: "+1w",
               changeMonth: true,
               numberOfMonths: 1,
               beforeShowDay:checkForHolidays,
               onClose: function( selectedDate ) {
                   $("#bookedtill").datepicker( "option", "minDate", selectedDate );
               }
           });
        
        $( "#bookedtill" ).datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 1,
            beforeShowDay: checkForHolidays,
            onClose: function( selectedDate ) {
                $( "#bookedfrom" ).datepicker( "option", "maxDate", selectedDate );
            }
        });
    });
   
     
    function checkForHolidays(date)
    {
     var isHoliday=$.datepicker.noWeekends(date);
    		for (var i = 0; i < publicHoliDays.length; i++) {
    		      if (date.getMonth() == publicHoliDays[i][0] - 1
    		          && date.getDate() ==publicHoliDays[i][1]) {
    		        return [false,'']; 
    		      }
    		}
    		if(isHoliday[0])
    		      return[true,''];
    		else
    		      return[false,'weekend']; 
    }
   
    </script>
</head>
<body>
<form  id="BookingForm" method="post" action="book" name="book">
<table>
  <tr>
    <td>FacilityID:</td>
    <td><input type="text" name="facilityID" value="F000000001" readonly="readonly"></td>
  </tr>
  <tr>
    <td>UserID:</td>
    <td><input type="text" name="UserID" value="A000000002" readonly="readonly"></td>
   </tr>
   <tr>
  <td>
    <label for="bookedfrom">From date</label></td>
  <td>
    <input type="text" id="bookedfrom" name="from" />
  </td>
</tr>
<tr>
   <td>
     <label for="bookedtill">to</label></td>
   <td>
     <input type="text" id="bookedtill" name="to" /></td>
  </tr>
  <tr>
  <td><input type="radio" id="prior" name="prior" value="H">High</input></td>
  <td><input type="radio" id="prior" name="prior" value="M">Medium</input></td>
  <td><input type="radio" id="prior" name="prior" value="L">Low</input></td>
  </tr>
  <tr>
  <td>
 <label for="Reason">Reason:</label> 
 </td>
 <td>
    <textarea id="reason" name="reason" rows="4" cols="20">  </textarea>
    </td>
  </tr>
  <tr>
    <td><input type="submit" value="save"> <input
      type="reset" value="reset"> 
      <input type="submit" value="back">
   </td>
  </tr>
</table>
</form>
</body>
</html>