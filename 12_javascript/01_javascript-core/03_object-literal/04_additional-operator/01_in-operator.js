// in 연산자 : 프로퍼티 존재 여부 확인
var student = {
    name : '유관순',
    age : 16,
    test : undefined
};

console.log(student.name === undefined);
console.log(student.age === undefined);
// 프로퍼티는 존재하지만 프로퍼티 값이 undefined인 상황이라 판변이 모호하다.
console.log(student.test === undefined);
console.log("-------------");
console.log("name" in student);
console.log("age" in student);
console.log("test" in student);
console.log("test2" in student);