/* flag의 종류
* i(ignore case) : 대소문자 구별 않고 패턴 검색
* g(global) : 대상 문자열 내에서 패턴과 일치하는 모든 문자열을 전역 검색
* flag는 옵션이므로 선택적으로 사용하며, 순서와 상관 없이 하나 이상의 플래그를 동시 설정 가능
* */

let target = 'Java JavaScript';

console.log(target.match(/VA/));
console.log(target.match(/VA/i));
console.log(target.match(/VA/ig));
console.log('----------------------------');

/* pattern
* 패턴은 특별한 의미를 가지는 메타문자 또는 기호로 표현할 수 있다.
* */

// . : 임의의 문자열
target = 'abcdefg';
console.log(target.match(/../g));   // 임의의 2자리 문자열 전역 검색
console.log('----------------------------');

// {m,n} : 최소 m번, 최대 n번 반복 되는 문자열 (반복 검색)
target = 'a aa aaa b bb bbb ab aab abb';
console.log(target.match(/a{2,3}/g));   // a 최소 2번 ~ 최대 3번 반복
console.log(target.match(/b{2}/g));   // b 두 번 반복
console.log(target.match(/b{3,}/g));   // b 3번 이상 반복
console.log('----------------------------');

// + : 앞선 패턴이 최소 한 번 이상 반복 되는 문자열(반복 검색)
// +는 {1,}과 같다.
console.log(target.match(/b+/g));
console.log('----------------------------');

// ? : 앞선 패턴이 최대 한 번(0번 포함) 포함 되는 문자열
// ?는 {0,1}과 같다.
target = 'soul seoul';
console.log(target.match(/se?oul/g)); // e는 없어도 됨
console.log('----------------------------');

// | : or
target = 'ab aa bb cc dd 123 456 @';
console.log(target.match(/a|b/g));
console.log(target.match(/a+|b+/g));
// [] 내의 문자는 or로 동작
console.log(target.match(/[abc]+/g));
// 범위를 지정하려면 - 사용
console.log(target.match(/[a-z]+/g));
// 대소문자 범위
console.log(target.match(/[A-Za-z]+/g));
// 숫자 범위
console.log(target.match(/[0-9]+/g));
console.log('----------------------------');

// \d : 숫자
// \D : 숫자가 아닌 문자
console.log(target.match(/\d+/g));
console.log(target.match(/\D+/g));
// \w : 알파벳, 숫자, 언더스코어
// \W : \w의 반대
console.log(target.match(/\w+/g));
console.log(target.match(/\W+/g));
console.log('----------------------------');

// [] 내의 ^ : not
console.log(target.match(/[^0-9]+/g));
console.log(target.match(/[^a-z]+/g));
console.log('----------------------------');

// [] 밖의 ^ : 시작 위치 검색
// $ : 마지막 위치 검색
target = 'https://www.google.com';
console.log(/^https/.test(target));
console.log(/com$/.test(target));
