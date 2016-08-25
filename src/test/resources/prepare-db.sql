use voter;

set FOREIGN_KEY_CHECKS = 0;
truncate table states;
truncate table voters;
truncate table candidates;
truncate table voters_candidates;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `voter`.`states` ( `name`,  `created_at`, `updated_at`, `electoral_needed`)
VALUES
  ('IL',  '2001-01-11', '2001-01-11', '100'),
  ('CA',  '2001-01-11', '2001-01-11', '200'),
  ('TX',  '2001-01-11', '2001-01-11', '70'),
  ('WI',  '2001-01-11', '2001-01-11', '80');

insert into voters (created_at, age, name, updated_at, version, ethnicity, gender, state_id) values ('2016-08-22', '25', 'Bill', '2016-08-22', 0, 'WHITE', 'M', '1');
insert into voters (created_at, age, name, updated_at, version, ethnicity, gender, state_id) values ('2016-08-22', '30', 'Jill', '2016-08-22', 0, 'BLACK', 'F', '1');
insert into voters (created_at, age, name, updated_at, version, ethnicity, gender, state_id) values ('2016-08-22', '40', 'Tony', '2016-08-22', 0, 'HISPANIC', 'M', '2');
insert into voters (created_at, age, name, updated_at, version, ethnicity, gender, state_id) values ('2016-08-22', '50', 'Jen', '2016-08-22', 0, 'WHITE', 'F', '2');
insert into voters (created_at, age, name, updated_at, version, ethnicity, gender, state_id) values ('2016-08-22', '28', 'Sam', '2016-08-22', 0, 'BLACK', 'M', '2');



INSERT INTO `voter`.`candidates` (`version`, `name`, `position`, `created_at`, `updated_at`, `party`, `state_id`)
VALUES
  ('0', 'Hilary Clinton', 'PRESIDENT', '2001-01-11', '2001-01-11', 'DEMOCRAT', NULL ),
  ('0', 'Donald Trump', 'PRESIDENT', '2001-01-11', '2001-01-11', 'REPUBLICAN', NULL),
  ('0', 'Bruce Rauner', 'GOVERNOR', '2001-01-11', '2001-01-11', 'REPUBLICAN', '1'),
  ('0', 'Tammy Duckworth', 'GOVERNOR', '2001-01-11', '2001-01-11', 'DEMOCRAT', '1'),
  ('0', 'Mark Kirk', 'SENATOR', '2001-01-11', '2001-01-11', 'REPUBLICAN', '1'),
  ('0', 'Dick Durban', 'SENATOR', '2001-01-11', '2001-01-11', 'DEMOCRAT', '1');



INSERT INTO `voter`.`voters_candidates` (`voter_id`, `candidate_id`)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 2),
  (1, 3),
  (2, 3),
  (3, 3),
  (4, 3),
  (5, 4),
  (1, 5),
  (2, 6),
  (3, 6),
  (4, 6),
  (5, 6);