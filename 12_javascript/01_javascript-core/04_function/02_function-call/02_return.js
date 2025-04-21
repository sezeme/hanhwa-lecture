// 반환문
function hello (name) {
    // 반환문
    return `${name}님 안녕하세요`;
    // 반환문 이후의 코드는 실행되지 않고 무시된다.
    console.log(name);
}

console.log(hello('유관순'));

// 반환값이 없는 함수
function func() {
    console.log('함수가 호출되었습니다.');
    // 반환 값이 없는 경우 return 구문 생략 가능하며 암묵적으로 undefined 가 반환된다.
    return; // 반환 값이 명시적으로 작성되지 않은 경우도 undefined 가 반환된다.
}
console.log(func());
