<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="css/employee.css">
<link rel="stylesheet" href="css/menu.css">
<script language="JavaScript" src="js/menu.js"></script>
<script language="JavaScript" src="js/emp_menu_items.js"></script>
<script language="JavaScript" src="js/menu_tpl.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="js/EMPLOYEE_Calendar.js"></SCRIPT>

<title>Add new Employee</title>
</head>
<body>
    <script>
  
        function funcDateEntry()
        {
        show_calendar('frmAddUser.dob', 'month()', 'year()', 'MM/DD/YYYY', null,'');
        }
        function funcDateClear()
        {
        window.document.frmAddUser.dob.value='';
        }
        function validate() {

        	var message = '';
        	var isvalid =true;
        	var today = new Date();
        	var iscurrent = true;
        	var year =today.getFullYear();
        	var month = today.getMonth()+1;
        	var date = today.getDate();
        	var curdate = month+'/'+date+'/'+year;

        	if (document.frmAddDept.departName.value== '') {
        		alert("Please enter the Department Name");
        	
        	} 
        	else{
        		document.frmAddDept.submit();
        	}
        	
        }
    </script>
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
		new menu (MENU_ITEMS, MENU_POS);
</script>
</div>



    <form method="POST" action='DepartmentController' name="frmAddDept">
   <table width = "100%">
   <tr><td>
        <table align="left" width =40% bgcolor="#FFFFFF" border="0" cellspacing="1" cellpadding="1">
           <tr height="20%"><td class="Table_Header"  colspan="2"> <p align="left"  >Add Department</p></td>  
       	 	</tr>
    
         <tr>
        
        	<td class="Fld_Lb" width="30%">Department Name : </td>
	        <td class="Fld_Vl" width="70%"> 
	        <input type="text" name="departName" size="30" /> </td>
         </tr>
          
         
          
        <tr>
       		<td colspan="2" align="right"><input type="button" value="Submit" onclick="validate()" />
       		</td>
        </tr>
      </table>
      </td>
      </tr>
      <tr><td>
      	
		<table align="center">
			<tr>
				<td class="ERROR_VL"><c:out value="${delEmp}" />
				</td>
			</tr>
		</table>
	
	</td>
	</tr>
      <tr>
      <td>
      <table align="left" width="50%">
 
        <thead>
       
            <tr class="border">
                <th class="Table_Header" >Department Id</th>
                <th class="Table_Header" >Department Name</th>
               
            </tr>
        </thead>
        <tbody >
            <c:forEach items="${departments}" var="department">
                <tr>
                    <td class="Fld_Vl"><c:out value="${department.departId}" /></td>
                    <td class="Fld_Vl"><c:out value="${department.departName}" /></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </td>
    </tr>
    </table>
    </form>
</body>
</html>