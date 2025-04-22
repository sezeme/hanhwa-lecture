// 배열 고차 함수
// * 고차 함수 : 함수를 인수로 전달 받거나 함수를 반환하는 함수

// Array.prototype.sort
let numbers = [];
for(let i = 0; i < 10; i++) {
    numbers[i] = Math.floor(Math.random() * 100) + 1;
}
console.log(`정렬 전 numbers : ${numbers}`);
numbers.sort();
console.log(`정렬 후 numbers : ${numbers}`);

// sort의 기본 정렬은 문자 정렬이므로 필요하다면 정렬 기준 콜백 함수를 전달해야 한다.
numbers.sort((a, b) => a - b);
console.log(`숫자 오름차순 정렬 후 numbers : ${numbers}`);
numbers.sort((a, b) => b - a);
console.log(`숫자 내림차순 정렬 후 numbers : ${numbers}`);

// Array.prototype.forEach : for 문을 대체하는 고차 함수
numbers = [1, 2, 3, 4, 5];
numbers.forEach((item, index, array) => {
    console.log(`item : ${item}`);
    console.log(`index : ${index}`);
    console.log(`array : ${array}`);
});

numbers.forEach(item => console.log(item * 10));

// Array.prototype.map : 배열 요소 전체를 대상으로 콜백함수 호출 후 반환 값들로 구성 된 새로운 배열 반환
const types = [true, 1, 'text'].map(item => typeof item);
console.log(types);
const lengths
    = ['apple', 'banana', 'cat', 'dog', 'egg'].map(item => item.length);
console.log(lengths);

// Array.prototype.filter : 배열 요소 전체를 대상으로 콜백함수 호출 후 반환 값이 true 인
// 요소로만 구성 된 새로운 배열 반환
const odds = numbers.filter(item => item % 2);
console.log(odds);

// Array.prototype.reduce : 배열을 순회하며 각 요소에 대하여 이전의 콜백함수 실행 반환 값을
// 전달하여 콜백함수를 실행하고 그 결과를 반환
numbers.reduce((previousValue, currentValue, currentIndex, array) => {
    console.log(`previousValue : ${previousValue}`);
    console.log(`currentValue : ${currentValue}`);
    console.log(`currentIndex : ${currentIndex}`);
    console.log(`array : ${array}`);
    return currentValue;
});

// 합산
const sum = numbers.reduce((pre, cur) => pre + cur);
console.log(`sum : ${sum}`);
// 최대값
const max
    = numbers.reduce((pre, cur) => pre > cur ? pre : cur);
console.log(`max : ${max}`);

// Array.prototype.some : 배열 내 일부 요소가 콜백 함수의 테스트를 통과하는지 확인하며
// 그 결과를 boolean으로 반환

// 배열 내 10보다 큰 값이 1개 이상 존재하는지 확인
let result = [1, 5, 3, 2, 4].some(item => item > 10);
console.log(`result : ${result}`);
// 배열 내 3보다 큰 값이 1개 이상 존재하는지 확인
result = [1, 5, 3, 2, 4].some(item => item > 3);
console.log(`result : ${result}`);

// Array.prototype.every : 배열 내 모든 요소가 콜백 함수의 테스트를 통과하는지 확인하며
// 그 결과를 boolean으로 반환

// 배열 내 모든 요소가 3보다 큰지 확인
result = [1, 5, 3, 2, 4].every(item => item > 3);
console.log(`result : ${result}`);
// 배열 내 모든 요소가 0보다 큰지 확인
result = [1, 5, 3, 2, 4].every(item => item > 0);
console.log(`result : ${result}`);

// Array.prototype.find : 배열을 순회하며 각 요소에 대하여 인자로 주어진 콜백함수를 실행하여
// 그 결과가 참인 첫 번째 요소를 반환한다. 참인 요소가 존재하지 않는다면 undefined 를 반환한다.
// Array.prototype.findIndex : 배열을 순회하며 각 요소에 대하여 인자로 주어진 콜백함수를 실행하여
// 그 결과가 참인 첫 번째 요소의 인덱스를 반환한다. 참인 요소가 존재하지 않는다면 -1 을 반환한다.
const students = [
    { name : '유관순', score : 90 },
    { name : '홍길동', score : 80 },
    { name : '장보고', score : 70 }
];

// 이름이 홍길동인 학생 찾기
result = students.find(item => item.name === '홍길동');
console.log('result : ', result);
result = students.findIndex(item => item.name === '홍길동');
console.log('result : ', result);

// 만약 80점 이상인 학생들을 찾고 싶다면? find 말고 filter로 처리
result = students.filter(item => item.score >= 80);
console.log('result : ', result);














