CREATE DATABASE authors;
CREATE DATABASE books;

-- =========================================================

-- Connect to authors and create a table
\c authors;
CREATE TABLE public.author (
	id int4 NOT NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);

INSERT INTO public.author (id, email, "name") VALUES
(1, 'aa@aaaa', 'AAAA'),
(2, 'bb@bbbb', 'BBBB'),
(3, 'cc@cccc', 'CCCC'),
(4, 'dd@dddd', 'DDDD');

-- =========================================================

-- Connect to books and create a table
\c books;
CREATE TABLE public.book (
	id int4 NOT NULL,
	author_id int4 NULL,
	email varchar(255) NULL,
	firstname varchar(255) NULL,
	lastname varchar(255) NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id)
);

INSERT INTO public.book (id, email, firstname, lastname, author_id) VALUES
(1, 'xx@xxxx', 'xx', 'XXXX', 1),
(2, 'yy@yyyy', 'yy', 'YYYY', 1),
(3, 'zz@zzzz', 'zz', 'ZZZZ', 1),
(4, 'll@llll', 'll', 'LLLL', 2),
(5, 'mm@mmmm', 'mm', 'MMMM', 2),
(6, 'nn@nnnn', 'nn', 'NNNN', 2);