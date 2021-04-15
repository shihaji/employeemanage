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

  function funcload(){
	  if(departName!=null && departName!=""){
		 	var depart = document.frmAddUser.departNm;
		  depart.options[depart.selectedIndex].value=departId;
		  depart.options[depart.selectedIndex].text=departName;
		
		  document.frmAddUser.deptId.value = departId;
		  
		  document.frmAddUser.deptNm.value = departName;
	  }
  }
        function funcDateEntry()
        {
        show_calendar('frmAddUser.dob', 'month()', 'year()', 'MM/DD/YYYY', null,'');
        }
        function funcDateClear()
        {
        window.document.frmAddUser.dob.value='';
        }
        function funcSelect(){
        //	document.frmAddUser.departID.value = document.frmAddUser.departNm.value;
        		var depart = document.frmAddUser.departNm;
        	document.frmAddUser.deptId.value = depart.options[depart.selectedIndex].value;
			document.frmAddUser.deptNm.value = depart.options[depart.selectedIndex].text;
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
        function validate() {
        	var message = '';
        	var isvalid =true;
        	
        	var today = new Date();
        	var iscurrent = true;
        	var isalpha =true;
        	var year =today.getFullYear();
        	var month = today.getMonth()+1;
        	var date = today.getDate();
        	var curdate = month+'/'+date+'/'+year;
        	var validMsg ='';
        	 
        	if (document.frmAddUser.firstName.value== '') {
        		message= "First Name\n";
        		isvalid = false;
        	} 
        	else{
        		isalpha =isalphabet(document.frmAddUser.firstName.value);
        		if(!isalpha){
        		 isvalid = false;
        		}
        	}
        	if (document.frmAddUser.lastName.value== '') {
        		message= message+"Last Name\n";
        		isvalid = false;
        	}
        	else{
        		isalpha = isalphabet(document.frmAddUser.lastName.value);
        		if(!isalpha){
        		isvalid = false;
        		}
        	}
        	
        	if (document.frmAddUser.dob.value== '') {
        		message= message+"DOB\n";
        		isvalid = false;
        	}
        	
           
        	var email = checkEmail();
        	if(!email){
        		isvalid = false;
        	}
        	if(document.frmAddUser.departNm.value=='Selected'){
        		message= message+"Department\n";
        		isvalid = false;
        	}
       	
        	if(isvalid){
        		document.frmAddUser.submit();
        	}
        	else{
        		if(message!=''){
        		alert('The following fields needs to be entered \n'+message);
        		}
        		if(!iscurrent){
        		alert("DOB cannot be a future date");
        		}
        		isvalid=true;
        	}

        }
    </script>
    <body onload="funcload()" CLASS="Body_Bgcolor"  topmargin="0" leftmargin="0">
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
		new menu (MENU_ITEMS, MENU_POS1);
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
	<form method="POST" action='UserController' name="frmAddUser">

		<table align="left" width=40% bgcolor="#FFFFFF" border="0"
			cellspacing="1" cellpadding="1">
			<tr height="20%">
				<td class="Table_Header" colspan="2">
					<p align="left">Add/Edit Employee</p>
				</td>
			</tr>

			<tr>

				<td class="Fld_Lb" width="30%">First Name :</td>
				<td class="Fld_Vl" width="70%"><input type="hidden"
					name="userid" readonly value="<c:out value="${employee.userid}" />" />
					<input type="text" name="firstName" size="30"
					value="<c:out value="${employee.firstName}" />" /></td>
			</tr>

			<tr>
				<td class="Fld_Lb">Last Name :</td>
				<td class="Fld_Vl" width="70%"><input type="text"
					name="lastName" size="30"
					value="<c:out value="${employee.lastName}" />" /></td>
			</tr>

			<tr>
				<td class="Fld_Lb">DOB :</td>
				<td class="Fld_Vl"><input type="text" name="dob" readonly
					value="<fmt:formatDate pattern="MM/dd/yyyy" value="${employee.dob}" />" />&nbsp;
					<img src="images/datepic.gif" class="Cursor_Hand" width="16"
					height="13" onMouseUp="funcDateEntry()">&nbsp;&nbsp; <img
					src="images/EraseDate.gif" class="Cursor_Hand" width="16"
					height="13" onMouseUp="funcDateClear()" alt="   Clear Date    ">
				</td>
			</tr>

			<tr>
				<td class="Fld_Lb">Email :</td>
				<td class="Fld_Vl"><input type="text" name="email" size="50"
					value="<c:out value="${employee.email}" />" /> <br /></td>
			</tr>
			<tr>
				<td class="Fld_Lb">Department : <input type="hidden"
					name="departID" />
				</td>
				<td class="Fld_Vl"><select name="departNm"
					onchange="funcSelect(this)">
						<option value="Selected">--Selected--</option>
						<c:forEach var="depart" items="${departments}">
							<option value='<c:out value="${depart.departId}"/>'>
								<c:out value="${depart.departName}" />
							</option>
						</c:forEach>
				</select> <br /><input type="hidden" name="deptId" /><input type="hidden" name = "deptNm"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="button"
					value="Submit" onclick="validate();" /></td>
			</tr>
		</table>
	</form>
</body>
</html>