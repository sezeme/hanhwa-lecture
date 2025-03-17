-- 15. build in functions (내장 함수)

-- (1) 문자열 관련 함수

-- ASCII(아스키코드), CHAR(숫자)
SELECT ASCII('A'), CHAR(65);

-- bit : bit 수, char : 문자 수, length : byte 수
SELECT BIT_LENGTH('pie'), CHAR_LENGTH('pie'), LENGTH('pie');

-- 한글 값은 저장 시 3byte
SELECT BIT_LENGTH(menu_name), CHAR_LENGTH(menu_name), LENGTH(menu_name)
  FROM tbl_menu;
  
-- concat(문자열1, 문자열2, ...)
-- concat_ws(구분자, 문자열1, 문자열2, ...)
SELECT CONCAT('호랑이', '기린', '토끼');
SELECT CONCAT_WS(',', '호랑이', '기린', '토끼');  

-- 문자 탐색 시 사용 될 수 있는 함수들   
SELECT 
       ELT(2, '사과', '딸기', '바나나') 
		 -- 첫번째 인자인 숫자 위치에 있는 문자 반환
     , FIELD('딸기', '사과', '딸기', '바나나')
       -- 첫번째 인자인 문자가 있는 위치의 숫자 반환
     , FIND_IN_SET('바나나', '사과,딸기,바나나')
       -- 첫번째 인자인 문자가 셋 안에서 있는 위치 숫자 반환
     , INSTR('사과딸기바나나', '딸기')
       -- 두번째 인자인 문자가 첫번째 인자 문자열 내부에서의 시작 위치 반환
     , LOCATE('딸기', '사과딸기바나나');
       -- INSTR과 인자 순서만 반대 
  
-- format(숫자, 소수점 자리수)
SELECT FORMAT(123123123123.567567, 3);

-- bin : 2진수, oct : 8진수, hex : 16진수
SELECT BIN(65), OCT(65), HEX(65);

-- insert
SELECT INSERT('내 이름은 아무개입니다.', 7, 3, '홍길동');

-- left, right
SELECT LEFT('Hello World!', 3), RIGHT('Hello World!', 3);

-- upper, lower
SELECT UPPER('Hello World!'), LOWER('Hello World!');

-- lpad, rpad
SELECT LPAD('왼쪽', 6, '@'), RPAD('오른쪽', 6, '@');

-- ltrim, rtrim
SELECT LTRIM('   왼쪽   '), RTRIM('   오른쪽   ');

-- trim
-- both, leading, trailing
SELECT TRIM('   mariadb   '), TRIM(BOTH '@' FROM '@@@mariadb@@@');

-- repeat
SELECT repeat('재밌어', 3);

-- replace
SELECT REPLACE('마리아db', '마리아', 'maria');

-- reverse
SELECT REVERSE('hello');

-- space
SELECT CONCAT('제 이름은', SPACE(5), '이고 나이는', SPACE(3), '세 입니다.');

-- substring
SELECT 
       SUBSTRING('안녕하세요 반갑습니다.', 7, 2)
     , SUBSTRING('안녕하세요 반갑습니다.', 7);

-- substring_index
SELECT 
       SUBSTRING_INDEX('hong.test@gmail.com', '.', 2)
     , SUBSTRING_INDEX('hong.test@gmail.com', '.', -2);

-- (2) 숫자 관련 함수

-- abs
SELECT ABS(123), ABS(-123); 

-- ceiling(올림), floor(내림), round(반올림)
SELECT CEILING(1234.34), FLOOR(1234.56), ROUND(1234.56);

-- conv(변환대상숫자, 원래진수, 변환할진수)
SELECT CONV('A', 16, 10), CONV('A', 16, 2), CONV(1010, 2, 8);

-- mod
SELECT MOD(75, 10), 75 % 10, 75 MOD 10;

-- pow : 거듭제곱 , sqrt : 제곱근
SELECT POW(2, 4), SQRT(16);

-- rand : 0 이상 1 미만의 임의의 실수 반환
SELECT RAND();
-- m <= 임의의 정수 < n 을 구하고 싶다면 FLOOR(RAND() * (n - m) + m)
SELECT FLOOR(RAND() * (11 - 1) + 1);

-- sign (음수인지 양수인지 알려줌)
SELECT SIGN(10.1), SIGN(0), SIGN(-10.1);

-- truncate
SELECT TRUNCATE(12345.12345, 2), TRUNCATE(12345.12345, -2); 

-- (3) 날짜/시간 관련 함수

-- adddate, subdate
SELECT 
       ADDDATE('2023-05-31', INTERVAL 30 DAY)
     , ADDDATE('2023-05-31', INTERVAL 6 MONTH)
     , ADDDATE('2023-05-31', INTERVAL 1 YEAR)
     , SUBDATE('2023-05-31', INTERVAL 30 DAY)
     , SUBDATE('2023-05-31', INTERVAL 6 MONTH)
     , SUBDATE('2023-05-31', INTERVAL 1 YEAR);

-- addtime, subtime
SELECT 
       ADDTIME('2023-05-31 09:00:00', '1:0:1')
     , SUBTIME('2023-05-31 09:00:00', '1:0:1');

-- 현재 시스템 날짜/시간 반환
SELECT CURDATE(), CURRENT_DATE(), CURRENT_DATE;
SELECT CURTIME(), CURRENT_TIME(), CURRENT_TIME;
SELECT NOW(), LOCALTIME, LOCALTIME(), LOCALTIMESTAMP, LOCALTIMESTAMP();

-- year, month, dayofmonth
SELECT YEAR(CURDATE()), MONTH(CURDATE()), DAYOFMONTH(CURDATE());
-- hour, minute, second, microsecond
SELECT HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURTIME()), 
MICROSECOND(CURTIME(6));
-- date, time
SELECT DATE(NOW()), TIME(NOW());

-- datediff, timediff
SELECT DATEDIFF('2023-05-31', '2023-02-27')
     , TIMEDIFF('17:07:11', '13:06:10');
     
-- dayofweek, monthname, dayofyear
SELECT DAYOFWEEK(CURDATE()), MONTHNAME(CURDATE()), DAYOFYEAR(CURDATE());     
     
-- last_day (해당 달의 마지막 날짜)
SELECT LAST_DAY('2023-02-01');
     
-- makedate, maketime
SELECT MAKEDATE(2023, 32), MAKETIME(17, 03, 02);     
     
-- quarter
SELECT QUARTER('2023-05-01');
     
-- time_to_sec
SELECT TIME_TO_SEC('1:1:1');
     