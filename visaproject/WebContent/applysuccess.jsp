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
    margin-left: 1220px;
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
    
    <img src="reg.png" style="margin-top: -855px;margin-left: 35px;border-radius: 10px" width="1280px" height="820px">
    
    <h1 style="margin-left: 320px;font-size: 50px;margin-top: -710px">VISA Applied Successfully !!!</h1>
    
    <p style="margin-left: 250px;font-size: 30px;margin-top: 150px;width:900px" ALIGN=CENTER>Your visa appeal is sent to admin's approval
		please stay tuned for the results
		You can check the the results by clicking<br>"Pay & Get VISA" button</p>

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
	
	<div style="margin-top: -470px;margin-left: -10px"><span style="font-size:30px;cursor:pointer;position: fixed;margin-top: -10px;" onclick="openNav()"><input type="image" src="scroll.jpg" width="30px"></span></div>

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

</body>
</html>