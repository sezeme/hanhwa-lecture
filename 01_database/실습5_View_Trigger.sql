-- View - Trigger

-- Q1. view 생성
-- 1단계 : create table
-- (1) students table 생성
CREATE TABLE students(
	student_id INT auto_increment PRIMARY KEY,
	NAME VARCHAR(30),
	class VARCHAR(30)
);

-- (2) grades table 생성
CREATE or replace TABLE grades(
	grade_id INT auto_increment PRIMARY KEY,
	student_id INT,
	SUBJECT VARCHAR(30),
	grade CHAR(10),
	FOREIGN KEY(student_id) REFERENCES students(student_id)
	ON DELETE SET NULL ON UPDATE CASCADE
);

-- 추가 : 스키마 수정
-- (1) 참조되고 있는 부분의 foreign key 삭제
-- 외래키 이름 확인
SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE TABLE_NAME = 'grades';

ALTER TABLE grades DROP FOREIGN KEY grades_ibfk_1; 

-- (2) 참조하는 부분의 primary key 삭제
ALTER TABLE students DROP PRIMARY KEY;

-- (3) primary key 재설정
ALTER TABLE students MODIFY student_id INT AUTO_INCREMENT PRIMARY KEY;

-- (4) foreign key 다시 추가
ALTER TABLE grades ADD CONSTRAINT grades_fk_student
FOREIGN KEY (student_id) REFERENCES students(student_id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 2단계 : 데이터 insert
INSERT
  INTO students
VALUES
(NULL, '유관순','A'),
(NULL, '신사임당','B'),
(NULL, '홍길동','A');

INSERT
  INTO grades
VALUES
(NULL, 1, '과학','A'),
(NULL, 2, '과학','B'),
(NULL, 3, '과학','B'),
(NULL, 1, '수학','B'),
(NULL, 2, '수학','C'),
(NULL, 3, '수학','A');

-- 3단계 : create view
CREATE VIEW student_grades AS
SELECT b.subject, a.name, a.class, b.grade
FROM students a
JOIN grades b ON a.student_id = b.student_id;

-- 4단계 : select
SELECT * FROM student_grades;



-- Q2. Index 생성/삭제
EXPLAIN SELECT * FROM employee WHERE dept_code = 'D5';

-- 인덱스 생성
CREATE INDEX dept_idx ON employee(dept_code);


EXPLAIN SELECT * FROM employee WHERE dept_code = 'D5';

-- 인덱스 조회
SHOW INDEX FROM employee;

-- 인덱스 삭제
ALTER TABLE employee DROP INDEX dept_idx;
DROP INDEX dept_idx ON employee;


SHOW INDEX FROM employee;

-- Q3. Stored Procedure 생성
DELIMITER //

CREATE PROCEDURE addNumbers(
	IN num1 DECIMAL(10,2),
	IN num2 DECIMAL(10,2),
	OUT result DECIMAL(10,2)
)
BEGIN
		SET result = num1 + num2;
END //

DELIMITER ;

CALL addNumbers(10, 20, @sum);
SELECT @sum;

-- Q4. Stored function
DELIMITER //

CREATE FUNCTION increasePrice(
	cur_price DECIMAL(10,2),
	ratio DECIMAL(10,2)
)
RETURNS DECIMAL(10, 0)
DETERMINISTIC
BEGIN
	DECLARE result DECIMAL(10,0);
	SET result = cur_price * ratio ;
	RETURN result;
END //

DELIMITER ;

SELECT
		 menu_name '메뉴명'
	  , menu_price '기존가'
	  , truncate(increasePrice(menu_price, 1.1),-2) '예정가'
  FROM tbl_menu;



-- Q5. trigger 생성
-- 1단계 : table 생성
CREATE OR replace TABLE salary_history(
	history_id INT AUTO_INCREMENT PRIMARY KEY,
	emp_id VARCHAR(3),
	old_salary DECIMAL(10,2),
	new_salary DECIMAL(10,2),
	change_date DATETIME,
	FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

-- 2단계 : trigger 생성
DELIMITER //

CREATE TRIGGER trg_salary_update
	BEFORE UPDATE ON employee
	FOR EACH ROW
BEGIN
	IF OLD.salary <> NEW.salary THEN
		INSERT INTO salary_history(emp_id, old_salary, new_salary, change_date)
		VALUES (OLD.emp_id, OLD.salary, NEW.salary, NOW());
	END IF;
END //

DELIMITER ;

-- 3단계 : 트리거 동작하는지 확인
UPDATE
 employee
 SET salary = 5000000
WHERE emp_id = '202';
SELECT * FROM salary_history;
