insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (1 ,'Elecctronics','Keep away from water','2020-12-27','Mobile','Available');
insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (2 ,'Elecctronics','Keep away from water','2020-12-27','Mobile','Assigned');
insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (3 ,'Elecctronics','Keep away from water','2020-12-27','Laptop','Assigned');
insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (4 ,'Elecctronics','Keep away from water','2020-12-27','Laptop','Assigned');
insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (5 ,'Stationary','Keep away from water','2020-12-27','Calculator','Available');
insert into ASSETMODEL(AID,CATEGORY,CONDITIONNOTE,DATE,NAME,STATUS) values (6 ,'Stationary','Keep away from water','2020-12-27','Calculator','Available');

insert into CATEGORY(CID,CNAME,DESCRIPTION) values (1 ,'Electronics','Handle with most care');
insert into CATEGORY(CID,CNAME,DESCRIPTION) values (2 ,'Stationary','Handle with most care');
insert into CATEGORY(CID,CNAME,DESCRIPTION) values (3 ,'Furniture','Handle with most care');

insert into EMPLOYEE(EID,ASSIGNEDASSETID,ASSIGNEDOBJECT,DESIGNATION,FULLNAME) values (1 ,0,'NULL','Software Engineer','ABC');
insert into EMPLOYEE(EID,ASSIGNEDASSETID,ASSIGNEDOBJECT,DESIGNATION,FULLNAME) values (2 ,0,'NULL','Backend Developer','DEF');
insert into EMPLOYEE(EID,ASSIGNEDASSETID,ASSIGNEDOBJECT,DESIGNATION,FULLNAME) values (3 ,0,'NULL','Software Testing','HIJ');
insert into EMPLOYEE(EID,ASSIGNEDASSETID,ASSIGNEDOBJECT,DESIGNATION,FULLNAME) values (4 ,0,'NULL','Frontend Developer','JKL');
insert into EMPLOYEE(EID,ASSIGNEDASSETID,ASSIGNEDOBJECT,DESIGNATION,FULLNAME) values (5 ,0,'NULL','HR','MNO');