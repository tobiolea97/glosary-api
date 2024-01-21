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

insert into users(first_name, last_name, question_per_quiz) VALUES ('Tobias', 'Olea', 10);

insert into user_topics(user_id, topic_id) VALUES (1, 1);
insert into user_topics(user_id, topic_id) VALUES (1, 3);
insert into user_topics(user_id, topic_id) VALUES (1, 4);
insert into user_topics(user_id, topic_id) VALUES (1, 9);

insert into expressions(title, card_example, definition, topic_type_id)
	values ('Run out', 'He *ran out* of gas in the middle of nowhere', 'All of it has been used or it is completely finished', 1);

insert into examples(expression_id, sentence) values (1, 'We are about to {1} of milk. Could you bring some from the store?');

insert into gaps(example_id, order_number, anwser, wrong_awnser_1, wrong_awnser_2) VALUES (1, 1, 'run out', 'run down', 'set out');