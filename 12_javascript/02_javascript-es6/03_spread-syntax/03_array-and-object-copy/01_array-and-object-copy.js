// 스프레드 문법의 활용 => 배열 또는 객체를 복사할 때 주로 사용한다.
const arr = [10, 20, 30];
const arrCopy = [...arr];
console.log(arr);
console.log(arrCopy);
console.log(arr === arrCopy);

const obj = { name : '홍길동', age : 18 };
const objCopy = { ...obj };
console.log(obj);
console.log(objCopy);
console.log(obj === objCopy);
