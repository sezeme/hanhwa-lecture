// ES5까지 변수를 선언할 수 있는 유일한 방법은 var 키워드를 사용하는 것이었으나
// 이는 몇 가지 문제점이 있었다.

// 1. 동일 스코프 내 중복 변수 선언 가능
var msg = '안녕하세요';
console.log(msg);
var msg = '안녕히가세요';
console.log(msg);

// 2. 함수 레벨 스코프를 가짐

// 3. 변수 호이스팅
console.log(test);
test = '반갑습니다';
console.log(test);
var test; // 변수 선언이 맨 위로 끌어올려진 것 처럼 동작한다.