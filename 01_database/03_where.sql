-- 03. where : 특정 조건에 맞는 레코드만 선택

-- 1. 비교 연산자

-- 값이 일치하는지 확인 (=)
SELECT menu_code, menu_name
FROM  tbl_menu
WHERE orderable_status = 'Y';

-- 값이 일치하지 않는지 확인 (!=, <>)
SELECT menu_code, menu_name
FROM  tbl_menu
-- WHERE orderable_status != 'Y';
WHERE orderable_status <> 'Y';

-- 대소비교 (>, >=, <, <= )
SELECT menu_name, menu_price
FROM  tbl_menu
-- WHERE orderable_status != 'Y';
WHERE menu_price > 13000;

-- 2. 논리 연산자
-- a and b : a와 b 모두 만족할 경우 true
-- 주문 가능하며 category_code가 10에 해당하는 메뉴
SELECT *
FROM tbl_menu
WHERE orderable_status = 'Y' AND category_code = 10;
-- a or b : a 또는 b 하나만 만족해도 true
-- 주문 가능하거나 혹은 category_code가 10에 해당하는 메뉴
SELECT *
FROM tbl_menu
WHERE orderable_status = 'Y' OR category_code = 10;

-- and, or 연산자 중 우선순위가 높은 연산자는? and
SELECT *
FROM tbl_menu
WHERE category_code = 4
OR menu_price = 9000
AND menu_code > 10;

SELECT *
FROM tbl_menu
WHERE (category_code = 4
OR menu_price = 9000)
AND menu_code > 10;

-- 3. between and 연산자(이상, 이하 범위)
SELECT *
FROM tbl_menu
-- WHERE menu_price >= 10000
-- AND menu_price <= 25000
WHERE menu_price BETWEEN 10000 AND 25000
ORDER BY menu_price;

-- not 연산자와 조합
SELECT *
FROM tbl_menu
WHERE menu_price NOT BETWEEN 10000 AND 25000
ORDER BY menu_price;

-- 4. like 연산자
-- 문자 포함? 어떤 문자로 시작 or  끝나는지를 확인
SELECT * FROM tbl_menu
WHERE menu_name LIKE '%마늘%'; -- 해당 키워드 포함

SELECT * FROM tbl_menu
WHERE menu_name LIKE '%아메리카노'; -- 해당 키워드로 끝남

SELECT * FROM tbl_menu
WHERE menu_name LIKE '흑%'; -- 해당 키워드로 시작

SELECT * FROM tbl_menu
WHERE menu_name LIKE '_마늘%'; -- '_'는 한 글자 자리 차지

-- '_'나 '%'와 같은 기호를 실제로 검색하고 싶을 경우에는
-- LIKE '%\_%' 또는 
-- LIKE '%!_%' ESCAPE '!'와 같은 방식으로 escape함(!를 escape문자로 설정할게요)

-- NOT 연산자와 조합
SELECT *
FROM  tbl_menu
WHERE menu_name NOT LIKE '%마늘%';

-- 메뉴 가격이 5000원이고, 카테고리 코드가 10이며,
-- 메뉴 이름에 갈치가 들어가는 메뉴의 모든 컬럼 값 조회
SELECT *
FROM tbl_menu
WHERE menu_price >= 5000 AND category_code = 10 AND menu_name LIKE '%갈치%';

-- 5. in 연산자
SELECT *
FROM tbl_menu
WHERE category_code = 4 OR category_code = 5 category_code = 6
ORDER BY category_code;

SELECT *
FROM tbl_menu
WHERE category_code IN (4, 5, 6)
ORDER BY category_code;

-- not 연산자 조합
SELECT *
FROM tbl_menu
WHERE category_code NOT IN (4, 5, 6)
ORDER BY category_code;

-- 6. is nulll : null 값 비교
SELECT *
FROM tbl_category
WHERE ref_category_code IS NULL;

-- not 연산자 사용
SELECT *
FROM tbl_category
WHERE ref_category_code IS NOT NULL;