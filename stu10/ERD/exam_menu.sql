
/* Drop Tables */

DROP TABLE exam_menu CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE exam_menu
(
	ex_uid number NOT NULL,
	ex_name varchar2(20) NOT NULL,
	ex_con varchar2(20) NOT NULL CHECK (ex_con IN ('한식','중식','일식')),
	ex_price number DEFAULT 0 CHECK (ex_price>=0),
	PRIMARY KEY (ex_uid)
);

CREATE SEQUENCE exam_menu_seq;
DROP SEQUENCE exam_menu_seq;

INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '낙곱새', '한식', 12000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '짜장면', '한식', 5000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '짬뽕', '한식', 8000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '탕수육', '중식', 15000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '스시', '일식', 25000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '마라탕', '중식', 18000);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '라멘', '일식', 7500);
INSERT INTO exam_menu VALUES (exam_menu_seq.nextval, '라면', '한식', 6000);

SELECT ex_uid "uid", ex_name name, ex_con con, ex_price price
FROM exam_menu ORDER BY ex_uid DESC;


