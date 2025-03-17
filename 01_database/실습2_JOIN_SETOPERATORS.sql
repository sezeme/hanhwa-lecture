-- 1. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.(1행)
SELECT a.EMP_ID, a.EMP_NAME, b.DEPT_TITLE
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
WHERE a.EMP_NAME LIKE '%형%';

-- 2. 해외영업팀에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.(9행)
SELECT a.EMP_NAME, c.job_name, a.DEPT_CODE, b.DEPT_TITLE
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
JOIN job c ON a.JOB_CODE = c.job_code
WHERE b.DEPT_TITLE LIKE '해외%';

-- 3. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.(8행)
-- (INNER JOIN 결과)
SELECT a.EMP_NAME, a.BONUS, b.DEPT_TITLE, c.LOCAL_NAME
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
JOIN location c ON b.LOCATION_ID = c.LOCAL_CODE
WHERE a.BONUS IS NOT NULL;

-- 4. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.(3행)
SELECT a.EMP_NAME, b.job_name, c.DEPT_TITLE, d.LOCAL_NAME
FROM employee a
JOIN job b ON a.JOB_CODE = b.JOB_CODE
JOIN department c ON a.DEPT_CODE = c.DEPT_ID
JOIN location d ON c.LOCATION_ID = d.LOCAL_CODE
WHERE a.DEPT_CODE = 'D2';


-- 5. 급여 테이블의 등급별 최소급여(MIN_SAL)보다 많이 받는 직원들의
-- 사원명, 직급명, 급여, 연봉을 조회하시오.
-- 연봉에 보너스포인트를 적용하시오.(20행)
SELECT a.EMP_NAME, b.job_name, a.SALARY, a.SALARY * ( 1 + IFNULL(a.BONUS,0)) * 12 연봉
FROM employee a
JOIN job b ON a.JOB_CODE = b.JOB_CODE
JOIN sal_grade c USING(sal_level)
-- WHERE a.SALARY > (SELECT min_sal FROM sal_grade WHERE sal_level = a.SAL_LEVEL);
WHERE a.SALARY > c.min_sal;

-- !! where에서 변수끼리 비교하면 같은 행에서 컬럼값끼리 비교가 된다.

-- 6. 한국(KO)과 일본(JP)에 근무하는 직원들의 
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.(15행)
SELECT a.emp_name, b.dept_title, c.local_name, d.national_name
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
JOIN location c ON b.LOCATION_ID = c.LOCAL_CODE
JOIN NATIONAL d ON c.NATIONAL_CODE = d.NATIONAL_CODE
WHERE c.NATIONAL_CODE IN ('KO','JP');

-- 7. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, join과 IN 사용할 것(8행)
SELECT a.emp_name, b.job_name, a.SALARY
FROM employee a
JOIN job b ON a.JOB_CODE = b.JOB_CODE
WHERE a.BONUS IS NULL AND a.JOB_CODE IN ('J4','J7');

-- 8. 직급이 대리이면서 아시아 지역(ASIA1, ASIA2, ASIA3 모두 해당)에 근무하는 직원 조회(2행)
-- 사번(EMPLOYEE.EMP_ID), 이름(EMPLOYEE.EMP_NAME), 직급명(JOB.JOB_NAME), 부서명(DEPARTMENT.DEPT_TITLE),
-- 근무지역명(LOCATION.LOCAL_NAME), 급여(EMPLOYEE.SALARY)를 조회하시오.
-- (해당 컬럼을 찾고, 해당 컬럼을 지닌 테이블들을 찾고, 테이블들을 어떤 순서로 조인해야 하는지 고민하고 SQL문을 작성할 것)
SELECT a.EMP_ID, a.EMP_NAME, b.JOB_NAME, c.DEPT_TITLE, d.LOCAL_NAME, a.SALARY
FROM employee a
JOIN job b ON a.JOB_CODE = b.JOB_CODE
JOIN department c ON a.DEPT_CODE = c.DEPT_ID
JOIN location d ON c.LOCATION_ID = d.LOCAL_CODE
WHERE b.JOB_NAME = '대리' AND d.LOCAL_NAME LIKE 'ASIA%';
   
-- 9. 각 부서별 평균 급여와 직원 수를 조회하시오. (NULL 급여는 제외) 
-- 평균 급여가 높은 순으로 정렬하시오. (6행)
SELECT AVG(SALARY), COUNT(*)
FROM employee a
GROUP BY a.DEPT_CODE
HAVING dept_code IS NOT NULL
ORDER BY AVG(a.SALARY) DESC;
 
-- 10. 직원 중 보너스를 받는 직원들의 연봉 총합이 1억 원을 
-- 초과하는 부서의 부서명과 연봉 총합을 조회하시오. (1행)
SELECT sum(a.salary * (1 + IFNULL(a.bonus,0)) * 12) '연봉 총합', b.dept_title
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
WHERE a.bonus IS NOT NULL
GROUP BY a.dept_code
HAVING sum(a.salary * (1 + IFNULL(a.bonus,0)) * 12) > 100000000;
 
-- 11. 국내 근무하는 직원들 중 평균 급여 이상을 받는 
-- 직원들의 사원명, 급여, 부서명을 조회하시오. (서브쿼리 사용) (4행)
SELECT a.EMP_NAME, a.SALARY, b.DEPT_TITLE
FROM employee a
JOIN department b ON a.DEPT_CODE = b.DEPT_ID
JOIN location c ON b.LOCATION_ID = c.LOCAL_CODE
WHERE a.salary >= (
		SELECT AVG(salary)
		FROM employee
		WHERE salary IS NOT null
		)
	AND c.national_code = 'KO';
-- 	(SELECT AVG(salary) FROM employee WHERE dept_id IN -- 국내 근무하는 부서의 급여 평균
-- 		(SELECT dept_id from department where location_id = -- 국내 근무하는 부서 id
-- 			(SELECT LOCAL_CODE FROM location WHERE NATIONAL_CODE = 'KO'))); -- 'KO'의 지역 코드
-- 


-- 12. 모든 부서의 부서명과 해당 부서에 소속된 직원 수를 조회하시오. 
-- 직원이 없는 부서도 함께 표시하시오. (9행)
SELECT a.DEPT_TITLE, COUNT(*) -- COUNT에도 '*'은 가급적 쓰지 않기
FROM department a
LEFT JOIN employee b ON a.DEPT_ID = b.DEPT_CODE
GROUP BY a.DEPT_ID;

-- 13. 차장(J4) 이상 직급을 가진 직원과 사원(J7) 직급을 가진 
-- 직원들의 급여 합계를 비교하여 결과를 출력하시오. (SET OPERATOR 사용) (2행)
SELECT '차장 이상' as 구분, SUM(a.salary) AS 급여합계
FROM employee a
WHERE a.job_code IN ('J1','J2','J3','J4')
UNION
SELECT '사원' as 구분, SUM(a.salary) AS 급여합계
FROM employee a
WHERE a.job_code IN ('J7');
