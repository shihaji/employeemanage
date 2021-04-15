<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%@page import="com.sample.model.EmployeeTO"%>
<title>Add new Employee</title>
</head>
<%
String departName = "";
int departId =0;
if(request.getAttribute("employee")!=null){
EmployeeTO employeeTO  = (EmployeeTO)request.getAttribute("employee");
if(employeeTO!=null && employeeTO.getDepartment()!=null && employeeTO.getDepartment().getDepartName()!=null){
departName = employeeTO.getDepartment().getDepartName();
departId =employeeTO.getDepartment().getDepartId();
}
}

%>


	<script>
	var departName = "<%=departName%>";
	var departId = "<%=departId%>";


        function funcDateEntry()
        {
        show_calendar('frmCreateRL.createDate', 'month()', 'year()', 'MM/DD/YYYY', null,'');
        }
        function funcDateClear()
        {
        window.document.frmCreateRL.createDate.value='';
        }
    
        function checkEmail() {
			if(document.frmAddUser.email.value!=''){
            var email = document.frmAddUser.email.value;
            var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;   
            if(email.match(mailformat))   
            {   
            return true;   
            }   
            else  
            {   
            alert("You have entered an invalid email address!");   
            return false;   
            }   
			}
			return true;
        }
        function isalphabet(fldvalue) {      
        	var name = fldvalue;  
        	var pattern = /^[A-Za-z]{1,30}$/;      
        	if (pattern.test(name)) {   
        		return true;
        		} else {           
        			alert(name+" is not a valid entry. Please enter only alphabets!");            
        			return false;        
        		}    
        }
        function funcSelect(){
            //	document.frmAddUser.departID.value = document.frmAddUser.departNm.value;
            		var depart = document.frmCreateRL.departNm;
            	document.frmCreateRL.deptId.value = depart.options[depart.selectedIndex].value;
    			document.frmCreateRL.deptNm.value = depart.options[depart.selectedIndex].text;
            } 
        function validate() {
        
        		document.frmCreateRL.submit();
        	
        }
    </script>
    <body onload="" CLASS="Body_Bgcolor"  topmargin="0" leftmargin="0">
	<TABLE width='100%' height='85' border='1'>
		<TR bordercolor="#000000">
			<TD>
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					bgcolor="#007c7a" background="images/EMP_bg_03.jpg">
					<tr>
						<td align="left">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td><img src="images/EMP_logo_03.jpg" />
									</td>
								</tr>
							</table></td>

						<td align="right">
							<table border="0" cellpadding="0" cellspacing="0" height="90%">
								<tr>
									<td><img src="images/EMP_03.jpg" />
									</td>
								</tr>
							</table></td>
					</tr>
				</table></TD>
		</TR>

	</TABLE>
	<div>
		<script language="JavaScript"> 
		new menu (MENU_ITEMS1, MENU_POS2);
</script>
	</div>



	<div id="errormsg">
		<table align="center">
			<tr>
				<td class="ERROR_VL"><c:out value="${message}" />
				</td>
			</tr>
		</table>
	</div>
	<form method="POST" action='RLController?action=statusrpt' name="frmCreateRL">
<table width = "100%">
<tr>
<td>
		<table align="left" width=40% bgcolor="#FFFFFF" border="0"
			cellspacing="1" cellpadding="1">
			<tr height="20%">
				<td class="Table_Header" colspan="2">
					<p align="left">StatusReport</p>
				</td>
			</tr>
			<tr>
				<td class="Fld_Lb">Comments 
				</td>
				<td class="Fld_Vl"><textarea name = "comments"></textarea></td>
			</tr>

			<tr>
				<td class="Fld_Lb">Creation Date :</td>
				<td class="Fld_Vl"><input type="text" name="createDate" readonly
					value="" />&nbsp;
					<img src="images/datepic.gif" class="Cursor_Hand" width="16"
					height="13" onMouseUp="funcDateEntry()">&nbsp;&nbsp; <img
					src="images/EraseDate.gif" class="Cursor_Hand" width="16"
					height="13" onMouseUp="funcDateClear()" alt="   Clear Date    ">
				</td>
			</tr>
			
			

			<tr>
				<td colspan="2" align="right"><input type="button"
					value="Submit"   onclick="validate();"/></td>
			</tr>
		</table>
		</td>
		</tr>
		
		<tr>
	<td>
	 <table align="center" width="80%">
 
        <thead>
       
            <tr class="border">
                <th class="Table_Header" >Status Report Id</th>
                 <th class="Table_Header" >Comments</th>
                <th class="Table_Header">Creation Date</th>
               <th class="Table_Header">Department</th>
            </tr>
        </thead>
        <tbody >
            <c:forEach items="${reports}" var="statusReport">
                <tr>
                    <td class="Fld_Vl"><c:out value="${statusReport.statusId}" /></td>
                    <td class="Fld_Vl"><c:out value="${statusReport.comments}" /></td>
                    <td class="Fld_Vl"><fmt:formatDate pattern="yyyy-MMM-dd" value="${statusReport.createDate}" /></td>
                    <td class="Fld_Vl"><c:out value="${statusReport.department.departName}" /></td>
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