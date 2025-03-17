-- 실습 : DDL / DML
-- Q1.다음 논리ERD와 물리ERD를 참고하여, 아래 조건을 만족하는 테이블을 생성하는 DDL 구
-- 문을 작성하세요.


DROP TABLE member_info;
DROP TABLE team_info;

CREATE TABLE team_info(
	team_code INT AUTO_INCREMENT COMMENT '소속코드',
	team_name VARCHAR(100) not null COMMENT '소속명',
	team_detail VARCHAR(500) COMMENT '소속상세정보',
	USE_YN CHAR(2) NOT NULL DEFAULT 'Y' COMMENT '사용여부' CHECK(USE_YN IN ('Y','N')) ,
	PRIMARY KEY(team_code)
);

CREATE TABLE member_info(
  member_code INT auto_increment COMMENT '회원코드',
  member_name VARCHAR(70) NOT NULL COMMENT '회원이름',
  birth_date DATE COMMENT '생년월일',
  division_code CHAR(2) COMMENT '구분코드',
  detail_info VARCHAR(500) COMMENT '상세정보',
  contact VARCHAR(50) NOT NULL COMMENT '연락처',
  team_code INT NOT NULL COMMENT '소속코드',
  active_status CHAR(2) NOT NULL DEFAULT 'Y' COMMENT '활동상태' CHECK(active_status IN ('Y','N','H')),
  PRIMARY KEY(member_code),
  FOREIGN KEY (team_code) REFERENCES team_info(team_code)
  ON UPDATE CASCADE ON DELETE CASCADE
);

-- Q2. Q1에서 생성한 TEAM_INFO 테이블과 MEMBER_INFO 테이블에 아래와 같이 데이터를
-- INSERT하는 쿼리를 작성하세요.

-- team_info insert
INSERT
  INTO team_info
VALUES
(NULL, '음악감상부', '클래식 및 재즈 음악을 감상하는 사람들의 모임', 'Y'),
(NULL, '맛집탐방부', '맛집을 찾아다니는 사람들의 모임', 'N'),
(NULL, '행복찾기부',NULL , DEFAULT);

-- team_info table USE_YN 컬럼에 not null 설정 추가
-- ALTER TABLE team_info
-- CHANGE COLUMN USE_YN use_yn CHAR(2) NOT NULL DEFAULT 'Y' COMMENT '사용여부' CHECK(use_yn IN ('Y','N')); 

-- 행 삭제
-- DELETE FROM team_info
-- WHERE team_code IN (6,7);

-- member_info insert
INSERT
  INTO member_info
VALUES
(NULL, '송가인', '1990-01-30', 1, '안녕하세요 송가인입니다~', '010-9494-9494', 1, 'H'),
(NULL, '임영웅', '1992-05-03', NULL, '국민아들 임영웅입니다~', 'hero@trot.com',1,DEFAULT),
(NULL, '태진아', NULL, NULL,NULL,'(1급기밀)',3,DEFAULT);

-- team_info의 team_code 변경 : cascade나 null, default 등의 외래키 제약조건이 있어야 가능
-- 1. foreign key 이름 찾기
SELECT CONSTRAINT_NAME 
FROM information_schema.TABLE_CONSTRAINTS 
WHERE TABLE_NAME = 'member_info' 
AND CONSTRAINT_TYPE = 'FOREIGN KEY';

-- 2. foreign key 제약조건 삭제
ALTER TABLE member_info
DROP FOREIGN KEY member_info_ibfk_1;

-- 3. foreign key 제약조건 추가
ALTER TABLE member_info
add FOREIGN KEY (team_code) REFERENCES team_info(team_code) on UPDATE CASCADE on DELETE CASCADE;

-- 4. team_info의 team_code 변경tbl_menu
UPDATE team_info
   SET team_code = 3
WHERE team_name = '행복찾기부';


