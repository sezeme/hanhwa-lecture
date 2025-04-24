// 배열 구조 분해 할당
const nameArr = ['Gildong', 'Hong'];
// const firstName = nameArr[0];
// const lastName = nameArr[1];
const [firstName, lastName] = nameArr;
console.log(firstName);
console.log(lastName);

// 반환 값이 배열인 split 메소드를 활용한 예제
const [firstName2, lastName2] = "Saimdan Shin".split(" ");
console.log(firstName2);
console.log(lastName2);

// 쉼표를 사용하여 필요하지 않은 배열 요소를 버릴 수 있다.
const arr = ['first', 'middle', 'last'];
const [first, , last] = arr;
console.log(first);
console.log(last);




