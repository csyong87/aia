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
INSERT INTO USER_ROLE (USERROLEID, CREATEDBY, DATECREATED, DATEUPDATED, ROLEINFOID, STATUS, UPDATEDBY, USERINFOID,  VERSION) 
	VALUES ( 1, 'ADMIN', sysdate, null, 1, 'ACTIVE', null, 1, 0);
	
COMMIT;
