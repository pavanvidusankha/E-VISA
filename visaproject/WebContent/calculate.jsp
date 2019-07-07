<%@page import="visa.service.*"%>
<%@page import="visa.model.*"%>
<%@page import="java.util.ArrayList"%>


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

    margin-top: -940px;
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
    padding: 20px 35px;
    text-align: center;
    text-decoration: none;
    font-size: 25px;
    margin: 4px 2px;
    cursor: pointer;
    
	}
	
	legend { 
    display: block;
    padding-left: 2px;
    padding-right: 2px;
    border: none;
	}
	
	table.table2 {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 1235px;
    background-color: white;
	}
	
	#td1, #th1 {
	    border: 1px solid black;
	    text-align: left;
	    padding: 8px;
	    width:20;
	}
	
	tr.tr1:nth-child(even) {
	    background-color: #dddddd;
	}
	
	h1
{
	margin:0px;
	margin-top:40px;
	color:#8181F7;
	font-size:45px;
}
#date
{
	margin-top:70px;
	color:White;
	font-size:100px;
	padding:10px;
	width:800px;
	margin-left:200px;
}
#time
{
	margin-top:20px;
	font-size:250px;
	color:White;
	padding:10px;
	width:1000px;
	margin-left:150px;
}

.vl {
    border-left: 1px solid white;
    height: 600px;
    margin-top: 80px;
    margin-left: 640px;
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
    
    <img src="add.png" style="position: absolute;left: 0px;top: 0px;z-index: -1;margin-top: 100px;margin-left: 35px;border-radius: 10px" width="1280px" height="820px">
    
    <div id="mySidenav" class="sidenav">

        <div style="padding-left: 50px">
        <input type="image" src="person.png" width="50px">
        </div>

        <br><br><br>

  		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#">Change Password</a>
        <a href="#">Apply Visa</a>
        <a href="#">View Applied VISA</a>
        <a href="#">Pay & Get VISA</a>
        <a href="#">Extend VISA</a>
        <a href="#">Pay for Extend VISA</a>
    </div>
	
	<div style="margin-top: -840px;margin-left: -10px"><span style="font-size:30px;cursor:pointer;position: fixed;margin-top: -10px;" onclick="openNav()"><input type="image" src="scroll.jpg" width="30px"></span></div>

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

	<h1 style="margin-left: 390px;font-size: 50px;margin-top: 10px;color: white">Calculate Visa Charge</h1>
	
	<div style="position: absolute;top: 50px;left: 270px">
	
		<form method="POST" action="Calculate" onsubmit="return checkForm(this);" >
		
		
		
		<table style="width: 950px;height: 500px">
			<tr>
				<td><p style="font-size: 30px;color: white">Days :</p></td>
				<td><input type="number" style="width: 100px;height: 32px;border-radius: 5px;font-size: 28px" name="days"><td>
			
				<td><td><p style="font-size: 30px;color: white">Visa Type :</p></td>
				<td><select name="vtype" style="width: 200px;height: 32px;border-radius: 5px;font-size: 28px">
					<option value="" selected="selected">Select Action</option>
					<option value="1" >Tourist</option>
					<option value="2" >Business</option>
					<option value="3" >Economic</option> </select></td>
			
			
			<td><p><br><br><br><br><br><br><br><br><br><br><input id="button" style="background-color: #008CBA;margin-left: -610px;" type="submit" value="Calculate" ></p></td>
			
			</tr>	
			
		</table>
		
		
		</form>
		
		
		<div style="margin-top: -90px;margin-left: 25px;background-color: white;width:750px;height: 300px;border-radius: 10px">
			
			<p style="padding: 20px;margin-left: 200px;font-size: 50px;color:black">Total Amount</p>
			<p align="center" style="margin-top: -20px;font-size: 80px;color:black">${sessionScope.calculatetotal }</p>
		
		</div>
	
	
	</div>
	
</body>
</html>