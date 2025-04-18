// 숫자 타입으로 암묵적 변환

// 1. 산술 연산자
// 산술 연산자의 피 연산자는 모두 숫자여야 하므로 숫자가 아닌 피연산자를 숫자 타입으로 암묵적 타입 변환한다.
console.log(10 - '5');
console.log(10 * '5');
console.log(10 / '5');
console.log(10 % '5');
console.log(10 % 'JavaScript'); // NaN - 피연산자 숫자 변환 불가로 연산 수행 불가

// 2. 비교 연산자
// 비교 연산자로 크기를 비교하기 위해 모두 숫자 타입이여야 하므로 숫자가 아닌 피연산자를 숫자 타입으로 암묵적 타입 변환한다.
console.log(10 > '5');
console.log(10 > '20');
// 문자는 모두 NaN으로 변환 되기 때문에 NaN은 비교 연산자를 통해 어떤 값과도 비교 불가능하다.
// 따라서 항상 false를 반환한다.
console.log(`10 > 'a' : ${ 10 > 'a' }`);
console.log(`1000 > 'a' : ${ 1000 > 'a' }`);
// 참고 : NaN 끼리 비교 연산자 사용도 불가능하므로 isNaN 함수를 이용해 확인해야 한다.
console.log(`NaN == NaN : ${NaN == NaN}`);
console.log(`isNaN(NaN) : ${isNaN(NaN)}`);

// 3. + 단항 연산자
// 피연산자가 숫자 타입의 값이 아니면 숫자 타입의 값으로 암묵적 타입 변환 수행
console.log(+'');               // 0
console.log(+'1');              // 1
console.log(+'JavaScript');     // NaN
console.log(+true);             // 1
console.log(+false);            // 0
console.log(+null);             // 0
console.log(+undefined);        // NaN
// console.log(+Symbol());
// TypeError: Cannot convert a Symbol value to a number
console.log(+{});               // NaN
console.log(+[]);               // 0
console.log(+function(){});     // NaN

// 빈문자열, 빈배열, null, false => 0
// true => 1
// 객체, undefined, 함수 => NaN










