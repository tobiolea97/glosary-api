insert into topic_types(name) VALUES ('Vocabulary');
insert into topic_types(name) VALUES ('Grammar');

insert into topics(name, topic_type_id) VALUES('Phrasal verbs', 1);
insert into topics(name, topic_type_id) VALUES('Idioms', 1);
insert into topics(name, topic_type_id) VALUES('Words', 1);
insert into topics(name, topic_type_id) VALUES('Prepositions', 1);
insert into topics(name, topic_type_id) VALUES('Collocations', 1);
insert into topics(name, topic_type_id) VALUES('Conditionals', 2);
insert into topics(name, topic_type_id) VALUES('Wish', 2);
insert into topics(name, topic_type_id) VALUES('Present tenses', 2);
insert into topics(name, topic_type_id) VALUES('Past tenses', 2);

insert into users(first_name, last_name, username, password, questions_per_quiz) VALUES ('Tobias', 'Olea', 'tobiolea', '$2a$10$43TVodx0PHCnOXfyWiDPr.Xn0yhs1oPf8jDW2mQgHpl.bR7rvhcd6', 10);

insert into user_topics(user_id, topic_type_id) VALUES (1, 1);
insert into user_topics(user_id, topic_type_id) VALUES (1, 2);
insert into user_topics(user_id, topic_type_id) VALUES (1, 3);
insert into user_topics(user_id, topic_type_id) VALUES (1, 4);
--insert into user_topics(user_id, topic_type_id) VALUES (1, 5);
--insert into user_topics(user_id, topic_type_id) VALUES (1, 9);

-- Phrasal verb: 'Run out'
insert into expressions(title, card_example, definition, topic_type_id) values ('Run out', 'He *ran out* of gas in the middle of nowhere', 'All of it has been used or it is completely finished', 1);
insert into examples(expression_id, sentence) values (1, 'We are about to {1} of milk. Could you bring some from the store?');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3) values (1, 1, 'run out', 'run down', 'set out', 'run off');

-- Phrasal verb: 'Look forward to'
insert into expressions(title, card_example, definition, topic_type_id) values ('Look forward to', 'She *looks forward to* her vacation every year', 'To be excited and pleased about something that is going to happen', 1);
insert into examples(expression_id, sentence) values (2, 'We {1} seeing you at the party next week.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3) values (2, 1, 'look forward to', 'look into', 'look for', 'look forward for');

-- Phrasal verb: 'Bring up'
insert into expressions(title, card_example, definition, topic_type_id) values ('Bring up', 'She *brought up* an interesting point during the meeting', 'To mention a subject or start to talk about it', 1);
insert into examples(expression_id, sentence) values (3, 'I didn''t want to {1} the topic during dinner.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3) values (3, 1, 'bring up', 'bring in', 'bring out', 'bring over');

-- Phrasal verb: 'Take off'
insert into expressions(title, card_example, definition, topic_type_id) values ('Take off', 'The plane *took off* right on schedule', 'When an aircraft leaves the ground and begins to fly', 1);
insert into examples(expression_id, sentence) values (4, 'The rocket {1} with a deafening roar.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3) values (4, 1, 'took off', 'took out', 'took away', 'took in');

-- Phrasal verb: 'Give up'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Give up', 'After years of trying, she finally *gave up* smoking', 'To stop doing something, especially something that you do regularly', 1);
insert into examples(expression_id, sentence)
    values (5, 'Don''t {1} on your dreams, keep working towards them.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (5, 1, 'give up', 'give in', 'give out', 'give off');

-- Phrasal verb: 'Come across'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Come across', 'She *came across* an old photo while cleaning out her closet', 'To find or meet (something or someone) by chance', 1);
insert into examples(expression_id, sentence)
    values (6, 'I {1} an interesting article while browsing the internet.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (6, 1, 'came across', 'came over', 'came up', 'came into');

-- Phrasal verb: 'Set up'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Set up', 'They *set up* a charity to help the homeless in their community', 'To establish or create something, typically a business, organization, or system', 1);
insert into examples(expression_id, sentence)
    values (7, 'She {1} her own photography studio after years of working for others.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (7, 1, 'set up', 'set off', 'set out', 'set about');

-- Phrasal verb: 'Hold on'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Hold on', 'She asked him to *hold on* while she finished the call', 'To wait or stop for a short time', 1);
insert into examples(expression_id, sentence)
    values (8, 'Just {1} a moment, I''ll be right with you.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (8, 1, 'hold on', 'hold up', 'hold out', 'hold off');

-- Phrasal verb: 'Turn down'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Turn down', 'She *turned down* the job offer because it required too much travel', 'To refuse or reject something, typically an offer, proposal, or invitation', 1);
insert into examples(expression_id, sentence)
    values (9, 'He {1} the volume on the radio because it was too loud.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (9, 1, 'turned down', 'turned off', 'turned up', 'turned in');

-- Phrasal verb: 'Put off'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Put off', 'They *put off* their trip to Europe until next summer', 'To delay or postpone something, typically an event, task, or decision', 1);
insert into examples(expression_id, sentence)
    values (10, 'Don''t {1} until tomorrow what you can do today.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (10, 1, 'put off', 'put out', 'put away', 'put on');



-- Collocation: 'Break the ice'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Break the ice', 'They played a game to *break the ice* at the party', 'To initiate social interaction in a formal or awkward situation', 5);
insert into examples(expression_id, sentence)
    values (11, 'Playing a game can help {1} at social gatherings.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (11, 1, 'break the ice', 'break ice', 'breaking the ice', 'ice breaking');

-- Collocation: 'Bite the bullet'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Bite the bullet', 'He knew he had to *bite the bullet* and tell the truth', 'To face a difficult or unpleasant situation with courage', 5);
insert into examples(expression_id, sentence)
    values (12, 'She knew she had to {1} and go to the dentist.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (12, 1, 'bite the bullet', 'bit the bullet', 'biting the bullet', 'bullet biting');


-- Collocation: 'Turn a blind eye'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Turn a blind eye', 'The teacher decided to *turn a blind eye* to the student''s behavior', 'To ignore or pretend not to notice something wrong or illegal', 5);
insert into examples(expression_id, sentence)
    values (13, 'The police officer decided to {1} to the minor offense.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (13, 1, 'turn a blind eye', 'set a blind eye', 'turning a blind eye', 'blind eye turning');


-- Collocation: 'Cost an arm and a leg'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Cost an arm and a leg', 'The new car *cost an arm and a leg*, but it was worth it', 'To be very expensive', 5);
insert into examples(expression_id, sentence)
    values (14, 'The repairs to the house {1}.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (14, 1, 'cost an arm and a leg', 'cost arm and a leg', 'costing an arm and a leg', 'arm and a leg costing');

-- Collocation: 'Catch someone's eye'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Catch someone''s eye', 'The colorful painting *caught her eye* as she walked into the gallery', 'To attract someone''s attention', 5);
insert into examples(expression_id, sentence)
    values (15, 'The shiny new car {1} as he walked by the dealership.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (15, 1, 'caught his eye', 'catching his eye', 'caught him eye', 'catch his eye');


-- Collocation: 'Keep an eye on'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Keep an eye on', 'Could you *keep an eye on* the children while I make dinner?', 'To watch or take care of someone or something', 5);
insert into examples(expression_id, sentence)
    values (16, 'Could you {1} my bag while I use the restroom?');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (16, 1, 'keep an eye on', 'keeping an eye on', 'kept an eye on', 'keep eye on');

-- Collocation: 'Get cold feet'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Get cold feet', 'He *got cold feet* and decided not to go through with the plan', 'To become too scared or nervous to do something previously decided', 5);
insert into examples(expression_id, sentence)
    values (17, 'He {1} and decided not to jump out of the plane.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (17, 1, 'got cold feet', 'getting cold feet', 'got cold foot', 'getting cold foot');


-- Collocation: 'Turn the tables'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Turn the tables', 'They *turned the tables* on their opponents and won the game', 'To reverse a situation, especially to one''s advantage', 5);
insert into examples(expression_id, sentence)
    values (18, 'She {1} on her opponent with a surprising move.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (18, 1, 'turned the tables', 'turning the tables', 'turned table', 'turning table');


-- Collocation: 'Hit the nail on the head'
insert into expressions(title, card_example, definition, topic_type_id)
    values ('Hit the nail on the head', 'She *hit the nail on the head* with her analysis of the situation', 'To describe exactly what is causing a situation or problem', 5);
insert into examples(expression_id, sentence)
    values (19, 'He {1} with his explanation of the problem.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3)
    values (19, 1, 'hit the nail on the head', 'hitting the nail on the head', 'hit nail on the head', 'hitting nail on the head');


-- Collocation: 'A piece of cake'
insert into expressions(title, card_example, definition, topic_type_id) values ('A piece of cake', 'The exam was *a piece of cake* for him because he had studied so much', 'Something that is very easy to do', 5);
insert into examples(expression_id, sentence) values (20, 'The test was {1} because she had studied so much.');
insert into gaps(example_id, order_number, alternative_answer_1, wrong_answer_1, wrong_answer_2, wrong_answer_3) values (20, 1, 'a piece of cake', 'piece of cake', 'cake piece', 'cake of piece');


INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (1,1,1,'20240218', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (2,1,2,'20240218', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (3,1,3,'20240218', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (4,1,0,NULL, TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (5,1,5,'20240215', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (6,1,1,'20240215', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (7,1,2,'20240215', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (8,1,3,'20240212', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (9,1,0,NULL, TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (10,1,5,'20240212', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (11,1,1,'20240220', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (12,1,2,'20240220', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (13,1,0,'20240220', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (14,1,4,'20240220', TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (15,1,5,'20240221', TRUE);

--INSERT INTO authentication (id, username, password) VALUES (1, 'user', 'password');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);