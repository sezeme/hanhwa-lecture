// ES6에서는 var 키워드의 단점을 보완하기 위해 let, const 를 도입했다.

// 1. 변수 중복 선언 금지
let msg = '안녕하세요';
// let msg = '안녕히가세요';
console.log(msg);

// 2. 블록 레벨 스코프
let i = 0;
for(let i = 0; i < 10; i++){}
console.log(i);

// 3. 변수 호이스팅
// console.log(x);
let x;