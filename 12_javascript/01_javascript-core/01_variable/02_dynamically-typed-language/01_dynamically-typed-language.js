// JavaScript는 동적 타입 언어이다.
// => 데이터 타입을 사전에 선언하지 않는다.
// => 변수 선언이 아니라 할당에 의해 타입이 결정 되며
// 재할당에 의해 동적으로 변수의 타입이 변화할 수 있다.
var test;
console.log(typeof test);

test = 1;
console.log(typeof test);

test = 'JavaScript';
console.log(typeof test);

test = true;
console.log(typeof test);

test = null;
console.log(typeof test);   //object
// 자바스트립트 첫 번째 버전의 버그이지만 기존 코드에 영향을 줄 수 있어 아직까지 수정되지 못하고 있다.

test = Symbol();
console.log(typeof test);

test = {};  //객체
console.log(typeof test);

test = [];  //배열
console.log(typeof test);

test = function(){};  //함수
console.log(typeof test);   //function(object의 한 종류)