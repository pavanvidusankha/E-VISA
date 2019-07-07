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

    margin-top: -938px;
    position: absolute;
    margin-left: 1080px;
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
	
	#button {
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
	}
	
	legend { 
    display: block;
    padding-left: 2px;
    padding-right: 2px;
    border: none;
	}

</style>


</head>
<body>

	<img src="logo.png" style="margin-top: -10px;margin-left: -10px">
	
	<div class="div2">

        <table align="right" class="table1">

            <tr>
                <td><a href="login.jsp" id="link_line" ><b><font color="white">Log in</font></b></a></td>
                <td><a href="register.jsp" id="link_line" ><b><font color="white">Register</font></b></a></td>
            </tr>

        </table>

    </div>
    
    <div style="margin-top: -968px;margin-left: 530px;position: absolute;width: 300px">
    
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
        <input type="image" src="person.png" width="50px">
        </div>

        <br><br><br>

  		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#">User Profile</a>
        <a href="#">Apply Visa</a>
        <a href="#">View Apply Visa</a>
        <a href="#">Payments</a>
        <a href="#">Successful Visa & Extend Visa</a>
        <a href="#">Extend Visa</a>
    </div>
	
	<div style="margin-top: -830px;margin-left: -10px"><span style="font-size:30px;cursor:pointer;position: fixed;margin-top: -10px;" onclick="openNav()"><input type="image" src="scroll.jpg" width="30px"></span></div>

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
	
	<div >
	
		<img src="reg.png" style="margin-top: 0px;margin-left: 100px;border-radius: 10px" width="1100px" height="750px">
	
		<div style="position: absolute;margin-top: -750px;margin-left: 300px">
		
		<form method="POST" action="UserServlet" onsubmit="return checkForm(this);">
		
		<h1 style="margin-left: 220px;font-size: 50px">Register</h1>
		
		<table style="width: 850px;height: 500px">
			<tr>
				<td><p style="font-size: 30px">Name:</p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Enter your name" type="text" required pattern="\w+" name="name"></td>
			</tr>
			
			<tr>
				<td><p style="font-size: 30px">Username: </p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Enter a username" type="text" required pattern="\w+" name="username"></td>
			</tr>
			
			<tr>
				<td><p style="font-size: 30px">Password: </p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers" type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd1" onchange="
				  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
				  if(this.checkValidity()) form.pwd2.pattern = RegExp.escape(this.value);
				"></td>
			</tr>
			
			<tr>
				<td><p style="font-size: 30px">Confirm Password: </p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Please enter the same Password as above" type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd2" onchange="
				  this.setCustomValidity(this.validity.patternMismatch ? this.title : '');
				"></td>
			</tr>	
			
		</table>
		
		<br>
		
			<p style="margin-left: 250px"><input id="button" style="background-color: #008CBA" type="submit" value="Sign Up" ></p>
		
		</form>
		
		</div>
		
	</div>
	
</body>
</html>