<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	body{
		
		background: url('background.jpg');
		background-repeat: no-repeat;
		font-family: "Lato", sans-serif;
		
	}
	
	div.div2{

    margin-top: -625px;
    position: absolute;
    margin-left: 1200px;
	}
	
	table.table1{

    width: 300px;
    align: right;

	}
	
	#link_line{

    text-decoration: none;
    font-size: 28px;

	}
	
	.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
	}
	
	.sidenav a {
	    padding: 8px 8px 8px 32px;
	    text-decoration: none;
	    font-size: 25px;
	    color: #818181;
	    display: block;
	    transition: 0.3s;
	}
	
	.sidenav a:hover {
	    color: #f1f1f1;
	}
	
	.sidenav .closebtn {
	    position: absolute;
	    top: 0;
	    right: 25px;
	    font-size: 36px;
	    margin-left: 50px;
	}
	
	@media screen and (max-height: 450px) {
	  .sidenav {padding-top: 15px;}
	  .sidenav a {font-size: 18px;}
	}
	
	a.one:link {
    color: #ffffff;
	}
	
	/* visited link */
	a.one:visited {
	    color: #ffffff;
	}
	
	/* mouse over link */
	a.one:hover {
	    color: black;
	}
	
	/* selected link */
	a.one:active {
	    color: #ffffff;
	}


</style>


</head>
<body>

	<img src="logo.png" style="margin-top: -10px;margin-left: -10px">
	
	<img src="1.png" style="margin-top: -960px;margin-left: -10px">
	
	<div style="margin-top: -850px;margin-left: 300px">
	  <img style="border-radius: 10px" class="mySlides" src="2.jpg">
	  <img style="border-radius: 10px" class="mySlides" src="3.jpg" >
	  <img style="border-radius: 10px" class="mySlides" src="4.jpg">
	</div>
	
	<div class="div2">

        <table align="right" class="table1">

			<form method="POST" action="LogOut">

            <tr>
            	<td></td>
                <td><input  style="background:none;border:none;margin:0;padding:0;color: white;font-size: 28px" type="submit" value="Log out" ></td>
            </tr>
            
            </form>

        </table>

    </div>
    
    <div style="margin-top: -655px;margin-left: 530px;position: absolute;width: 300px">
    
    	<a href="main.jsp" id="link_line"><p><font face="verdana" color="white">eVISA SRI LANKA</font></p></a>
    
    </div>
	
	<script>
	var myIndex = 0;
	carousel();
	
	function carousel() {
	    var i;
	    var x = document.getElementsByClassName("mySlides");
	    for (i = 0; i < x.length; i++) {
	       x[i].style.display = "none";  
	    }
	    myIndex++;
	    if (myIndex > x.length) {myIndex = 1}    
	    x[myIndex-1].style.display = "block";  
	    setTimeout(carousel, 4000); // Change image every 2 seconds
	}
	</script>
	
	<div id="mySidenav" class="sidenav">

        <div style="padding-left: 50px">
        <input type="image" src="${sessionScope.username }.jpg" width="100px" style="border-radius: 100%">
        </div>

        <br><br><br>

  		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="userprofile.jsp">Change Password</a>
        <a href="applyvisa.jsp">Apply Visa</a>
        <a href="viewapplyvisa.jsp">View Applied VISA</a>
        <a href="userpayment.jsp">Pay & Get VISA</a>
        <a href="successfulappy&extendvisa.jsp">Extend VISA</a>
        <a href="extend.jsp">Pay for Extend VISA</a>
    </div>
	
	<div style="margin-top: -530px;margin-left: -10px"><span style="font-size:30px;cursor:pointer;position: fixed;margin-top: -10px;" onclick="openNav()"><input type="image" src="scroll.jpg" width="30px"></span></div>

	<script>
		function openNav() {
		
		if(document.getElementById("mySidenav").style.display == "none")
		{
			document.getElementById("mySidenav").style.display = "";
		}
		
	    document.getElementById("mySidenav").style.width = "250px";
		}
	
		function closeNav() {
			document.getElementById("mySidenav").style.display = "none";
			
			
		}
	</script>
	
	<div style="margin-top: 110px;margin-left:60px" >
	
		<table  style="height: 200px;width:220px">
				<tr><td><a style="text-decoration: none;font-size: 22px" class="one" href="userwatch.jsp">Watch</a></td></tr>
		        <tr><td><a style="text-decoration: none;font-size: 22px" class="one" href="usercalendar.jsp">Calendar</a></td></tr>
		        <tr><td><a style="text-decoration: none;font-size: 22px" class="one" href="usercalculate.jsp">Calculate Visa Charge</a></td></tr>
		        <tr><td><a style="text-decoration: none;font-size: 22px" class="one" href="usercontactus.jsp">Contact Us</a></td></tr>
		</table>
    </div>
	
	<p style="margin-left: 335px;font-size: 30px;margin-top: 240px;width:900px" ALIGN=CENTER>
	Welcome to the eVISA Sri lanka<br></p>
<p style="margin-left: 335px;font-size: 27px;margin-top: -20px;width:900px" ALIGN=CENTER>The Official Site of Online VISA System of the Democratic Socialist Republic of Sri Lanka.
This site helps you to provide a official VISA to travel  to Sri lanka
An eligable Passport is valid to Get your VISA ,otherwise it will be rejected.
Also You can Extend your VISA 
Site Hosted & Maintained by Department of Immigration & Emigration, Colombo, Sri Lanka. 
For more information, </p><br><p style="margin-left: 335px;font-size: 18px;margin-top: -40px;width:900px" ALIGN=CENTER>visit <a href="">http://www.immigration.gov.lk</a>
All rights reserved.</p>
	
</body>
</html>