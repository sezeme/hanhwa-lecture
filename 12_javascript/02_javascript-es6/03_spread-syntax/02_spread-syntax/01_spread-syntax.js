// 스프레드 문법 (전개 문법)

const arr = [10, 20, 30];
console.log(`가장 큰 값 : ${ Math.max(10, 20, 30) }`);
// 배열이 아닌 숫자 목록을 인수로 받기 때문에 정상 동작하지 않는다.
console.log(`가장 큰 값 : ${ Math.max(arr) }`);
// 스프레드 문법을 사용하면 arr이 인수 목록으로 확장된다.
console.log(`가장 큰 값 : ${ Math.max(...arr) }`);

const arr1 = [10, 30, 20];
const arr2 = [100, 300, 200];
console.log(`가장 큰 값 : ${ Math.max(...arr1, ...arr2) }`);
console.log(`가장 큰 값 : ${ Math.max(0, ...arr1, 5, ...arr2) }`);

// concat 메소드보다 간결하게 배열을 병합할 수 있다.
const merged = [0, ...arr1, ...arr2];
console.log(merged);

// 문자열을 배열로 변환할 수 있다.
const str = "JavaScript";
console.log([...str]);

