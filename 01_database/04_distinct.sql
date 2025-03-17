-- 04. distinct : 중복 컬럼 값 제거 후 조회
SELECT category_code
FROM tbl_menu
ORDER BY category_code;

-- 메뉴 테이블에 존재하는 카테고리의 종류를 조회
SELECT DISTINCT category_code
FROM tbl_menu
ORDER BY category_code;

-- null 값이 존재하는 컬럼에 사용( null도 중복되면 하나만 사용한다. )
SELECT DISTINCT ref_category_code
FROM tbl_category
ORDER BY 1; -- 1 : select절에 나열된 컬럼의 순번

-- 다중열에 distinct 사용
SELECT DISTINCT category_code, orderable_status  -- 두 개 컬럼 조합했을 때 중복되는 것을 제거
FROM tbl_menu;

SELECT category_code, orderable_status
FROM tbl_menu;

-- group by 역시 중복 제거하는 방법 중 하나
SELECT category_code, orderable_status
FROM tbl_menu
GROUP BY category_code;

SELECT distinct category_code
FROM tbl_menu;