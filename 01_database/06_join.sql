-- 06. join
SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;

-- 조인의 종류
-- 1. inner join : 두 테이블의 교집합을 반환
-- (1) on : 
SELECT menu_name, category_name
FROM tbl_menu AS a
JOIN tbl_category AS b ON a.category_code = b.category_code;

-- (2) using : join할테이블의 컬럼명이 동일한 경우만 사용
SELECT a.menu_name, b.category_name
FROM tbl_menu a
JOIN tbl_category b USING (category_code);

-- employee와 department join
SELECT a.emp_name, b.dept_title
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID;
-- inner join은 교집합만 반환하므로 겹치지 않는 값은 view에 들어가지 않는다.

-- 2. left [outer] join
-- : 왼쪽 테이블의 모든 레코드와 오른쪽 테이블에서 일치하는 레코드(행)를 반환
SELECT a.emp_name, b.dept_title
FROM employee a
LEFT JOIN department b ON a.DEPT_CODE = b.DEPT_ID;

-- 3. right [outer] join
-- : 오른쪽 테이블의 모든 레코드와 왼쪽 테이블에서 일치하는 레코드(행)를 반환
SELECT a.emp_name, b.dept_title
FROM employee a
RIGHT JOIN department b ON a.DEPT_CODE = b.DEPT_ID;

-- 4. cross join : 두 테이블의 가능한 모든 조합을 반환하는 조인
-- 카티션 프로덕트
SELECT 
       a.menu_name
     , b.category_name
  FROM tbl_menu a
 CROSS JOIN tbl_category b;

-- 5. self join : 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해
-- 사용되는 유형의 조인
SELECT a.category_name 하위분류, b.category_name 상위분류
FROM tbl_category a
JOIN tbl_category b ON a.ref_category_code = b.category_code;

-- employeedb 사원명, 관리자명 self join
SELECT a.EMP_NAME 사원명, b.EMP_NAME 관리자명
FROM employee a
left JOIN employee b ON a.MANAGER_ID = b.EMP_ID;

-- employeedb에서 다중 테이블 join
-- 사원명, 부서명, 직급명 조회
SELECT a.emp_name, b.dept_title, c.job_name
FROM employee a
left JOIN department b ON a.dept_code = b.dept_id
JOIN job c ON a.job_code = c.job_code;

-- 사원명, 근무 지역명, 근무 국가명 조회
SELECT a.emp_name, b.local_name, c.national_name
FROM employee a
JOIN department b ON	a.dept_code = b.dept_id
JOIN location c ON b.LOCATION_ID = c.LOCAL_CODE
JOIN NATIONAL d ON c.NATIONAL_CODE = d.NATIONAL_CODE;

