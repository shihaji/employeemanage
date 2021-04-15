<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Locale"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/employee.css">
<script type="text/javascript" src="scripts/validators.js"></script>
</head>
<%String message="";
   if(request.getAttribute("message")!=null){
	   message=request.getAttribute("message").toString();
	   
   }
   session.invalidate(); 
%>
<body CLASS="Body_Bgcolor"  topmargin="0" leftmargin="0">
<TABLE  width='100%' height='85' border='1'  >
 <TR bordercolor="#000000">
    <TD>
    <table border="0" cellpadding="0" cellspacing="0" width="100%"  bgcolor="#007c7a" background="images/EMP_bg_03.jpg">
		<tr>
			<td align="left">
				<table border="0" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td><img src="images/EMP_logo_03.jpg" /></td>
    				</tr>
    			</table>
			</td>
 
			<td align="right">
				<table border="0" cellpadding="0" cellspacing="0" height = "90%">
    				<tr>
    					<td><img src="images/EMP_03.jpg" /></td>
    				</tr>
    			</table>
			</td>
		</tr>
	</table>
	</TD>
  </TR>
 
</TABLE>
<form action="LoginController" method="post"> 
<table id="logintable" align="center" width="100%">
   <tr>
    <td colspan="3"><span id="loginerror" ><%=message %></span></td>
   </tr>
	<tr>
	<td  width="50%">
		
		</td>
		<td class="Fld_Lb">
		 User ID
		</td>
		<td class="Fld_Vl"><input type="text" name="userid" id="userid"></td>
		<td width="50%">
		
		</td>		 
	</tr>
	<tr>
	<td colspan="2">
	<span id="usererror" ></span>
	</td></tr>
	<tr>
		<td  width="50%"></td>
		<td class="Fld_Lb">Password</td>
		<td class="Fld_Vl"><input type="password" name="password" id="password" /></td>
		<td  width="50%"></td>		 
	</tr>
	<tr>
	<td colspan="2"><span id="passerror"></span></td>
	</tr>
	<tr >
		<td class="columnstyle">
		
	</td>
		<td colspan="2" align="center" class="columnstyle"><input   type="submit" name="login" value = "login" /></td>
				<td  width="50%"></td>	
				</tr>
				
</table>

</form>


</body>
</html>