-- 1. 대여

-- (1) 대여하려는 도서가 대여 가능 상태인지 확인
SELECT available
  FROM books
 WHERE book_id = 3 AND IS_DELETED = 'N';
-- (2) 미납 연체료가 있는지 확인
SELECT COUNT(*)
  FROM fines f
  JOIN rentals r ON f.rental_id = r.rental_id
 WHERE r.user_id = 2 AND f.paid = 'N' AND  f.is_deleted = 'N';
-- (3) 현재 대여중인 도서 개수 확인 (최대 5권까지 가능)
-- (4) 현재 연체중인 도서가 있는지 확인
SELECT COUNT(*)
  FROM rentals r
  JOIN rental_books rb ON r.rental_id = rb.rental_id
 WHERE r.user_id = 1 AND r.return_date IS NULL;
 
-- (4) rentals 와 rental_books에 데이터 삽입
INSERT
  INTO rentals ( user_id, rental_date, due_date )
VALUES (1, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY));

-- 마지막으로 발생한 auto_increment 값을 조회하는 방법
SELECT LAST_INSERT_ID();

INSERT
  INTO rental_books ( rental_id, book_id )
VALUES (LAST_INSERT_ID() , 3);
 
-- (5) 대여한 책을 대여중으로 상태 변경
UPDATE books
   SET available = 'N'
 WHERE book_id = 3;
 
 
-- 2. 반납
-- 근데 연체하고 반납도 안했으면서 다시 빌리려고 하는경우는 어떻게 하지?
-- 반납 일자 초과하면 바로 fine에 추가되어야하는거 아닌가?


-- (1) 연체 확인과 관련된 stored function과 trigger 설정
-- (1-1) CalculateFine 저장 함수
DELIMITER //

CREATE or replace FUNCTION CalculateFine(
	rentalID INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
	DECLARE overdue_days DECIMAL(10,2); -- 연체일
	DECLARE totalFine DECIMAL(10,2);
	
	SELECT DATEDIFF(CURDATE(), due_date) INTO overdue_days
	  FROM rentals r
	 WHERE r.rental_id = rentalID;
	
	IF overdue_days > 0 THEN
		SELECT SUM(daily_fine * overdue_days) INTO totalFine 
		  FROM fine_rates f
		 WHERE f.min_days <= overdue_days 
		   AND (f.max_days >= overdue_days OR f.max_days IS NULL);
	END IF;
	
	RETURN IFNULL(totalFine,0);
END //

DELIMITER ;

-- 함수 호출 테스트
SELECT rental_id, CalculateFine(rental_id) FROM rentals;

-- (1-2) AddFineAfterDueDate 트리거
-- 위에서 작성한 저장 함수를 통해서 fine_amount를 계산하고 fines에 삽입
DELIMITER //

CREATE TRIGGER AddFineAfterDueDate
AFTER UPDATE ON rentals
FOR EACH ROW
BEGIN
	DECLARE totalFine DECIMAL(10,2);
	SET totalFine = CalculateFine(NEW.rental_id); -- 바뀌는 값
	IF OLD.return_date IS NULL AND NEW.return_date IS NOT NULL
	AND OLD.due_date < NEW.return_date THEN
		INSERT
		  INTO fines (rental_id, fine_amount)
		VALUES (NEW.rental_id, CalculateFine(NEW.rental_id));
	END IF;

END //

DELIMITER ;

-- Q 근데 fine요금 추가 시점이 반납할 때가 맞나?? 실제 연체 일자를 기준으로 해야하는거 아닌가?
-- (2) rentals 테이블의 return_date 수정 => 해당 시점에 트리거 동작
UPDATE rentals
   SET return_date = CURDATE()
 WHERE rental_id = 6;


-- (3) books 테이블의 available 수정
UPDATE books
   SET available = 'Y'
 WHERE book_id IN (
  SELECT book_id FROM rental_books WHERE rental_id = 6
 );
 
 
 
 
 
 
 
 
 
 
 
 
 
 