CREATE DATABASE SurveyDB
;

use SurveyDB;

CREATE TABLE Survey (
    Survey_id smallint NOT NULL AUTO_INCREMENT,
    Survey_Name varchar(255) NOT NULL,
    PRIMARY KEY (Survey_id)
); 

select * from survey
;

CREATE TABLE Question (
    Question_id smallint NOT NULL AUTO_INCREMENT,
    Question_text varchar(255) NOT NULL,
    PRIMARY KEY (Question_id)
); 

insert into Question (Question_text)
values ('The physical work environment is appropriate for the kind of work I do'),
('I know what is expected of me at work'),
('I am willing to go above and beyond normal job requirements to meet organizational goals'),
('If offered a comparable position with similar pay and benefits at a different company, I would stay within my company'),
('I feel appreciated for the contribution I make'),
('The amount of work expected of me is reasonable'),
("I am able to maintain a balance between my personal and work activities that's right for me"),
('I have access to the information I need to do my job'),
("Most days, I feel that I've accomplished something worthwhile"),
('Considering both my performance and the required skills for my job, I feel my total compensation is fair')
;

select * from Question
;

CREATE TABLE Survey_Question (
    id int not null AUTO_INCREMENT,
    Survey_id SMALLINT not null,
    Question_id smallint NOT NULL,
    PRIMARY KEY (id)
); 

insert into Survey_Question (Survey_id, Question_id)
values (1,11),(1,12),
(1,13),(1,14),(1,15),
(1,16),(1,17),(1,18),
(1,19),(1,20);


CREATE TABLE Answer (
    Answer_id smallint NOT NULL AUTO_INCREMENT,
    Answer_text varchar(255) NOT NULL,
    PRIMARY KEY (Answer_id)
); 

insert into Answer (Answer_text)
values ('Strongly agree'),
('Somewhat agree'),
('Neither agree /  disagree'),
('Somewhat disagree'),
('Strongly disagree')
;

select * from Answer
;

CREATE TABLE Survey_Answer (
    id int not null AUTO_INCREMENT,
    Survey_id SMALLINT not null,
    Answer_id smallint NOT NULL,
    PRIMARY KEY (id)
); 

insert into Survey_Answer (Survey_id, Answer_id)
values (1,1),(1,2),
(1,3),(1,4),(1,5);


CREATE TABLE Statistic (
    id int NOT NULL AUTO_INCREMENT,
    Survey_id SMALLINT NOT NULL,
    Question_id SMALLINT not null,
    Answer_id SMALLINT not null,
    Chosen_count int null,
    PRIMARY KEY (id)
); 

SELECT *
FROM Statistic
;

insert into Statistic (Survey_id, Question_id, Answer_id, Chosen_count)
select s.survey_id, sq.Question_id, sa.Answer_id, 0
from survey s
inner join survey_question sq
on s.survey_id = sq.survey_id
inner join survey_answer sa
on s.survey_id = sa.survey_id
where s.survey_id = 1
;

CREATE VIEW VW_Survey (Survey_id, Survey_Name, Number_of_questions, Number_of_answers)
as
select s.Survey_id, s.Survey_Name, count(distinct sq.id) as Number_of_questions, count(distinct sa.id) as Number_of_answers
from Survey s
inner join Survey_question sq
on s.Survey_id = sq.Survey_id
inner join Survey_answer sa
on s.Survey_id = sa.Survey_id
group by s.Survey_id, s.Survey_Name
;

SELECT * 
FROM VW_Survey
;

create VIEW VW_SurveyAnswer (Survery_id, Answer_id, Answer_text)
as
select sa.Survey_Id, sa.Answer_id, a.Answer_text
from Survey_Answer sa
inner join Answer a
on sa.Answer_id = a.Answer_Id
order by sa.Survey_id, sa.Answer_id
;

SELECT * 
FROM VW_SurveyAnswer
;

create VIEW VW_SurveyQuestion (Survey_id, Question_id, Question_text)
as
select sq.Survey_id, sq.Question_id, q.Question_text
from Survey_Question sq
inner join Question q
on sq.Question_id = q.Question_Id
order by sq.Survey_id, sq.Question_id
;

SELECT * 
FROM VW_SurveyQuestion
;

