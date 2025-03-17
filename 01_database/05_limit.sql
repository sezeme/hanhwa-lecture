-- 05. limit : select 문의 결과 집합에서 반환할 행의 갯수 제한
SELECT menu_code, menu_name, menu_price
FROM tbl_menu
ORDER BY menu_price;

SELECT menu_code, menu_name, menu_price
FROM tbl_menu
ORDER BY menu_price
LIMIT 1, 4;
-- [offset] : 시작할 행의 번호(인덱스), 0부터
-- row_count : 이후 행부터 반환

-- offset은 생략이 가능하며 row_count만 입력하면 top-n 행 반환
SELECT menu_code, menu_name, menu_price
FROM tbl_menu
ORDER BY menu_price
LIMIT 5;