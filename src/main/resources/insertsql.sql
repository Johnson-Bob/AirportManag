insert into statuses(`status`) value ('chek-in');
insert into statuses(`status`) value ('gate closed');
insert into statuses(`status`) value ('arrived');
insert into statuses(`status`) value ('departed at');
insert into statuses(`status`) value ('unknown');
insert into statuses(`status`) value ('canceled');
insert into statuses(`status`) value ('expected at');
insert into statuses(`status`) value ('delayed');
insert into statuses(`status`) value ('in flight');
insert into classFlight (`class_name`) value ('busines');
insert into classFlight (`class_name`) value ('economy');
insert into gates (`number`) value (1);
insert into gates (`number`) value (2);
insert into gates (`number`) value (3);
insert into gates (`number`) value (4);
insert into gates (`number`) value (5);
insert into terminals (`terminal`) value ('north');
insert into terminals (`terminal`) value ('east');
insert into terminals (`terminal`) value ('west');
insert into cities(`name`) value ('Odessa');
insert into cities(`name`) value ('Kiev');
insert into cities(`name`) value ('Lviv');
insert into cities(`name`) value ('Dnipro');
insert into flights(`type`, `dates`, `number`, `city`, `terminal`, `status`, `gate`)value ('arrival', '2016-12-13 12:44:00', 'Od155', 
(select city_id from cities where name = 'Odessa'), (select terminal_id from terminals where terminal = 'north'),
 (select status_id from statuses where status = 'unknown'), (select gate_id from gates where number = 1));
 insert into flights(`type`, `dates`, `number`, `city`, `terminal`, `status`, `gate`)value ('DEPARTURE', '2016-12-16 15:30:00', 
 'Kv027', (select city_id from cities where name = 'Kiev'), (select terminal_id from terminals where terminal = 'east'),
 (select status_id from statuses where status = 'delayed'), (select gate_id from gates where number = 2));
 insert into flights(`type`, `dates`, `number`, `city`, `terminal`, `status`, `gate`)value ('ARRIVAL', '2016-12-16 20:10:00', 'Lv543', 
(select city_id from cities where name = 'Lviv'), (select terminal_id from terminals where terminal = 'west'),
 (select status_id from statuses where status = 'chek-in'), (select gate_id from gates where number = 3));
insert into flights(`type`, `dates`, `number`, `city`, `terminal`, `status`, `gate`)value ('DEPARTURE', '2016-12-17 07:18:00', 'Dn111', 
(select city_id from cities where name = 'Dnipro'), (select terminal_id from terminals where terminal = 'west'),
 (select status_id from statuses where status = 'in flight'), (select gate_id from gates where number = 4));
