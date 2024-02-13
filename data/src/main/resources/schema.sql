DROP TABLE IF EXISTS gaps;
DROP TABLE IF EXISTS examples;
DROP TABLE IF EXISTS user_expressions;
DROP TABLE IF EXISTS user_topics;
DROP TABLE IF EXISTS expressions;
DROP TABLE IF EXISTS topics;
DROP TABLE IF EXISTS topic_types;
DROP TABLE IF EXISTS users;

CREATE TABLE topic_types (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE topics (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    topic_type_id INTEGER,
    FOREIGN KEY (topic_type_id) REFERENCES topic_types(id)
);

CREATE TABLE expressions (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    card_example VARCHAR(255),
    definition VARCHAR(255),
    topic_type_id INTEGER,
    FOREIGN KEY (topic_type_id) REFERENCES topics(id)
);

CREATE TABLE examples (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    expression_id INT,
    sentence VARCHAR(255),
    FOREIGN KEY (expression_id) REFERENCES expressions(id)
);

CREATE TABLE gaps (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    example_id INTEGER,
    order_number INTEGER,
    alternative_answer_1 VARCHAR(255),
    alternative_answer_2 VARCHAR(255),
    alternative_answer_3 VARCHAR(255),
    alternative_answer_4 VARCHAR(255),
    wrong_answer_1 VARCHAR(255),
    wrong_answer_2 VARCHAR(255),
    wrong_answer_3 VARCHAR(255),
    wrong_answer_4 VARCHAR(255),
    FOREIGN KEY (example_id) REFERENCES examples(id)
);

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    questions_per_quiz INTEGER NOT NULL
);

CREATE TABLE user_expressions (
    expression_id INTEGER,
    user_id INTEGER,
    score INTEGER,
    last_completed DATETIME,
    learn BOOLEAN,
    FOREIGN KEY (expression_id) REFERENCES expressions(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE(expression_id, user_id)
);

CREATE TABLE user_topics (
    user_id INTEGER NOT NULL,
    topic_type_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (topic_type_id) REFERENCES topics(id),
    UNIQUE(user_id, topic_type_id)
);
