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

insert into users(first_name, last_name, questions_per_quiz) VALUES ('Tobias', 'Olea', 10);

insert into user_topics(user_id, topic_type_id) VALUES (1, 1);
insert into user_topics(user_id, topic_type_id) VALUES (1, 3);
insert into user_topics(user_id, topic_type_id) VALUES (1, 4);
insert into user_topics(user_id, topic_type_id) VALUES (1, 9);

insert into expressions(title, card_example, definition, topic_type_id)
	values ('Run out', 'He *ran out* of gas in the middle of nowhere', 'All of it has been used or it is completely finished', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Look forward to', 'I *look forward to* meeting you tomorrow', 'To be excited or pleased about something that is going to happen', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Break up', 'They *broke up* after years of being together', 'To end a relationship or marriage', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Set up', 'I will *set up* a meeting for next week', 'To arrange or organize something', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Turn down', 'She *turned down* the job offer', 'To reject or decline an offer or invitation', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Bring up', 'He *brought up* an interesting topic during the discussion', 'To introduce or mention a topic', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Give up', 'Do not *give up* on your dreams', 'To stop trying or surrender', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Hold on', 'Please *hold on* while I transfer your call', 'To wait or pause', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Turn up', 'She *turned up* late for the meeting', 'To arrive or appear, especially unexpectedly', 1);

insert into expressions(title, card_example, definition, topic_type_id)
    values ('Look up', 'You can *look up* the information in the dictionary', 'To search for information in a reference source', 2);


INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (1,1,0,NULL, TRUE);
INSERT INTO user_expressions (expression_id, user_id, score, last_completed, learn) VALUES (2,1,0,NULL, FALSE);

insert into examples(expression_id, sentence) values (1, 'We are about to {1} of milk. Could you bring some from the store?');

insert into gaps(example_id, order_number, anwser, wrong_awnser_1, wrong_awnser_2) VALUES (1, 1, 'run out', 'run down', 'set out');