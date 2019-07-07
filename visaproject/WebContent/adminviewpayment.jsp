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
	text-align: center;
	}
	
	#td1, #th1 {
	    border: 1px solid black;
	    text-align: center;
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
	
	
	
	<div style="margin-top: 5px;margin-left: 53px">
	
		<table class="table2" >
			<tr class="tr1">
				<th id="th1">Id</th>
				<th id="th1">Username</th>
				<th id="th1">Country</th>
				<th id="th1">Visa Type</th>
				<th id="th1">Days</th>
				<th id="th1">Total Amount</th>
				<th id="th1">Visa Issue Date</th>
				<th id="th1">Visa Expire Date</th>
			</tr>
	
			<%
				AdminPayments admin = new AdminPayments();
				ArrayList<Payment> arrayList = admin.getPayments();
	
				for (Payment payment : arrayList) {
			%>
			<tr class="tr1">
				<td id="td1"><%=payment.getId() %></td>
				<td id="td1"><%=payment.getUser() %></td>
				<td id="td1"><%=payment.getCountry() %></td>
				<td id="td1"><%=payment.getVvtype() %></td>
				<td id="td1"><%=payment.getDays() %></td>
				<td id="td1"><%=payment.getCtotal() %></td>
				<td id="td1"><%=payment.getIvisa() %></td>
				<td id="td1"><%=payment.getExvisa() %></td>
			</tr>
			<%
				}
			%>
		</table>
		
	</div>
	
	

</body>
</html>