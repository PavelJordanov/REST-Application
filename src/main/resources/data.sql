insert into product(id, name, prodgroup) values('fd8985a2-84ad-4245-8500-d9f362ca2f65','iPhone', 'Apple');
insert into product(id, name, prodgroup) values('fd8985a2-84ad-4245-8500-d9f362111111','iPad', 'Apple');
insert into users(firstname, lastname, dob, username, pwd, id, weight, height, fitness_goal, planID, start_date, end_date) 
    values('Pavel','Jordanov', '2002-11-24', 'PJ', 'KMO', 'fd8985a2-84ad-4245-8500-d9f362222222', 
            '87', '183', 'Build Lean Muscle', 'fd8985a2-84ad-4245-8500-d9f361111111', '2025-01-05', '2025-04-05');
insert into users(firstname, lastname, dob, username, pwd, id, weight, height, fitness_goal, planID, start_date, end_date) 
    values('Petar','Jordanov', '1995-03-14', 'Fatboy123', 'KMO864', 'fd8985a2-84ad-4245-8500-d9f362333333',
            '82', '185', 'Lose skinny fat and build some lean muscle', 'fd8985a2-84ad-4245-8500-d9f362222222', '2025-01-05', '2025-02-05');
insert into plans(id, name, description, type, durationInWeeks, price, numclients)
    values('fd8985a2-84ad-4245-8500-d9f361111111', '3 Month Plan', '8 training sessions a month, 12 week custom diet, 12 week training routine', 
    'mix', '12', '2190', '0');
insert into plans(id, name, description, type, durationInWeeks, price, numclients)
    values('fd8985a2-84ad-4245-8500-d9f362222222', '1 Month Plan', '8 training sessions a month, 4 week custom diet, 4 week training routine', 
    'mix', '4', '750', '0');
insert into plans(id, name, description, type, durationInWeeks, price, numclients)
    values('fd8985a2-84ad-4245-8500-d9f363333333', '4 Week Training Routine', '4 week customer customized training routine', 
    'training routine', '4', '60', '0');
insert into plans(id, name, description, type, durationInWeeks, price, numclients)
    values('fd8985a2-84ad-4245-8500-d9f364444444', '4 Week Diet', '4 week customer customized diet', 
    'nutrition/diet', '4', '60', '0');
insert into subscriptions(id, uid, pid, start_date, end_date, price)
    values('fd8985a2-84ad-4245-8500-d9f362222999', 'fd8985a2-84ad-4245-8500-d9f362222222', 'fd8985a2-84ad-4245-8500-d9f361111111', 
    '2025-01-03', '2025-04-03', '2190');
insert into subscriptions(id, uid, pid, start_date, end_date, price)
    values('fd8985a2-84ad-4245-8500-d9f362222888', 'fd8985a2-84ad-4245-8500-d9f362333333', 'fd8985a2-84ad-4245-8500-d9f362222222', 
    '2025-01-03', '2025-02-03', '750');
insert into payments(id, uid, type, amount, date)
    values('fd8985a2-84ad-4245-8500-d9f360000000', 'fd8985a2-84ad-4245-8500-d9f362222222', 'payment', '2190', '2025-01-06');
insert into payments(id, uid, type, amount, date)
    values('fd8985a2-84ad-4245-8500-d9f361111111', 'fd8985a2-84ad-4245-8500-d9f362333333', 'payment', '750', '2025-01-06');
insert into userbalances(id, uid, balance)
    values('fd8985a2-84ad-4245-8500-d9f360000001', 'fd8985a2-84ad-4245-8500-d9f362222222', '0');
insert into userbalances(id, uid, balance)
    values('fd8985a2-84ad-4245-8500-d9f361111112', 'fd8985a2-84ad-4245-8500-d9f362333333', '0');