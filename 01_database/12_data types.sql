-- 12. data types

-- (1) 명시적 형변환
SELECT AVG(menu_price) FROM tbl_menu;
-- ANSI 표준 : cast
SELECT CAST(AVG(menu_price) AS SIGNED INTEGER)
AS '평균 메뉴 가격' FROM tbl_menu;

SELECT CAST('2023$5$30' AS DATE);
SELECT CAST('2023/5/30' AS DATE);
SELECT CAST('2023%5%30' AS DATE);
SELECT CAST('2023@5@30' AS DATE);

-- 메뉴 가격 구하기
SELECT CAST(menu_price AS CHAR(5)) FROM tbl_menu;
SELECT CONCAT(CAST(menu_price AS CHAR(5)), '원') FROM tbl_menu;


-- (2) 암시적 형변환
SELECT '1' + '2'; -- 각 문자가 정수로 변환됨
SELECT CONCAT(menu_price, '원') FROM tbl_menu; -- menu_price가 문자로 변환된다
SELECT 3 > 'MAY'; -- 문자는 0으로 변환된다.
-- true : 1, false or 형변환 불가 : 0

SELECT 7 > '6MAY'; -- 문자에서 첫번째로 나온 숫자는 정수로 전환된다.
SELECT 5 > 'M6AY'; -- 숫자가 뒤에 나오면 문자로 인식되어 0으로 젼환된다
SELECT hire_Date > '2000-5-30'
FROM employee; -- 날짜형으로 바뀔 수 있는 문자는 바뀌어 계산된다.




