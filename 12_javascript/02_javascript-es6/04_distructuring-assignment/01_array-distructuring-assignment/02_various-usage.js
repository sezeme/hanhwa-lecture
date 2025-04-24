// 다양한 사용법

// 1. 객체 프로퍼티에서 사용하기
const user = {};
[user.firstName, user.lastName] = "Gwansoon Yu".split(" ");
console.log(user);

// 2. 변수 교환 용도로 사용하기
let student = '학생';
let teacher = '선생님';
[teacher, student] = [student, teacher];
console.log(`student : ${student}, teacher : ${teacher}`);

// 3. rest parameter 와 함께 사용하기
const [sign1, sign2, ...rest] = ['양자리', '황소자리', '쌍둥이자리', '게자리'];
console.log(sign1);
console.log(sign2);
console.log(rest);

// 4. 기본 값 설정하고 사용하기
const [firstName = "아무개", lastName = "김"] = ["길동"];
console.log(firstName);
console.log(lastName);




