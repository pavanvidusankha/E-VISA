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
	
	#button {
    border: none;
    color: white;
    padding: 10px 28px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
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

			<form method="POST" action="LogOut">

            <tr>
            	<td></td>
                <td><input  style="background:none;border:none;margin:0;padding:0;color: white;font-size: 28px" type="submit" value="Log out" ></td>
            </tr>
            
            </form>

        </table>

    </div>
    
    <div style="margin-top: -968px;margin-left: 530px;position: absolute;width: 300px">
    
    	<a href="adminmain.jsp" id="link_line"><p><font face="verdana" color="white">eVISA SRI LANKA</font></p></a>
    
    </div>
    
    <img src="add.png" style="position: absolute;left: 0px;top: 0px;z-index: -1;margin-top: 100px;margin-left: 35px;border-radius: 10px" width="1280px" height="820px">
    
    <div id="mySidenav" class="sidenav">

        <div style="padding-left: 50px">
        <input type="image" src="${sessionScope.username }.jpg" width="100px" style="border-radius: 100%">
        </div>

        <br><br><br>

  		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="admin.jsp">Admin page</a>
        <a href="adminprofile.jsp">Update Password</a>
        <a href="checkapplyvisa.jsp">Check Applied Visa</a>
        <a href="adminviewpayment.jsp">View Payments</a>
        <a href="adminextendvisa.jsp">Check Extend VISA Appeals</a>
        <a href="adminpageusers.jsp">Users Management</a>
        <a href="adminspage.jsp">Admins Management</a>
        <a href="adminviewmsg.jsp">View Messages</a>
        <a href="adminchargers.jsp">Update VISA Charges</a>
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

	<h1 style="margin-left: 500px;font-size: 50px;margin-top: 0px;color: white">Contact Us.</h1>
	
	<div style="position: absolute;margin-top: 50px;margin-left: 680px">
		
		<form method="POST" action="GetMassage" onsubmit="return checkForm(this);">
		
		<table style="width: 650px;height: 550px">
			<tr>
				<td><p style="font-size: 30px;color: white">Name :</p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Enter your name" type="text" required pattern="\w+" name="name"></td>
			</tr>
			
			<tr>
				<td><p style="font-size: 30px;color: white">Mail : </p></td>
				<td><input style="width: 350px;height: 50px;border-radius: 5px;font-size: 25px" title="Enter a mail" type="mail" name="mail"></td>
			</tr>
			
			<tr>
				<td style="vertical-align: top"><p style="font-size: 30px;color: white">Message : </p></td>
				<td><textarea style="width: 350px;height: 200px;border-radius: 5px;font-size: 25px" title="Your Massage" name="msg" rows="4" cols="50" name="massage" ></textarea></td>
			</tr>
			
		</table>
		
		<br>
		
			<p style="margin-left: 183px"><input id="button" style="background-color: #008CBA" type="submit" value="Send" ></p>
		
		</form>
		
	</div>
		
	<div class="vl" ></div>
	
	<div style="position: absolute;margin-top: -610px;margin-left: 80px">
	
	<table style="width: 650px;height: 350px">
		<tr>
			<td><p style="font-size: 25px;color: white">Website :</p></td>
			<td><p style="font-size: 25px;color: white">eVISASRILANKA.lk</p></td>
		</tr>
		
		<tr>
			<td><p style="font-size: 25px;color: white">phn :</p></td>
			<td><p style="font-size: 25px;color: white">+94 71 11 444 11</p>
			<p style="font-size: 25px;color: white">+94 77 11 444 11</p></td>
		</tr>
		
		<tr>
			<td><p style="font-size: 25px;color: white">Mail :</p></td>
			<td><p style="font-size: 25px;color: white">contact@eVISASRILANKA.lk</p></td>
		</tr>
	
	</div>
	
	
	<div style="position: absolute;margin-top: -70px;margin-left: 80px">
		<p style="margin-left: 255px;font-size: 23px;color:white;width:900px">Please send your ideas to improve our service</p>
	</div>

</body>
</html>