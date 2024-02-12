PRAGMA foreign_keys = ON;

drop table if exists gaps;
create table gaps (
	id integer primary key autoincrement,
	example_id integer,
	order_number integer,
	alternative_answer_1 varchar(255),
	alternative_answer_2 varchar(255),
	alternative_answer_3 varchar(255),
	alternative_answer_4 varchar(255),
	wrong_answer_1 varchar(255),
	wrong_answer_2 varchar(255),
	wrong_answer_3 varchar(255),
	wrong_answer_4 varchar(255),

	foreign key (example_id) references examples(id)

);


drop table if exists examples;
create table examples (
	id integer primary key autoincrement,
	expression_id int,
	sentence varchar(255),

	foreign key (expression_id) references expressions(id)
);

drop table if exists user_expressions;
create table user_expressions (
	expression_id integer,
	user_id integer,
	score integer,
	last_completed datetime,
	learn boolean,

	foreign key (expression_id) references expressions(id),
	foreign key (user_id) references users(id),
	unique(expression_id, user_id)
);


drop table if exists user_topics;
create table user_topics (
	user_id integer not null,
	topic_type_id integer not null,

	foreign key (user_id) references users(id),
	foreign key (topic_type_id) references topics(id)
	unique(user_id, topic_type_id)
);

drop table if exists expressions;
create table expressions (
	id integer primary key autoincrement,
	title varchar(255),
	card_example varchar(255),
	definition varchar(255),
	topic_type_id integer,

	foreign key (topic_type_id) references topics(id)
);

drop table if exists topics;
create table topics (
	id integer primary key autoincrement,
	name varchar(255),
	topic_type_id integer,

	foreign key (topic_type_id) references topic_types(id)
);

drop table if exists topic_types;
create table topic_types (
	id  integer primary key autoincrement,
	name varchar(255)
);





drop table if exists users;
create table users (
	id integer primary key autoincrement,
	first_name varchar(255),
	last_name varchar(255),
	questions_per_quiz integer not null
);







