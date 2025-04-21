// for in 반복문 : 객체의 모든 키를 순회하는 반복문
var student = {
    name : '유관순',
    age : 16,
    getInfo() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
};

for(var key in student) {
    console.log(`key : ${key}`);
    // 프로퍼티 키가 변수인 경우 대괄호 표기법을 사용해야 한다.
    console.log(`student.key : ${student.key}`);
    console.log(`student.key : ${student[key]}`);
}