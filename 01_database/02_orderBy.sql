-- 02. order by : result set을 정렬(select문으로 조회한 결과)

SELECT
		 menu_code
		 , menu_name
		 , menu_price
	FROM tbl_menu
-- 	ORDER BY menu_price ASC; --asc는 오름차순 (default)
		ORDER BY menu_price DESC; -- desc는 내림차순

-- 정렬 기준 상 동일한 값이 있을 때
-- 그 다음 정렬 기준을 세울 수 있음	

SELECT
		 menu_code
		 , menu_name
		 , menu_price
	FROM tbl_menu
	ORDER BY menu_price DESC, menu_code;
	
-- order by절 뒤에 컬럼명 외에 연산 결과, 별칭 등을 사용할 수 있음
SELECT
		 menu_code
		 , menu_name
		 , menu_price * menu_code
	FROM tbl_menu
	ORDER BY menu_price * menu_code;
	
SELECT
		 menu_code '메뉴코드'
		 , menu_name '메뉴명'
		 , menu_price * menu_code '연산결과'
	FROM tbl_menu
	ORDER BY '연산결과';
	
-- field 함수
-- 첫번째 인자로 나온 값이 뒤에 쭉 몇 번째에 나오는건지
-- 내가 정렬하고 싶은 데이터의 순서가 있을 때, 이 함수와 함께  커스텀 ORDER BY 사용 가능.
SELECT FIELD('A', 'A', 'B', 'C');
SELECT FIELD('B', 'A', 'B', 'C');
SELECT FIELD('C', 'A', 'B', 'C');

-- field 함수를 활용하면 정렬 데이터 기준을 설정할수 있음.
SELECT
		 menu_name
		,orderable_status
		,FIELD(orderable_status, 'Y', 'N')
	FROM tbl_menu
 ORDER BY FIELD(orderable_status, 'Y','N');
 
 -- null 값의 정렬 방식
 SELECT
 		 category_code
 		, category_name
 		, ref_category_code
	FROM tbl_category
-- ORDER BY ref_category_code ASC;
-- ORDER BY ref_category_code DESC; 
-- ORDER BY -ref_category_code DESC; 
ORDER BY -ref_category_code; 
-- 오름차순일 땐 맨 위 null 값
-- 내림차순일 땐 맨 아래 null 값
