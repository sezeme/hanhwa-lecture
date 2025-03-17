-- 07. grouping

-- group by : 결과 집합을 특정 열의 값에 따라 그룹화
-- having : group by 절과 함께 사용하며 그룹의 조건을 적용

-- 그룹 함수 : count, sum, average, min, max

-- group by : distinct와 같은 효과
SELECT *
FROM tbl_menu
GROUP BY category_code;

SELECT category_code, COUNT(*)
FROM tbl_menu
GROUP BY category_code;

-- count 함수의 특성
SELECT
	  COUNT(*) -- '*' 모든 행
	, COUNT(category_code) -- 컬럼명 기재 시 
	, COUNT(ref_category_code) -- null 값은 카운트하지 않음
FROM tbl_category;

-- sum
SELECT category_code, SUM(menu_price)
FROM tbl_menu
GROUP BY category_code;

-- avg
SELECT category_code, AVG(menu_price)
FROM tbl_menu
GROUP BY category_code;

-- min, max는 모든 데이터 타입을 대상으로 사용 가능
SELECT MIN(emp_name), MAX(emp_name), MIN(hire_date), MAX(hire_date)
FROM employee;

-- group by 에서 2개 이상의 그룹 생성
SELECT menu_price, category_code, COUNT(*)
FROM tbl_menu
GROUP BY menu_price, category_code;

-- 카테고리별로 메뉴 가격 평균이 10000원 이상인 카테고리의
-- 카테고리 코드, 카테고리명, 평균 메뉴 가격 조회
SELECT a.category_code, b.category_name, AVG(menu_price)
FROM tbl_menu a
JOIN tbl_category b USING(category_code)
-- where
GROUP BY category_code, category_name -- 일치시켜줘야 함
HAVING AVG(a.menu_price) >= 10000; -- ~~별 조건
-- order by 절은 항상 맨 끝에!!

--    작성 순서
-- 6 select : 조회 컬럼
-- 1 from : 조회 대상 테이블
-- 2 join : 조회 대상 테이블
-- 3 where : 테이블 행을 조건으로 필터링
-- 4 group by : 대상 컬럼으로 결과 집합 그룹핑
-- 5 having : 그루핑 결과를 조건으로 필터링
-- 7 order by : 정렬 기준

--    접근 순서
-- 1. FROM
-- 2. JOIN
-- 3. WHERE // 조건에 맞는 행만 걸러옴
-- 4. GROUP BY -> HAVING
--    행들을 골라내는 작업
-- 5. SELECT
-- 6. ORDER by by

-- rollup : 중간 집계 함수로 group by 함수와 함께 사용
-- group by 절의 첫 번쨰 기준 컬럼에 대한 중간 집게 + 총 집계 값이
-- result set에 포함된다.
SELECT
		 category_code
		, SUM(menu_price)
  FROM tbl_menu
GROUP BY category_code
  WITH ROLLUP; -- 기준삼아 그룹핑한 컬럼의 합계 행 추가

SELECT
		 menu_price
		, category_code
		, SUM(menu_price)
  FROM tbl_menu
GROUP BY menu_price, category_code
  WITH ROLLUP; -- 앞에 서술한 컬럼 기준 중간집계 값을 구해줌


