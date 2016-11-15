insert into user values(1,'Super','User','M','mphone', 'superuser@hni.com', 0, 'password', '42M7kr4oektqA6Jgy9u1YQ==', now(), '0');
insert into user values(2,'Freddy','Fikes','M','479-555-1212', '', 0, '', '', now(), '0');
insert into user values(3,'Mikey','Multiphone','M','479-555-4321', '', 0, '', '', now(), '0');
insert into user values(4,'Mikey','Multiphone','M','479-555-5678', '', 0, '', '', now(), '0');
insert into user values(5, 'Ericka', 'Energy', 'F', '123-456-7830', '' ,0, '', '', now(), '0');
insert into user values(6, 'Barbara', 'Bollingsworth', 'F', '123-456-7830', '' ,0, '', '', now(), '0');

insert into organization values(1, 'Not Impossible', 'phone', 'website', 'logo', now(), 1);
insert into organization values(2, 'Samaritan House', 'phone', 'website', 'logo', now(), 1);
insert into organization values(3, 'Shelter House', 'phone', 'website', 'logo', now(), 1);


insert into user_organization_role values(1, 2, 1);
insert into user_organization_role values(2, 2, 3);
insert into user_organization_role values(3, 2, 3);
insert into user_organization_role values(4, 3, 4);
insert into user_organization_role values(5, 3, 5);
insert into user_organization_role values(5, 3, 2);
insert into user_organization_role values(5, 2, 5);
insert into user_organization_role values(5, 2, 2);
insert into user_organization_role values(6, 3, 5);
insert into user_organization_role values(6, 3, 2);
insert into user_organization_role values(6, 2, 5);
insert into user_organization_role values(6, 2, 2);

insert into provider values(1, 'Subway', now(), 1);
insert into provider_location values(1, 'Subway #1', 1, now(), 1);
insert into menu values(1, '"Subway Lunch', 1, 10, 16); /* 10am to 4pm */
insert into menu_item values(1, 1, 'Ham Sandwich', 'ham and cheese with LTP', 6.99, null);
insert into menu_item values(2, 1, 'Turkey Sandwich', 'turkey and cheese with LTP', 7.99, null);
insert into menu_item values(3, 1, 'Roast beef Sandwich', 'beef and cheese with LTP', 8.99, null);
insert into menu_item values(4, 1, 'Club Sandwich', 'turkey, ham and cheese with LTP', 7.95, null);

insert into user_order values(1, 2, 1, dateadd('DAY', -2, current_date), dateadd('DAY', -2, current_date), null, 9.95, 1.20, 1);



insert into security_permission values(1,'*','*'); /* user-user only! */

insert into security_permission values(11,'organizations','create');
insert into security_permission values(12,'organizations','read');
insert into security_permission values(13,'organizations','update');
insert into security_permission values(14,'organizations','delete');
insert into security_permission values(15,'organizations','*');

insert into security_permission values(21,'users','create');
insert into security_permission values(22,'users','read');
insert into security_permission values(23,'users','update');
insert into security_permission values(24,'users','delete');
insert into security_permission values(25,'users','*');

insert into security_permission values(41,'providers','create');
insert into security_permission values(42,'providers','read');
insert into security_permission values(43,'providers','update');
insert into security_permission values(44,'providers','delete');
insert into security_permission values(45,'providers','*');

insert into security_permission values(61,'orders','create');
insert into security_permission values(62,'orders','read');
insert into security_permission values(63,'orders','update');
insert into security_permission values(64,'orders','delete');
insert into security_permission values(65,'orders','*');
insert into security_permission values(67,'orders','provision');


insert into security_permission values(81,'activation-codes','create');
insert into security_permission values(82,'activation-codes','read');
insert into security_permission values(83,'activation-codes','update');
insert into security_permission values(84,'activation-codes','delete');
insert into security_permission values(85,'activation-codes','*');

/* super-user / admin */
insert into security_role_permission values(1,1,1);
insert into security_role_permission values(2,15,0);
insert into security_role_permission values(2,25,1);
insert into security_role_permission values(2,45,1);
insert into security_role_permission values(2,65,1);
insert into security_role_permission values(2,85,1);

/* volunteer */
insert into security_role_permission values(3,12,0);
insert into security_role_permission values(3,67,1);

/* client/user */
insert into security_role_permission values(4,12,0);
insert into security_role_permission values(5,12,0);
