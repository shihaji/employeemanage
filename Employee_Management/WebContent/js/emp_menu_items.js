var param;
var userName;
var navgPath;
var empName;
	
	
var MENU_ITEMS = [
					  
					  
              		['Emp', null, {'wd':90},
              						
              							['View','UserController?action=listUser',{'tw':'_top'}],
              							['Add','UserController?action=insert',{'tw':'_top'}],
              							['Create RL','RLController',{'tw':'_top'}]
              		],	
              		['Department', null, {'wd':90},
						
						['Add','DepartmentController',{'tw':'_top'}]
						
					
              		],	
              		
              		
              		['Logout', 'login.jsp', {'wd':90, 'tw':'_top'}]		
              		
              ];

var MENU_ITEMS1 = [
					  
              		
              		['Logout', 'login.jsp', {'wd':90, 'tw':'_top'}]		
              		
              ];

