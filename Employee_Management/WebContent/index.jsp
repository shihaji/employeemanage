<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/employee.css">
<link rel="stylesheet" href="css/menu.css">
<script language="JavaScript" src="js/menu.js"></script>
<script language="JavaScript" src="js/emp_menu_items.js"></script>
<script language="JavaScript" src="js/menu_tpl.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Employee Portal Management</title>
</head>
<body>
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
<div  >
<script language="JavaScript"> 
		new menu (MENU_ITEMS, MENU_POS1);
</script>
</div>
  <H4 align="center">This Portal gives the complete information of the Employees working with our organization.</H4>
  <div align="center">
  <a href="UserController?action=listUser">Click Here to View Employee Details</a>
</div>

<table  height='85' align="center" width="100%">
      <tr >
      <td colspan="2" align="center">
      
      </td>
      </tr>
           
               
       
        </tbody>
    </table>
</body>
</html>