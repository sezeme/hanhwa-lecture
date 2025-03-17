-- 08. subqueriees : 메인 쿼리 내에서 실행되는 보조 쿼리

-- '민트미역국'과 같은 카테고리인 메뉴를 조회
SELECT
		 category_code
	FROM tbl_menu
 WHERE menu_name = '민트미역국';

SELECT
		 menu_name
	FROM tbl_menu
 WHERE category_code = 4;

-- 위의 질의를 하나의 질의로 변경
SELECT
		 menu_name
	FROM tbl_menu
 WHERE category_code = (SELECT
										 category_code
									FROM tbl_menu
								 WHERE menu_name = '민트미역국');
								
-- 서브쿼리가 from절에서 사용될 경우 인라인 뷰라고 한다. 만들어진 테이블을 대상으로 select (from)
-- from절에 서브 쿼리를 사용할 경우 반드시 별칭을 작성해야 하며
-- 서브 쿼리 내부에 함수를 사용할 경우 별칭을 통해 컬럼명으로 
-- 지칭할 수 있도록 작성해야 한다.
SELECT COUNT(*) AS 'count'
FROM tbl_menu
GROUP BY category_code;

SELECT MAX(COUNT)
FROM(SELECT COUNT(*) AS 'count'
FROM tbl_menu
GROUP BY category_code) AS codemenu;

-- 상[호연]관 서브쿼리
-- : 메인 쿼리가 서브 쿼리의 결과에 영향을 주는 형태
-- 해당 카테고리 메뉴의 평균가보다 높은 가격을 가진 메뉴만 조회
SELECT menu_code, menu_name, category_code, menu_price, orderable_status
FROM tbl_menu a
WHERE menu_price > (SELECT AVG(menu_price)
							FROM tbl_menu
							WHERE category_code = a.category_code);
							
-- exists : 조회 결과가 있을 때 true, 없을 때 false
-- 메뉴 테이블에 존재하는 카테고리만 조회
SELECT category_name
FROM tbl_category a
WHERE EXISTS (SELECT 1 FROM tbl_menu b
					WHERE b.category_code = a.category_code);

-- CTE(Common Table Expression)
-- 인라인뷰로 사용되는 서브쿼리를 미리 정의해서 사용하는 문법
WITH menucate AS (
	SELECT menu_name
		  , category_name
	  FROM tbl_menu a
	  JOIN tbl_category b USING(category_code))
SELECT *
FROM menucate;




