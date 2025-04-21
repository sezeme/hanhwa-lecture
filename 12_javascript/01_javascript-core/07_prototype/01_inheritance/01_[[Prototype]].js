// [[Prototype]]
const user = {
    activate : true,
    login : function() {
        console.log('로그인 되었습니다.');
    }
};

const student = {
    passion : true
};

student.__proto__ = user;   // __proto__는 [[Prototype]]의 getter, setter

// student의 프로토타입은 user이다. 또는 student는 user를 상속 받는다. 라고 표현한다.
// 프로토타입에서 상속 받은 프로퍼티를 상속 프로퍼티라고 한다.
console.log(student.passion);   // 상속 프로퍼티
console.log(student.activate);  // 상속 프로퍼티
student.login();

// 프로토타입 체인
const greedyStudent = {
    class : 2,
    __proto__ : student
};
console.log(greedyStudent.class);
console.log(greedyStudent.passion);
console.log(greedyStudent.activate);
greedyStudent.login();