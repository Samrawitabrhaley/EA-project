INSERT INTO ea_badge.Role (id, name) VALUES (1, 'Student');
INSERT INTO ea_badge.Role (id, name) VALUES (2, 'Staff');
INSERT INTO ea_badge.Role (id, name) VALUES (3, 'Faculty');

INSERT INTO ea_badge.Member (id, emailAddress, firstName, lastName) VALUES (1, 'mem@mail.com', 'Joe', 'Student');
INSERT INTO ea_badge.Member (id, emailAddress, firstName, lastName) VALUES (2, 'gat@mail.com', 'Mer', 'Staff');

INSERT INTO ea_badge.Member_Role (Member_id, Role_id) VALUES (1, 1);
INSERT INTO ea_badge.Member_Role (Member_id, Role_id) VALUES (2, 2);
INSERT INTO ea_badge.Member_Role (Member_id, Role_id) VALUES (2, 3);

INSERT INTO ea_badge.Badge (id, activationDate, active, expirationDate, member_id) VALUES (1, '2022-05-09', true, '2022-05-23', 1);
INSERT INTO ea_badge.Badge (id, activationDate, active, expirationDate, member_id) VALUES (2, '2022-05-02', false, '2022-05-23', 1);
INSERT INTO ea_badge.Badge (id, activationDate, active, expirationDate, member_id) VALUES (3, '2022-05-02', true, '2022-05-09', 2);

INSERT INTO ea_badge.Rule (id, allowedLimit, perDurationDays) VALUES (1, 90, 30);
INSERT INTO ea_badge.Rule (id, allowedLimit, perDurationDays) VALUES (2, 3, 1);
INSERT INTO ea_badge.Rule (id, allowedLimit, perDurationDays) VALUES (3, 1, 1);

INSERT INTO ea_badge.Plan (id, Description, PlanName, Rule_id) VALUES (1, '90 times a month', '90x a month', 1);
INSERT INTO ea_badge.Plan (id, Description, PlanName, Rule_id) VALUES (2, '3 times a day for student, staff and faculty', '3x a day', 2);
INSERT INTO ea_badge.Plan (id, Description, PlanName, Rule_id) VALUES (3, '1 time a day for staff and faculty', '1x a day', 3);

INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (1, 1);
INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (2, 1);
INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (2, 2);
INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (2, 3);
INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (3, 2);
INSERT INTO ea_badge.Plan_Role (Plan_id, Role_id) VALUES (3, 3);

INSERT INTO ea_badge.Location (id, capacity, description, locationType, name) VALUES (1, 100, 'Dinning Hall', 'DINNING_HALL', 'LoFU');
INSERT INTO ea_badge.Location (id, capacity, description, locationType, name) VALUES (2, 20, 'Recreational center', 'GYMNASIUM', 'Rec Center');

INSERT INTO ea_badge.Timeslot (id, days, end_time, start_time, location_id) VALUES (1, 'MONDAY', '08:30:00', '10:00:00', 1);
INSERT INTO ea_badge.Timeslot (id, days, end_time, start_time, location_id) VALUES (2, 'MONDAY', '12:30:00', '08:00:00', 1);
INSERT INTO ea_badge.Timeslot (id, days, end_time, start_time, location_id) VALUES (3, 'MONDAY', '19:00:00', '20:30:00', 1);
INSERT INTO ea_badge.Timeslot (id, days, end_time, start_time, location_id) VALUES (4, 'MONDAY', '18:00:00', '20:30:00', 2);

INSERT INTO ea_badge.Membership (id, endDate, startDate, location_Id, member_Id, membershipType) VALUES (1, '2022-05-09', '2022-05-02', 1, 1, 'LIMITED');
INSERT INTO ea_badge.Membership (id, endDate, startDate, location_Id, member_Id, membershipType) VALUES (2, '2022-05-23', '2022-05-09', 2, 1, 'UNLIMITED');
INSERT INTO ea_badge.Membership (id, endDate, startDate, location_Id, member_Id, membershipType) VALUES (3, '2022-05-23', '2022-05-09', 1, 2, 'CHECKER');

INSERT INTO ea_badge.Membership_Plan (Membership_id, Plan_id) VALUES (1, 1);
INSERT INTO ea_badge.Membership_Plan (Membership_id, Plan_id) VALUES (1, 2);
INSERT INTO ea_badge.Membership_Plan (Membership_id, Plan_id) VALUES (3, 3);

INSERT INTO ea_badge.Location_Plan (Location_id, plans_id) VALUES (1, 1);
INSERT INTO ea_badge.Location_Plan (Location_id, plans_id) VALUES (1, 2);

INSERT INTO ea_badge.Transaction (id, datetime, succeed, badge_id, location_id) VALUES (1, '2022-05-17', true, 1, 1);
INSERT INTO ea_badge.Transaction (id, datetime, succeed, badge_id, location_id) VALUES (2, '2022-05-17', true, 1, 1);
INSERT INTO ea_badge.Transaction (id, datetime, succeed, badge_id, location_id) VALUES (3, '2022-05-17', true, 2, 1);
INSERT INTO ea_badge.Transaction (id, datetime, succeed, badge_id, location_id) VALUES (4, '2022-05-17', true, 2, 2);





