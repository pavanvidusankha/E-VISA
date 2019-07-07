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
    position: absolute;
    z-index: 1;
    top: 0;
    left: 0;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
    margin-top: 450px;
    margin-left: 530px;
	}
	
	.sidenav a {
	    padding: 8px 8px 8px 32px;
	    text-decoration: none;
	    font-size: 25px;
	    color: #FFFFFF;
	    display: block;
	    transition: 0.3s;
	}
	
	.sidenav a:hover {
	    color: #754C72;
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
    
    	<a href="usermain.jsp" id="link_line"><p><font face="verdana" color="white">eVISA SRI LANKA</font></p></a>
    
    </div>
    
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
	
	<img src="add.png" style="margin-top: -855px;margin-left: 35px;border-radius: 10px" width="1280px" height="820px">
    
    <img src="${sessionScope.username }.jpg" style="margin-top: -780px;margin-left: 530px;border-radius: 100%">

	<div id="mySidenav" class="sidenav">
	
        <a href="userprofile.jsp">Change Password</a>
        <a href="applyvisa.jsp">Apply Visa</a>
        <a href="viewapplyvisa.jsp">View Applied VISA</a>
        <a href="userpayment.jsp">Pay & Get VISA</a>
        <a href="successfulappy&extendvisa.jsp">Extend VISA</a>
        <a href="extend.jsp">Pay for Extend VISA</a>
        
    </div>
	
</body>
</html>