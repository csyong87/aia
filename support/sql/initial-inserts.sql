--
INSERT INTO USER_INFO (userinfoid, loginid, domain, username,
                       mobilenumber, password, email, emailpassword, status, createdby, datecreated)
  VALUES (1, 'christian', 'msat', 'Christian', '####-####',
          '64a3c0a664030e056fcc412a847022769139ff736bc58ad484f7809cfe127c4c',
          'christian_javellana@xxxx.com', 'C1vEry80NvpRnAY+8PKw4CyJxkcDGRTZ',
          'ACTIVE', 'ADMIN', sysdate);
          
          
-- create roles
INSERT INTO ROLE_INFO (ROLEINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, UPDATEDBY, VERSION) 
	VALUES (1, 'ADMIN', sysdate, null, 'Administrator Role', 'ADMIN', null, 0);
INSERT INTO ROLE_INFO (ROLEINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, UPDATEDBY, VERSION) 
	VALUES (2, 'ADMIN', sysdate, null, 'Manager Role', 'MANAGER', null, 0);
INSERT INTO ROLE_INFO (ROLEINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, UPDATEDBY, VERSION) 
	VALUES (3, 'ADMIN', sysdate, null, 'Developer Role', 'DEVELOPER', null, 0);
	
-- Mapping between users and roles
-- user 'christian' as 'administrator'
INSERT INTO USER_ROLE (USERROLEID, CREATEDBY, DATECREATED, DATEUPDATED, ROLEINFOID, STATUS, UPDATEDBY, USERINFOID,  VERSION) 
	VALUES ( 1, 'ADMIN', sysdate, null, 1, 'ACTIVE', null, 1, 0);
-- user 'christian' as 'developer'
INSERT INTO USER_ROLE (USERROLEID, CREATEDBY, DATECREATED, DATEUPDATED, ROLEINFOID, STATUS, UPDATEDBY, USERINFOID,  VERSION)
  VALUES ( 2, 'ADMIN', sysdate, null, 3, 'ACTIVE', null, 1, 0);

-- 1 - 99 (System Reserved Menu Items)

-- Administration
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(1, 'ADMIN', sysdate, null, 'Administration', 'Administration', null, null, '/aia-web/administration.html', 0);
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(2, 'ADMIN', sysdate, null, 'User Management', 'User Management', 1, null, '/aia-web/userManagement.html', 0);
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(3, 'ADMIN', sysdate, null, 'System Management', 'System Management', 1, null, '/aia-web/systemManagement.html', 0);

-- Profiles
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(10, 'ADMIN', sysdate, null, 'Profile', 'Profile', null, null, '/aia-web/profile.html', 0);
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(11, 'ADMIN', sysdate, null, 'Account Settings', 'Account Settings', 10, null, '/aia-web/accountSettings.html', 0);
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(12, 'ADMIN', sysdate, null, 'Logout', 'Logout', 10, null, '/aia-web/logout.html', 0);

--Dashboard
INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(100, 'ADMIN', sysdate, null, 'Dashboard', 'Dashboard', null, null, '/aia-web/dashboard.html', 0);

INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(110, 'ADMIN', sysdate, null, 'Deployments', 'Deployments', null, null, '/aia-web/deployments.html', 0);

INSERT INTO FUNCTION_INFO(FUNCTIONINFOID, CREATEDBY, DATECREATED, DATEUPDATED, DESCRIPTION, NAME, PARENTFUNCTIONINFOID, UPDATEDBY, URL, VERSION)
  VALUES(120, 'ADMIN', sysdate, null, 'Reports', 'Reports', null, null, '/aia-web/reports.html', 0);

COMMIT;
