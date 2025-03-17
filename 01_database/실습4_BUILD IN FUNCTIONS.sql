-- 실습4 build in functions

-- Q1.
SELECT 
	EMP_NAME, 
	CONCAT(SUBSTRING(PHONE, 1,3), '-', SUBSTRING(phone, 4,4), '-', SUBSTRING(phone,8,4))
  FROM employee a
WHERE a.PHONE LIKE '010%';

-- Q2.
SELECT  a.emp_name 직원명
	   , CONCAT(year(a.HIRE_DATE),'년',MONTH(a.hire_date),'월',DAYOFMONTH(a.HIRE_DATE),'일') 입사일
		, format(a.SALARY, 0) 급여
  FROM employee a
 WHERE datediff(NOW(),a.hire_date) >= (20 * 365)
 ORDER BY hire_date, SALARY DESC;

-- Q3. ??
SELECT a.EMP_NAME, 
		 FORMAT(a.SALARY,0) SALARY, 
		 CONCAT(TRUNCATE(a.BONUS*100,0), '%') BONUS, 
		 FORMAT(ROUND(a.salary * (1 + IFNULL(bonus,0))),0) 'TOTAL_SALARY'
  FROM employee a
 ORDER BY TOTAL_SALARY DESC;

-- Q4
SELECT a.EMP_NAME, LPAD(a.email,  (SELECT MAX(LENGTH(email)) FROM employee), ' ') EMAIL
  FROM employee a;

-- Q5
SELECT  CONCAT(a.emp_name, ' ', b.job_name,'님') NAME_TAG
		, RPAD(SUBSTRING(a.EMP_NO,1,8), 14, '*') EMP_NO
		, CONCAT(e.NATIONAL_NAME,'지사 ', c.DEPT_TITLE, ' 소속') BELONG
		, f.EMP_NAME MANAGER_NAME
  FROM employee a
  JOIN job b ON a.JOB_CODE = b.JOB_CODE
  JOIN department c ON a.DEPT_CODE = c.DEPT_ID
  JOIN location d ON c.LOCATION_ID = d.LOCAL_CODE
  JOIN national e ON d.NATIONAL_CODE = e.NATIONAL_CODE
  LEFT JOIN employee f ON a.MANAGER_ID = f.EMP_ID
 ORDER BY MANAGER_NAME ASC;




