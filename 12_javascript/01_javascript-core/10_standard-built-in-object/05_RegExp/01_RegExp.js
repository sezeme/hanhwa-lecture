// 정규 표현식(Regular Expression)은 일정한 패턴을 가진 문자열의 집합을
// 표현하기 위해 사용하는 형식 언어(format language)이다.

// 검색 대상
const target = 'JavaScript';

// 1. 정규 표현식 리터럴 - /pattern/플래그
let regExp = /j/i;  //패턴 : j, 플래그 : i => 대소문자 구별 없이

// 2. RegExp 생성자 함수 - new RegExp(pattern[, flag])
regExp = new RegExp('j', 'i');
regExp = new RegExp(/j/, 'i');
regExp = new RegExp(/j/i);  //ES6부터 가능한 표현

// test 메서드 - target 문자열에 대해 정규 표현식의 패턴을 검색하여 매칭 결과를 boolean으로 반환
console.log(regExp.test(target));