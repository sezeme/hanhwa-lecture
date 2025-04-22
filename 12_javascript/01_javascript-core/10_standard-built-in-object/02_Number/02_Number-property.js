/* 02_Number-property */

// Number.MAX_VALUE : 자바스크립트에서 표현할 수 있는 가장 큰 양수 값
console.log(Number.MAX_VALUE);
console.log(Infinity > Number.MAX_VALUE);   // 무한대가 크다

// Number.MIN_VALUE : 자바스크립트에서 표현할 수 있는 가장 작은 양수 값
console.log(Number.MIN_VALUE);
console.log(Number.MIN_VALUE > 0);          // 0보다 크다

// Number.MAX_SAFE_INTEGER : 자바스크립트에서 안전하게 표현할 수 있는 가장 큰 정수 값
console.log(Number.MAX_SAFE_INTEGER);

// Number.MIN_SAFE_INTEGER : 자바스크립트에서 안전하게 표현할 수 있는 가장 작은 정수 값
console.log(Number.MIN_SAFE_INTEGER);

// Number.POSITIVE_INFINITY : 양의 무한대를 나타내는 숫자값 Infinity와 같다
console.log(Number.POSITIVE_INFINITY);

// Number.NEGATIVE_INFINITY : 음의 무한대를 나타내는 숫자값 -Infinity와 같다
console.log(Number.NEGATIVE_INFINITY);

// Number.NaN : 숫자가 아님을 나타내는 숫자값
console.log(Number.NaN);

// Number.EPSILON : 부동 소수점으로 인해 발생하는 오차를 해결하기 위해 사용한다
console.log(Number.EPSILON);    // 1과 1보다 큰 숫자 중에서 가장 작은 숫자와의 차이와 같다
console.log(0.1 + 0.2);         // 부동소수점 표현은 2진법으로 변환했을 때 무한소수가 되어 미세한 오차가 발생할 수 밖에 없다
console.log(0.1 + 0.2 === 0.3);             // false
console.log(isEqual(0.1 + 0.2, 0.3));       // true

function isEqual(a, b) {
    // a - b의 절대값이 Number.EPSILON 보다 작으면 같은 수로 인정한다
    return Math.abs(a - b) < Number.EPSILON;
}