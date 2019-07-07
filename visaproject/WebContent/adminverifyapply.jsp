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

    margin-top: -938px;
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
	
	
	<div style="margin-top: 10px;margin-left: 50px">
	
		<table class="table2" >
			<tr class="tr1">
				<th id="th1">Id</th>
				<th id="th1">First Name</th>
				<th id="th1">Last Name</th>
				<th id="th1">Passport ID</th>
				<th id="th1">Passport First Name</th>
				<th id="th1">Passport Last Name</th>
				<th id="th1">Passport Issue Date</th>
				<th id="th1">Passport Expiredate</th>
			</tr>
	
			
			<tr class="tr1">
				<td id="td1">${sessionScope.id }</td>
				<td id="td1">${sessionScope.fname }</td>
				<td id="td1">${sessionScope.lname }</td>
				<td id="td1">${sessionScope.passportid }</td>
				<td id="td1">${sessionScope.pfname }</td>
				<td id="td1">${sessionScope.plname }</td>
				<td id="td1">${sessionScope.Idate }</td>
				<td id="td1">${sessionScope.Exdate }</td>
			</tr>
			
		</table>
		
	</div>
	
	<div style="position: absolute;top: 630px;left: 300px">
	
		<form method="POST" action="AdminAction" onsubmit="return checkForm(this);" >
		
		
		
		<table style="width: 750px;height: 500px">
			<tr>
				<td><p style="font-size: 25px;color: white">Apply Id :</p></td>
				<td>
					<select name="id" style="width: 150px;height: 27px;border-radius: 5px;font-size: 18px">
					<option value="" selected="selected">Select Id</option> 
					
					<option value="${sessionScope.id }" >${sessionScope.id }</option> 
					</select><td>
			
				<td><td><p style="font-size: 25px;color: white">Action :</p></td>
				<td><select name="action" style="width: 150px;height: 27px;border-radius: 5px;font-size: 18px">
					<option value="" selected="selected">Select Action</option>
					<option value="0" >Verify</option>
					<option value="2" >Reject</option>
					<option value="3" >Delete</option> </select></td>
			
			
			<td><p><input id="button" style="background-color: #008CBA" type="submit" value="Confirm" ></p></td>
			
			</tr>	
			
		</table>
		
		
		</form>
	
	
	</div>
	
	<div style="position: absolute;margin-top: 312px;margin-left: -60px">
		<p style="margin-left: 255px;font-size: 28px;color:white;width:900px" ALIGN=CENTER>${sessionScope.passport }</p>
	</div>
	
	<% session.removeAttribute("passport"); %>
	
</body>
</html>