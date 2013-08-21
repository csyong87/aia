--
INSERT INTO USER_INFO (userinfoid, loginid, domain, username,
                       mobilenumber, password, email, emailpassword, status, createdby, datecreated)
  VALUES (1, 'christian', 'msat', 'Christian', '####-####',
          '64a3c0a664030e056fcc412a847022769139ff736bc58ad484f7809cfe127c4c',
          'christian_javellana@xxxx.com', 'C1vEry80NvpRnAY+8PKw4CyJxkcDGRTZ',
          'ACTIVE', 'ADMIN', sysdate);
COMMIT;
