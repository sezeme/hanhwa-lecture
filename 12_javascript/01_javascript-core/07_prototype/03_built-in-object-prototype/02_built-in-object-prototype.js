// Function, String, Number 를 비롯한 내장 객체들 역시 프로토타입 메서드를 저장한다.
// 모든 내장 프로토타입 상속 트리 꼭대기에는 Object.prototype이 있어야 한다고 규정한다.
const num = new Number(100);

// num은 Number.prototype을 상속 받았는가?
console.log(num.__proto__ === Number.prototype);
// num은 Object.prototype을 상속 받았는가?
console.log(num.__proto__.__proto__ === Object.prototype);
// Object.prototype의 [[Prototype]]은 null
console.log(num.__proto__.__proto__.__proto__);

// Object.prototype과 Number.prototype에 모두 toString 메소드가 있으며
// 프로토타입 체인에서 가까운 메소드가 사용 된다.
console.log(num.toString());

// 내장 프로토타입을 수정할 수 있다. 하지만 가급적 변경하지 않도록 한다.
// 명세서에 새로 등록 된 기능을 쓰고 싶지만 자바스크립트 엔진에 구현 되어 있지 않은 경우 정도에만
// 변형하는 것이 좋다.
String.prototype.hello = function () {
    console.log(`hello, ${this}`);
}

"JavaScript".hello();







