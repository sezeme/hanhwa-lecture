// 숫자 타입으로 명시적 변환

// 1. Number 생성자 함수를 new 연산자 없이 호출
console.log(Number('10'));
console.log(Number('10.01'));
console.log(Number(true));
console.log(Number(false));

// 2. parseInt, parseFloat 함수 이용
console.log(parseInt('10'));
console.log(parseInt('10.01'));
console.log(parseFloat('10'));
console.log(parseFloat('10.01'));

// 3. + 단항 산술 연산자 이용 - 암묵적 변환 챕터에서 확인함

// 4. * 산술 연산자 이용
console.log('10' * 1);
console.log('10.01' * 1);
console.log(true * 1);
console.log(false * 1);








