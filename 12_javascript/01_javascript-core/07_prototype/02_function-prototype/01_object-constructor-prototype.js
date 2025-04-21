// 생성자 함수 프로토타입
const user = {
    activate : true,
    login : function() {
        console.log('로그인 되었습니다.');
    }
};

function Student(name) {
    this.name = name;
}
// 여기서의 prototype은 앞에서 배운 프로토타입(__proto__)과 이름만 같을 뿐 실제로는 일반 프로퍼티이다.
Student.prototype = user;

// Function.prototype은 new Function()을 호출할 때만 사용되며
// 이 때 만들어지는 객체의 [[Prototype]]을 할당한다.
let student = new Student('홍길동');// student.__proto__ = user; 가 내부적으로 동작
console.log(student.name);      // 본인 프로퍼티
console.log(student.activate);  // 상속 프로퍼티
student.login();                // 상속 프로퍼티

let student2 = new Student('유관순');
console.log(student2.name);      // 본인 프로퍼티
console.log(student2.activate);  // 상속 프로퍼티
student2.login();                // 상속 프로퍼티



